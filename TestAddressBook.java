
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        FileReader fr = null;
        BufferedReader br = null;

        String tokens[] = null;
        String name, add, ph;

        try {
            fr = new FileReader("output.txt");
            br = new BufferedReader(fr);

            String s = br.readLine();
            while (s != null) {
                tokens = s.split(",");
                name = tokens[0];
                add = tokens[1];
                ph = tokens[2];
                PersonInfo p = new PersonInfo(name, add, ph);
                persons.add(p);
                s = br.readLine();

            }
            br.close();
            fr.close();

        } catch (Exception ex) {
        }
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
        System.out.println("Saving data before close...");
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("output.txt");
            pw = new PrintWriter(fw);
            for (int i = 0; i < persons.size(); i++) {
                pw.print(persons.get(i).name + ",");
                pw.print(persons.get(i).address + ",");
                pw.print(persons.get(i).phoneNum + "");
                pw.println();
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception occurred");
        }

        System.exit(0);
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
                    myAddressBook.exitApp();
                    break;

            }
        }
    }
}
