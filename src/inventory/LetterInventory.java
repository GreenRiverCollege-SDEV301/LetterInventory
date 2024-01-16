package inventory;

/**
 * This class represents an inventory of the 26 letters in the English alphabet.
 * A LetterInventory object keeps track of how many a’s, how many b’s, etc.
 * are contained in the inventory. This object stores the counts of the letters
 * in an integer array with a maximum count of Short.MAX_VALUE for each letter
 * For example:
 * the letter inventory for the string “WashingtonState” corresponds to
 * [aaeghinnosstttw] --> String representation of the inventory
 * [2,0,0,0,1,0,1,1,1,0,0,0,0,2,1,0,0,0,2,3,0,0,1,0,0,0] --> inventory count array
 * [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z] --> corresponding letters
 * The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.
 *
 * @author Sage Markwardt
 * @version 1.0
 */
public class LetterInventory {

  private short[] inventory; // inventory is null here
  public static final byte ALPHABET_SIZE = 26;

  /**
   * Constructs an integer array for the size of the alphabet.
   * All letter counts are initialized to zero.
   */
  public LetterInventory(){
    inventory = new short[ALPHABET_SIZE];
  }
  /**
   * Constructs an integer array for the size of the alphabet.
   * Each element in the array should hold a 16-bit integer
   * and adds each character in the text to the inventory
   * @param text
   */
  public LetterInventory(String text) {
    inventory = new short[ALPHABET_SIZE];
    char[] temp = text.toCharArray();
    for (int i = 0; i < text.length(); i++) {
      this.add(temp[i]);
    }
  }

  /**
   * Identifies the index for the given character within the inventory array , throws an
   * IIegalArgumentException if the character is not in the a-z or A-Z range.
   * For example: if the given character is 'c' or 'C', then the index returned is 2
   *              if the given character is '?', then an IllegalArgumentException is thrown
   *
   * @param c a-z or A-Z character
   * @return index of the character
   */
  public int getIndex(char c) throws IllegalArgumentException {
    // check for uppercase char
    if (c >= 'A' && c <= 'Z'){
      return (int)c - 65;
    } else if (c >= 'a' && c <= 'z'){
      // check for lowercase char
      return (int)c - 97;
    } else {
      // throw exception if not a letter
      throw new IllegalArgumentException("Not a letter of the alphabet");
    }
  }

  /**
   * Increases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void add(char c) {
    this.inventory[this.getIndex(c)] += 1;
  }

  /**
   * Decreases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void subtract(char c) {
    // check that there is more than 0 at the index
    // if none have been counted, we cannot subtract
    if (inventory[this.getIndex(c)] <= 0){
      throw new IllegalArgumentException("There are no more of this letter to subtract.");
    } else {
      // if there is a positive amount of this character, we can subtract
      this.inventory[this.getIndex(c)] -= 1;
    }
  }

  /**
   * Returns the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public int get(char c) {
    if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
      return inventory[this.getIndex(c)];
    } else {
      throw new IllegalArgumentException("Unexpected character");
    }
  }

  /**
   * Sets the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @param count the number of occurrences of the character c; if count < 0
   *              IllegalArgumentException is thrown
   */
  public void set(char c, short count) {
    if (count < 0) {
      throw new IllegalArgumentException("Count cannot be negative");
    } else {
      inventory[this.getIndex(c)] = count;
    }

  }

  /**
   * Determines if a character's count is in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @return true if character is in inventory, false otherwise
   */
  public boolean contains(char c) {
    // get the count for the char in the index
    if (this.inventory[getIndex(c)] > 0){
      // greater than 0 means it does contain that char
      return true;
    }
    return false;
  }

  /**
   * Return the total count of all letters in the inventory
   * @return total count
   */
  public int size() {
    // create a variable to hold the count
    int count = 0;
    // iterate through the array to add up the count
    for (int i = 0; i < inventory.length; i++) {
      count += inventory[i];
    }
    return count;
  }

  /**
   * Determine if the inventory has zero counts for all letters
   * @return true, if empty, false otherwise
   */
  public boolean isEmpty() {
    // check if size of list is 0
    if (this.size() == 0){
      return true;
    }
    // if size is greater than 0, it's not empty
    return false;
  }

  /**
   * Returns a String representation of the inventory with the letters all in
   * lowercase
   * surrounded by square brackets in alphabetical order. The number of
   * occurrences of
   * each letter matches its count in the inventory.
   * For example, an inventory of 4 a’s, 1 b, 1 k and 1 m would be represented as
   * “[aaaabkm]”.
   *
   * @return a bracketed string representation of the letters contained in the
   *         inventory
   */
  public String toString() {
    // If you are concatenating many strings together, StringBuilder class
    // is often more efficient
    StringBuilder toReturn = new StringBuilder("[");

    // for every count in the letters inventory
    for (int i = 0; i < inventory.length; i++) {
      // add each character to the string count times
      for (int count = 0; count < inventory[i]; count++) {
        // ascii math performed here
        // Example:
        // 'a' + 0 = 'a'
        // 'a' + 1 = 'b'
        // 'a' + 2 = 'c'
        // 'a' + 25 = 'z'
        toReturn.append((char) ('a' + i));
      }
    }
    return toReturn.append("]").toString();
  }

}
