package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String str) {
        boolean[] booleanArray;
        try {
            booleanArray = new BinaryStringConverter().binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException("binaryString not valid", ex);
        }
        return booleanArray;
    }

    public int answerTruePercent(String answers) {
        int percent = 0;
        boolean[] booleanArray = new BinaryStringConverter().binaryStringToBooleanArray(answers);
        for (boolean b : booleanArray) {
            if (b == true) {
                percent++;
            }
        }
        percent = Math.toIntExact(Math.round(percent * 100.0 / booleanArray.length));

        return percent;
    }
}
