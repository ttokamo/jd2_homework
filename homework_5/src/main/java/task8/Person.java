package task8;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
public class Person {
    @Value("Pavel")
    private String name;
    @Value("Petrov")
    private String surname;

    @Override
    public String toString() {
        return name + " " + surname + "\n";
    }
}
