package trztinn;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DocFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("src/main/java/trztinn/trstin.txt");
            BufferedReader reader = new BufferedReader(fr);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}