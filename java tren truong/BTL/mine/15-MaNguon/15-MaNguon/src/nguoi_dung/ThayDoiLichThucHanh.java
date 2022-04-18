package nguoi_dung;

import doi_tuong.Date;
import doi_tuong.LopHoc;
import doi_tuong.PhongThucHanh;
import doi_tuong.TaiKhoan;
import doi_tuong.YeuCauDangKiLichThucHanh;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import DBEngine.Database;
import static demo_chuong_trinh.DangNhap.user;
import doi_tuong.KhuNha;
import doi_tuong.MonHoc;
import doi_tuong.YeuCauThayDoiLichThucHanh;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nguoi_dung.DemoNguoiDung.index;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author admin
 */
public class ThayDoiLichThucHanh {
        static Database db = new Database();
	static ArrayList<YeuCauDangKiLichThucHanh> DSLTH = new ArrayList<YeuCauDangKiLichThucHanh>();
	static ArrayList<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
	static ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
	static ArrayList<PhongThucHanh> dsPhongThucHanhs = new ArrayList<PhongThucHanh>();
	static String maGiaoVien;
        static String linkIdYCTD = "data/IDYCTD.txt";
        static String linkPTH = "data/pth.txt";
        static String linkTK = "data/DSTK.txt";
        static String linkDSYCDK = "data/DSYCDK.txt";
        static String linkDSYCTD="data/DSYCTD.txt";
        static ArrayList<YeuCauThayDoiLichThucHanh> YCTD = new ArrayList<>();
	static int autoIdTD = 0;
        
        
	public static void menuThayDoiLichThucHanh() {
            
            try {
                DSLTH =  (ArrayList<YeuCauDangKiLichThucHanh>) db.docFile(linkDSYCDK);
		} catch (Exception e) {
            }
            
            try {
                dsTaiKhoan =  (ArrayList<TaiKhoan>) db.docFile(linkTK);
		} catch (Exception e) {
            }
            try {
                dsPhongThucHanhs = (ArrayList<PhongThucHanh>) db.docFile(linkPTH);
            } catch (Exception ex) {
            }
            try {
                YCTD = (ArrayList<YeuCauThayDoiLichThucHanh>) db.docFile(linkDSYCTD);
            } catch (Exception ex) {
            }
            try {
                autoIdTD = (int) db.docFile(linkIdYCTD);
            } catch (Exception ex) {
            }
           
            
        Scanner scan = new Scanner(System.in);
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n-------------THAY ĐỔI LỊCH THỰC HÀNH -------------");
            System.out.println("Danh sách lịch thực hành đang có của người dùng ");
            inDsLTH();
            System.out.println("Nhập mã lịch thực hành cần thay đổi:");
            String ma = scan.nextLine();
            int i= KiemTraTonTai(ma);
            if(i !=-1 ){
                YeuCauThayDoiLichThucHanh YCLTH = new YeuCauThayDoiLichThucHanh();
                nhapYeuCauTD(i, YCLTH);
                System.out.println("Nhập Lý do muốn thay đổi lịch thực hành (ngắn gọn): ");
                String lydo = scan.nextLine();
                YCLTH.setLydo(lydo);
            
                //Xác nhận thêm lần nữa
                System.out.println("=> Thực sự muốn gửi yêu cầu thay đổi lịch thực hành (1: có, bất kỳ: hủy): ");
                String xn = scan.nextLine();
                if(xn.equals("1")){
                    autoIdTD++;
                    YCTD.add(YCLTH);
                    System.out.println("=> Đã gửi yêu cầu thay đổi");
                    try {
                        db.LuuFile(linkDSYCTD, YCTD);
                        db.LuuFile(linkIdYCTD, autoIdTD);
                    } catch (Exception e) {
                    }
                }
                else{
                    System.out.println("=> Đã hủy yêu cầu.");
                }
            

                
            }
            else 
                System.out.print("Lịch thực hành không tồn tại");
            
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
	}
        
        
        
        public static int KiemTraTonTai(String ma){
            for(YeuCauDangKiLichThucHanh i: DSLTH)
                if(ma.equals(i.getMaYCDK())&& i.getMaGV().equals(user.getMaGV()))
                    return DSLTH.indexOf(i);
                return -1;
        }
        
        
        
        public static void nhapYeuCauTD(int i, YeuCauThayDoiLichThucHanh YCLTH) {
            
            
            YCLTH.setMaYCTD("YCTD"+autoIdTD);
            YCLTH.setLTH(DSLTH.get(i));
            
            while(true){
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println("\n------------- NHẬP THÔNG TIN YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH -------------");
                System.out.println("1: Thay đổi phòng thực hành.");
                System.out.println("2: Thay đổi ca thực hành.");
                System.out.println("3: Thay đổi ngày thực hành.");
                System.out.println("4: Thay đổi số tuần thực hành.");
                System.out.println("5: Hoàn tất.");
                System.out.print("=> Lựa chọn của bạn là: ");
                int c;
                try{
                    c = Integer.parseInt(scan.nextLine());
                }
                catch(Exception err){
                    c = -1;
                }

                switch(c){
                    case 1:
                        System.out.print("Mời nhập mã ca thực hành mới: ");
                        String maPhong = scan.nextLine();
                        if (KiemTraMaPhong(maPhong)) {
                            YCLTH.setMaPTHmoi(maPhong); 
                         }else{
                             System.out.print("Mã phòng không tồn tại");
                        }
                        break;

                    case 2:
                        System.out.print("Mời nhập ca thực hành mới: ");
                        int maCa = nhapMaCaThucHanh();
                        YCLTH.setMaCaTHmoi(maCa);
                        break;
                        
                    case 3:
                        LocalDateTime localDate = LocalDateTime.now();
                        int year = localDate.getYear();
                        System.out.println("Mời nhập ngày tháng năm: ");
                        int ngay =Integer.parseInt(scan.nextLine());
                        int thang =Integer.parseInt(scan.nextLine());
                        int nam = Integer.parseInt(scan.nextLine());
                        if (nam < year || nam > (year+2) || (thang < 0 || thang > 12) || (ngay < 0 || ngay > 31)) {
                              System.out.print("Thời gian đăng ký không hợp lệ"); 
                        }else{
                            Date date = new Date(ngay, thang, nam);
                            YCLTH.setNgayTHmoi(date);   
                        }
                        break;
                    case 4:
                        System.out.print("Mời nhập số tuần thực hành mới: ");
                        int soTuan = Integer.parseInt(scan.nextLine());
                        if(soTuan < 0 || soTuan > 20){
                             System.out.print("Số tuần đăng ký (0 - 20)");
                        }else{
                            YCLTH.setSoTuan(soTuan);
                        }
                        break;
                        
                    case 5:
                        return;
                    
                    default:
                        System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                        System.out.println("=> Enter để tiếp tục!");
                        scan.nextLine();
                }
            }
        
            
        }
        
	static private void inDsLTH() {
            
            if(DSLTH.size() == 0) {
                System.out.println("Chưa có lịch thực hành nào");
            }else {
                int stt = 0;
                
                YeuCauDangKiLichThucHanh.tieuDe3();
                for (YeuCauDangKiLichThucHanh ycdk : DSLTH) {
                    if(user.getMaGV().equals(ycdk.getMaGV())&&ycdk.getTrangThaiPheDuyet() == 1)
                        ycdk.inYCDK3();
                }
            }
 
	}
	public static int nhapMaCaThucHanh() {
		int maCaThucHanh = 0;
		Scanner scan = new Scanner(System.in);
		int luaChon = 0;
		while (luaChon < 1 || luaChon > 4) {
			System.out.print("Nhập 1. Ca sáng   ");
			System.out.print("Nhập 2. Ca chiều   ");
			System.out.print("Nhập 3. Ca tối   ");
			System.out.print("\nMời nhập: ");
			luaChon = Integer.parseInt(scan.nextLine());
		}
		switch (luaChon) {
		case 1: {
			maCaThucHanh = 1;
			break;
		}
		case 2: {
			maCaThucHanh = 2;
			break;
		}
		case 3: {
			maCaThucHanh = 3;
			break;
		}
		}
		return maCaThucHanh;
	}

	
        
	public static boolean KiemTraMaPhong(String x) {
            for (PhongThucHanh phongThucHanh : dsPhongThucHanhs) {
                    if (phongThucHanh.getMaPhong().equals(x)) {
                            return true;
                    }
            }
            return false;
	}
        
}
