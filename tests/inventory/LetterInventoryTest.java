package inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterInventoryTest {

    static LetterInventory washington;
    static LetterInventory empty;
    static LetterInventory atoz;

    @BeforeEach
    void setUp() {
        washington = new LetterInventory("WashingtonState");
        empty = new LetterInventory();
        atoz = new LetterInventory("abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    void getIndex() {
        for (int i = 0; i < LetterInventory.ALPHABET_SIZE; i++) {
            assertEquals(i,washington.getIndex((char)('a' + i)));
        }
    }

    @Test
    void add() {
        assertEquals("[abcdefghijklmnopqrstuvwxyz]",atoz.toString());
    }

    @Test
    public void testAddException() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.add('?');
                }
        );

    }

    @Test
    void subtract() {
         washington.subtract('a');
         assertEquals("[aeghinnosstttw]", washington.toString());
    }

    @Test
    public void testSubtractException() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.subtract('?');
                }
        );

    }
    @Test
    void get() {
        assertEquals(3,  washington.get('t'));
    }
    @Test
    public void testGetException() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.get('?');
                }
        );

    }
    @Test
    void set() {
        washington.set('z', (short) 5);
        assertEquals("[aaeghinnosstttwzzzzz]", washington.toString());
    }
    @Test
    public void testSetException() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.set('?',(short) 2);
                }
        );

    }
    @Test
    public void testSetException2() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.set('a',(short) -2);
                }
        );

    }
    @Test
    void contains() {
        assertTrue(washington.contains('a'));
        assertFalse(washington.contains('x'));
    }

    @Test
    public void testContainsException() {

        assertThrows(IllegalArgumentException.class, () -> {
                    // Add your code that is expected to throw the exception
                    atoz.contains('?');
                }
        );

    }
    @Test
    void size() {
        assertEquals(0,empty.size());
        assertEquals(26,atoz.size());
        assertEquals(15,washington.size());
    }

    @Test
    void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(atoz.isEmpty());
        assertFalse(washington.isEmpty());
    }

}