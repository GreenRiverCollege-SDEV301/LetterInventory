package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
//        LetterInventory inv = new LetterInventory();
        LetterInventory inv = new LetterInventory("WashingtonState");
        LetterInventory not = new LetterInventory("");
        System.out.println(inv);

        System.out.println(inv.get('e'));
        System.out.println(inv.getIndex('e'));
        inv.add('e');
        System.out.println(inv.get('e'));
        inv.subtract('e');
        System.out.println(inv.get('e'));
        System.out.println(inv.size());
        System.out.println(inv.isEmpty());
        System.out.println(not.isEmpty());
        System.out.println(inv.contains('e'));
        System.out.println(inv.contains('z'));

    }
}
