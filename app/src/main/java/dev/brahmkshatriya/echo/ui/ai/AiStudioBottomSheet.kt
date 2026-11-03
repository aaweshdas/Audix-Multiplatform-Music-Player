package dev.brahmkshatriya.echo.ui.ai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.databinding.BottomSheetAiStudioBinding

class AiStudioBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetAiStudioBinding? = null
    private val binding get() = _binding!!

    override fun getTheme() = R.style.EchoBottomSheetDialog

    override fun onStart() {
        super.onStart()
        val dialog = dialog as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.skipCollapsed = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetAiStudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tagCyberpunk.setOnClickListener {
            binding.aiPromptInput.setText("Cyberpunk Neon Tokyo Synthwave 140 BPM")
        }
        binding.tagLofi.setOnClickListener {
            binding.aiPromptInput.setText("Rainy Midnight Lo-Fi Beats with warm vinyl crackle")
        }
        binding.tagFocus.setOnClickListener {
            binding.aiPromptInput.setText("Deep Focus Alpha Wave ambient acoustic piano")
        }
        binding.tagWorkout.setOnClickListener {
            binding.aiPromptInput.setText("Aggressive Gym Bass Phonk High Energy workout")
        }

        binding.btnGenerateAi.setOnClickListener {
            val prompt = binding.aiPromptInput.text.toString().trim()
            val text = if (prompt.isNotBlank()) prompt else "Instant Studio Soundstage Mix"
            Toast.makeText(requireContext(), "✨ Generating AI Sonic Mix for: $text", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
