package inventory;

/*
 * [2,0,0,0,1,0,1,1,1,0,0,0,0,2,1,0,0,0,2,3,0,0,1,0,0,0] --> inventory count array
 * [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z] --> corresponding letters
 *
 * [1,0,0,0,1,0,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0] --> presence count array
 * [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z] --> corresponding letters
 *
 * can use an int to represent this -- bitwise ops
 * zyxwvutsrqponmlkjihgfedcba
 * 00010011000110000111010001 -- some bits left off of start since we are only using 26
 */

public class LetterPresence {
    private int inventory;

    public int getIndex(char letter)
    {
        //assume letter is valid and lowercase
        return letter - 'a';
    }

    public void add(char letter)
    {
        int position = getIndex(letter);
        /*
            << or >> operator shifts position of number
            ex: 1 << 4 makes 10000
            0000001 -- 0010000
         */
        int temp = 1 << position;
        inventory += temp;
    }

    public boolean isPresent(char letter)
    {
        int position = getIndex(letter);
        int temp = 1 << position;
        /* ANDs the two numbers together - checks if any of the values match
         * 0110000 & 1 << 4
         * 0010000
         * 0010000 - AND result
         *
         * 0110000 & 1 << 2
         * 0110100
         * 0000000 - AND result
         */
        int check = inventory & temp;
        return check > 0;
    }
}
