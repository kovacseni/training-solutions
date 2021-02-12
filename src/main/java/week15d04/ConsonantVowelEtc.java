package week15d04;

public class ConsonantVowelEtc {

    private int consonant;
    private int vowel;
    private int etc;

    public ConsonantVowelEtc(int consonant, int vowel, int etc) {
        this.consonant = consonant;
        this.vowel = vowel;
        this.etc = etc;
    }

    public int getConsonant() {
        return consonant;
    }

    public int getVowel() {
        return vowel;
    }

    public int getEtc() {
        return etc;
    }

    public void setConsonant() {
        this.consonant++;
    }

    public void setVowel() {
        this.vowel++;
    }

    public void setEtc() {
        this.etc++;
    }
}
