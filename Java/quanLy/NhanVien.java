package quanLy;

public class NhanVien {
    private String maNV;
    private String hoTen;
    private double luongCoBan;

    public NhanVien(String maNV, String hoTen, double luongCoBan){
        this.maNV = maNV;
        this.hoTen = hoTen;
        setluong(luongCoBan);
    }

    public String getName(){
        return this.hoTen;
    }

    public void setName(String ten){
        this.hoTen = ten;
    }

    public String getMaNV(){
        return this.maNV;
    }

    public void setmaNV(String maNV){
        this.maNV = maNV;
    }

    public double getluong(){
        return luongCoBan;
    }

    public void setluong(double luongCoBan){
        if (luongCoBan <= 0) {
            this.luongCoBan = 0;
        }else this.luongCoBan = luongCoBan;
    }

    public double tinhluong(){
        return this.luongCoBan;
    }

    public void hienThiThongTin(){
        System.out.println("Ma so: "+ getMaNV());
        System.out.println("Ho va ten: "+ getName());
        System.out.println("Luong:"+ tinhluong());
    }
}
