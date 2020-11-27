package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDataManager {
    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    static List<Employee> employees = new ArrayList<Employee>();
    static int x = 1;
    private static boolean exit = false;

    public static void addEmployees() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < x; i++, x++) {
            System.out.println("Enter employee[" + employees.size() + "]");
            System.out.println("Enter employee name");
            String name = scanner.next();
            System.out.println("Enter employee surname");
            String surname = scanner.next();
            System.out.println("Enter employee birthdate (00-Month-0000)");

            LocalDate birthdate = LocalDate.parse(scanner.next(), dateFormat);
            Employee emp = new Employee(name, surname, birthdate);
            employees.add(emp);
            System.out.println("continue adding employees?(True/False)");
            boolean y = scanner.nextBoolean();
            if (y == false) {
                break;
            } else {
                continue;
            }
        }
    }

    public static void displayEmployee() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Displaying employee[" + i + "]");
            String name;
            String surname;
            LocalDate birthdate;
            name = employees.get(i).getName();
            surname = employees.get(i).getSurname();
            birthdate = employees.get(i).getBirthdate();
            System.out.println(name);
            System.out.println(surname);
            System.out.println(birthdate);
        }
    }

    public static void displayEmployee(int n) {
        System.out.println("Displaying employee[" + n + "]");
        String name;
        String surname;
        LocalDate birthdate;
        name = employees.get(n).getName();
        surname = employees.get(n).getSurname();
        birthdate = employees.get(n).getBirthdate();
        System.out.println(name);
        System.out.println(surname);
        System.out.println(birthdate);
    }

    //
    private static void searchEmployee() throws ParseException {
        boolean exit1 = false;
        int z = 0;
        Scanner scanner = new Scanner(System.in);
        String name;
        String surname;
        LocalDate birthdate;
        while (!exit1) {
            printSearch();
            int choice = getMenuChoice();
            switch (choice) {
                case 1:z=0;
                    System.out.println("Enter name:");
                    name = scanner.next();
                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).getName().equals(name)) {
                            displayEmployee(i);z = 1;
                        }
                    }if (z==0){
                    System.out.println("There is no employee with the selected name");
                }
                    break;
                case 2:z=0;
                    System.out.println("Enter surname:");
                    surname = scanner.next();
                        for (int i = 0; i < employees.size(); i++) {
                            if (employees.get(i).getSurname().equals(surname)) {
                                displayEmployee(i);
                                z = 1;
                            }
                        }if (z==0){
                    System.out.println("There is no employee with the selected surname");
                }

                    break;
                case 3:z=0;
                    System.out.println("Enter birthdate: (00-Month-0000)");
                    birthdate = LocalDate.parse(scanner.next(), dateFormat);
                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).getBirthdate().equals(birthdate)) {
                            displayEmployee(i);z = 1;
                        }
                    }if (z==0){
                    System.out.println("There is no employee with the selected birthdate");
                }
                    break;
                default:
                    System.out.println("Unknown error");
                case 4:
                    exit1 = true;
            }

        }


    }

    //
    public static void manageEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Modify employee");
        int n;
        String surname;
        String name;
        LocalDate birthdate;
        System.out.println("Enter employee position :");
        n = scanner.nextInt();
        employees.remove(n);
        System.out.println("Enter employee name");
        name = scanner.next();
        System.out.println("Enter employee surname");
        surname = scanner.next();
        System.out.println("Enter employee birthdate (00-Month-0000)");
        birthdate = LocalDate.parse(scanner.next(), dateFormat);
        Employee emp = new Employee(name, surname, birthdate);
        employees.add(n, emp);
    }

    public static void deleteEmployee() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete employee");
        System.out.println("Enter employee position for delete :");
        int n = scanner.nextInt();
        employees.remove(n);
        --x;
    }

    public static void runMenu() throws ParseException {
        while (!exit) {
            printHeader();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    public static void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Choose what to do          |");
        System.out.println("|        1.Add Employee             |");
        System.out.println("|        2.Display Employee         |");
        System.out.println("|        3.Manage Employee          |");
        System.out.println("|        4.Search Employee          |");
        System.out.println("|        5.Delete Employee          |");
        System.out.println("|        6.Exit                     |");
        System.out.println("+-----------------------------------+");
    }

    public static void printSearch() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Choose what to search by   |");
        System.out.println("|        1.Search by name           |");
        System.out.println("|        2.Search by surname        |");
        System.out.println("|        3.Search by birthdate      |");
        System.out.println("|        4.Exit                     |");
        System.out.println("+-----------------------------------+");
    }

    private static int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid selection. Numbers only.");
            }
            if (choice < 0 || choice > 6) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 6);
        return choice;
    }

    private static void performAction(int choice) throws ParseException {
        switch (choice) {
            case 1:
                EmployeeDataManager.addEmployees();
                break;
            case 2:
                EmployeeDataManager.displayEmployee();
                break;
            case 3:
                EmployeeDataManager.manageEmployee();
                break;
            case 4:
                EmployeeDataManager.searchEmployee();
                break;
            case 5:
                EmployeeDataManager.deleteEmployee();
                break;
            default:
                System.out.println("Unknown error");
            case 6:
                exit = true;
        }
    }


}
