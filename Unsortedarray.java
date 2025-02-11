import java.util.Random;

public class Unsortedarray 
{
    public static boolean unsorted_search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
        if (array[index] == key) {
        return true;
        }
        }
        return false;
        }




}

