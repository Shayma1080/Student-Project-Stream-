package be.intecbrussel.project;

import java.util.stream.Stream;

public class ScoreInfo {
     int score;
     Student student;

    public ScoreInfo(int score, Student student) {
        this.score = score;
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ScoreInfo{" +
                "score=" + score +
                ", student=" + student +
                '}';
    }

}
