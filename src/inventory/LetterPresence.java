package inventory;

public class LetterPresence
{
    private int inventory;

    public int getIndex(char letter)
    {
        //assume letter is valid and lowercase (for Ken's example, but not yours)
        return letter - 'a';

        //letter a returns 0, letter b returns 1, letter c returns 2
    }

    public void add(char letter)
    {
        int position = getIndex(letter);
        int temp = 1 << position;       //storing all the number of each char
        inventory += temp;
    }

    public boolean isPresent(char letter)
    {
        int position = getIndex(letter);
        int temp = 1 << position;
        int check = inventory & temp;
        return  check > 0; //if check has more th
    }
}
