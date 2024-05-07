import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Institute {
    String name;
    List<Faculty> facultyList;

    public Institute(String name, List<Faculty> facultyList) {
        this.name = name;
        this.facultyList = facultyList;
    }

    @Override
    public String toString() {
        return name + " - " + facultyList;
    }
}

class Faculty {
    String facultyName;
    List<Enrollee> studentList;

    public Faculty(String facultyName, List<Enrollee> studentList) {
        this.facultyName = facultyName;
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return facultyName + " - " + studentList;
    }
}

class Enrollee {
    String enrolleeName;
    String enrolleeSurname;
    Integer numberOfExamBook;
    Integer avgScore;

    public Enrollee(String enrolleeName, String enrolleeSurname, Integer numberOfExamBook, Integer avgScore) {
        this.enrolleeName = enrolleeName;
        this.enrolleeSurname = enrolleeSurname;
        this.numberOfExamBook = numberOfExamBook;
        this.avgScore = avgScore;
    }

    public String getEnrolleeName() {
        return enrolleeName;
    }
    public String getEnrolleeSurname() {
        return enrolleeSurname;
    }
    public Integer getNumberOfExamBook() {
        return numberOfExamBook;
    }

    @Override
    public String toString() {
        return enrolleeName + " " + enrolleeSurname + " (" + numberOfExamBook + ") - " + avgScore;
    }
}

public class Task2_1 {
    public static void main(String[] args) {
        List<Enrollee> enrollees = new ArrayList<>();
        enrollees.add(new Enrollee("Kim", "Son", 4, 67));
        enrollees.add(new Enrollee("Kim", "Bon", 2, 47));
        enrollees.add(new Enrollee("Kim", "Ton", 34, 97));
        enrollees.add(new Enrollee("Aim", "Ron", 4, 67));
        enrollees.add(new Enrollee("Aim", "Ron", 3, 47));
        enrollees.add(new Enrollee("Aim", "Ron", 2, 87));

        Institute institute = new Institute("Kpi", List.of(new Faculty("IT", enrollees)));

        institute.facultyList.stream()
                .flatMap(faculty -> faculty.studentList.stream())
                .sorted(Comparator.comparing(Enrollee::getEnrolleeName)
                        .thenComparing(Enrollee::getEnrolleeSurname)
                        .thenComparing(Enrollee::getNumberOfExamBook))
                .forEach(System.out::println);

    }
}
