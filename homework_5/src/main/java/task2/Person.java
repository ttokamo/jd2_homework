package task2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Person {
    @PostConstruct
    public void init() {
        System.out.println("Person initialize");
        destroy();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Person destroyed");
    }
}
