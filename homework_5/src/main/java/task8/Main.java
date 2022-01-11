package task8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "task8")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Person.class, PersonPrinter.class);
        context.refresh();
        Person person = context.getBean(Person.class);
        PersonPrinter personPrinter = context.getBean(PersonPrinter.class);

        personPrinter.printPerson();
    }
}
