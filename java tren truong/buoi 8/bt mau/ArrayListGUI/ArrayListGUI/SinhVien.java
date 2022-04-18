package ArrayListGUI;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVien implements Serializable{
    private String lop;
    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public SinhVien() {
        try {
            this.lop = "KTPM1";
            this.maSV = "0000";
            this.hoTen = "";
            this.ngaySinh = format.parse("01/01/1992");
            this.diaChi = "";
        } catch (ParseException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SinhVien(String lop, String maSV, String hoTen, Date ngaySinh, String diaChi) {
        this.lop = lop;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return format.format(ngaySinh);
    }

    public void setNgaySinh(Date ngaySinh) {

        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SinhVien other = (SinhVien) obj;
        if (!Objects.equals(this.maSV, other.maSV)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maSV);
        return hash;
    }
}
