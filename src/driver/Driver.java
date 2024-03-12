package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        //LetterInventory inv = new LetterInventory();
        LetterInventory inv = new LetterInventory("WashingtonState");
        inv.get('t');
        System.out.println(inv);

        System.out.println("Get e: " + inv.get('e'));
        System.out.println("Get Index for e: " + inv.getIndex('e'));

        inv.add('c');
        inv.add('g');
        inv.add('D');
        inv.add('C');
        System.out.println(inv.contains('c'));  // returns true
        inv.subtract('c');
        System.out.println(inv.contains('c'));  // returns false
        inv.subtract('e');
    }
}
