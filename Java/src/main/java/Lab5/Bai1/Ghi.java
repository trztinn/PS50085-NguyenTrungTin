package Lab5.Bai1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Ghi {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(List.of(
            "Nguyen Trung Tin",
            "Nguyen Thi Thuy Duong",
            "Truong Thien Anh"
        ));
        try {
            FileWriter ghi = new FileWriter("file.txt");
            for (String object : a) {
                ghi.write(object+"\n");
            }
            ghi.close();
            System.out.println("Da ghi xong");
        } catch (Exception e) {
            System.out.println("Co loi: "+ e.getMessage());
        }
    }
}