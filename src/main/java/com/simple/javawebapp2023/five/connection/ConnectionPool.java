package com.simple.javawebapp2023.five.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static ConnectionPool INSTANCE;
    private static final int SIZE = 5;
    private static final List<Connection> pool = new ArrayList<>(SIZE);
    private int first = 0;
    private int last = 0;
    private int free = SIZE;

    private ConnectionPool() {
        for (int i = 0; i < SIZE; i++) {
            Connection connection = createConnection();
            pool.add(connection);
        }
    }

    public static void close() {
        //zatvoriti

    }

    private Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "root");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Connection getConnection() {
        if (free == 0) {
            return null;
        }
        free--;
        Connection connection = pool.get(first);
        first = (first + 1) % SIZE;//RAZMISLITI
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        free++;
        pool.set(last, connection);
        last = (last + 1) % SIZE;
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }
}
