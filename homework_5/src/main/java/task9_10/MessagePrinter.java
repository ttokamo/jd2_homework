package task9_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@InPriority
public class MessagePrinter {

    PersonPrinterInterface personPrinterInterface;

    @Autowired
    public MessagePrinter(@Qualifier("personPrinterSecondImpl") PersonPrinterInterface personPrinterInterface) {
        this.personPrinterInterface = personPrinterInterface;
    }

    public void printMessage() {
        System.out.println("Program started");
        personPrinterInterface.printPerson();
    }
}
