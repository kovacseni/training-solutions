package week08d01;

public class Robot {

    private int x;
    private int y;

    public Position move(String str) {
        for (int i = 0; i < str.length(); i++) {
            switch (str.substring(i, i+1)) {
                case "F" :
                    y += 1;
                    break;
                case "L" :
                    y -= 1;
                    break;
                case "J" :
                    x += 1;
                    break;
                case "B" :
                    x -= 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid move!");
            }
        }
        return new Position(x, y);
    }
}
