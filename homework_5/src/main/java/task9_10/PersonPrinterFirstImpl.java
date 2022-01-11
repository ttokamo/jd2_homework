package task9_10;

import org.springframework.beans.factory.annotation.Autowired;

@InPriority
public class PersonPrinterFirstImpl implements PersonPrinterInterface {
    private final Person person;

    @Autowired
    public PersonPrinterFirstImpl(Person person) {
        this.person = person;
    }

    @Override
    public void printPerson() {
        System.out.println("This is first implementation");
        System.out.println(person);
    }
}
