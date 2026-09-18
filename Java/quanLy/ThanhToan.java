package quanLy;

public class ThanhToan {
    private double soTien;

    public double getMoney(){
        return soTien;
    }

    public void setMoney(double money){
        this.soTien = money;
    }

    public void thanhToan() {
        System.out.println("Ban da thanh toan: "+ getMoney());
    }
}

class TheNganHang extends ThanhToan{
    private int soThe;

    @Override 
    public void thanhToan(){
        System.out.println("Thanh toan "+ getMoney()+ " qua the ngan hang "+ soThe);
    }
}

class ViDienTu extends ThanhToan{
    private int soDienThoai;

    @Override 
    public void thanhToan(){
        System.out.println("Thanh toan "+ getMoney()+ " qua vi dien tu "+ soDienThoai);
    }
}