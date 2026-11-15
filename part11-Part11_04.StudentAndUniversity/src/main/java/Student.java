
public class Student {

    private int studentID;
    private String name;
    private University university;

    public Student(int studentID, String name, University university) {
        this.studentID = studentID;
        this.name = name;
        this.university = university;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public String getName() {
        return this.name;
    }

    public University getUniversity() {
        return this.university;
    }
}
