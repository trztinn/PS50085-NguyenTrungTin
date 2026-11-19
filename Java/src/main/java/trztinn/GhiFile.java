package trztinn;

import java.io.FileWriter;

public class GhiFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("trstin.txt");
            writer.write("Nguyen Thi Thuy Duong");
            writer.close();
            System.out.println("Da ghi xong");
        } catch (Exception e) {
            System.out.println("Co loi: "+ e.getMessage());
        }
        
    }
}
