import java.util.HashMap;
import java.util.Scanner;

public class OnlineReservationSystem {
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        users.put("Akhila", "123");
        System.out.println("Enter your login ID:");
        String loginId = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        if (login(loginId, password)) {
            System.out.println("Login successful!");
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        makeReservation(scanner, loginId);
                        break;
                    case 2:
                        cancelReservation(scanner, loginId);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }
    private static boolean login(String loginId, String password) {
        return users.containsKey(loginId) && users.get(loginId).equals(password);
    }
    private static void cancelReservation(Scanner scanner, String userId) {
        System.out.println("Enter PNR Number:");
        String res = scanner.nextLine();
        if (reservations.containsKey(res)) {
            reservations.remove(res);
            System.out.println("Cancellation successful for PNR: " + res);
        } else {
            System.out.println("PNR not found!");
        }
    }
    private static void makeReservation(Scanner scanner, String userId) {
        System.out.println("Enter Train Number:");
        String trainNumber = scanner.nextLine();
        System.out.println("Enter Date of Journey (dd/mm/yyyy):");
        String dateOfJourney = scanner.nextLine();
        System.out.println("Enter From Location:");
        String from = scanner.nextLine();
        System.out.println("Enter To Location:");
        String to = scanner.nextLine();

        String res = "RES" + (reservations.size() + 1);
        String reservationDetails = "Train: " + trainNumber + ", Date: " + dateOfJourney + "," +
                " From: " + from + ", To: " + to;

        reservations.put(res, reservationDetails);

        System.out.println("Reservation successful! Your RES: " + res);
    }
}