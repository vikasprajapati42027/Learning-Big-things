# Test 11: Content Security Policy (CSP)

## Simple Explanation
CSP is a security layer that helps detect and mitigate certain types of attacks, including Cross-Site Scripting (XSS) and data injection attacks. It tells the browser which sources of content (scripts, styles, images) are trusted.

## How it works
You send a `Content-Security-Policy` HTTP header. The browser reads this and blocks any resource that doesn't match the policy.

## Example Policy: `default-src 'self'; script-src 'self' https://trusted.com;`
- `default-src 'self'`: Only load content from my own domain.
- `script-src 'self' https://trusted.com`: Only allow scripts from my domain and `trusted.com`.
- `object-src 'none'`: Prevent plugins like Flash or Java Applets (security risks!).

## Why use it?
Even if an attacker finds a way to inject a script tag into your page (XSS), the browser will refuse to run it because the attacker's domain is not in your CSP whitelist!
