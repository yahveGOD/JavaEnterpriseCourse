package org.example.main.util;

import liquibase.pro.packaged.C;
import liquibase.pro.packaged.T;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConnectionHolder {
    private final DataSource dataSource;
    private final Map<Thread,Connection> connectionMap = new HashMap<>();
    private final List<Connection> pool = new ArrayList<>();

    private Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @SneakyThrows
    public synchronized Connection getTransactionConnection() {
        Thread thread = Thread.currentThread();
        if(connectionMap.containsKey(thread)) {
            if (connectionMap.get(thread).isClosed())
                throw new RuntimeException("Connection is closed");

            return connectionMap.get(thread);
        } else {
            Connection connection = getConnectionFromPool();

            connectionMap.put(thread, connection);

            return connection;
        }
    }

    @SneakyThrows
    public synchronized Connection getConnection() {
        Thread thread = Thread.currentThread();
        if(connectionMap.containsKey(thread) && !connectionMap.get(thread).isClosed()) {
            return connectionMap.get(thread);
        } else {
            return getConnectionFromPool();
        }
    }

    @SneakyThrows
    private Connection getConnectionFromPool() {
        if (pool.isEmpty()) {
            Connection connection = createConnection();
            return connection;
        }
        Connection connection = pool.remove(pool.size() - 1);

        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {

        Thread currentThread = Thread.currentThread();
        if (connectionMap.containsKey(currentThread)) {
            Connection currentConnection = connectionMap.remove(currentThread);
            currentConnection.close();
        }
        pool.add(connection);

    }
}
