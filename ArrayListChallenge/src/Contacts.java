public class Contacts extends MobilePhone {
    private String name;
    private String number;

    // Constructors

    public Contacts(String name, String number) {
        super("Iphone");
        this.name = name;
        this.number = number;
    }


    // Getters

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    // Methods

    public static Contacts createContact(String name, String number) {
        return new Contacts(name,number);
    }


}
