package methodvarargs.examstats;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    double limit = maxPoints * (limitInPercent / 100.0);
    int above = 0;
    for ( int i : results) {
        if (i > limit) {
            above++;
        }
    }
    return above;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    double limit = maxPoints * (limitInPercent / 100.0);
    boolean failed = false;
    for (int i : results) {
        if (i < limit) {
            failed = true;
        }
    }
    return failed;
    }
}
