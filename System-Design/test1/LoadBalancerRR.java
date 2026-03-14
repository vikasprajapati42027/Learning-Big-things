import java.util.*;
public class RoundRobin {
    private List<String> servers = Arrays.asList("S1", "S2", "S3");
    private int index = 0;
    public synchronized String getNext() {
        String s = servers.get(index);
        index = (index + 1) % servers.size();
        return s;
    }
}
