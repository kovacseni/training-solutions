package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        String heapString = new String("Ez a szöveg.");
        return heapString;
    }


    public String createStringForPool() {
        String poolString = "Ez a szöveg.";
        return poolString;
    }
}
