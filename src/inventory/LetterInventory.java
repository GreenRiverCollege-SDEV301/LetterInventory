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
 */
public class LetterInventory  {

  private short[] inventory = new short[26]; // inventory is null here
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
  //Fills the elements of the inventory array by looping through a string parameter
  public LetterInventory(String text) {
    for (int i = 0; i < text.length(); i++) {
      add(text.charAt(i));
    }
  }

  /**
   * Identifies the index for the given character within the inventory array , throws an
   * IllegalArgumentException if the character is not in the a-z or A-Z range.
   * For example: if the given character is 'c' or 'C', then the index returned is 2
   *              if the given character is '?', then an IllegalArgumentException is thrown
   *
   * @param c a-z or A-Z character
   * @return index of the character
   */
  //Gets the index where a character c would belong within the inventory array, which
  // is 26 elements in alphabetical order. if the given character is not an alpha character,
  // it throws an IllegalArgumentException.
  public int getIndex(char c) {
    if((int)Character.toLowerCase(c) >=97 && (int)Character.toLowerCase(c) <= 122) {
      return (int) Character.toLowerCase(c) - 'a';
    }
    else
    {
      throw new IllegalArgumentException("Please enter a valid input (a-z)");
    }
  }

  /**
   * Increases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  //Adds a given character c to increment the appropriate index in the inventory array
  public void add(char c) {
    inventory[getIndex(c)]++;
  }

  /**
   * Decreases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  //decrements the appropriate index for the given character c within the inventory array
  public void subtract(char c) {
    inventory[getIndex(c)]--;
  }

  /**
   * Returns the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  //gets the index of a given character c
  public int get(char c) {
    return inventory[getIndex(c)];
  }

  /**
   * Sets the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @param count the number of occurrences of the character c; if count < 0
   *              IllegalArgumentException is thrown
   */
  //sets the value of the index for a given character c to a value "count" given as a parameter. If the character is
  //not alpha or if the count is less than 0, it throws an IllegalArgumentException
  public void set(char c, short count) {
    if((int)Character.toLowerCase(c) >=97 && (int)Character.toLowerCase(c) <= 122 && count>=0)
    {
      inventory[getIndex(c)] = count;
    }
    else
    {
      throw new IllegalArgumentException("Please enter a valid input (a-z) and count must be a positive integer.");
    }
  }

  /**
   * Determines if a character's count is in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @return true if character is in inventory, false otherwise
   */
  //Finds the given character c within the inventory array, and returns the index of it.
  public boolean contains(char c) {
    return inventory[getIndex(c)] > 0;
  }

  /**
   * Return the total count of all letters in the inventory
   * @return total count
   */
  //returns the size of the string that was passed in
  public int size() {
    short count = 0;
    for (int i = 0; i < inventory.length; i++)
    {
      count += inventory[i];
    }
    return count;
  }

  /**
   * Determine if the inventory has zero counts for all letters
   * @return true, if empty, false otherwise
   */
  //checks if the string that was originally passed in is empty
  public boolean isEmpty() {
      return size() == 0;
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
