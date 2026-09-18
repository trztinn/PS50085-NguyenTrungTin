package car;

public class XeTai extends Xe {
    private int taiTrong;

    public XeTai(){
        super();
        this.taiTrong = 0;
    }

    public XeTai(String tenXe, int tocDo, int taiTrong){
    super(tenXe, tocDo);
    this.taiTrong = taiTrong;    
    }

    public int getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(int taiTrong) {
        this.taiTrong = taiTrong;
    }
     @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Tai trong:"+ taiTrong);
    }

}
