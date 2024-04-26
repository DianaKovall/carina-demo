package koval.web.myfitnesspal;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private final List<String> connections;
    private int poolSize;
    private final Object lock = new Object();

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        connections = new ArrayList<>();
        for (int i = 0; i < poolSize; i++) {
            connections.add("Connection " + (i + 1));
        }
    }

    public String getConnection() {
        synchronized (lock) {
            if (poolSize > 0) {
                String connection = connections.remove(poolSize - 1);
                poolSize--;
                return connection;
            } else {
                return null;
            }
        }
    }

    public void releaseConnection(String connection) {
        synchronized (lock) {
            connections.add(connection);
            poolSize++;
        }
    }

}
