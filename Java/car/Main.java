package car;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    // Danh sách chứa kiểu cha Xe
ArrayList<Xe> ds = new ArrayList<>();

Xe hoi1 = new Xe("A", 10);
Xe hoi2 = new Xe("B", 20);
Xe hoi3 = new Xe("C", 30);

ds.add(hoi1);
ds.add(hoi2);
ds.add(hoi3);

for (Xe xe2 : ds) {
    xe2.xuatThongTin();
    System.out.println();
}
}
}
