import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) throws IOException, ParseException {
       
            if (args.length != 1) {
            System.out.println("Usage: ");
            System.exit(1);
        }

        String csvFilePath = args[0];
        long buildStartTime = System.currentTimeMillis();

        // Create a map of car make to binary search tree
        Map<String, BinaryTree> bstMap = new HashMap<>();

        // Read the CSV file and build the binary search trees
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(tokens[0]);
            SaleRecord saleRecord = new SaleRecord(date, tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]),
                    Double.parseDouble(tokens[6]), Double.parseDouble(tokens[7]), Double.parseDouble(tokens[8]));

            // Get the car make
            String carMake = saleRecord.getCarMake();

            // Get the binary search tree for the car make
            BinaryTree bst = bstMap.get(carMake);
            if (bst == null) {
                bst = new BinaryTree();
                bstMap.put(carMake, bst);
            }

            // Insert the sale record into the binary search tree
            bst.insert(saleRecord);
        }
        reader.close();

        long buildEndTime = System.currentTimeMillis();
        System.out.println((buildEndTime - buildStartTime) + " milliseconds to build the binary search trees");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the car make (e.g., Nissan): ");
            String carMakeInput = scanner.nextLine();
            if (carMakeInput.isEmpty()) {
                break;
            }

            System.out.println("Enter the date (e.g., 2022-08-01): ");
            String dateInput = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date searchDate = dateFormat.parse(dateInput);

            // Get the binary search tree for the car make
            BinaryTree bst = bstMap.get(carMakeInput);

            if (bst != null) {
                long startTime = System.currentTimeMillis();
                int salesCount = bst.search(searchDate);
                long endTime = System.currentTimeMillis();
                System.out.println(salesCount + " sales records are available for " + carMakeInput + " after the date " + dateInput);
                System.out.println((endTime - startTime) + " milliseconds to calculate using children count fields");

                startTime = System.currentTimeMillis();
                int recursiveSalesCount = bst.recursiveSearch(searchDate);
                endTime = System.currentTimeMillis();
                System.out.println(recursiveSalesCount + " sales records are available for " + carMakeInput + " after the date " + dateInput);
                System.out.println((endTime - startTime) + " milliseconds to calculate using recursive method");
            } else {
                System.out.println("No records found for car make: " + carMakeInput);
            }
        }

        scanner.close();
    }
}
