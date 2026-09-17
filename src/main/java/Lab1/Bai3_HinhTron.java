
package Lab1;

import java.util.Scanner;

public class Bai3_HinhTron {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double PI = 3.14159;
        
        double banKinh = sc.nextDouble();
        
        double chuVi = 2*PI*banKinh;
        double dienTich = PI*banKinh*banKinh;
        
        xuatManHinh(chuVi, dienTich);
        
        sc.close();
    }
    
    static void xuatManHinh(double chuVi, double dienTich){
    
        System.out.printf("Chu vi hinh tron: %.2f\n",chuVi);
        System.out.printf("Dien tich hinh tron:%.2f",dienTich);
    }
}
