package be.intecbrussel.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class ScoreInfoService extends Person{

    private List<ScoreInfo> scoreData= new ArrayList<>();
    long numberOfStudents;

    public ScoreInfoService() {}

    public void addScoreInfo(ScoreInfo newScore) {
        scoreData.add(newScore);
        scoreData.stream()
                //.map(Person::getName())
                .forEach(e -> System.out.println(e));

    }

    public void calculateAverageScore(){
        double gemiddelde = scoreData.stream()
                .mapToDouble(ScoreInfo::getScore)
                .average()
                .orElse(0.0);

        System.out.println("Gemiddelde score is : " + gemiddelde);
    }

    public long filterScore(){
        return scoreData.stream()
                .filter(s-> s.getScore() >=90)
                .map(e -> e.student)
                .count();
    }

    private String[] getFailingStudents(){
        return scoreData.stream()
                .filter(s-> s.getScore() < 60)
                .map(s->s.student.getName().toString())
                .toArray(String[]::new);
    }

    public void printFailingStudents(){
        String[] studenten = getFailingStudents();
        for( String namen: studenten){
            System.out.println("Niet-geslaagd: " + namen);
        }
    }

    public void getDataSortedByLastName(){
        scoreData.stream()
                .map(e -> e.student)
                .forEach(e -> System.out.println(e));
    }

    public void getDataSortedByScore(){
        scoreData.stream()
                .map(e -> e.score)
                .forEach(e -> System.out.println(e));
    }

    public ScoreInfo[] getScoreData() {
        return scoreData.toArray(new ScoreInfo[100]);
    }
    //return scoreData.toArray(new ScoreInfo[0])

    public long getNumberOfStudents() {
        return numberOfStudents;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
