package task8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonPrinter {
    private final Person person;

    @Autowired
    public PersonPrinter(Person person) {
        this.person = person;
    }

    public void printPerson() {
        System.out.println(person);
    }
}
