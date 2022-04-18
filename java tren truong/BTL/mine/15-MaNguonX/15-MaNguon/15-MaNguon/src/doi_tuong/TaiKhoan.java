package doi_tuong;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author VND
 */

public class TaiKhoan implements Serializable{
    private String maGV;
    private String tenTaiKhoan;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh = new Date();
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String chuyenNganh;
    private String soCCCD;
    private Quyen quyen;
    private boolean trangThai;
    private String ghiChu;
    private ArrayList<LopHoc> dsLopHoc;

    public TaiKhoan(boolean trangThai, int autoID) {
        this.maGV = "HAUI" + autoID;
        this.tenTaiKhoan = "GV" + autoID;
        this.matKhau = "HAUI" + autoID;
        this.trangThai = trangThai;
        this.quyen = new Quyen(1, "Quyền giáo viên", "Sử dụng được các chức năng thường");
    }
    
    public TaiKhoan(boolean trangThai, Quyen quyen, int autoID) {     
        this.maGV = "HAUI" + autoID;
        this.tenTaiKhoan = "QTV" + autoID;
        this.matKhau = "HAUI" + autoID;
        this.trangThai = trangThai;
        this.quyen = quyen;
    }
    
    public static void tieuDe(){
        System.out.printf("\n%-5s %-15s %-15s %-20s %-30s %-15s %-10s %-25s %-10s\n",
        "STT", "Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Họ tên", "Ngày sinh", "Giới tính", "Chuyên ngành", "Trạng thái");
    }
    
    public void inDSTK(int stt){
        System.out.printf("%-5s %-15s %-15s %-20s %-30s %-15s %-10s %-25s %-10s\n",
        stt, maGV, tenTaiKhoan, matKhau, hoTen, ngaySinh.hienThi(), gioiTinh, chuyenNganh, trangThai(trangThai));
    }
    
    public String trangThai(boolean x){
        if(x)
            return "Mở";
        return "Đóng";
    }

    public TaiKhoan() {
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ArrayList<LopHoc> getDsLopHoc() {
        return dsLopHoc;
    }

    public void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
        this.dsLopHoc = dsLopHoc;
    }
    
    
}
