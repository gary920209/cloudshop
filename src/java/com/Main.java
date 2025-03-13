package src.java.com;

import src.java.com.command.Command;
import src.java.com.repository.ListingRepository;
import src.java.com.repository.UserRepository;
import src.java.com.service.Service;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Initialize repositories and services
        UserRepository userRepo = new UserRepository();
        ListingRepository listingRepo = new ListingRepository();
        Service service = new Service(userRepo, listingRepo);
        Command commandHandler = new Command(service);

        // Scanner for reading from STDIN
        Scanner scanner = new Scanner(System.in);

        // Main application loop
        while (true) {
            try {
                // Print prompt
                System.out.print("# ");
                System.out.flush();

                // Check if there is input available
                if (!scanner.hasNextLine()) {
                    break;
                }

                // Read command
                String command = scanner.nextLine().trim();
                if (command.isEmpty()) {
                    continue;
                }

                // Exit on 'exit' command
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                // Handle command and print response
                String response = commandHandler.handleCommand(command);
                System.out.println(response);

            } catch (NoSuchElementException e) {
                // End of input
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
