package be.intecbrussel.project;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class ScoreInfoService {

    private List<ScoreInfo> scoreData= new ArrayList<>();
    long numberOfStudents;

    public ScoreInfoService() {}

    public void addScoreInfo(ScoreInfo newScore) {
        scoreData.add(newScore);
        scoreData.stream()
                //.map(e-> e.getStudent())
                .map(ScoreInfo::getStudent)// beter en veilliger
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
                .map(s->s.student.getName())
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
                .map(ScoreInfo::getStudent)
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);
    }

    public void getDataSortedByScore(){
        scoreData.stream()
                .sorted(Comparator.comparing(ScoreInfo::getScore))
                .forEach(System.out::println);
    }

    public ScoreInfo[] getScoreData() {
        return scoreData.toArray(new ScoreInfo[100]);
    }
    //return scoreData.toArray(new ScoreInfo[0])

    public long getNumberOfStudents() {
        return numberOfStudents;
    }

//    @Override
//    public String getName() {
//        return super(name);
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
