package driver;

/*
    Everett Hanke
    SDEV 301
    01/16/24
 */
import inventory.LetterInventory;

public class Driver {

    public static void main(String[] args) {
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
    }
}
