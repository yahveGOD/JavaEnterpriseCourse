package org.example.service.impl;

import lombok.Setter;
import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.repository.DatabaseInterface;
import org.example.service.ServiceInterface;
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
