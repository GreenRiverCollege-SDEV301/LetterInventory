package inventory;

public class LetterPresence
{
    private int inventory;

    public int getIndex(char letter){
         return letter - 'a';

    }
                            //e
    public void add(char letter){
            //4             //e
        int position = getIndex(letter);
                            //4
        int temp = 1 << position; //

        inventory += temp;
    }
    //with letter e
//000000001 because 1<< position 4 that means (bite shifted)
//000010000

//with letter f
//000000001
//shift 5 times
//000100000

    public boolean isPresent(char letter){
      int position = getIndex(letter);
      int temp = 1<<position;
      int check  = inventory & temp; //& for bite. & i s1 if both values are 1. Check position and temp
        //
        //temp ->
        //check->
        return check >0;
    }
}
