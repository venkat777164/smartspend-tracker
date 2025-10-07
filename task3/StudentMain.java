public class StudentMain {
    public static void main(String[] args) {
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

// Custom exception for invalid name
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

class Student {
    int rollNo;
    String name;
    int age;
    String course;

    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age not within range (15-21)");
        }
        if (!name.matches("[a-zA-Z ]+")) {
            throw new NameNotValidException("Name is not valid (no numbers or special characters allowed)");
        }

        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }
    }
}
}