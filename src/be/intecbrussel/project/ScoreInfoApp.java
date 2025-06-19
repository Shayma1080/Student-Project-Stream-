package be.intecbrussel.project;

public class ScoreInfoApp {
    public static void main(String[] args) {
        ScoreInfoService service = new ScoreInfoService();

        Student student1 = new Student("Chaïma", "Hajji");
        ScoreInfo info1 = new ScoreInfo(65, student1);
        service.addScoreInfo(info1);
        service.getDataSortedByLastName();
        service.getDataSortedByScore();


        Student student2 = new Student("Saif","Ben");
        ScoreInfo info2 = new ScoreInfo(50,student2);
        service.addScoreInfo(info2);
        service.getDataSortedByLastName();
        service.getDataSortedByScore();
        service.calculateAverageScore();
        service.filterScore();
        service.printFailingStudents();
        service.getScoreData();






    }
}
