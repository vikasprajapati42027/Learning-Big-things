# Test 12: XSS Prevention

## Simple Explanation
Cross-Site Scripting (XSS) happens when an attacker injects a malicious script into a webpage viewed by other users. 

## Two Main Types
1. **Reflected**: The script is part of a URL (e.g., `?name=<script>...`) and the server echoes it back.
2. **Stored**: The script is saved in the database (e.g., in a comment field) and shown to every user who opens the page.

## The Fix: Output Encoding
Instead of sending `<script>`, we send `&lt;script&gt;`. The browser shows the text on the screen but does NOT execute it as code.

## Key Tool: `HtmlUtils.htmlEscape()`
Spring provides `HtmlUtils` to help you escape data before sending it to a JSP or Thymeleaf template.

## Pro Tip
Modern frameworks like **React** and **Angular** automatically escape all data rendered in the browser. However, you should still validate and sanitize input on the backend to be safe!
