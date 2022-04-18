
package doi_tuong;

import java.io.Serializable;

public class YeuCauDangKiLichThucHanh implements Serializable{
    private String maYCDK;
    private String maGV;
    private String maLopHoc;
    private int maCaThucHanh;
    private String maPhongThucHanh;
    private Date ngayBatDau;
    private int soTuan;
    private int trangThaiPheDuyet = 3;
    private String ghiChu;

    public YeuCauDangKiLichThucHanh(String maYCDK, String maGV, String maLopHoc, int maCaThucHanh, String maPhongThucHanh, Date ngayBatDau, int soTuan) {
        this.maYCDK = maYCDK;
        this.maGV = maGV;
        this.maLopHoc = maLopHoc;
        this.maCaThucHanh = maCaThucHanh;
        this.maPhongThucHanh = maPhongThucHanh;
        this.ngayBatDau = ngayBatDau;
        this.soTuan = soTuan;
    }
    
    public YeuCauDangKiLichThucHanh() {
    }
    
    // Tiêu đề của ds yêu cầu
    public static void tieuDe1(){
        System.out.printf("\n%-5s %-10s %-15s %-10s %-10s %-15s %-15s %-10s %-30s\n",
        "STT", "Mã YC", "Mã giáo viên", "Mã lớp", "Ca", "Mã phòng YC", "Ngày bắt đầu", "Số tuần", "Trạng thái");
    }
    
    public static void tieuDe2(){
        System.out.printf("\n%-5s %-10s %-15s %-10s %-10s %-15s %-15s %-10s %-20s %-30s\n",
        "STT", "Mã YC", "Mã giáo viên", "Mã lớp", "Ca", "Mã phòng YC", "Ngày bắt đầu", "Số tuần", "Trạng thái", "Ghi chú");
    }
    
    public static void tieuDe3(){
        System.out.printf("\n%-10s %-15s %-10s %-10s %-15s %-15s %-10s\n",
        "Mã YC", "Mã giáo viên", "Mã lớp", "Ca", "Mã phòng YC", "Ngày bắt đầu", "Số tuần");
    }
    
    // Hiển thị danh sách yêu cầu
    public void inYCDK1(int stt){
        System.out.printf("%-5d %-10s %-15s %-10s %-10s %-15s %-15s %-10s %-30s\n",
        stt, maYCDK, maGV, maLopHoc, ca(maCaThucHanh), maPhongThucHanh, ngayBatDau.hienThi(), soTuan, trangThai(trangThaiPheDuyet));
    }
    
    public void inYCDK2(int stt){
        System.out.printf("%-5d %-10s %-15s %-10s %-10s %-15s %-15s %-10s %-20s %-30s\n",
        stt, maYCDK, maGV, maLopHoc, ca(maCaThucHanh), maPhongThucHanh, ngayBatDau.hienThi(), soTuan, trangThai(trangThaiPheDuyet), ghiChu);
    }
    
    public void inYCDK3(){
        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s %-10s\n",
        maYCDK, maGV, maLopHoc, ca(maCaThucHanh), maPhongThucHanh, ngayBatDau.hienThi(), soTuan);
    }

    public String trangThai(int tt){
        if(tt == 1)
            return "Chấp thuận";
        else if(tt == 2)
            return "Không chấp thuận";
        return "Đang chờ phê duyệt";
    }

   
    public String ca(int tt){
        if(tt == 1)
            return "Sáng";
        else if(tt == 2)
            return "Chiều";
        return "Tối";
    }

    public String getMaYCDK() {
        return maYCDK;
    }

    public void setMaYCDK(String maYCDK) {
        this.maYCDK = maYCDK;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public int getMaCaThucHanh() {
        return maCaThucHanh;
    }

    public void setMaCaThucHanh(int maCaThucHanh) {
        this.maCaThucHanh = maCaThucHanh;
    }

    public String getMaPhongThucHanh() {
        return maPhongThucHanh;
    }

    public void setMaPhongThucHanh(String maPhongThucHanh) {
        this.maPhongThucHanh = maPhongThucHanh;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public int getSoTuan() {
        return soTuan;
    }

    public void setSoTuan(int soTuan) {
        this.soTuan = soTuan;
    }

    public int getTrangThaiPheDuyet() {
        return trangThaiPheDuyet;
    }

    public void setTrangThaiPheDuyet(int trangThaiPheDuyet) {
        this.trangThaiPheDuyet = trangThaiPheDuyet;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
