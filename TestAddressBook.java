
import java.util.ArrayList;
import javax.swing.JOptionPane;

class PersonInfo {

    String name;
    String address;
    String phoneNum;

    public PersonInfo(String name, String address, String pNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = pNum;
    }

    public void printPersonInfo() {
        JOptionPane.showMessageDialog(null, "Name: " + this.name + " Address:" + this.address + " Phone number: " + this.phoneNum);
    }
}

class AddressBook {

    ArrayList<PersonInfo> persons;

    public AddressBook() {
        persons = new ArrayList<PersonInfo>(); // persons is an array persons[]
    }

    public void addPerson() {
        String name = JOptionPane.showInputDialog("Enter name");
        String address = JOptionPane.showInputDialog("Enter address");
        String phoneNum = JOptionPane.showInputDialog("Enter Phone number");

        PersonInfo person = new PersonInfo(name, address, phoneNum);

        persons.add(person);

    }

    public void searchPerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i); // downcasting
            if (p.name.equals(n)) {
                p.printPersonInfo();
            }
        }
    }

    public void deletePerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i); // downcasting
            if (p.name.equals(n)) {
                persons.remove(i);
            }
        }
    }

    public void exitApp() {
    }
}

public class TestAddressBook {

    public static void main(String[] args) {
        AddressBook myAddressBook = new AddressBook();
        while (true) {
            String input = JOptionPane.showInputDialog("1: Add \n 2: Search \n 3: Delete \n 4:Exit");
            char ch = input.charAt(0);
            switch (ch) {
                case '1':
                    myAddressBook.addPerson();
                    break;
                case '2':
                    String nameToSearch = JOptionPane.showInputDialog(null, "Enter name to search");
                    myAddressBook.searchPerson(nameToSearch);
                    break;
                case '3':
                    String nameToDelete = JOptionPane.showInputDialog(null, "Enter name to delete the person data");
                    myAddressBook.deletePerson(nameToDelete);
                    break;
                case '4':
                    System.exit(0);
            }
        }
    }
}
