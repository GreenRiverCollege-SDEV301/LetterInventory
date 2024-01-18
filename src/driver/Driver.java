package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv1 = new LetterInventory();
        System.out.println(inv1);

        LetterInventory inv = new LetterInventory("WashingtonState");
        System.out.println(inv);

        System.out.println(inv.get('e'));
        System.out.println(inv.getIndex('e')); //4
        System.out.println(inv.getIndex('Z')); //25
//        System.out.println(inv.getIndex('1')); //Throw exception

        //Test add();
        inv.add('a');
        System.out.println(inv);

        int temp = 1 << 4;
        System.out.println("testing bit shift: " + temp);
    }
}
