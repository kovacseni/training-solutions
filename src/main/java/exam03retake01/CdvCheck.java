package exam03retake01;

public class CdvCheck {

    public boolean check(String cdv) {
      validate(cdv);

      String[] cdvToNumbers = cdv.split("");
      int sum = multipleNumbersOfCdv(cdvToNumbers);
      int last = sum % 11;

      return last == Integer.parseInt(cdvToNumbers[9]);
    }

    private void validate(String cdv) {
        String rightNumbers = "0123456789";
        for (char c : cdv.toCharArray()) {
            if (rightNumbers.indexOf(c) < 0 || cdv.length() != 10) {
                throw new IllegalArgumentException("Wrong number!");
            }
        }
    }

    private int multipleNumbersOfCdv(String[] cdvToNumbers) {
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            int x = Integer.parseInt(cdvToNumbers[i - 1]);
            x *= i;
            sum += x;
        }
        return sum;
    }
}
