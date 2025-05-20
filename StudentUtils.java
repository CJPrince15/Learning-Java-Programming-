import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtils {

    public static List<Student> loadStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the format is: name surname score
                // e.g. John Doe 4.5
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    String name = parts[0];
                    String surname = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    students.add(new Student(name, surname, score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
