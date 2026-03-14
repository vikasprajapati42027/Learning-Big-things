package TestJava.Test216;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 216: OAuth2 Authorization Code Flow (Concept) ===\n");

        System.out.println("OAuth2 is NOT authentication (who you are), it's AUTHORIZATION (what app can do on your behalf).");
        System.out.println("OIDC (OpenID Connect) adds an 'ID Token' on top of OAuth2 for Authentication.\n");

        System.out.println("--- The Flow (e.g. Logging into Spotify using Google) ---");
        
        System.out.println("1. User clicks 'Login with Google' on Spotify.");
        System.out.println("   Spotify redirects user's browser to Google's Auth Server:");
        System.out.println("   https://accounts.google.com/auth?client_id=SPOTIFY_ID&redirect_uri=spotify.com/callback&response_type=code");
        
        System.out.println("\n2. User logs into Google and grants permission.");
        System.out.println("   Google redirects browser BACK to Spotify with a temporary Code:");
        System.out.println("   http://spotify.com/callback?code=SPLENDID_SECRET_CODE_123");
        
        System.out.println("\n3. Spotify's BACKEND takes that code, adds its own CLIENT_SECRET, and calls Google directly.");
        System.out.println("   POST https://oauth2.googleapis.com/token");
        System.out.println("   Body: code=SPLENDID_SECRET_CODE_123 & client_secret=SUPER_SECRET_SPOTIFY_KEY");
        
        System.out.println("\n4. Google validates everything and replies with:");
        System.out.println("   {");
        System.out.println("     \"access_token\": \"ya29.a0AfH6S...\",");
        System.out.println("     \"expires_in\": 3600,");
        System.out.println("     \"id_token\": \"eyJhbGciOi...\"  <-- This proves WHO the user is (OIDC)");
        System.out.println("   }");
        
        System.out.println("\n5. Spotify now knows who the user is and can use the access_token to fetch their Google Calendar!");
    }
}
