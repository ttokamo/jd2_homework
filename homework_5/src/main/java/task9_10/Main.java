package task9_10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = InPriority.class))
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MessagePrinter.class, PersonPrinterFirstImpl.class, PersonPrinterSecondImpl.class, Person.class);
        context.refresh();
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
