package org.example.main.repository.impl;

import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.main.model.ParametersHolder;
import org.example.main.repository.DatabaseInterface;
@Component
public class DatabaseInterfaceImpl implements DatabaseInterface {
    @AutoWire
    private ParametersHolder parametersHolder;
    @Override
    public String execute() {
        return parametersHolder.getSomeText();
    }
}
