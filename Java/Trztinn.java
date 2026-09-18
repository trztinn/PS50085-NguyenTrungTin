import java.util.Scanner;

public class Trztinn {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    final double GIAM_TRU_BAN_THAN = 11000000;
    final double GIAM_TRU_PHU_THUOC = 4400000;

    double thuNhapHangThang = sc.nextDouble();
    int nguoiPhuThuoc = sc.nextInt();

    double thuNhapChiuThue = thuNhapHangThang - GIAM_TRU_BAN_THAN 
    - (nguoiPhuThuoc * GIAM_TRU_PHU_THUOC);
    
    if (thuNhapChiuThue <= 0) {
        System.out.println("Khong co thue");
    }else{
        if (thuNhapChiuThue <= 10000000) {
            System.out.println(thuNhapChiuThue * 0.05);
        } else {
            System.out.println(1000000 * 0.05 
            + (thuNhapChiuThue - 10000000) * 0.1);
        }
    }

    sc.close();
}

static void tinhTienDien(){
    final double kWh50 = 1.806;
    final double kWh100 = 1.866;
    final double kWh200 = 2.167;

    Scanner sc = new Scanner(System.in);

    System.out.print("Nhap kWh: ");
    double kWh = sc.nextDouble();

    double Tinhtong = 0;
    if (kWh <= 50) {
        Tinhtong = kWh * kWh50;
    } else if(kWh <= 100) {
        Tinhtong = 50 * kWh50 + (kWh - 50) * kWh100;
    } else 
        Tinhtong = 50 * kWh50 + 50 * kWh100 + (kWh - 100) * kWh200;

    System.out.println("Tong tien dien: " + Tinhtong * 1.08);
}
}