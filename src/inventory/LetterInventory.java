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

  // if this was private int[] inventory - it takes up 32 bits * 26 letter => 832 bits of space

  // if this is private short[] inventory - it takes up 16 bits * 26 letters => 416 bits of space

  // if this is private byte[] inventory - it takes up 8 bits * 26 letters => 208 bits of space
    // only want to do this if the letter count < 127

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

    //This is okay...
    //inventory = new short[ALPHABET_SIZE];

    //This is better, as it calls the default constructor
    this();
    for (int i = 0; i < text.length(); i++)
    {
      char currentChar = text.charAt(i);

      if((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z'))
      {
        add(currentChar);
      }
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

    int num = (int)c;
    int index = 0;

    if(num >= 'a' && num <= 'z')
    {
      index = num - 'a';
    }

    else if(num >= 'A' && num <= 'Z')
    {
      index = num - 'A';
    }

    else
    {
      throw new IllegalArgumentException("Received a non alpha character");
    }

    return index;
  }

  /**
   * Increases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void add(char c) {
//TODO

    try
    {
      inventory[getIndex(c)]++;
    }
    catch(NullPointerException e)
    {
      inventory[getIndex(c)] = 1;
    }
  }

  /**
   * Decreases the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public void subtract(char c) {
  //TODO

    try
    {
      inventory[getIndex(c)]--;
    }
    catch(NullPointerException e)
    {
      inventory[getIndex(c)] = 0;
    }

  }

  /**
   * Returns the count for the given character in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   */
  public int get(char c) {
   //TODO

    int index = getIndex(c);
    if (index >= 0 && index < ALPHABET_SIZE) {
      return inventory[index];
    }
    else
    {
      throw new IllegalArgumentException("Character is not in the a-z or A-Z range");
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

    int index = getIndex(c);

    if(index >= 0 && index < ALPHABET_SIZE)
    {
      if(count >= 0)
      {
        inventory[index] = count;
      }
      else
      {
        throw new IllegalArgumentException("Count can't be negative");
      }
    }
    else
    {
      throw new IllegalArgumentException("Character is not in the a-z or A-Z range");
    }

  }

  /**
   * Determines if a character's count is in the inventory
   * @param c a-z or A-Z otherwise an IllegalArgumentException is thrown
   * @return true if character is in inventory, false otherwise
   */
  public boolean contains(char c) {
    //TODO
    return false;
  }

  /**
   * Return the total count of all letters in the inventory
   * @return total count
   */
  public int size() {
   //TODO



    return 0;
  }

  /**
   * Determine if the inventory has zero counts for all letters
   * @return true, if empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO
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
    //join in the closing ]
    toReturn.append("]");

    //convert the StringBuilder to a String and return it
    return toReturn.toString();
  }

}
