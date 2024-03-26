package org.example.model;
import lombok.Getter;
import org.example.annotations.Component;
import org.example.annotations.Value;

@Component
public class ParametersHolder {
    @Getter
    @Value("value")
    private String someText;
}
