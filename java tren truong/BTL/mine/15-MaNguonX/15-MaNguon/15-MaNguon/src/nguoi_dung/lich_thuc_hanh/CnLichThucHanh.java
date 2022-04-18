package nguoi_dung.lich_thuc_hanh;

import java.util.Scanner;

/**
 *
 * @author Duc_Cuong
 */
public class CnLichThucHanh {
  
    public static void menuLichThucHanh(){
        Scanner scan = new Scanner(System.in);
         while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- MENU LỊCH THỰC HÀNH -------------");
            System.out.println("1: Đăng ký lịch thực hành.");
            System.out.println("2: Xem lịch thực hành.");
            System.out.println("3: Thay đổi lịch thực hành.");
            System.out.println("4: Trở về.");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon;
            try{
                chon = Integer.parseInt(scan.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    DangKyLichThucHanh.menuDangKyLichThucHanh();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
}
