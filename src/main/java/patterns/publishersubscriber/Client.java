package main.java.patterns.publishersubscriber;

public class Client {
    public static void main(String[] args) {
        FSServer server = new FSServer(".");
        server.addClient(new FSMonitor() {
            @Override
            public void event(String fName, int kind) {
                switch (kind) {
                    case FSMonitor.CREATE:
                        System.out.println("File was created");
                        break;
                    case FSMonitor.REMOVE:
                        System.out.println("File was removed");
                        break;
                }
            }
        });
        server.start();
    }
}
