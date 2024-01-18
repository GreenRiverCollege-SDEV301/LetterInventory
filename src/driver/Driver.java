package driver;

/*
    Everett Hanke
    SDEV 301
    01/16/24
 */
import inventory.LetterInventory;
import inventory.LetterInventoryBits;

public class Driver {

    public static void main(String[] args)
    {
        LetterInventory inv = new LetterInventory();
        LetterInventory inv1 = new LetterInventory("WashingtonState");
        //System.out.println(inv1);
        System.out.println("Retrieving index for Z: " + inv.getIndex('Z'));

        System.out.println("Retrieving count for e: "+ inv.get('e'));
        System.out.println("Retrieving index for e: " + inv.getIndex('e'));
        //lets add 3 different letters
        inv.add('e');
        inv.add('e');
        inv.add('l');
        //count out how many e are in the inventory
        System.out.println("Retrieving count for e: " + inv.get('e'));
        //inv.set('-', (short) 9);

        System.out.println("Retrieving size of list: " + inv.size());

        LetterInventory testingByKen = new LetterInventory("washingtonstate");
        System.out.println(testingByKen.toString());

        //*************************************************************************
        //testing bitwise letter inventory below
        LetterInventoryBits inv2 = new LetterInventoryBits();
        //play arround with how much you want to shift and see the changes 32/12/4/etc do you see it wrap?
        int temp = 1 << 32;
        System.out.println("Testing shift 4: " + temp);

        inv2.add('e');
        inv2.add('p');
        inv2.add('z');
        System.out.println(inv2.isPresent('l'));
        System.out.println(inv2.isPresent('e'));
    }
}
