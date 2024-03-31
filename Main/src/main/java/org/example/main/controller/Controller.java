package org.example.main.controller;

import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.main.service.ServiceInterface;

@Component
public class Controller {
    private ServiceInterface service;
    @AutoWire
    public Controller(ServiceInterface service)
    {
        this.service = service;
    }
    public void execute()
    {
        System.out.println(service.execute());
    }
}
