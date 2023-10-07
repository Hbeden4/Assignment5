import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<String[]> readCSV(String csvFilePath) throws IOException {
        List<String[]> records = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            records.add(tokens);
        }
        reader.close();

        return records;
    }
}