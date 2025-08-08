package hibernate.demo;

import java.util.List;
import java.util.Scanner;

import hibernate.demo.entity.Pan;
import hibernate.demo.repo.PanRepo;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- PAN Management Menu ---");
            System.out.println("1. Create PAN Record");
            System.out.println("2. Find PAN by ID");
            System.out.println("3. Update PAN Record");
            System.out.println("4. Delete PAN by ID");
            System.out.println("5. Find All PAN Records");
            System.out.println("6. Find All PAN Holder Names");
            System.out.println("7. Find PAN by PAN Number");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PanRepo.createPan();
                    break;
                case 2:
                    System.out.print("Enter PAN ID: ");
                    int id = sc.nextInt();
                    Pan pan = PanRepo.findByPanId(id);
                    System.out.println(pan != null ? pan : "PAN not found.");
                    break;
                case 3:
                    PanRepo.updatePan();
                    break;
                case 4:
                    System.out.print("Enter PAN ID to delete: ");
                    int delId = sc.nextInt();
                    PanRepo.deletePanById(delId);
                    break;
                case 5:
                    List<Pan> all = PanRepo.findAll();
                    System.out.println("All PAN Records: " + all);
                    break;
                case 6:
                    List<String> names = PanRepo.findAllHolderNames();
                    System.out.println("PAN Holder Names: " + names);
                    break;
                case 7:
                    System.out.print("Enter PAN Number: ");
                    String number = sc.next();
                    List<Pan> byNumber = PanRepo.findByPanNumber(number);
                    System.out.println("Matching PAN Records: " + byNumber);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}
