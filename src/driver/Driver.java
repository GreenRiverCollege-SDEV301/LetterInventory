package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv = new LetterInventory();
        LetterInventory inv1 = new LetterInventory("WashingtonState");
        //System.out.println(inv1);
        System.out.println(inv.getIndex('Z'));

        System.out.println(inv.get('e'));
        System.out.println(inv.getIndex('e'));




    }
}
