# Test 25: Common Security Headers

## Simple Explanation
Browsers are smart! You can tell them to help protect your site by sending special instructions in the HTTP **Headers**.

## 1. HSTS (Strict-Transport-Security)
Tells the browser: "Only talk to me over **HTTPS**. Never use regular HTTP again."
- Prevents "Man-in-the-Middle" attacks.

## 2. X-Frame-Options: `DENY`
Tells the browser: "Never allow my website to be put inside an `<iframe>` on another site."
- This prevents **Clickjacking** (where an attacker hides your site under an invisible layer to trick you into clicking buttons).

## 3. X-Content-Type-Options: `nosniff`
Tells the browser: "Listen to what **I** say the content type is. Don't try to 'guess' if a `.txt` file is actually a `.js` script."
- Prevents script injection via file uploads.

## Spring Security Default
Spring Security enables these by default! You only need to touch these if you want to be more strict or if you have special needs (like allowing iframes for a dashboard).
