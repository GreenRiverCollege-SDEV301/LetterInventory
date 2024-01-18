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
        inv.add('e');
        inv.add('e');
        inv.add('l');
        System.out.println(inv.toString());
        System.out.println(inv.get('e'));
        //inv.set('-', (short) 9);

        System.out.println(inv.size());



    }
}
