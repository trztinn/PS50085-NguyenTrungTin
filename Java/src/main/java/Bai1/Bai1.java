package Bai1;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Bai1 {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(Path.of("hel=lo.txt"), StandardCharsets.UTF_8)) {
            w.write("Xin chào");
            w.newLine();
            w.write("Nguyễn Trung Tín");
        }
        System.out.println("Đã ghi xong");
    }
}