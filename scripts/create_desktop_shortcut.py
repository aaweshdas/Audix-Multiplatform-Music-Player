import os
import sys

def create_shortcuts():
    # Use powershell script without nested string escaping issues
    ps_script = r'''
$wsh = New-Object -ComObject WScript.Shell
$desktopPaths = @(
    [Environment]::GetFolderPath('Desktop'),
    (Join-Path $env:USERPROFILE 'OneDrive\Desktop'),
    (Join-Path $env:USERPROFILE 'Desktop')
) | Select-Object -Unique

foreach ($dp in $desktopPaths) {
    if (Test-Path $dp) {
        $lnk = Join-Path $dp 'Audix.lnk'
        $s = $wsh.CreateShortcut($lnk)
        $s.TargetPath = 'S:\All Code\Antigravity\echo-nightly\Run-Audix.bat'
        $s.WorkingDirectory = 'S:\All Code\Antigravity\echo-nightly'
        $ico = 'S:\All Code\Antigravity\echo-nightly\desktopApp\src\desktopMain\resources\icons\audix.ico'
        if (Test-Path $ico) {
            $s.IconLocation = "$ico,0"
        }
        $s.Description = 'Audix - High-Fidelity Music Player'
        $s.Save()
        Write-Host "Created shortcut: $lnk"
    }
}
'''
    ps_file = 'build/create_shortcut.ps1'
    os.makedirs('build', exist_ok=True)
    with open(ps_file, 'w', encoding='utf-8') as f:
        f.write(ps_script)
    import subprocess
    res = subprocess.run(['powershell', '-NoProfile', '-ExecutionPolicy', 'Bypass', '-File', ps_file], capture_output=True, text=True)
    print(res.stdout)
    if res.stderr:
        print(res.stderr)

if __name__ == '__main__':
    create_shortcuts()
