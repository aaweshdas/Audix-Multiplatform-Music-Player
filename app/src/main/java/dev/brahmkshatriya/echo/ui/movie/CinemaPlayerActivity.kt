package dev.brahmkshatriya.echo.ui.movie

import android.annotation.SuppressLint
import android.app.PictureInPictureParams
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Rational
import android.view.View
import android.view.WindowManager
import android.webkit.ConsoleMessage
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.databinding.ActivityCinemaPlayerBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayInputStream
import java.net.URLEncoder

class CinemaPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCinemaPlayerBinding
    private var customView: View? = null
    private var customViewCallback: WebChromeClient.CustomViewCallback? = null

    private var movieTitle: String = "In-App Cinema"
    private var movieYear: String = "2024"
    private var movieGenre: String = "Cinema"
    private var movieQuality: String = "1080p HD"
    private var imdbId: String = ""
    private var isSeries: Boolean = false

    private var currentServerIndex: Int = 0
    private val handler = Handler(Looper.getMainLooper())

    private val hideControlsRunnable = Runnable {
        fadeControls(false)
    }

    private data class StreamServer(val name: String, val badge: String, val urlBuilder: (imdb: String, title: String, isTv: Boolean) -> String)

    private val streamServers = listOf(
        StreamServer("Server 1 (VidSrc Cloud)", "Fast HD") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://vidsrc.to/embed/tv/$cleanId/1/1" else "https://vidsrc.to/embed/movie/$cleanId"
        },
        StreamServer("Server 2 (VidSrc PM)", "Ultra HD") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://vidsrc.pm/embed/tv/$cleanId/1-1" else "https://vidsrc.pm/embed/movie/$cleanId"
        },
        StreamServer("Server 3 (VidSrc VIP)", "Multi-Audio") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://vidsrc.xyz/embed/tv/$cleanId/1-1" else "https://vidsrc.xyz/embed/movie/$cleanId"
        },
        StreamServer("Server 4 (VidSrc Direct)", "Direct Stream") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://vidsrc.net/embed/tv/$cleanId/1/1" else "https://vidsrc.net/embed/movie/$cleanId"
        },
        StreamServer("Server 5 (2Embed VIP)", "Reliable HD") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://www.2embed.cc/embedtv/$cleanId&s=1&e=1" else "https://www.2embed.cc/embed/$cleanId"
        },
        StreamServer("Server 6 (Smashy Player)", "Instant Mirror") { id, title, isTv ->
            val cleanId = id.ifBlank { "tt0816692" }
            if (isTv) "https://embed.smashystream.com/playere.php?imdb=$cleanId&season=1&episode=1" else "https://embed.smashystream.com/playere.php?imdb=$cleanId"
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCinemaPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Keep screen on while playing video
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // Fullscreen immersive mode
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.hide(WindowInsetsCompat.Type.systemBars())
        insetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        parseIntentExtras()
        setupViews()
        setupWebView()
        startStreamPlayback(currentServerIndex)
    }

    private fun parseIntentExtras() {
        movieTitle = intent.getStringExtra(EXTRA_TITLE) ?: "In-App Cinema"
        movieYear = intent.getStringExtra(EXTRA_YEAR) ?: "2024"
        movieGenre = intent.getStringExtra(EXTRA_GENRE) ?: "Cinema"
        movieQuality = intent.getStringExtra(EXTRA_QUALITY) ?: "1080p HD"
        val explicitImdb = intent.getStringExtra(EXTRA_IMDB_ID) ?: ""
        val coverUrl = intent.getStringExtra(EXTRA_COVER_URL) ?: ""
        val bannerUrl = intent.getStringExtra(EXTRA_BANNER_URL) ?: ""
        val rawId = intent.getStringExtra(EXTRA_RAW_ID) ?: ""

        // Extract IMDb ID if present (e.g. tt0050083)
        val candidate = "$explicitImdb $rawId $coverUrl $bannerUrl"
        val match = Regex("""tt\d+""", RegexOption.IGNORE_CASE).find(candidate)
        imdbId = match?.value?.lowercase() ?: explicitImdb

        val type = intent.getStringExtra(EXTRA_TYPE) ?: ""
        isSeries = type.equals("series", ignoreCase = true) ||
                type.equals("tv", ignoreCase = true) ||
                movieGenre.contains("eps", ignoreCase = true) ||
                movieGenre.contains("tv", ignoreCase = true) ||
                movieQuality.contains("tv", ignoreCase = true)
    }

    private fun setupViews() {
        binding.tvCinemaTitle.text = movieTitle
        binding.tvLoadingTitle.text = movieTitle
        binding.tvCinemaMeta.text = "$movieYear • $movieQuality • In-App Cinema"

        binding.btnBackCinema.setOnClickListener {
            finish()
        }

        binding.btnReloadStream.setOnClickListener {
            binding.llCinemaLoading.visibility = View.VISIBLE
            binding.tvLoadingStatus.text = "Reloading In-App Cinema Stream..."
            binding.wvCinemaPlayer.reload()
            scheduleControlsAutoHide()
        }

        binding.btnServerSelector.setOnClickListener {
            showServerSelectionDialog()
        }

        binding.btnPipCinema.setOnClickListener {
            enterPipMode()
        }

        binding.cinemaPlayerRoot.setOnClickListener {
            toggleControls()
        }

        scheduleControlsAutoHide()
    }

    private fun showServerSelectionDialog() {
        val serverOptions = streamServers.mapIndexed { idx, s ->
            val active = if (idx == currentServerIndex) " (Active)" else ""
            "${s.name} • ${s.badge}$active"
        }.toTypedArray()

        MaterialAlertDialogBuilder(this)
            .setTitle("Switch Cinema Server Mirror")
            .setItems(serverOptions) { _, which ->
                currentServerIndex = which
                binding.btnServerSelector.text = "Server ${which + 1} ▾"
                startStreamPlayback(which)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun startStreamPlayback(index: Int) {
        currentServerIndex = index
        if (imdbId.isNotBlank() && imdbId.startsWith("tt", ignoreCase = true)) {
            loadServerStream(index)
        } else {
            binding.llCinemaLoading.visibility = View.VISIBLE
            binding.tvLoadingStatus.text = "Resolving Cinema ID for '$movieTitle'..."
            lifecycleScope.launch(Dispatchers.IO) {
                val resolved = MoviePlayRepository.resolveImdbId(movieTitle, isSeries)
                withContext(Dispatchers.Main) {
                    if (!resolved.isNullOrBlank()) {
                        imdbId = resolved
                    }
                    loadServerStream(index)
                }
            }
        }
    }

    private fun loadServerStream(index: Int) {
        val server = streamServers.getOrElse(index) { streamServers[0] }
        val streamUrl = server.urlBuilder(imdbId, movieTitle, isSeries)

        binding.llCinemaLoading.visibility = View.VISIBLE
        binding.tvLoadingStatus.text = "Streaming via ${server.name}..."
        binding.btnServerSelector.text = "Server ${index + 1} ▾"

        binding.wvCinemaPlayer.loadUrl(streamUrl)
        scheduleControlsAutoHide()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val wv = binding.wvCinemaPlayer
        val settings = wv.settings

        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.mediaPlaybackRequiresUserGesture = false
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.allowFileAccess = true
        settings.allowContentAccess = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        // Strict anti-ad & anti-popup settings:
        // Set multiple windows to true so window.open() routes to onCreateWindow,
        // which returns false to swallow popups completely.
        settings.setSupportMultipleWindows(true)
        settings.javaScriptCanOpenWindowsAutomatically = false

        // Set modern Chrome user agent to prevent unwanted mobile redirects
        settings.userAgentString =
            "Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro Build/UQ1A.240205.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"

        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.setAcceptThirdPartyCookies(wv, true)

        wv.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.llCinemaLoading.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                handler.postDelayed({
                    binding.llCinemaLoading.animate().alpha(0f).setDuration(400L).withEndAction {
                        binding.llCinemaLoading.visibility = View.GONE
                        binding.llCinemaLoading.alpha = 1f
                    }
                }, 800L)

                // Inject CSS/JS to remove intrusive overlay buttons and ensure dark background
                view?.evaluateJavascript(
                    """
                    (function() {
                        const style = document.createElement('style');
                        style.textContent = `
                            iframe[id*="google_ads"], div[class*="ad-"], div[id*="ad-"],
                            a[href*="betting"], a[href*="casino"], .banner-ad,
                            .ad-banner, .pop-overlay, #overlay, .jw-ad { display: none !important; }
                            body, html { background-color: #000000 !important; }
                        `;
                        document.head.appendChild(style);
                    })();
                    """.trimIndent(), null
                )
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url?.toString() ?: return true

                // Block non-HTTP schemes (intent://, market://, tg://, etc.) entirely
                if (!url.startsWith("http://", ignoreCase = true) && !url.startsWith("https://", ignoreCase = true)) {
                    return true // Block completely, never launch external apps
                }

                val uri = Uri.parse(url)
                val host = uri.host?.lowercase() ?: ""

                // Common ad network patterns
                val isAdPattern = host.contains("doubleclick") ||
                        host.contains("syndication") ||
                        host.contains("popads") ||
                        host.contains("popcash") ||
                        host.contains("betting") ||
                        host.contains("casino") ||
                        host.contains("exoclick") ||
                        host.contains("propeller") ||
                        host.contains("trafficjunky") ||
                        host.contains("juicyads") ||
                        host.contains("adnxs")

                if (isAdPattern) {
                    return true // Swallow and block ad redirect silently
                }

                // If sub-frame (iframe video player, CDN stream, token handshake)
                // NEVER block it! Let it load cleanly inside the player iframe
                if (request?.isForMainFrame == false) {
                    return false
                }

                // Strict Allowed Streaming & Infrastructure Domains for main frame
                val isStreamingDomain = host.contains("vidsrc") ||
                        host.contains("vidlink") ||
                        host.contains("smashy") ||
                        host.contains("anyembed") ||
                        host.contains("2embed") ||
                        host.contains("multiembed") ||
                        host.contains("superembed") ||
                        host.contains("rabbitstream") ||
                        host.contains("megacloud") ||
                        host.contains("streambucket") ||
                        host.contains("cloudflarestorage") ||
                        host.contains("cloudflare") ||
                        host.contains("strem.io") ||
                        host.contains("metahub.space")

                if (isStreamingDomain) {
                    return false // Allow WebView to navigate internally
                }

                // Block unexpected external navigations
                return true
            }

            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                val url = request?.url?.toString()?.lowercase() ?: return null
                // Block known ad/tracking endpoints by returning empty resource response
                val blockedKeywords = listOf(
                    "doubleclick.net", "googlesyndication.com", "adservice",
                    "adsystem", "popads", "popcash", "histats", "propellerads",
                    "exoclick", "juicyads", "trafficjunky", "adnxs.com"
                )
                if (blockedKeywords.any { url.contains(it) }) {
                    return WebResourceResponse("text/plain", "UTF-8", ByteArrayInputStream(ByteArray(0)))
                }
                return super.shouldInterceptRequest(view, request)
            }
        }

        wv.webChromeClient = object : WebChromeClient() {
            override fun onCreateWindow(
                view: WebView?,
                isDialog: Boolean,
                isUserGesture: Boolean,
                resultMsg: android.os.Message?
            ): Boolean {
                // Silently block popups and unwanted new windows!
                return false
            }

            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                customView = view
                customViewCallback = callback
                binding.flCustomVideoContainer.addView(view)
                binding.flCustomVideoContainer.visibility = View.VISIBLE
                binding.wvCinemaPlayer.visibility = View.GONE
                fadeControls(false)
            }

            override fun onHideCustomView() {
                binding.flCustomVideoContainer.removeView(customView)
                binding.flCustomVideoContainer.visibility = View.GONE
                binding.wvCinemaPlayer.visibility = View.VISIBLE
                customViewCallback?.onCustomViewHidden()
                customView = null
                customViewCallback = null
                customViewCallback = null
                fadeControls(true)
            }

            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                return true // suppress noisy console logs
            }
        }
    }

    private fun toggleControls() {
        val currentlyVisible = binding.rlTopCinemaBar.visibility == View.VISIBLE
        fadeControls(!currentlyVisible)
    }

    private fun fadeControls(show: Boolean) {
        handler.removeCallbacks(hideControlsRunnable)
        if (show) {
            binding.rlTopCinemaBar.visibility = View.VISIBLE
            binding.llBottomCinemaStatus.visibility = View.VISIBLE
            binding.rlTopCinemaBar.animate().alpha(1f).setDuration(250L).start()
            binding.llBottomCinemaStatus.animate().alpha(1f).setDuration(250L).start()
            scheduleControlsAutoHide()
        } else {
            binding.rlTopCinemaBar.animate().alpha(0f).setDuration(250L).withEndAction {
                binding.rlTopCinemaBar.visibility = View.GONE
            }.start()
            binding.llBottomCinemaStatus.animate().alpha(0f).setDuration(250L).withEndAction {
                binding.llBottomCinemaStatus.visibility = View.GONE
            }.start()
        }
    }

    private fun scheduleControlsAutoHide() {
        handler.removeCallbacks(hideControlsRunnable)
        handler.postDelayed(hideControlsRunnable, 4000L)
    }

    private fun enterPipMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fadeControls(false)
            val params = PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16, 9))
                .build()
            enterPictureInPictureMode(params)
        }
    }

    @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: android.content.res.Configuration) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            fadeControls(false)
        } else {
            fadeControls(true)
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (customView != null) {
            binding.flCustomVideoContainer.removeView(customView)
            binding.flCustomVideoContainer.visibility = View.GONE
            binding.wvCinemaPlayer.visibility = View.VISIBLE
            customViewCallback?.onCustomViewHidden()
            customView = null
            customViewCallback = null
            fadeControls(true)
            return
        }
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        binding.wvCinemaPlayer.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.wvCinemaPlayer.onPause()
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        binding.wvCinemaPlayer.stopLoading()
        binding.wvCinemaPlayer.destroy()
        super.onDestroy()
    }

    companion object {
        const val EXTRA_TITLE = "extra_movie_title"
        const val EXTRA_YEAR = "extra_movie_year"
        const val EXTRA_GENRE = "extra_movie_genre"
        const val EXTRA_QUALITY = "extra_movie_quality"
        const val EXTRA_IMDB_ID = "extra_imdb_id"
        const val EXTRA_COVER_URL = "extra_cover_url"
        const val EXTRA_BANNER_URL = "extra_banner_url"
        const val EXTRA_RAW_ID = "extra_raw_id"
        const val EXTRA_TYPE = "extra_movie_type"

        fun launch(context: Context, movie: MovieBoxItem) {
            val intent = Intent(context, CinemaPlayerActivity::class.java).apply {
                putExtra(EXTRA_TITLE, movie.title)
                putExtra(EXTRA_YEAR, movie.year)
                putExtra(EXTRA_GENRE, movie.genre)
                putExtra(EXTRA_QUALITY, movie.qualityBadge)
                putExtra(EXTRA_COVER_URL, movie.coverUrl)
                putExtra(EXTRA_BANNER_URL, movie.bannerUrl)
                putExtra(EXTRA_RAW_ID, movie.id)
                putExtra(EXTRA_TYPE, movie.type)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }
}
