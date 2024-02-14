package domain;

public class Calculator {
    public static Integer CalculateScore(Integer TimeElapsed) {
        if (TimeElapsed > 0) {
            return 300 / TimeElapsed;
        } else {
            return 0;
        }

    }
}
