# Test 139: Internationalization (i18n)

Serving the right language based on the user's locale.

## Key Files:
- `I18nController.java`: Reads `Accept-Language` header and returns the translated message.
- `EXPLANATION.md`: MessageSource and properties file setup.

## Concept:
Store messages in `messages.properties` (English), `messages_hi.properties` (Hindi), `messages_fr.properties` (French). Spring MessageSource picks the right file based on the locale. Your code never changes — just add more translation files!
