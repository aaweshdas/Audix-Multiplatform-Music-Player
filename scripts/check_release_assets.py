import subprocess
import urllib.request
import json

def get_token():
    p = subprocess.Popen(['git', 'credential', 'fill'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True)
    out, _ = p.communicate('protocol=https\nhost=github.com\n\n')
    creds = dict(line.split('=', 1) for line in out.splitlines() if '=' in line)
    return creds.get('password', '')

token = get_token()
req = urllib.request.Request(
    'https://api.github.com/repos/aaweshdas/Audix-Multiplatform-Music-Player/releases/tags/v1.0.3',
    headers={'Authorization': f'Bearer {token}', 'User-Agent': 'Audix-Checker', 'Accept': 'application/vnd.github+json'}
)
resp = urllib.request.urlopen(req)
data = json.loads(resp.read().decode())
print("Release:", data.get('name'))
print("Assets:")
for a in data.get('assets', []):
    print(f" - {a['name']}: {a['size']} bytes, state: {a['state']}")
    if a['name'] == 'v1.0.3.apk':
        del_req = urllib.request.Request(
            f"https://api.github.com/repos/aaweshdas/Audix-Multiplatform-Music-Player/releases/assets/{a['id']}",
            headers={'Authorization': f'Bearer {token}', 'User-Agent': 'Audix-Checker'},
            method='DELETE'
        )
        urllib.request.urlopen(del_req)
        print("   -> Deleted stale v1.0.3.apk asset")
