package org.example.main.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.main.annotation.Transaction;
import org.example.main.util.ConnectionHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Aspect
@RequiredArgsConstructor
public class TransactionAspect {
    private final ConnectionHolder connectionHolder;

    @Before("@annotation(Transaction)")
    public void transactionAnnotationPointcut() throws SQLException {
        connectionHolder.transactional = true;
        connectionHolder.getConnection().beginRequest();
    }

    @Around("transactionAnnotationPointcut()")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = connectionHolder.getConnection();
        try {

            Object result = joinPoint.proceed();

            commitTransaction();

            return result;
        } catch (RuntimeException e) {

            rollbackTransaction();
            throw e;
        }
        finally {
            connection.setAutoCommit(true);
            connectionHolder.closeConnection(connection);
        }
    }

    private void rollbackTransaction() {
        try {
            Connection connection = connectionHolder.getConnection();
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void beginTransaction()
    {
        try {
            Connection connection = connectionHolder.getConnection();
            connection.beginRequest();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void commitTransaction()
    {
        try {
            Connection connection = connectionHolder.getConnection();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
