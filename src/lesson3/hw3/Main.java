package lesson3.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class PhoneBook{
    private HashMap<String, ArrayList<Person>> phoneBook = new HashMap<>();

    PhoneBook(Person[] persons) {
        for(int i = 0; i < persons.length; i++){
            if(phoneBook.containsKey(persons[i].lastName)){
                ArrayList<Person> name = phoneBook.get(persons[i].lastName);
                name.add(persons[i]);
            }else {
                ArrayList<Person> name = new ArrayList<>();
                name.add(persons[i]);
                phoneBook.put(persons[i].lastName ,name);
            }
        }
    }
    public void printPhonesByName(String name){
        System.out.println("\n" + name + " phones:");
        for (String phone: getPhones(name)) {
            System.out.println("    " + phone);
        }
    }

    public void printEmailsByName(String name){
        System.out.println("\n" + name + " eMails:");
        for (String email: getEmails(name)) {
            System.out.println("    " + email);
        }
    }
    private ArrayList<String> getPhones(String  name){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Person> persons = phoneBook.get(name);
        for (int i = 0; i < persons.size(); i++){
            list.add(persons.get(i).phone);
        }
        return list;
    }

    private ArrayList<String> getEmails(String name){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Person> persons = phoneBook.get(name);
        for (int i = 0; i < persons.size(); i++){
            list.add(persons.get(i).email);
        }
        return list;
    }
}

class Person{
    String lastName;
    String email;
    String phone;
    Person(String str){
        lastName = str;
        phone = generateNumber();
        email = generateEmail(str);
    }
    private String generateNumber(){
        Random rand = new Random();
        String str = "+7(" + (rand.nextInt(899) + 100) + ")" + (rand.nextInt(899) + 100) + "-" + (rand.nextInt(89) + 10) + "-" + (rand.nextInt(89) + 10);
        return str;
    }

    private String generateEmail(String name){
        Random rand = new Random();
        String str =
                name.toLowerCase() + (rand.nextInt(99) + 1900) + "@gmail.com";
        return str;
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] names = {"Lennon", "McCartney","Lennon", "McCartney", "Harrison", "Starr", "Bond", "Black", "White", "Lennon", "McCartney"};
        Person[] persons = new Person[names.length];
        for(int i = 0; i < names.length; i++){
            persons[i] = new Person(names[i]);
        }
        PhoneBook p = new PhoneBook(persons);
        p.printEmailsByName(names[rand.nextInt(names.length)]);
        p.printPhonesByName(names[rand.nextInt(names.length)]);




    }
}