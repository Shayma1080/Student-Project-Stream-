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

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "score=" + score + ", student=" + student;
    }

}
