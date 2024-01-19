package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv = new LetterInventory();
//        LetterInventory inv = new LetterInventory("WashingtonState");
        System.out.println(inv);

        System.out.println(inv.get('e'));
        System.out.println(inv.getIndex('f'));

         inv.add('a');
        System.out.println("this is the array");
        System.out.println(inv);



    }
}
