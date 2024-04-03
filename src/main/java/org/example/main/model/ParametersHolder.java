package org.example.main.model;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParametersHolder {
    @Getter
    @Value("value")
    private String someText;
}
