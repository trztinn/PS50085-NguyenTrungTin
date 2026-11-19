package Lab5.Bai1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Doc {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Loi: "+ e.getMessage());
        }
    }
}
