package driver;

import inventory.LetterInventory;
import inventory.MLetterInventory;

public class Driver
{

    public static void main(String[] args)
    {
        MLetterInventory inv = new MLetterInventory();
//        LetterInventory ine = new LetterInventory("WashingtonState");

        LetterInventory ine = new LetterInventory();

        LetterInventory anotherine = new LetterInventory("WasgingtonState");

        System.out.println(ine);
        System.out.println(anotherine);

        System.out.println(ine.getIndex('z'));
        System.out.println(ine.getIndex('a'));

//        System.out.println(inv.get('e'));
//        System.out.println(inv.getIndex('e'));


    }
}
