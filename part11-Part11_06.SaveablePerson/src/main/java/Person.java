
public class Person implements Saveable {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public void save() {
        // saving the person
    }

    @Override
    public void delete() {
        // deleting the person
    }

    @Override
    public void load(String fileName) {
        // loading the person
    }
}
