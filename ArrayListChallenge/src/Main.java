import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("Iphone");

    public static void main(String[] args) {

        boolean flag = true;

        startPhone();
        printList();

        while (flag) {

            System.out.println("Enter accion number : ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 0:
                    printList();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }


    }

    // Add

    private static void addContact() {
        System.out.println("Enter contact name : ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number : ");
        String number = scanner.nextLine();

        Contacts newContact = Contacts.createContact(name,number);
        if (mobilePhone.addContact(newContact)) {
            System.out.println("New contact added: name- " + name + ", phone number- " + number);
        }else {
            System.out.println("Can't add " + name + ", already on file");
        }
    }

    // Modify

    private static void modifyContact() {
        System.out.println("Enter contact name you want to change: ");
        String name = scanner.nextLine();
        Contacts oldContact = mobilePhone.queryContact(name);

        if (oldContact == null) {
            System.out.println("Can not find that contact");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newname = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newnumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newname,newnumber);

        mobilePhone.modifyContact(oldContact, newContact);

    }

    // Remove

    private static void removeContact() {
        System.out.println("Enter contact name you want to remove: ");
        String name = scanner.nextLine();
        Contacts oldContact = mobilePhone.queryContact(name);

        if (oldContact == null) {
            System.out.println("Can not find that contact");
            return;
        }
        System.out.println("Contact successfully removed ");
        mobilePhone.removeContact(name);
    }

    // Start Phone

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    // Menu

    private static void printList() {
        System.out.println("Press 0 if you want to see menu");
        System.out.println("press 1 if you want to see Contacts");
        System.out.println("press 2 if you want to add Contact");
        System.out.println("press 3 if you want to modify Contact");
        System.out.println("press 4 if you want to remove Contact");
        System.out.println("press 5 if you want to exit program");
    }

}
