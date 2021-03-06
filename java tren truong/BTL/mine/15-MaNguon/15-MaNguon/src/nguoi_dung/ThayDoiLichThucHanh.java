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
            System.out.println("\n-------------THAY ?????I L???CH TH???C H??NH -------------");
            System.out.println("Danh s??ch l???ch th???c h??nh ??ang c?? c???a ng?????i d??ng ");
            inDsLTH();
            System.out.println("Nh???p m?? l???ch th???c h??nh c???n thay ?????i:");
            String ma = scan.nextLine();
            int i= KiemTraTonTai(ma);
            if(i !=-1 ){
                YeuCauThayDoiLichThucHanh YCLTH = new YeuCauThayDoiLichThucHanh();
                nhapYeuCauTD(i, YCLTH);
                System.out.println("Nh???p L?? do mu???n thay ?????i l???ch th???c h??nh (ng???n g???n): ");
                String lydo = scan.nextLine();
                YCLTH.setLydo(lydo);
            
                //X??c nh???n th??m l???n n???a
                System.out.println("=> Th???c s??? mu???n g???i y??u c???u thay ?????i l???ch th???c h??nh (1: c??, b???t k???: h???y): ");
                String xn = scan.nextLine();
                if(xn.equals("1")){
                    autoIdTD++;
                    YCTD.add(YCLTH);
                    System.out.println("=> ???? g???i y??u c???u thay ?????i");
                    try {
                        db.LuuFile(linkDSYCTD, YCTD);
                        db.LuuFile(linkIdYCTD, autoIdTD);
                    } catch (Exception e) {
                    }
                }
                else{
                    System.out.println("=> ???? h???y y??u c???u.");
                }
            

                
            }
            else 
                System.out.print("L???ch th???c h??nh kh??ng t???n t???i");
            
            System.out.println("=> Enter ????? ti???p t???c!");
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
                System.out.println("\n------------- NH???P TH??NG TIN Y??U C???U THAY ?????I L???CH TH???C H??NH -------------");
                System.out.println("1: Thay ?????i ph??ng th???c h??nh.");
                System.out.println("2: Thay ?????i ca th???c h??nh.");
                System.out.println("3: Thay ?????i ng??y th???c h??nh.");
                System.out.println("4: Thay ?????i s??? tu???n th???c h??nh.");
                System.out.println("5: Ho??n t???t.");
                System.out.print("=> L???a ch???n c???a b???n l??: ");
                int c;
                try{
                    c = Integer.parseInt(scan.nextLine());
                }
                catch(Exception err){
                    c = -1;
                }

                switch(c){
                    case 1:
                        System.out.print("M???i nh???p m?? ca th???c h??nh m???i: ");
                        String maPhong = scan.nextLine();
                        if (KiemTraMaPhong(maPhong)) {
                            YCLTH.setMaPTHmoi(maPhong); 
                         }else{
                             System.out.print("M?? ph??ng kh??ng t???n t???i");
                        }
                        break;

                    case 2:
                        System.out.print("M???i nh???p ca th???c h??nh m???i: ");
                        int maCa = nhapMaCaThucHanh();
                        YCLTH.setMaCaTHmoi(maCa);
                        break;
                        
                    case 3:
                        LocalDateTime localDate = LocalDateTime.now();
                        int year = localDate.getYear();
                        System.out.println("M???i nh???p ng??y th??ng n??m: ");
                        int ngay =Integer.parseInt(scan.nextLine());
                        int thang =Integer.parseInt(scan.nextLine());
                        int nam = Integer.parseInt(scan.nextLine());
                        if (nam < year || nam > (year+2) || (thang < 0 || thang > 12) || (ngay < 0 || ngay > 31)) {
                              System.out.print("Th???i gian ????ng k?? kh??ng h???p l???"); 
                        }else{
                            Date date = new Date(ngay, thang, nam);
                            YCLTH.setNgayTHmoi(date);   
                        }
                        break;
                    case 4:
                        System.out.print("M???i nh???p s??? tu???n th???c h??nh m???i: ");
                        int soTuan = Integer.parseInt(scan.nextLine());
                        if(soTuan < 0 || soTuan > 20){
                             System.out.print("S??? tu???n ????ng k?? (0 - 20)");
                        }else{
                            YCLTH.setSoTuan(soTuan);
                        }
                        break;
                        
                    case 5:
                        return;
                    
                    default:
                        System.out.println("\n=> L???a ch???n c???a b???n ch??a ch??nh x??c. Vui l??ng th??? l???i!");
                        System.out.println("=> Enter ????? ti???p t???c!");
                        scan.nextLine();
                }
            }
        
            
        }
        
	static private void inDsLTH() {
            
            if(DSLTH.size() == 0) {
                System.out.println("Ch??a c?? l???ch th???c h??nh n??o");
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
			System.out.print("Nh???p 1. Ca s??ng   ");
			System.out.print("Nh???p 2. Ca chi???u   ");
			System.out.print("Nh???p 3. Ca t???i   ");
			System.out.print("\nM???i nh???p: ");
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
