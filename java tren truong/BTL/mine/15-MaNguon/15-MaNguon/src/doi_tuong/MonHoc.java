package doi_tuong;

import java.io.Serializable;

public class MonHoc implements Serializable{
    private String maMH;
    private String tenMonHoc;
    private String chuyenNganh;

    public MonHoc(String maMH, String tenMonHoc, String chuyenNganh) {
        this.maMH = maMH;
        this.tenMonHoc = tenMonHoc;
        this.chuyenNganh = chuyenNganh;
    }

    public MonHoc() {
    }
    
    

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
    
    
}
