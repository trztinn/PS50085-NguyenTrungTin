package Bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// Mình đổi tên class thành Bai2App để không trùng với package Bai2
public class Bai2a { 
    public static void main(String[] args) {
        // Đã thêm dấu ngoặc đơn ( sau newBufferedReader
        try (BufferedReader r = Files.newBufferedReader(Path.of("C:/Users/Admin/Documents/PS50085_NguyenTrungTin/Java/src/main/java/Bai2/hello.txt"), StandardCharsets.UTF_8)) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println("Dòng: " + line);
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file!");
            e.printStackTrace();
        }
    }
}