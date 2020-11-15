package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDataManager {
    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    static List<Employee> employees = new ArrayList<Employee>();

    static int x=1;
    private static boolean exit = false;

    public static void addEmployees() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < x; i++,x++) {
            System.out.println("Enter employee["+i+"]");
            System.out.println("Enter employee name");
            // TODO: de inlocuit name[i] surname[i] cu codul comentat
             String name = scanner.next();
//            employee.name[i]=scanner.next();
            System.out.println("Enter employee surname");
//            employee.surname[i]=scanner.next();
             String surname = scanner.next();
            System.out.println("Enter employee birthdate (00-Month-0000)");
//            employee.birthdate[i]=simpleDateFormat.parse(scanner.next());

            LocalDate birthdate = LocalDate.parse(scanner.next(),dateFormat);
            Employee emp = new Employee(name, surname, birthdate);
            employees.add(emp);
            System.out.println("continue adding employees?(True/False)");
            boolean y = scanner.nextBoolean();
            if(y == false){ break;}
            else {continue;}
        }

    }
    //

    public static void displayEmployee() {
        for (int i = 0; i < x; i++) {
            System.out.println("Displaying employee[" + i + "]");
            //System.out.println(" name : " + employees.get(i).getName() + " surname: " + employees.get(i).getSurname() + " birthdate: " + employees.get(i).getBirthdate());
            String surname;
            String name;
            LocalDate birthdate;
            surname = employees.get(i).getSurname();
            name = employees.get(i).getName();
            birthdate = employees.get(i).getBirthdate();
            System.out.println(surname);
            System.out.println(name);
            System.out.println(birthdate);
//            for (Employee x:employees){
//                System.out.println(x.getName());
//                System.out.println(x.getSurname());
//                System.out.println(x.getBirthdate());
//            }
        }
    }
    //
    public static void manageEmployee() throws ParseException {
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
                name=scanner.next();
                //employee.name[n]=scanner.next();
                System.out.println("Enter employee surname");
                surname=scanner.next();
                System.out.println("Enter employee birthdate (00-Month-0000)");
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
//                employee.birthdate[n]=simpleDateFormat.parse(scanner.next());
                  birthdate= LocalDate.parse(scanner.next(),dateFormat);
        Employee emp = new Employee(name, surname, birthdate);
                  employees.add(n,emp);

    }
//        neterminat
    public static void deleteEmployee() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete employee");
        System.out.println("Enter employee position for delete :");
        int n = scanner.nextInt();
//        for (int i = n+=1,j=i; i < x ; i++,j++) {
//            employee.name[i] = employee.name[j];
//            employee.surname[i] = employee.surname[j];
//            employee.birthdate[i] = employee.birthdate[j];
//            employee.name[--x] = null;
//            employee.surname[--x] = null;
//            employee.birthdate[--x] = null;
//        }
        employees.remove(n);
        --x;
    }

    /////Meniul:
    public static void runMenu() throws ParseException {
        while (!exit) {
            printHeader();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }
//litere mici
    public static void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Choose what to do          |");
        System.out.println("|        1.Add Employee             |");
        System.out.println("|        2.Display Employee         |");
        System.out.println("|        3.Manage Employee          |");
        System.out.println("|        4.Delete Employee          |");
        System.out.println("|        5.Exit                     |");
        System.out.println("+-----------------------------------+");
    }

    private static int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 5) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

    private static void performAction(int choice) throws ParseException {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
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
                EmployeeDataManager.deleteEmployee();
                break;
            default:
                System.out.println("Unknown error has occured.");
            case 5:
                exit = true;
        }
    }

    }
