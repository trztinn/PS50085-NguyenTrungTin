package trztinn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAnh {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("anh-goc.jpg");
                FileOutputStream out = new FileOutputStream("anh-copy.jpg")) {

            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            System.out.println("Copy xong!");

        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}