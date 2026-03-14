package TestJava.Test206;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// 1. The Remote Interface (Must extend java.rmi.Remote and throw RemoteException)
interface MathService extends Remote {
    int add(int a, int b) throws RemoteException;
}

// 2. The Implementation
class MathServiceImpl extends UnicastRemoteObject implements MathService {
    protected MathServiceImpl() throws RemoteException { super(); }

    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("[RMI Server] Executing add(" + a + ", " + b + ") on the server...");
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 206: RMI (Remote Method Invocation) Concept ===\n");

        System.out.println("RMI allows a Java program to invoke methods on an object running in");
        System.out.println("ANOTHER JVM (potentially on another machine network)! It uses TCP serialization.\n");

        // We run the server in a separate thread
        Thread serverThread = new Thread(() -> {
            try {
                // Start the RMI Registry on port 1099
                Registry registry = LocateRegistry.createRegistry(1099);
                
                // Bind our service to the registry so clients can find it!
                MathService service = new MathServiceImpl();
                registry.rebind("RemoteMathService", service);
                
                System.out.println("[RMI Server] Registry started. Service bound to 'RemoteMathService'");
            } catch (Exception e) {
                System.out.println("Port 1099 might be in use, but the concept stands.");
            }
        });
        
        serverThread.setDaemon(true);
        serverThread.start();
        Thread.sleep(1000); // Wait for server to boot

        // --- Client Simulation ---
        System.out.println("\n[RMI Client] Attempting to connect to 'RemoteMathService'...");
        try {
            // Find the registry and look up the service
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MathService stub = (MathService) registry.lookup("RemoteMathService");
            
            // Invoke the method! It looks local, but it's happening over the network!
            System.out.println("[RMI Client] Calling stub.add(5, 10)...");
            int result = stub.add(5, 10);
            
            System.out.println("[RMI Client] Result received from Server: " + result);
            
        } catch (Exception e) {}
    }
}
