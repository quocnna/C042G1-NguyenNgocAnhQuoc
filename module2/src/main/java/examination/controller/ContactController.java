package examination.controller;

import com.opencsv.exceptions.CsvException;
import examination.common.Utils;
import examination.common.Validation;
import examination.model.Contact;
import examination.service.ContactManager;
import examination.service.MainManager;
import java.io.IOException;
import java.util.*;

public class ContactController {
    private static Scanner scanner = new Scanner(System.in);
    private static MainManager<Contact> contactManager = new MainManager<>(new ContactManager());

    public static void DisplayMainMenu() throws Exception {
        System.out.println("1. Add New Contact");
        System.out.println("2. Show Contact");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Sort Product");
        System.out.println("7. Exit Program");
        int numberChoice = Integer.parseInt(Utils.GetNumberChoice());
        switch (numberChoice) {
            case 1:
                addNewContact();
                backMainMenu();
                break;
            case 2:
                showContacts();
                backMainMenu();
                break;
            case 3:
                updateContact();
                backMainMenu();
                break;
            case 4:
                deleteContact();
                backMainMenu();
                break;
            case 5:
                searchContact();
                backMainMenu();
                break;
            case 6:
                sortContact();
                backMainMenu();
                break;
            case 7:
                System.exit(0);
        }
    }

    private static void sortContact() throws IOException, CsvException {
        List<Contact> contactList= contactManager.GetContacts();
        contactList.sort(Comparator.comparing(Contact::getFullName).thenComparing(Contact::getEmail));
        contactList.stream().forEach(e-> System.out.println(e));

    }

    private static void searchContact() throws IOException, CsvException {
        contactManager.ShowContacts();
        int count = 0;
        String phoneOrName;
        do {
            System.out.print(count == 0 ? "Please input phone number or name for search: " : "Please input again with correct format: ");
            phoneOrName = scanner.nextLine();
            count++;
        }
        while (!Validation.Check("PhoneOrNumber", phoneOrName));
        List<Contact> contactList = contactManager.SearchContact(phoneOrName);
        if (contactList.size() > 0) {
            String[] header = {"Phone Number", "Contact Group", "Full Name", "Gender", "Address", "Birthday", "Email"};
            for (int i = 0; i < header.length; i++) {
                System.out.print(header[i] + "\t");

            }
            System.out.println(System.lineSeparator());
            for (int i = 0; i < contactList.size(); i++) {
                System.out.print(contactList.get(i).getPhoneNumber() + "\t");
                System.out.print(contactList.get(i).getContactGroup() + "\t");
                System.out.print(contactList.get(i).getFullName() + "\t");
                System.out.print(contactList.get(i).getGender() + "\t");
                System.out.print(contactList.get(i).getAddress() + "\t");
                System.out.print(contactList.get(i).getBirthday() + "\t");
                System.out.print(contactList.get(i).getEmail() + "\t");
                System.out.println(System.lineSeparator());
            }
        }
        else
            System.out.println("No found this contact");
    }

    private static void deleteContact() throws Exception {
        contactManager.ShowContacts();
        int count = 0;
        String phoneNumber;
        do {
            System.out.print(count == 0 ? "Please input phone number for update: " : "No found this phone number, please input again: ");
            phoneNumber = scanner.nextLine();
            count++;
        }
        while (!Validation.Check("Phone Number", phoneNumber) || !contactManager.CheckPhoneNumber(phoneNumber));
        contactManager.DeleteContact(phoneNumber);
        System.out.println("Deleted contact successful");
    }

    private static void updateContact() throws Exception {
        contactManager.ShowContacts();
        int count = 0;
        String phoneNumber;
        do {
            System.out.print(count == 0 ? "Please input phone number for update: " : "Not found this phone number! Please input again: ");
            phoneNumber = scanner.nextLine();
            count++;
        }
        while (!Validation.Check("Phone Number", phoneNumber) || !contactManager.CheckPhoneNumber(phoneNumber));
        HashMap<String, String> hashMap = Utils.InputFields(Contact.class,true);
        Contact contact = new Contact(phoneNumber, hashMap.get("Contact Group"), hashMap.get("Full Name"),
                hashMap.get("Gender"), hashMap.get("Address"), hashMap.get("Birthday"), hashMap.get("Email"));

        boolean res= contactManager.UpdateContact(contact);
        System.out.println(res? "Updated contact successful":"Not found this contact");
    }

    private static void showContacts() throws IOException, CsvException {
        contactManager.ShowContacts();
    }

    private static void addNewContact() throws Exception {
        HashMap<String, String> hashMap = Utils.InputFields(Contact.class,false);
        Contact contact = new Contact(hashMap.get("Phone Number"), hashMap.get("Contact Group"), hashMap.get("Full Name"),
                hashMap.get("Gender"), hashMap.get("Address"), hashMap.get("Birthday"), hashMap.get("Email"));
        contactManager.Write(contact);
        System.out.println("Adding contact " + hashMap.get("Full Name") + " successful");
    }

    private static void backMainMenu() throws Exception {
        System.out.print("Do you back to main menu (Y/N): ");
        String ipAnswer = scanner.nextLine();
        if ("Y".equalsIgnoreCase(ipAnswer))
            DisplayMainMenu();
        else
            System.exit(0);
    }
}
