package org.example;

import org.example.annotations.AutoWire;
import org.example.context.ApplicationContext;
import org.example.controller.Controller;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = Applicaton.run("org.example");
        Controller controller = applicationContext.getObject(Controller.class);
        controller.execute();
    }
}
