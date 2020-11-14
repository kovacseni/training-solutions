package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char letter) {
        char convertedLetter;

        switch(letter) {
            case 'a' :
            case 'b' :
                convertedLetter = 'b';
                break;
            case 'c' :
                convertedLetter = 'c';
                break;
            case 'd' :
                convertedLetter = 'd';
                break;
            case 'e' :
            case 'f' :
                convertedLetter = 'f';
                break;
            case 'g' :
                convertedLetter = 'g';
                break;
            case 'h' :
                convertedLetter = 'h';
                break;
            case 'i' :
            case 'j' :
                convertedLetter = 'j';
                break;
            case 'k' :
                convertedLetter = 'k';
                break;
            case 'l' :
                convertedLetter = 'l';
                break;
            case 'm' :
                convertedLetter = 'm';
                break;
            case 'n' :
                convertedLetter = 'n';
                break;
            case 'o' :
            case 'p' :
                convertedLetter = 'p';
                break;
            case 'q' :
                convertedLetter = 'q';
                break;
            case 'r' :
                convertedLetter = 'r';
                break;
            case 's' :
                convertedLetter = 's';
                break;
            case 't' :
                convertedLetter = 't';
                break;
            case 'u' :
            case 'v' :
                convertedLetter = 'v';
                break;
            case 'w' :
                convertedLetter = 'w';
                break;
            case 'x' :
                convertedLetter = 'x';
                break;
            case 'y' :
                convertedLetter = 'y';
                break;
            case 'z' :
                convertedLetter = 'z';
                break;
            default :
                convertedLetter = '0';
        }
        return convertedLetter;
    }
}
