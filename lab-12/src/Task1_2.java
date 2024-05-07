import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String surname;
    int score;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    @Override
    public String toString() {
        return surname + " - " + score;
    }
}

public class Task1_2 {
    public static void main(String[] args) {
        int value_budget_places = 3;
        int value_contract_places = 6;

        List<Student> students = new ArrayList<>();
        students.add(new Student("Moroz", 74));
        students.add(new Student("Horoz", 64));
        students.add(new Student("Naruto", 65));
        students.add(new Student("Mirni", 75));
        students.add(new Student("Mico", 79));
        students.add(new Student("Sigma", 99));
        students.add(new Student("Kim Jong Un", 100));
        students.add(new Student("Shelly", 70));
        students.add(new Student("Timoshenko", 78));
        students.add(new Student("Creeper", 97));
        students.add(new Student("Charlie", 40));
        students.add(new Student("Poco", 10));


        students.stream()
                .sorted(Comparator.comparing((Student s) -> s.score).reversed())
                .filter(s -> s.score >= 60)
                .skip(value_budget_places)
                .limit(value_contract_places)
                .forEach(System.out::println);
    }
}
