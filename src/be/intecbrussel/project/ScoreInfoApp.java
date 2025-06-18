package be.intecbrussel.project;

public class ScoreInfoApp {
    public static void main(String[] args) {
        Student student1 = new Student("Chaïma", "Hajji");
        ScoreInfo info = new ScoreInfo(50, student1);
        System.out.println(info.student.name);
        System.out.println(info.score);




    }
}
