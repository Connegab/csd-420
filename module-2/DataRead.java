import java.io.*;

public class DataRead {
    public static void main(String[] args) {
        File file = new File("Gabe_datafile.dat");

        if (!file.exists()) {
            System.out.println("The file does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Contents of " + file.getName() + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }
}
