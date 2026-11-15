
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028"));
        persons.add(new Teacher("Mikael Nousiainen", "Leppavaara", 3850));

        printPersons(persons);
    }

    public static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
