package inventory;

public class LetterPresence {

    /*
     * to check ONLY for letter presence:
     * zyxwvytsrqponmlkjihgfedcba - flip char index
     * 00010011000110000111010001 - can be represented as an int - shows that inventory contains a, e, g, h, i, n, o, s, t, w
     */

    private int inventory;

    public int getIndex(char letter) {
        // TODO: account for capital letters
        return letter - 'a'; // gets the correct index
    }

    public void add(char letter) {
        int position = getIndex(letter);
        int temp = 1 << position; // << is a bit shift, shifts bits in int by position spaces
        this.inventory += temp;
    }

    public boolean isPresent(char letter) {
        int position = getIndex(letter); // the position of target letter
        int temp = 1 << position; // what int with only target letter looks like
        int check = position & temp; // bitwise &
        // isolates the bit at position of target letter (1 at correct position means letter is present)
        /*
        ex: letter = 'e'
        position = 4
        inv = 00110000
        temp = 00000001 => 00010000
        check = 00010000

        check > 0 (inv contains letter)

         */

        return check > 0;
    }
}
