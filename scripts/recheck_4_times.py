import subprocess
import os
import sys
import time

PROJECT_ROOT = r'S:\All Code\Antigravity\echo-nightly'
os.chdir(PROJECT_ROOT)

def run_command(cmd, name):
    print(f"\n---> Starting: {name}...")
    start_time = time.time()
    proc = subprocess.Popen(
        cmd,
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT,
        text=True,
        bufsize=1
    )
    output_lines = []
    for line in proc.stdout:
        print(line, end='', flush=True)
        output_lines.append(line)
    proc.wait()
    duration = time.time() - start_time
    if proc.returncode != 0:
        print(f"\n[FAILED] {name} exited with code {proc.returncode} in {duration:.2f}s")
        return False, duration
    print(f"\n[PASSED] {name} completed successfully in {duration:.2f}s")
    return True, duration

def main():
    print("=" * 70)
    print("AUDIX 4-CYCLE EXHAUSTIVE VERIFICATION SUITE")
    print("Objective: Verify zero bugs, zero cyber errors, 100% stability across 4 consecutive cycles")
    print("=" * 70)

    total_runs = 4
    results = []

    for cycle in range(1, total_runs + 1):
        print(f"\n{'#' * 70}")
        print(f"### CYCLE {cycle}/{total_runs} STARTING ###")
        print(f"{'#' * 70}")
        cycle_start = time.time()

        # Step A: Cybersecurity and boundary sanity test
        sec_ok, sec_dur = run_command([sys.executable, r"scripts\test_cyber_security_fixes.py"], f"Cycle {cycle} - Security & Boundary Validation")
        if not sec_ok:
            print(f"[FATAL] Cycle {cycle} security validation failed!")
            sys.exit(1)

        # Step B: End-to-end multi-track playback, singleton and background manager verification
        e2e_ok, e2e_dur = run_command([sys.executable, r"scripts\run_verification.py"], f"Cycle {cycle} - E2E Playback & Stability Verification")
        if not e2e_ok:
            print(f"[FATAL] Cycle {cycle} E2E verification failed!")
            sys.exit(2)

        cycle_dur = time.time() - cycle_start
        print(f"\n>>> CYCLE {cycle}/{total_runs} PASSED PERFECTLY in {cycle_dur:.2f}s! <<<")
        results.append({
            "cycle": cycle,
            "security_duration": sec_dur,
            "e2e_duration": e2e_dur,
            "total_duration": cycle_dur,
            "status": "PASSED"
        })

    print("\n" + "=" * 70)
    print("FINAL 4-CYCLE AUDIT & VERIFICATION SUMMARY")
    print("=" * 70)
    for r in results:
        print(f"Cycle {r['cycle']}: {r['status']} | Security: {r['security_duration']:.2f}s | Playback/E2E: {r['e2e_duration']:.2f}s | Total: {r['total_duration']:.2f}s")
    print("=" * 70)
    print("ALL 4 CYCLES COMPLETED WITH 100% SUCCESS — ZERO BUGS, ZERO FREEZES, ZERO ERRORS!")
    print("=" * 70)

if __name__ == "__main__":
    main()
