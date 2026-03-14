/**
 * INTERVIEWER: How do you persist data in Docker containers?
 * 
 * CANDIDATE: We use Volumes. Volumes are the preferred mechanism for persisting 
 * data generated and used by Docker containers.
 * 
 * PROPER EXPLANATION:
 * 1. Ephemeral FS: Containers are immutable by nature; data is lost when container perishes.
 * 2. Volumes: Managed by Docker. Best for production.
 * 3. Bind Mounts: Map a host path to a container path. 
 * 4. tmpfs: Store data in host's memory (RAM), never written to disk.
 */

public class Q2_Volumes {
    public static void main(String[] args) {
        System.out.println("Persistence Command:");
        System.out.println("docker run -d -v my-data:/var/lib/mysql mysql:latest");
        System.out.println("Explanation: 'my-data' is a named volume managed by Docker.");
    }
}
