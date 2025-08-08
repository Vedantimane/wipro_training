package com.wiproA.mockitdemo;

import java.sql.*;
import java.util.Scanner;

public class App {

    static String url = "jdbc:mysql://localhost:3306/Employee";
    static String username = "root";
    static String password = "Kimtae@7";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu-----");
            System.out.println("1 - Print Employee Records");
            System.out.println("2 - Add New Employee Record");
            System.out.println("3 - Exit");
            System.out.print("Enter choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    printData();
                    break;

                case 2:
                    insertData(scanner);
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    static void insertData(Scanner scanner) {
        String insertQuery = "INSERT INTO employee (emp_name, department) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setString(2, dept);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void printData() {
        String selectQuery = "SELECT id, emp_name, department FROM employee";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\nEmployee Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("emp_name");
                String dept = rs.getString("department");
                System.out.println(id + " | " + name + " | " + dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
