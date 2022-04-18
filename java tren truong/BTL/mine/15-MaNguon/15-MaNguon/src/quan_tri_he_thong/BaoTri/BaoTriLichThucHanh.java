/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_tri_he_thong.BaoTri;

import static quan_tri_he_thong.BaoTri.BaoTri.data;
import static quan_tri_he_thong.BaoTri.BaoTri.linkPTH;
import static quan_tri_he_thong.BaoTri.BaoTri.list;
import static quan_tri_he_thong.BaoTri.BaoTriPhongThucHanh.menuBaoTri3;
import static quan_tri_he_thong.BaoTri.BaoTriPhongThucHanh.sc;
import doi_tuong.LichThucHanh;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.BaoTri.BaoTri.linkLTH;
import static quan_tri_he_thong.BaoTri.BaoTri.listLTH;

/**
 *
 * @author DatLuu
 */
public class BaoTriLichThucHanh {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<LichThucHanh> listt = new ArrayList<LichThucHanh>();
     public static void menuBaoTri2(){
           while(true){
            System.out.println("\n------------- Bảo Trì Lịch Thực Hành -------------");
            System.out.println("1: Thêm lịch thực hành.");
            System.out.println("2: Sủa lịch thực hành .");
            System.out.println("3: Xóa lịch thực hành");
            System.out.println("4: Hiển thị lịch thực hành");
            System.out.println("5: Quay lại");
            System.out.print("=> Lựa chọn của bạn là: ");
            Scanner sc = new Scanner(System.in);
            int chon;
            try{
                chon = Integer.parseInt(sc.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }            
            switch (chon) {
                case 1:
                    themLichThucHanh();
                    break;
                case 2:
                    suaLichThucHanh();
                    break;
                case 3:
                    xoaPhongThucHanh();
                    break;
                case 4:
                    hienThiLichThucHanh();
                    break;
                case 5:
                    return;
     
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    sc.nextLine();
            }
        }
    }
     
    
    private static void themLichThucHanh() {
        System.out.println("\n\t\t.....Thêm mới lịch thực hành.....");
		int ngay;
		do {
			System.out.print("--->Nhập ngày thực hành:");
                        ngay = Integer.parseInt(sc.nextLine());
			
			if(ngay <= 0) {
				System.out.println("Ngày không được nhỏ hơn 0,mời nhập lại....!!!!");
			}
		}while(ngay <= 0);
                
                String caThucHanh = "";
                int chonCa;
                        System.out.println("Chọn ca :1.Ca sáng,2.Ca chiều,3.Ca tối");
                        System.out.print("--->Nhập lựa chọn ca thực hành:");
                        chonCa = Integer.parseInt(sc.nextLine());
                         switch (chonCa) {
                            case 1:
                                caThucHanh = "Sang";
                                break;
                            case 2:
                                caThucHanh = "Chieu";
                                break;
                            case 3:
                                caThucHanh = "Toi";
                                break;
                            default:
                                System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                                System.out.println("=> Enter để tiếp tục!");
                                sc.nextLine();  
                         }
                String khuNha = "A1";// danh sách các phòng chứa trong 1 toàn nhà

                String maPhong ;
		do {	
			System.out.print("--->Nhập mã phòng thực hành:");
                        maPhong = sc.nextLine();
			if(maPhong.length() == 0) 
				
				System.out.println("Mã phòng thực hành không được để trống,mời nhập lại....!!!!");
			}
			while(maPhong.length() == 0);
                
                
                
                int index = indexOfLichThucHanh(maPhong);
		if(index != -1) {
			System.out.println("Tên phòng này đã tồn tại....!!!!");
			return ;
		}
                
                 String maLop;
		do {
			System.out.print("--->Nhập mã lớp đăng kí thực hành:");
                        maLop = sc.nextLine();
			
			if(maLop.length() == 0) {
				System.out.println("Mã lớp không được để trống,mời nhập lại....!!!!");
			}
		}while(maLop.length() == 0);
                
                String tenGV;
		do {
			System.out.print("--->Nhập tên giáo viên đăng kí thực hành:");
                        tenGV = sc.nextLine();
			
			if(tenGV.length() == 0) {
				System.out.println("Tên giáo viên không được để trống,mời nhập lại....!!!!");
			}
		}while(tenGV.length() == 0);
                
                String tenMonHoc;
		do {
			System.out.print("--->Nhập tên môn học đăng kí thực hành:");
                        tenMonHoc = sc.nextLine();
			
			if(tenMonHoc.length() == 0) {
				System.out.println("Tên môn học không được để trống,mời nhập lại....!!!!");
			}
		}while(tenMonHoc.length() == 0);
                LichThucHanh lth = new LichThucHanh(ngay, caThucHanh, khuNha, maPhong,maLop, tenGV,tenMonHoc);
		listLTH.add(lth);
                 try {
                     data.LuuFile(linkLTH, listLTH);
                } catch (Exception ex) {
                    Logger.getLogger(BaoTriLichThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
		System.out.println("Đã thêm lịch thực hành mới thành công....!!!!");
                
               
                
    }
    private static void suaLichThucHanh() {
        System.out.println("\n\t\t....Sửa lịch thực hành....");
		
                  String maPhong;
		do {
			System.out.print("--->Nhập mã phòng:");
                        maPhong = sc.nextLine();
			
			if(maPhong.length()  == 0) {
				System.out.println("Mã phòng thực hành không được để trống ,mời nhập lại....!!!");
			}
		}while(maPhong.length() == 0);
                int index = indexOfLichThucHanh(maPhong);
                if(index == -1) {
                        System.out.println("Không tồn tại phòng trong danh sách....!!!!");
                        return;
                }
                
		int chon;
		do {
			System.out.println("\n\t\t~~Chọn thông tin cần sửa~~");
			System.out.println("\t1: Ngày thực hành");
			System.out.println("\t2: Ca thực hành");
                        System.out.println("\t3: Quay lại");
			System.out.print("--->Nhập lựa chọn của bạn:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				int ngayms;
				do {
					System.out.print("--->Nhập ngày thực hành mới:");
                                        ngayms = Integer.parseInt(sc.nextLine());
					 
				if(ngayms <= 0)
					System.out.println("Ngày không được nhỏ hơn 0 ,mời nhập lại....!!!! ");
				}while(ngayms <= 0);
                                
				listLTH.get(index).setNgay(ngayms);
                                 try {
                                    data.LuuFile(linkLTH, listLTH);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriLichThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
				System.out.println("Sửa ngày thành công....!!!!");
				break;
                        
                        case 2:
                            String caThucHanh="";
				int chonCa;
                        System.out.println("Chọn ca :1.Ca sáng,2.Ca chiều,3.Ca tối");
                        System.out.print("--->Nhập lựa chọn ca thực hành:");
                        chonCa = Integer.parseInt(sc.nextLine());
                         switch (chonCa) {
                            case 1:
                                caThucHanh = "Sang";
                                break;
                            case 2:
                                caThucHanh = "Chieu";
                                break;
                            case 3:
                                caThucHanh = "Toi";
                                break;
                            default:
                                System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                                System.out.println("=> Enter để tiếp tục!");
                                sc.nextLine();  
                         }
				
				listLTH.get(index).setCaThucHanh(caThucHanh);
                                 try {
                                    data.LuuFile(linkLTH, listLTH);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriLichThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
				System.out.println("Sửa ca thực hành thành công....!!!!");
				break;
                        case 3:
                            return;
			default:System.out.println("Lựa chọn không hợp lệ....!!!!");
			}
		}
		while(true);
                
                
}
    private static void xoaPhongThucHanh() {
        System.out.println("\n\t\t......Xóa lịch thực hành.....");
		String maPhong;
		do {
			System.out.print("--->Nhập mã phòng cần xóa:");
                        maPhong = sc.nextLine();
			
			if(maPhong.length()==0) {
				System.out.println("Mã phòng không được để trống ,mời nhập lại....!!!!");
			}
		}while(maPhong.length() ==0);
		int index = indexOfLichThucHanh(maPhong);
		if(index == -1) {
			System.out.println("Lịch thực hành này không có trong danh sách....!!!!");
			return;
		}
		listLTH.remove(index);
                 try {
                    data.LuuFile(linkLTH, listLTH);
                } catch (Exception ex) {
                    Logger.getLogger(BaoTriLichThucHanh.class.getName()).log(Level.SEVERE, null, ex);
}
		System.out.println("Xóa lịch  thực hành thành công....!!!!");
    }
    
    private static void hienThiLichThucHanh() {
		System.out.println("\n\t\t\t----Hiển thị lịch thực hành----");
		System.out.println();
                if(listLTH.size() != 0)
                    System.out.printf("   %-10s %-20s %-10s %-12s %-12s %-30s %-30s %n","Ngày","Ca thực hành","Khu Nhà","Mã phòng","Mã lớp","Tên GV","Tên Môn Học");  
		else
                    System.out.println("--->Chưa có lịch thực hành nào");
                for(LichThucHanh lth : listLTH){
                    lth.hienThilich();
                }
	}
    
    public static int indexOfLichThucHanh(String maPhong) {
		for(int i = 0 ;i < listLTH.size() ; i ++) {
			if(listLTH.get(i).getMaPhong().compareToIgnoreCase(maPhong) == 0) {
				return i;
			}	
		}
		return -1;
    }
}