package inventory;
/**
 * Another way to store letterinv is with an integer value
 * int inventory;
 * zyxwvutsrqponmlkjihgfedcba
 * 00010011000110000011101001
 *
 *
 *
 */
public class LetterPresence {
    private int inventory;

    public int getIndex(char letter) {
        return letter - 'a';
    }

    public void add(char letter){
        int position = getIndex(letter);
        int temp = 1 << position;
        inventory += temp;
    }

    public boolean isPresent(char letter){
        int position = getIndex(letter);
        int temp = 1 << position;
        int check = inventory & temp; //bitwise AND
        return check > 0;
    }

}
