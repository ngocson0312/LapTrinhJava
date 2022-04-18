/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_tri_he_thong.BaoTri;

import static quan_tri_he_thong.BaoTri.BaoTri.data;
import static quan_tri_he_thong.BaoTri.BaoTri.linkPTH;
import static quan_tri_he_thong.BaoTri.BaoTri.list;
import DBEngine.Database;
import doi_tuong.KhuNha;
import doi_tuong.PhongThucHanh;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatLuu
 */
public class BaoTriPhongThucHanh {

    static Scanner sc = new Scanner(System.in);
    

    public static void menuBaoTri3(){
        while(true){
            System.out.println("\n------------- Bảo Trì Phòng Thực Hành -------------");
            System.out.println("1: Thêm phòng thực hành.");
            System.out.println("2: Sửa phòng thực hành .");
            System.out.println("3: Xóa phòng thực hành.");
            System.out.println("4: Xem phòng thực hành.");
            System.out.println("5: Trở lại.");
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
                    System.out.println("Thêm phòng thực hành");
                    themPhongThucHanh();
                    break;
                case 2:
                    System.out.println("Sửa phòng thực hành");
                    suaThongTinPhongMay();
                    break;
                case 3:
                    System.out.println("Xóa phòng thực hành");
                    xoaPhongThucHanh();
                    break;
                case 4:
                    System.out.println("Xem phòng thực hành");
                    hienThiPhongThucHanh();
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

    private static void themPhongThucHanh() {
		System.out.println("\n\t\t.....Thêm mới phòng thực hành.....");
		String tenPhong;
		do{
                    System.out.print("--->Nhập tên phòng thực hành:");
                    tenPhong = sc.nextLine();
                    if(tenPhong.length() == 0) {
			System.out.println("Thong tin không được để trống ,mời nhập lại....!!!!");
                    }
		}
		while(tenPhong.length() == 0);
                int index = indexOfmaPhong(tenPhong);
		if(index != -1) {
			System.out.println("Mã phòng này đã tồn tại....!!!!");
			return ;
		}
		
		
                int soLuongMay;
		do {
			System.out.print("--->Nhập số lượng máy:"); soLuongMay = Integer.parseInt(sc.nextLine());
			
			if(soLuongMay <= 0) {
				System.out.println("Số lượng máy không được nhỏ hơn 0,mời nhập lại....!!!!");
			}
		}while(soLuongMay <= 0);
              
		String cauHinhMay;
		do {
			System.out.print("--->Nhập cấu hình của phòng:"); cauHinhMay = sc.nextLine();
			
			if(cauHinhMay.length() == 0) {
				System.out.println("Cấu hình máy không được để trống, mời nhập lại....!!!!");
			}
		}while(cauHinhMay.length()==0);
		
		
		String ghiChu;
		do {
			System.out.print("--->Nhập ghi chú:");ghiChu = sc.nextLine();
				 
			if(ghiChu.length() == 0) 
				System.out.println("Ghi chú không được để trống,mời nhập lại....!!!");
		}while(ghiChu.length() == 0);
			
	
		String trangThai;
			do {
				
				System.out.print("--->Nhập trạng thái:");trangThai = sc.nextLine();
			if(trangThai.length() == 0) 
				
				System.out.println("Trạng thái không được để trống,mời nhập lại....!!!!");
			}
			while(trangThai.length() == 0);
		
		
			
		PhongThucHanh pth = new PhongThucHanh(tenPhong, soLuongMay, cauHinhMay,ghiChu, trangThai,new KhuNha(1,"A1",16,""));
		list.add(pth);
        try {
            data.LuuFile(linkPTH, list);
        } catch (Exception ex) {
            Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
		System.out.println("Đã thêm phòng thực hành mới thành công....!!!!");	
	}
    
    private static void suaThongTinPhongMay() {
		System.out.println("\n\t\t....Sửa thông tin phòng máy....");
		String maPhong;
		do {
			System.out.print("--->Nhập mã phòng cần sửa:");
                        maPhong = sc.nextLine();
			
			if(maPhong.length()==0) {
				System.out.println("Mã phòng không được để trống,mời nhập lại....!!!");
			}
		}while(maPhong.length() ==0);
		
		
		int index = indexOfmaPhong(maPhong);
		if(index == -1) {
			System.out.println("Không tồn tại phòng trong danh sách....!!!!");
			return;
		}
		int chon;
		do {
			System.out.println("\n\t\t~~Chọn thông tin cần sửa~~");
			System.out.println("\t1: Sửa tên phòng");
			System.out.println("\t2: Sửa số lượng máy");
			System.out.println("\t3: Sửa cấu hình");
			System.out.println("\t4: Sửa ghi chú");
			System.out.println("\t5: Sửa trạng thái");
                        System.out.println("\t6: Quay lại");
			System.out.print("--->Nhập lựa chọn của bạn:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				String tenPhong;
				do {
					System.out.print("--->Nhập mã phòng mới:");
                                        tenPhong = sc.nextLine();
					 
				if(tenPhong.length() == 0)
					System.out.println("Tên phòng không được để trống ,mời nhập lại....!!!! ");
				}while(tenPhong.length() == 0);
				
				list.get(index).setTenPhong(tenPhong);
                                 try {
                                    data.LuuFile(linkPTH, list);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                                }
				System.out.println("Sửa tên phòng thành công....!!!!");
				break;
                        
                        case 2:
                            int soLuongMay;
				do {
					System.out.print("--->Nhập số lượng máy mới:");
                                        soLuongMay = Integer.parseInt(sc.nextLine());
					 
				if(soLuongMay <= 0)
					System.out.println("Số máy phải lớn hơn 0 ,mời nhập lại....!!!! ");
				}while(soLuongMay <= 0);
				
				list.get(index).setSoLuongMay(soLuongMay);
                                 try {
                                    data.LuuFile(linkPTH, list);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                                }
				System.out.println("Sửa số lượng máy thành công....!!!!");
				break;
                        case 3:
                            String cauHinh;
				do {
					System.out.print("--->Nhập cấu hình mới:");
                                        cauHinh = sc.nextLine();
					 
				if(cauHinh.length() == 0)
					System.out.println("Cấu hình không được để trống ,mời nhập lại....!!!! ");
				}while(cauHinh.length() == 0);
				
				list.get(index).setCauHinh(cauHinh);
                                try {
                                    data.LuuFile(linkPTH, list);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                                }
				System.out.println("Sửa cấu hình thành công....!!!!");
				break;
                        case 4:
                            String ghiChu;
				do {
					System.out.print("--->Nhập ghi chú mới:");
                                        ghiChu = sc.nextLine();
					 
				if(ghiChu.length() == 0)
					System.out.println("Ghi chú không được để trống ,mời nhập lại....!!!! ");
				}while(ghiChu.length() == 0);
				
				list.get(index).setGhiChu(ghiChu);
                                 try {
                                    data.LuuFile(linkPTH, list);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                                }
				System.out.println("Sửa ghi chú thành công....!!!!");
				break;
                        case 5:
                            String trangThai;
				do {
					System.out.print("--->Nhập trạng thái mới:");
                                        trangThai = sc.nextLine();
					 
				if(trangThai.length() == 0)
					System.out.println("Trạng thái không được để trống ,mời nhập lại....!!!! ");
				}while(trangThai.length() == 0);
				
				list.get(index).setTrangThai(trangThai);
                                 try {
                                    data.LuuFile(linkPTH, list);
                                } catch (Exception ex) {
                                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                                }
				System.out.println("Sửa trạng thái phòng thành công....!!!!");
				break;
                        case 6:
                            menuBaoTri3();
                            break;
			case 0:return ;
			default:System.out.println("Lựa chọn không hợp lệ....!!!!");
			}
		}
		while(true);
	}
    private static void xoaPhongThucHanh() {
		System.out.println("\n\t\t......Xóa phòng thực hành.....");
		String maPhong;
		do {
			System.out.print("--->Nhập mã phòng cần xóa:");
                        maPhong = sc.nextLine();
			
			if(maPhong.length()==0) {
				System.out.println("Mã phòng không được để trống ,mời nhập lại....!!!!");
			}
		}while(maPhong.length() ==0);
		int index = indexOfmaPhong(maPhong);
		if(index == -1) {
			System.out.println("Phòng này không có trong danh sách....!!!!");
			return;
		}
		list.remove(index);
                 try {
                    data.LuuFile(linkPTH, list);
                } catch (Exception ex) {
                    Logger.getLogger(BaoTriPhongThucHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
		System.out.println("Xóa phòng thực hành thành công....!!!!");
	}
	
    public static void hienThiPhongThucHanh() {
		System.out.println("\n\t\t\tHiển thị phòng thực hành");
		System.out.println();
		System.out.printf("   %-10s %-20s %-10s %-12s %-30s %-10s %n","Mã phòng","Tên Phòng","Số Máy","Cấu hình","Ghi chú","Trạng Thái");
		for( PhongThucHanh pth : list) {
			pth.hienThi();
		}
	}
	
    public static int indexOfmaPhong(String maPhong) {
		for(int i = 0 ;i < list.size() ; i ++) {
			if(list.get(i).getMaPhong().compareToIgnoreCase(maPhong) == 0) {
				return i;
			}	
		}
		return -1;
	}
}
