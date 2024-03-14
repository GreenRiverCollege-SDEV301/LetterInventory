package driver;

import inventory.LetterInventory;

import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv = new LetterInventory("WashingtonState");
        System.out.println(inv);

        // size method
        System.out.println("SIZE: " + inv.size());

        // get method
        System.out.println("NUMBER OF CHARACTERS FOR 'a': " + inv.get('a'));

        // get index method
        System.out.println("INDEX OF 'e': " + inv.getIndex('e'));

        // contains method
        System.out.println("STRING CONTAINS 'e': " + inv.contains('e'));
        System.out.println("STRING CONTAINS 'z': " + inv.contains('z'));

        // subtract method
        System.out.println("SUBTRACTING 't': ");
        inv.subtract('t');
        System.out.println("SUBTRACTED RESULT: " + inv);

        System.out.println("IS EMPTY: " + inv.isEmpty());
    }
}
