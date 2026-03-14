package TestJava.Test188;

// 1. Target interface
interface DatabaseRecord {
    String getHeavyData();
}

// 2. The Real Object (Heavy to build, reads from a file/database in the constructor)
class RealDatabaseRecord implements DatabaseRecord {
    private String data;
    
    public RealDatabaseRecord(int id) {
        System.out.println("----> [Expensive DB Call] Loading gigabytes of data for ID: " + id);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        this.data = "Massive Text Content for ID " + id;
    }
    
    @Override
    public String getHeavyData() { return data; }
}

// 3. The Proxy Object! It wraps the real one, but DELAYS creating it.
class LazyHibernateProxy implements DatabaseRecord {
    private int id;
    private RealDatabaseRecord realRecord;

    public LazyHibernateProxy(int id) {
        this.id = id;
        System.out.println("[Proxy] A lightweight shell for ID " + id + " was created instantly.");
    }

    @Override
    public String getHeavyData() {
        // ONLY fetch the real data if the user actually asks for it!
        if (realRecord == null) {
            realRecord = new RealDatabaseRecord(id);
        }
        return realRecord.getHeavyData();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 188: Lazy Loading Proxy Concept ===\n");

        System.out.println("When you use @OneToMany(fetch = FetchType.LAZY), Hibernate returns a Proxy object.");
        System.out.println("It's a fake shell that intercepts method calls and loads the database ONLY when needed.\n");

        System.out.println("1. Loading a user profile (which has a giant List of Orders that is marked LAZY)");
        DatabaseRecord lazyOrdersList = new LazyHibernateProxy(99); 
        
        System.out.println("\n2. User is just looking at the settings page. (No DB calls made for Orders!)");
        
        System.out.println("\n3. User clicks 'View My Orders'. Now we actually invoke a method on the list!");
        String data = lazyOrdersList.getHeavyData(); // BAM! The DB call happens here.
        System.out.println("Displayed: " + data);
        
        System.out.println("\n4. User refreshes the page:");
        System.out.println("Displayed: " + lazyOrdersList.getHeavyData()); // Instant, because it's already loaded
    }
}
