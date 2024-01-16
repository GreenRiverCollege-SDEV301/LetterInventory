package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv = new LetterInventory();
        //LetterInventory inv = new LetterInventory("WashingtonState");
        System.out.println(inv);
        System.out.println(inv.getIndex('b'));
//        inv.add('a');
//        LetterInventory inv2 = new LetterInventory("abbccc");
//        short count = 10;
//        inv2.set('z', count);
//        System.out.println(inv2);
//        System.out.println(inv2.isEmpty());
//        LetterInventory inv3 = new LetterInventory();
//        System.out.println(inv3.isEmpty());


    }
}
