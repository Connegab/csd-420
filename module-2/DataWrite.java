import java.io.*;
import java.util.*;

public class DataWrite {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);       // A random int 0–99
            doubleArray[i] = rand.nextDouble() * 100; // A random double 0–100
        }

        File file = new File("Gabe_datafile.dat");

        try (FileWriter fw = new FileWriter(file, true);
             PrintWriter output = new PrintWriter(fw)) {

            output.println("New Entry:");
            output.print("Integers: ");
            for (int num : intArray) {
                output.print(num + " ");
            }
            output.println();

            output.print("Doubles: ");
            for (double val : doubleArray) {
                output.printf("%.2f ", val);
            }
            output.println("\n");
            System.out.println("Data written successfully to " + file.getName());

        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
