import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "studentsEN.txt"; // path to the file

        List<Student> students = StudentUtils.loadStudentsFromFile(filename);

        // 1) Find students with a grade of 5 and print them on the console
        System.out.println("Students with grade 5:");
        students.stream()
                .filter(s -> s.getScore() == 5)
                .forEach(System.out::println);

        // 2) Calculate the average of all students' grades
        double averageScore = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage score: " + averageScore);

        // 3) Calculate how many students we have with a grade of 5
        long countGrade5 = students.stream()
                .filter(s -> s.getScore() == 5)
                .count();
        System.out.println("\nNumber of students with grade 5: " + countGrade5);
    }
}
