
package Lab1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai4_HinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double PI = 3.14159;
        
        System.out.print("Nhap chieu dai: ");
        double chieuDai = sc.nextDouble();
        
        System.out.print("Nhap chieu rong: ");
        double chieuRong = sc.nextDouble();
        
        double chuVi = 2* (chieuDai + chieuRong);
        double dienTich = chieuDai * chieuRong;
        
        xuatMangHinh(chuVi, dienTich);
        
        sc.close();
    }
    
    static void xuatMangHinh(double chuVi, double dienTich){
        System.out.println("Chu vi hinh chu nhat: "+ chuVi);
        System.out.println("Dien tich hinh chu nhat: "+ dienTich);
    }
}
