import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill the ArrayList with 50 random values (1–20)
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // The program will remove any duplicates
        ArrayList<Integer> noDuplicatesList = removeDuplicates(originalList);

        // It will display the new list
        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicatesList);
    }

    // A generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
