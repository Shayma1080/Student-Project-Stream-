package be.intecbrussel.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ScoreInfoService {

    private ScoreInfo[] scoreData;
    long numberOfStudents;

    public ScoreInfoService() {}

    public void addScoreInfo(ScoreInfo newScore) {
        scoreData = Stream.concat(Arrays.stream(scoreData), Stream.of(newScore))
                .toArray(ScoreInfo[]::new);
        numberOfStudents++;
        System.out.println(Arrays.toString(scoreData));
    }

    public void calculateAverageScore(){
        double average = Arrays.stream(scoreData)
                .mapToDouble(ScoreInfo::getScore)
                .average()
                .collect(Collection.toList);
        System.out.println(average);
    }

    public long filterScore(){
        return Arrays.stream(scoreData)
                .filter(getscore-> getscore >=90)
                .contain("A")
                .count();
    }

    private String[] getFailingStudents(){
        return Arrays.stream(scoreData)
                .toArray(getScoreData() < 60 && getDataSortedByLastName())
                .toList;
    }

    public void printFailingStudents(){
        String namen = Arrays.stream()
                .filter((Student) -> Student)
                .toList();
        System.out.println(namen);
    }

    public void getDataSortedByLastName(){
        scoreData = Arrays.stream()
                .filer((Student,ScoreInfo) -> Student + ScoreInfo)
                .contain(getDataSortedByLastName());
        System.out.println(scoreData);
    }

    public void getDataSortedByScore(){
        scoreData = Arrays.stream()
                .filer((Student,ScoreInfo) -> Student + ScoreInfo)
                .map(Arrays.stream(scoreData).distinct());
    }

    public ScoreInfo[] getScoreData() {
        return scoreData;
    }

    public long getNumberOfStudents() {
        return numberOfStudents;
    }
}
