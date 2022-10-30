import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFileHelper {

    //Reads a text file and return its content in the format of a List of String
    public static List<String> readLinesFromFile(String fileName) {

        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
