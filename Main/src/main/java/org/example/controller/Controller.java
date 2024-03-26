package org.example.controller;

import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.service.ServiceInterface;

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
