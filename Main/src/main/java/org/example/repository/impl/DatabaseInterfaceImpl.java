package org.example.repository.impl;

import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.model.ParametersHolder;
import org.example.repository.DatabaseInterface;
@Component
public class DatabaseInterfaceImpl implements DatabaseInterface {
    @AutoWire
    private ParametersHolder parametersHolder;
    @Override
    public String execute() {
        return parametersHolder.getSomeText();
    }
}
