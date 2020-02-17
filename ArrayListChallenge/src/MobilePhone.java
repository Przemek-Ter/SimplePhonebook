import java.util.ArrayList;

public class MobilePhone {
    private String myMobilephone;
    private ArrayList<Contacts> myContacts;

    // Constructors

    public MobilePhone(String myMobilephone) {
        this.myMobilephone = myMobilephone;
        this.myContacts = new ArrayList<Contacts>();
    }

    // Print Array

    public void printContacts() {
        System.out.println("Your Contacts : ");
        for (int i = 0 ; i < myContacts.size() ; i++) {
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getNumber());
        }
    }

    // Add

    public boolean addContact(Contacts contacts) {
        if (findContact(contacts.getName()) >= 0) {
            System.out.println("This contact already exist");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    // Modify

    public boolean modifyContact(Contacts oldContacts, Contacts newContacts) {
        int position = findContact(oldContacts);
        if (position >= 0) {
            myContacts.set(position, newContacts);
            System.out.println("Contact " + oldContacts.getName() + " have bean changed to " + newContacts.getName());
            return true;
        }else {
            System.out.println("There is no " + oldContacts.getName() + " contact");
            return false;
        }
    }

    // Remove

    public void removeContact(String toRemove) {
        int position = findContact(toRemove);
        if (position >= 0) {
            this.myContacts.remove(position);
        }else {
            System.out.println("tehre is no " + toRemove + " contact");
        }
    }

    // Find

    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String name) {
        for (int i = 0 ; i < this.myContacts.size() ; i++) {
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

}
