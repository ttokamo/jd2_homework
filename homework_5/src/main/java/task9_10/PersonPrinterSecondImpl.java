package task9_10;

import org.springframework.beans.factory.annotation.Autowired;

@InPriority
public class PersonPrinterSecondImpl implements PersonPrinterInterface {
    private final Person person;

    @Autowired
    public PersonPrinterSecondImpl(Person person) {
        this.person = person;
    }

    @Override
    public void printPerson() {
        System.out.println("This is second implementation");
        System.out.println(person);
    }
}
