package com.zerodaytrace;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class IDCardMain {
    public static void main(String[] args) {
        List<IDCardGenerator.IDCard> cardList = new ArrayList<>();
        Map<String, IDCardGenerator.IDCard> cardMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nID Card Generator System");
            System.out.println("1. Generate New ID Card");
            System.out.println("2. Search by ID Number");
            System.out.println("3. Display All Cards (Sorted)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine().trim();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine().trim();
                    System.out.print("ID Number: ");
                    String idNumber = scanner.nextLine().trim();
                    System.out.print("Date of Birth (yyyy-MM-dd): ");
                    String dateOfBirth = scanner.nextLine().trim();
                    System.out.print("Role (e.g., Student, Employee, Admin): ");
                    String role = scanner.nextLine().trim();
                    System.out.print("Gender (M/F): ");
                    String gender = scanner.nextLine().trim();


                    if (cardMap.containsKey(idNumber)) {
                        System.out.println("Error: ID Number already exists in the system!");
                        break;
                    }

                    try {
                        IDCardGenerator.IDCard newCard = new IDCardGenerator.IDCard(firstName, lastName, idNumber, dateOfBirth, role, gender);
                        cardList.add(newCard);
                        cardMap.put(idNumber, newCard);
                        System.out.println("ID Card generated successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd format");
                    }
                    break;

                case 2:
                    System.out.print("Enter ID Number to search: ");
                    String searchId = scanner.nextLine().trim();
                    IDCardGenerator.IDCard found = cardMap.get(searchId);
                    if (found != null) {
                        System.out.println("\n" + found);
                    } else {
                        System.out.println("No ID card found with that matches that number.");
                    }
                    break;

                case 3:
                    if (cardList.isEmpty()) {
                        System.out.println("No cards generated yet.");
                        break;
                    }
                    System.out.println("\n All Generated ID Cards (Sorted by ID Number):");
                    List<IDCardGenerator.IDCard> sortedCards = new ArrayList<>(cardList);
                    Collections.sort(sortedCards, Comparator.comparing(IDCardGenerator.IDCard::getIdNumber));

                    Iterator<IDCardGenerator.IDCard> it = sortedCards.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                        System.out.println("──────────────────────────────");
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid input. Please choose 1-4.");
            }
        }
    }
}