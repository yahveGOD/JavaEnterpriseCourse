package org.example.main.service.impl;

import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.main.repository.DatabaseInterface;
import org.example.main.service.ServiceInterface;
@Component
public class ServiceInterfaceImpl implements ServiceInterface {

    private DatabaseInterface database;
    @AutoWire
    public void setDatabase(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public String execute() {
        return database.execute();
    }
}
