package controlselection.accents;

public class WithoutAccents {

    public char convertToCharWithoutAccents(char letter) {
        char convertedLetter;

        if (letter == 'á') {
            convertedLetter = 'a';
        } else if (letter == 'Á') {
            convertedLetter = 'A';
        } else if (letter == 'é') {
            convertedLetter = 'e';
        } else if (letter == 'É') {
            convertedLetter = 'E';
        } else if (letter == 'í') {
            convertedLetter = 'i';
        } else if (letter == 'Í') {
            convertedLetter = 'I';
        } else if (letter == 'ó' || letter == 'ö' || letter == 'ő') {
            convertedLetter = 'o';
        } else if (letter == 'Ó' || letter == 'Ö' || letter == 'Ő') {
            convertedLetter = 'O';
        } else if (letter == 'ú' || letter == 'ü' || letter == 'ű') {
            convertedLetter = 'u';
        } else if (letter == 'Ú' || letter == 'Ü' || letter == 'Ű') {
            convertedLetter = 'U';
        } else {
            convertedLetter = letter;
        }
        return convertedLetter;
    }
}
