package be.intecbrussel.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

public class ScoreInfoService {

    private List<ScoreInfo> scoreData= new ArrayList<>();
    long numberOfStudents;

    public ScoreInfoService() {}

    public void addScoreInfo(ScoreInfo newScore) {
        scoreData.add(newScore);
        scoreData.stream()
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
        return Arrays.stream(scoreData)
                .filter(s-> s.getScore() < 60)
                .map(ScoreInfo::getStudentName)
                .toArray(String[]::new);
    }

    public void printFailingStudents(){
        scoreData.stream()
                .toArray((String::Student))
                .collect(Collection.toList)
                .toList;
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
        return scoreData;
    }

    public long getNumberOfStudents() {
        return numberOfStudents;
    }
}
