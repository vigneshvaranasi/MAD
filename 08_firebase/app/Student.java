public class Student {
    private String roll,name,grade,avg;
    public Student(String roll, String name, String grade, String avg) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
        this.avg = avg;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
}
