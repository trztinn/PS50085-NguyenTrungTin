
package Lab1;

import java.util.Scanner;//Ctrl + Shift + I

public class Bai2_NhapHoTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        
        System.out.print("Nhap nam sinh: ");
        int namSinh = sc.nextInt();
        
        int tinhTuoi = 2026 - namSinh;
        
        xuatMangHinh(hoTen, namSinh, tinhTuoi);
        
        sc.close();
    }
    
    static void xuatMangHinh(String hoTen, int namSinh, int tinhTuoi){
        System.out.println("Ho ten: "+ hoTen);
        System.out.println("Tuoi: "+ tinhTuoi);
    }
    
}
