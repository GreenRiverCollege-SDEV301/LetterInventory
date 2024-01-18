package driver;

import inventory.LetterInventory;

import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
//        LetterInventory inv = new LetterInventory();
        LetterInventory inv = new LetterInventory("WashingtonState");
        System.out.println(inv);

        System.out.println(inv.get('e'));
        System.out.println(inv.getIndex('e'));

        inv.subtract('t');
        System.out.println(inv);


    }
}
