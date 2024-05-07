import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Applicant {
    String surname;
    int score;

    public Applicant(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    @Override
    public String toString() {
        return surname + " - " + score;
    }
}

public class Task3_1 {
    public static void main(String[] args) {
        int value_budget_places = 3;
        int value_contract_places = 6;

        List<Applicant> students = new ArrayList<>();
        students.add(new Applicant("Moroz", 74));
        students.add(new Applicant("Horoz", 64));
        students.add(new Applicant("Naruto", 65));
        students.add(new Applicant("Mirni", 75));
        students.add(new Applicant("Mico", 79));
        students.add(new Applicant("Sigma", 99));
        students.add(new Applicant("Kim Jong Un", 100));
        students.add(new Applicant("Shelly", 70));
        students.add(new Applicant("Timoshenko", 78));
        students.add(new Applicant("Creeper", 97));
        students.add(new Applicant("Charlie", 40));
        students.add(new Applicant("Poco", 10));


        students.stream()
                .sorted(Comparator.comparing((Applicant s) -> s.score).reversed())
                .filter(s -> s.score <= 60)
                .forEach(System.out::println);
    }
}
