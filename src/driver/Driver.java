package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv2 = new LetterInventory();
        LetterInventory inv = new LetterInventory("WashingtonState");

        System.out.println(inv);

        System.out.println("Inventory of e:" + inv.get('e'));
        System.out.println("Index of e: " + inv.getIndex('e'));
        inv.add('e');
        System.out.println("Inventory of e after add:" + inv.get('e'));
        inv.subtract('e');
        System.out.println("Inventory of e after subtract:" + inv.get('e'));
        inv.set('e', (short) 5);
        System.out.println("Inventory of e after set:" + inv.get('e'));
        System.out.println("Inventory contains l:" + inv.contains('l'));
        System.out.println("Inventory total:" + inv.size());
        System.out.println("Is Inventory empty? " + inv2.isEmpty());

    }
}
