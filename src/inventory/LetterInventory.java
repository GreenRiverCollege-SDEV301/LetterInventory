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

  //If this was private int[] inventory - tit takes upp 32 bits + 26 letters = 832 bits of space
  //If this is private short[] inventory - it takes up 16 bits + 26 letters = 416 bits of space
  //If this is private byte[] inventory - it takes up 8 bits + 26 letters = 208 bits of space
  //only want to do this if the letter count < 2127

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
   //TODO

    //method 1: calling the same function from the top using this() 'default constructor'
    this();

    for (int i = 0; i < text.length(); i++)
    {
      add(text.charAt(i));

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
  public int getIndex(char c) {
  //TODO

    //first method
//    boolean isUpperCase = false;
//    boolean isLowerCase = false;
//
//    if((c >= 'A' && c <='Z') || (c >='a' && c <='z'))
//    {
//      isLowerCase = true;
//    }
//    else
//    {
//      throw new IllegalArgumentException("Received a non alpha character");
//    }
//
//    if(isUpperCase){
//      return c - 'A';
//    }
//    else {
//      return c - 'a';
//    }

//    int i = Character.toLowerCase(c) - 'a';  // 101 - 97
//    return i;         // Answer = 4, because 'e' is index 4

    char letter = Character.toLowerCase(c);
    if((int)letter >= 97 && (int)letter <= 122){
      return (int)letter -97;
    }else {
      throw new IllegalArgumentException(c + " is not a letter.");
    }
  }

  /**
   * Increases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void add(char c) {
//TODO
    if((c >= 'A' && c <='Z') || (c >='a' && c <='z'))
    {
      inventory[getIndex(c)]++;
    }
    else
    {
      throw new IllegalArgumentException(c + " is not a letter.");
    }

  }

  /**
   * Decreases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void subtract(char c) {
  //TODO

    if((c >= 'A' && c <='Z') || (c >='a' && c <='z'))
    {
      inventory[getIndex(c)]--;
    }
    else
    {
      throw new IllegalArgumentException(c + " is not a letter.");
    }

  }

  /**
   * Returns the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public int get(char c) {
   //TODO
    if((c >= 'A' && c <='Z') || (c >='a' && c <='z'))
    {
      int count = inventory[getIndex(c)];

      return count;
    }
    else
    {

      throw new IllegalArgumentException(c + " is not a letter.");
    }
  }

  /**
   * Sets the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @param count the number of occurrences of the character c; if count < 0
   *              IllegalArgumentException is thrown
   */
  public void set(char c, short count) {
    //TODO
    if((c >= 'A' && c <='Z') || (c >='a' && c <='z') && count >= 0)
    {
      inventory[getIndex(c)] = count;
    }
    else {
      throw new IllegalArgumentException(c + " is not a letter.");

    }
  }

  /**
   * Determines if a character's count is in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @return true if character is in inventory, false otherwise
   */
  public boolean contains(char c) {
    //TODO
    if((c >= 'A' && c <='Z') || (c >='a' && c <='z'))
    {
      return inventory[getIndex(c)] >= 1;
    }
    else {
      throw new IllegalArgumentException(c + " is not a letter.");

    }


  }

  /**
   * Return the total count of all letters in the inventory
   * @return total count
   */
  public int size() {       //will be correct if the array size is 0 ?
   //TODO
    short count = 0;
    for (int i = 0; i < inventory.length; i++)
    {
        count += inventory[i]; //if it is 0, add 0
    }
    return count;
  }

  /**
   * Determine if the inventory has zero counts for all letters
   * @return true, if empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO
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

    toReturn.append("]"); //add to the stringBuilder array

    return toReturn.toString(); //convert the StringBuilder to String and return it


  }

}
