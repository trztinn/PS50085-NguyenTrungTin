import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private double tax;

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten san pham: ");
        this.name = sc.nextLine();
        
        System.out.print("Nhap gia san pham: ");
        this.price = sc.nextDouble();
        
        System.out.print("Nhap thue san pham (vi du: 0.1 cho 10%): ");
        this.tax = sc.nextDouble();

        sc.close();
    }

    public double getTaxPrice() {
        return this.price * this.tax;
    }

    public void xuatThongTin() {
        System.out.println("Ten san pham: " + this.name);
        System.out.println("Gia san pham: " + this.price);
        System.out.println("Thue: " + this.tax);
        System.out.println("Tien thue: " + getTaxPrice());
    }
}