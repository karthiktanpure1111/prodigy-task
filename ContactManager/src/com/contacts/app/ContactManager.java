package com.contacts.app;

import java.io.*;
import java.util.*;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

public class ContactManager {
    static List<Contact> contacts = new ArrayList<>();
    static final String FILE_NAME = "contacts.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadContacts();

        int choice;
        do {
            System.out.println("\n---- Contact Management System ----");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: editContact(); break;
                case 4: deleteContact(); break;
                case 5: saveContacts(); System.out.println("Contacts saved. Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\n-- Contact List --");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact #" + (i + 1));
            System.out.println(contacts.get(i));
            System.out.println("-------------------");
        }
    }

    static void editContact() {
        viewContacts();
        System.out.print("Enter contact number to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact c = contacts.get(index - 1);
        System.out.print("New Name (" + c.getName() + "): ");
        c.setName(scanner.nextLine());
        System.out.print("New Phone (" + c.getPhone() + "): ");
        c.setPhone(scanner.nextLine());
        System.out.print("New Email (" + c.getEmail() + "): ");
        c.setEmail(scanner.nextLine());
        System.out.println("Contact updated.");
    }

    static void deleteContact() {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(index - 1);
        System.out.println("Contact deleted.");
    }

    static void saveContacts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact c : contacts) {
                writer.println(c.getName());
                writer.println(c.getPhone());
                writer.println(c.getEmail());
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    static void loadContacts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name, phone, email;
            while ((name = reader.readLine()) != null &&
                   (phone = reader.readLine()) != null &&
                   (email = reader.readLine()) != null) {
                contacts.add(new Contact(name, phone, email));
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}
