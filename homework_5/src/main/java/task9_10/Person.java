package task9_10;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@InPriority
@Scope("prototype")
@Getter
public class Person {
    @Value("Stepan")
    private String name;
    @Value("Stepanov")
    private String surname;

    @Override
    public String toString() {
        return name + " " + surname + "\n";
    }
}
