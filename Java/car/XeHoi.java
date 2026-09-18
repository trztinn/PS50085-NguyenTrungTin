package car;

public class XeHoi extends Xe {
    private double dTichBinhXang;

    public XeHoi(){
        super();
        this.dTichBinhXang = 0;
    }

    public XeHoi(String tenXe, int tocDo, double dtbx ){
        super(tenXe, tocDo);
        this.dTichBinhXang = dtbx;
    }
    public double getdTichBinhXang() {
        return dTichBinhXang;
    }

    public void setdTichBinhXang(double dTichBinhXang) {
        this.dTichBinhXang = dTichBinhXang;
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Dung tich:"+ dTichBinhXang);
    }

}
