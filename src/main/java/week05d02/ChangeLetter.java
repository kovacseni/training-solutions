package week05d02;

public class ChangeLetter {

    public String changeVowels(String str) {

        if (str == null || str.equals("") || str.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }

        for (int i = 0; i < str.length(); i++) {
            str = str.replace('a', '*');
            str = str.replace('e', '*');
            str = str.replace('i', '*');
            str = str.replace('o', '*');
            str = str.replace('u', '*');
            str = str.replace('A', '*');
            str = str.replace('E', '*');
            str = str.replace('I', '*');
            str = str.replace('O', '*');
            str = str.replace('U', '*');
        }
        return str;
    }
}
