package baiTap;

public class Student extends Person {
    private int mark;
    private String grade;
     
    public Student(String id, String name, int age, int mark) {
    super(id, name, age);
    this.mark = mark;
    setGrade(mark);
}
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
        setGrade(mark);
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(int mark) {
    if (mark >= 8) {
        this.grade = "A";
    } else if (mark >= 7) {
        this.grade = "B";
    } else if (mark >= 6) {
        this.grade = "C";
    } else if (mark >= 5) {
        this.grade = "D";
    } else {
        this.grade = "Tạch cmnr";
    }
}
    
}
