package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> listOfPerson;

    public SantaClaus(List<Person> listOfPerson) {
        this.listOfPerson = listOfPerson;
    }

    public List<PersonPresent> getThroughChimneys() {
        List<PersonPresent> listOfPresentsByPersonNames = new ArrayList<>();
        for (Person p : listOfPerson) {
            listOfPresentsByPersonNames.add(new PersonPresent(p.getName(), p.getPresent()));
        }
        return listOfPresentsByPersonNames;
    }
}
