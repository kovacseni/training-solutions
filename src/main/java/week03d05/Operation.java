package week03d05;

public class Operation {

    private int leftValue;
    private int rightValue;

    public Operation (String operation) {
        leftValue = Integer.parseInt(operation.substring(0, operation.indexOf("+")).trim());
        rightValue = Integer.parseInt(operation.substring(operation.indexOf("+")+1).trim());
    }

    public int getResult() {
        return (leftValue + rightValue);
    }
}
