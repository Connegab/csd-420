import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {

    public static void main(String[] args) {

        // Try it out with 50,000 elements
        System.out.println("Testing with 50,000 elements:");
        runTest(50000);

        System.out.println("\n----------------------------------------\n");

        // Now test with 500,000 elements
        System.out.println("Testing with 500,000 elements:");
        runTest(500000);
    }

    public static void runTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the list with numbers
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // --- Go through the list using an Iterator ---
        long startTime = System.nanoTime();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;

        // --- Go through the list using get(index) ---
        startTime = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        endTime = System.nanoTime();
        long getTime = endTime - startTime;

        // --- Show results ---
        System.out.println("Traversal using Iterator: " + iteratorTime / 1_000_000.0 + " ms");
        System.out.println("Traversal using get(index): " + getTime / 1_000_000.0 + " ms");

        // --- Quick check to make sure the list is correct ---
        if (list.get(0) == 0 && list.get(size - 1) == size - 1) {
            System.out.println("Verification: List loaded and accessed successfully.");
        } else {
            System.out.println("Verification failed.");
        }

        // --- Why the results look like they do ---
        System.out.println("\nExplanation:");
        System.out.println("Using an Iterator is a lot faster when going through a LinkedList because it moves "
                + "straight through each node one by one. The get(index) method is slower since LinkedList "
                + "does not use direct indexing like an ArrayList, it has to start from the beginning each time "
                + "to reach a specific spot. As the list gets bigger (like from 50,000 to 500,000), that slowdown "
                + "becomes much more noticeable.");
    }
}
