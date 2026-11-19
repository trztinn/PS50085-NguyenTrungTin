package trztinn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DocFileHienDai {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader (new FileReader
            ("src/main/java/trztinn/trstin.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}