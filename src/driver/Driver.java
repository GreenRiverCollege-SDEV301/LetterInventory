package driver;

import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
        LetterInventory inv = new LetterInventory("tat");
        //LetterInventory inv = new LetterInventory("WashingtonState");

        System.out.println(inv.getIndex('e'));
        System.out.println(inv);
        System.out.println(inv.get('t'));
//        byte a1 = 13;    // expressing leiteral as a decimal
//        byte a2 = 0b1101;// as binary , prefixed with 0b
//        byte a3 = 015;  //  as octal, prefixed with 0
//        byte a4 = 0xd  ; // as hex, prefixed with 0x
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3);
//        System.out.println(a4);
        System.out.println("tat" +inv.size());

    }
}
