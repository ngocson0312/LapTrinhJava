/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguoi_dung.lich_thuc_hanh;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import static nguoi_dung.DemoNguoiDung.index;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author Duc_Cuong
 */
public class DangKyLichThucHanh {
	static Database db = new Database();
	static ArrayList<YeuCauDangKiLichThucHanh> dsListYc = new ArrayList<YeuCauDangKiLichThucHanh>();
	static ArrayList<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
	static ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
	static ArrayList<PhongThucHanh> dsPhongThucHanhs = new ArrayList<PhongThucHanh>();
	static String maGiaoVien;
        static String linkIdYCDK = "data/IDYCDK.txt";
        static String linkPTH = "data/pth.txt";
        static String linkTK = "data/DSTK.txt";
        static String linkDSYCDK = "data/DSYCDK.txt";
	static int auToIdYCDK = 0;
        
	public static void menuDangKyLichThucHanh() {
            
            try {
                dsListYc =  (ArrayList<YeuCauDangKiLichThucHanh>) db.docFile(linkDSYCDK);
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
                auToIdYCDK = (int) db.docFile(linkIdYCDK);
            } catch (Exception ex) {
            }
           
            
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- MENU L???CH ????NG K?? TH???C H??NH -------------");
            System.out.println("1: ????ng k?? l???ch th???c h??nh.");
            System.out.println("2: Xem danh s??ch y??u c???u ????ng k??.");
            System.out.println("3: Tr??? v???.");
            System.out.print("=> L???a ch???n c???a b???n l??: ");
            int chon;
            try{
                chon = Integer.parseInt(scan.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }
            switch (chon) {
                case 1:
                    nhapYeuCauDk();
                    break;
                case 2:
                    xuatDsYeuCauDk();
                    break;
                case 3:
                    return;
                default:
                        System.out.println("\n=> L???a ch???n c???a b???n ch??a ch??nh x??c. Vui l??ng th??? l???i!");
                        System.out.println("=> Enter ????? ti???p t???c!");
                        scan.nextLine();
                }
        }
		
	}
        public static int nhapYeuCauDk() {
            YeuCauDangKiLichThucHanh ycdklth = new YeuCauDangKiLichThucHanh();
            try {
                    ycdklth.setMaYCDK("YC"+auToIdYCDK);
                    ycdklth.setMaGV(user.getMaGV());
                    System.out.print("M???i nh???p m?? l???p h???c: ");
                    String maLop = scan.nextLine();
                    if (KiemTraMaLop(maLop)) {
                        if(KiemTraMaLopTrongDs(maLop) != true){
                            ycdklth.setMaLopHoc(maLop);
                        }else{
                            nhapDk("M?? l???p ???? ???????c ????ng k??");
                            return 0;
                        }
                         
                    }else{
                         nhapDk("M?? l???p kh??ng t???n t???i");
                         return 0;
                    }
                    System.out.print("M???i nh???p m?? ph??ng th???c h??nh: ");
                    String maPhong = scan.nextLine();
                   if (KiemTraMaPhong(maPhong)) {
                       ycdklth.setMaPhongThucHanh(maPhong); 
                    }else{
                        nhapDk("M?? ph??ng kh??ng t???n t???i");
                        return 0;
                   }
                    int maCa = nhapMaCaThucHanh();
                    ycdklth.setMaCaThucHanh(maCa);
                    LocalDateTime localDate = LocalDateTime.now();
		    int year = localDate.getYear();
                    System.out.println("M???i nh???p ng??y th??ng n??m: ");
                    int ngay =Integer.parseInt(scan.nextLine());
                    int thang =Integer.parseInt(scan.nextLine());
                    int nam = Integer.parseInt(scan.nextLine());
                    if (nam < year || nam > (year+2) || (thang < 0 || thang > 12) || (ngay < 0 || ngay > 31)) {
                          nhapDk("Th???i gian ????ng k?? kh??ng h???p l???"); 
                    }else{
                        Date date = new Date(ngay, thang, nam);
                        ycdklth.setNgayBatDau(date);   
                    }
                    System.out.print("M???i nh???p s??? tu???n: ");
                    int soTuan = Integer.parseInt(scan.nextLine());
                    if(soTuan < 0 || soTuan > 20){
                         nhapDk("S??? tu???n ????ng k?? (0 - 20)");
                         return 0;
                    }else{
                        ycdklth.setSoTuan(soTuan);
                    }
                    
                    
                    auToIdYCDK++;
                    dsListYc.add(ycdklth);
                    System.out.println("???? g???i y??u c???u ????ng k??");
                    try {
                        db.LuuFile(linkDSYCDK, dsListYc);
                        db.LuuFile(linkIdYCDK, auToIdYCDK);
                    } catch (Exception e) {
                             
                    }

            } catch (Exception e) {
                System.err.println(e);
            }
            return 1;

	}

	static private void xuatDsYeuCauDk() {
            
            if(dsListYc.size() == 0) {
                System.out.println("Ch??a c?? y??u c???u ????ng k?? n??o");
            }else {
                int stt = 0;
                System.out.println(index);
                
                YeuCauDangKiLichThucHanh.tieuDe2();
                for (YeuCauDangKiLichThucHanh yeuCauDangKiLichThucHanh : dsListYc) {
                    if(user.getMaGV().equals(yeuCauDangKiLichThucHanh.getMaGV()))
                        yeuCauDangKiLichThucHanh.inYCDK2(++stt);
                }
            }
 
	}
	public static int nhapMaCaThucHanh() throws Exception {
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

	public static boolean KiemTraMaLop(String x) {
            for (LopHoc lopHoc : user.getDsLopHoc()) {
                    if (lopHoc.getMaLop().equals(x)) {
                            return true;
                    }
            }
            return false;
	}
        public static boolean KiemTraMaLopTrongDs(String x) {
            for (YeuCauDangKiLichThucHanh ycdklth:dsListYc) {
                    if (ycdklth.getMaLopHoc().equals(x)) {
                            return true;
                    }
            }
            return false;
	}
	public static boolean KiemTraMaPhong(String x) {
            for (PhongThucHanh phongThucHanh : dsPhongThucHanhs) {
                    if (phongThucHanh.getMaPhong().equals(x)) {
                            return true;
                    }
            }
            return false;
	}
        public static int nhapDk(String x){
            int luaChon = 0;
                while (luaChon < 1 || luaChon > 3) {
                    System.out.println(x);
                    System.out.println("\n--------------------------------------");
                    System.out.println("Nh???p 1 ????? nh???p l???i.");
                    System.out.println("Nh???p 2 ????? tho??t");
                    System.out.println("\n--------------------------------------");
                    luaChon = Integer.parseInt(scan.nextLine());
                    if (luaChon == 1) {
                            nhapYeuCauDk();
                    } else if (luaChon == 2) {
                            return 0;
                    }
                }
            return 1;
        }
	
}
