import java.security.MessageDigest;

public class MerkleNode {
    String hash;
    MerkleNode left, right;

    public MerkleNode(String data) {
        this.hash = sha256(data);
    }

    public MerkleNode(MerkleNode left, MerkleNode right) {
        this.left = left;
        this.right = right;
        this.hash = sha256(left.hash + right.hash);
    }

    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) hexString.append(String.format("%02x", b));
            return hexString.toString();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }
}
