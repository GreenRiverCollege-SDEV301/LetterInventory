package inventory;

/**
 *
 * This class represents an inventory of the 26 letters in the English alphabet.
 * A LetterInventory object keeps track of how many a’s, how many b’s, etc.
 * are contained in the inventory. This object stores the counts of the letters
 * in an integer array with a maximum count of Short.MAX_VALUE for each letter.
 * For example:
 * the letter inventory for the string “WashingtonState” corresponds to
 * [aaeghinnosstttw] --> String representation of the inventory
 * [2,0,0,0,1,0,1,1,1,0,0,0,0,2,1,0,0,0,2,3,0,0,1,0,0,0] --> inventory count array
 * [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z] --> corresponding letters
 * The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.
 *
 */
public class LetterInventory
{


    // if this was a private int [] inventory - it takes up 32 bits * 26 letter => 832 bits of space.
    // if this is private short [] inventory - it takes up 16 bits * 26 letters => 416 of space.
    // if this is private byte [] inventory - it takes up 8 bits * 26 letters => 208 bits of space.
    // only want to fo this of the letter count < 127
    private short[] inventory; // inventory is null here
    public static final byte ALPHABET_SIZE = 26;

    /**
     * Constructs an integer array for the size of the alphabet.
     * All letter counts are initialized to zero.
     */
    public LetterInventory()
    {
        inventory = new short[ALPHABET_SIZE];
    }

    /**
     * Constructs an integer array for the size of the alphabet.
     * Each element in the array should hold a 16-bit integer
     * and adds each character in the text to the inventory.
     *
     * @param text The text from which to build the inventory.
     */
    public LetterInventory(String text)
    {
//        inventory = new short[ALPHABET_SIZE];

        // using the word (this) avoids redundancy
        this();
        text = text.toLowerCase(); // Convert text to lowercase
        for (char c : text.toCharArray())
        {
            if (c >= 'a' && c <= 'z') {

                int index = getIndex(c);
                inventory[index]++;
            }
        }
    }

    /**
     * Identifies the index for the given character within the inventory array,
     * throws an IllegalArgumentException if the character is not in the a-z or A-Z range.
     *
     * @param c a-z or A-Z character
     * @return index of the character
     */
    public int getIndex(char c)
    {
        c = Character.toLowerCase(c);
        if (c < 'a' || c > 'z')
        {
            throw new IllegalArgumentException("Character is not in the 'a-z' or 'A-Z' range.");
        }
        return c - 'a';
    }

    /**
     * Increases the count for the given character in the inventory.
     *
     * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
     */
    public void add(char c)
    {
        int index = getIndex(c);
        inventory[index]++;
    }

    /**
     * Decreases the count for the given character in the inventory.
     *
     * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
     */
    public void subtract(char c) {
        int index = getIndex(c);
        if (inventory[index] > 0) {
            inventory[index]--;
        }
        else {
            throw new IllegalArgumentException("Character count cannot go below zero.");
        }
    }

    /**
     * Returns the count for the given character in the inventory.
     *
     * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
     * @return count of the character
     */
    public int get(char c)
    {
        int index = getIndex(c);
        return inventory[index];
    }

    /**
     * Sets the count for the given character in the inventory.
     *
     * @param c     a-z or A-Z otherwise an IllegalArgumentException is thrown
     * @param count the number of occurrences of the character c; if count < 0
     *              IllegalArgumentException is thrown
     */
    public void set(char c, short count)
    {
        int index = getIndex(c);
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }
        inventory[index] = count;
    }

    /**
     * Determines if a character's count is in the inventory.
     *
     * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
     * @return true if character is in inventory, false otherwise
     */
    public boolean contains(char c)
    {
        int index = getIndex(c);
        return inventory[index] > 0;
    }

    /**
     * Return the total count of all letters in the inventory.
     *
     * @return total count
     */
    public int size() {
        int total = 0;
        for (int count : inventory) {
            total += count;
        }
        return total;
    }

    /**
     * Determine if the inventory has zero counts for all letters.
     *
     * @return true, if empty, false otherwise
     */
    public boolean isEmpty()
    {
        for (int count : inventory) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a String representation of the inventory with the letters all in
     * lowercase surrounded by square brackets in alphabetical order.
     *
     * @return a bracketed string representation of the letters contained in the
     * inventory
     */
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder("[");
        for (int i = 0; i < inventory.length; i++)
        {
            for (int count = 0; count < inventory[i]; count++)
            {
                toReturn.append((char) ('a' + i));
            }
        }
        return toReturn.append("]").toString();
    }
}
