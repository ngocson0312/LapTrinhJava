
package doi_tuong;

import java.io.Serializable;

public class YeuCauThayDoiLichThucHanh implements Serializable{
    private String maYCTD;
    private YeuCauDangKiLichThucHanh LTH;
    private String maPTHmoi;
    private int maCaTHmoi;
    private Date ngayTHmoi = new Date();
    private int soTuan;
    private String lydo;
    private int trangThaiPheDuyet = 3;
    private String ghiChu;

    public YeuCauThayDoiLichThucHanh(String maYCTD, YeuCauDangKiLichThucHanh LTH, String maPTHmoi, int maCaTHmoi, Date ngayTHmoi, int soTuan, String lydo) {
        this.maYCTD = maYCTD;
        this.LTH = LTH;
        this.maPTHmoi = LTH.getMaPhongThucHanh();
        this.maCaTHmoi = LTH.getMaCaThucHanh();
        this.ngayTHmoi = LTH.getNgayBatDau();
        this.lydo = lydo;
        this.soTuan = LTH.getSoTuan();
    }

    public YeuCauThayDoiLichThucHanh() {
    }
    
    // Tiêu đề của ds yêu cầu
    public static void tieuDe1(){
        System.out.printf("\n%-5s %-20s %-15s %-10s %-40s %-20s\n",
        "STT", "Mã YC thay đổi", "Mã giáo viên", "Mã lớp", "Lý do", "Trạng thái");
    }
    
    //Xây dựng hàm in tiêu đề theo các nội dung có sự thay đổi, nội dung nào không thay đổi thì k hiển thị nữa
    public static void tieuDe2(boolean a, boolean b, boolean c, boolean d){
        System.out.printf("\n%-20s %-15s ", "Mã YC thay đổi", "Mã giáo viên");
        if(a)
            System.out.printf("%-10s ", "Ca mới");
        if(b)
            System.out.printf("%-20s ", "Mã phòng mới");
        if(c)
            System.out.printf("%-20s ", "Ngày bắt đầu mới");
        if(d)
            System.out.printf("%-15s ", "Số tuần mới");
        System.out.printf("%-40s %-15s\n", "Lý do", "Trạng thái");
    }
    
    //
    public static void tieuDe3(){
        System.out.printf("\n%-5s %-20s %-15s %-10s %-40s %-20s %-40s\n",
        "STT", "Mã YC thay đổi", "Mã giáo viên", "Mã lớp", "Lý do", "Trạng thái", "Ghi chú");
    }
    
    // Hiển thị danh sách yêu cầu
    public void inYCDK1(int stt){
        System.out.printf("%-5d %-20s %-15s %-10s %-40s %-20s\n",
        stt, maYCTD, LTH.getMaGV(), LTH.getMaLopHoc(), lydo, trangThai(trangThaiPheDuyet));
    }
    
    public void inYCDK2(boolean a, boolean b, boolean c, boolean d){
        System.out.printf("%-20s %-15s ", maYCTD, LTH.getMaGV());
        if(a)
            System.out.printf("%-10s ", ca(maCaTHmoi));
        if(b)
            System.out.printf("%-20s ", maPTHmoi);
        if(c)
            System.out.printf("%-20s ", ngayTHmoi.hienThi());
        if(d)
            System.out.printf("%-15s ", soTuan);
        System.out.printf("%-40s %-15s\n", lydo, trangThai(trangThaiPheDuyet));
    }
    
    public void inYCDK3(int stt){
        System.out.printf("%-5d %-20s %-15s %-10s %-40s %-20s %-40s\n",
        stt, maYCTD, LTH.getMaGV(), LTH.getMaLopHoc(), lydo, trangThai(trangThaiPheDuyet), ghiChu);
    }

    // Hiển thị tên trạng thái
    public String trangThai(int tt){
        if(tt == 1)
            return "Chấp thuận";
        else if(tt == 2)
            return "Không chấp thuận";
        return "Đang chờ phê duyệt";
    }
    
    //Hiển thị tên ca
    public String ca(int tt){
        if(tt == 1)
            return "Sáng";
        else if(tt == 2)
            return "Chiều";
        return "Tối";
    }
    
    //CÁc setter getter
    public String getMaYCTD() {
        return maYCTD;
    }

    public void setMaYCTD(String maYCTD) {
        this.maYCTD = maYCTD;
    }

    public YeuCauDangKiLichThucHanh getLTH() {
        return LTH;
    }

    public void setLTH(YeuCauDangKiLichThucHanh LTH) {
        this.LTH = LTH;
    }

    public String getMaPTHmoi() {
        return maPTHmoi;
    }

    public void setMaPTHmoi(String maPTHmoi) {
        this.maPTHmoi = maPTHmoi;
    }

    public int getMaCaTHmoi() {
        return maCaTHmoi;
    }

    public void setMaCaTHmoi(int maCaTHmoi) {
        this.maCaTHmoi = maCaTHmoi;
    }

    public Date getNgayTHmoi() {
        return ngayTHmoi;
    }

    public void setNgayTHmoi(Date ngayTHmoi) {
        this.ngayTHmoi = ngayTHmoi;
    }

    public int getSoTuan() {
        return soTuan;
    }

    public void setSoTuan(int soTuan) {
        this.soTuan = soTuan;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
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
