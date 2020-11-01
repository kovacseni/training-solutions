package javaapi;

public class Upper {

    /*
toUpperCase
public String toUpperCase()
Converts all of the characters in this String to upper case using the rules of the default locale. This method is equivalent to toUpperCase(Locale.getDefault()).

Note: This method is locale sensitive, and may produce unexpected results if used for strings that are intended to be interpreted locale independently. Examples are programming language identifiers, protocol keys, and HTML tags. For instance, "title".toUpperCase() in a Turkish locale returns "T\u0130TLE", where '\u0130' is the LATIN CAPITAL LETTER I WITH DOT ABOVE character. To obtain correct results for locale insensitive strings, use toUpperCase(Locale.ROOT).

Returns:
    the String, converted to uppercase.
See Also:
    toUpperCase(Locale) */

    public static void main(String[] args) {
        System.out.println("Hello World!".toUpperCase());


    }

}
