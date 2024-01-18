/**
 * SDEV 301: Systems Programming
 *
 * @author Kendrick Hang, Tien Han
 * @version 1.0
 */

package inventory;

public class LetterPresence {
    private int inventory;

    public int getIndex(char letter) {
        //assume letter is valid and lowercase
        return letter - 'a';
        //letter a returns 0, letter b returns 1, letter c returns 2
    }

    public void add(char letter) { //ex: e ||||| f
        int position = getIndex(letter); //4 ||||| 5
        int temp = 1 << position; //1 << 4 is bit shift (00000001 becomes 00010000) ||||| 00100000
        //00000001
        //00010000 -> shifted 4 places
        this.inventory += temp; //Add to temp to keep track of all "1"'s
    }

    public boolean isPresent(char letter) {
        int position = getIndex(letter);
        int temp = 1 << position;
        int check = inventory & temp; //bitwise and
        //Checking for e
        //inv  -> 0110000
        //temp -> 0010000
        //check-> 0010000 -> this is saying that there is one e
        //Checking for g
        //inv  -> 0110000
        //temp -> 10000000
        //check-> 00000000

        return check > 0;
    }
}
