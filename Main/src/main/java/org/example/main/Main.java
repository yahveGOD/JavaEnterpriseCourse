package org.example.main;

import org.example.Applicaton;
import org.example.context.ApplicationContext;
import org.example.main.controller.Controller;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = Applicaton.run("org.example.main");
        Controller controller = applicationContext.getObject(Controller.class);
        controller.execute();
    }
}
