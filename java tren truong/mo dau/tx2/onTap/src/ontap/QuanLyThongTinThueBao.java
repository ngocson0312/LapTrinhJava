package ontap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuanLyThongTinThueBao {
    
    static public Scanner sc = new Scanner(System.in);
    
    static ArrayList<ThueBao> DSTB = new ArrayList<>();
    
    static DBEngine db = new DBEngine();
    
    public static void main(String[] args) {
        while(true){
            try {
                menu();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }
    
    private static void menu() throws Exception{
        while(true){
            System.out.println("\n-------- CHƯƠNG TRÌNH QUẢN LÝ THUÊ BAO ---------");
            System.out.println("1: Nhập thêm thuê bao.");
            System.out.println("2: Xuất danh sách thuê bao.");
            System.out.println("3: (Các) Thuê bao có tiền cước phải trả lớn nhất.");
            System.out.println("4: Xuất dữ liệu ra file.");
            System.out.println("5: Đọc dữ liệu có sẵn.");
            System.out.println("6: kết thúc chương trình.");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon = 0;
            
            try{
                chon = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                chon = 0;
            }
            
            switch(chon){
                case 1: addTB(); break;
                case 2: inDSTB(); break;
                case 3: maxCuoc(); break;
                case 4: saveData(); break;
                case 5: readData(); break;
                case 6: 
                    System.out.println("=> Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! Bye^^");
                    System.exit(0);
                default:
                    System.out.println("=> Lựa chọn của bạn chưa đúng, hãy thử lại!");
                    sc.nextLine();
            }
        }
    }

    private static void addTB() throws Exception {
        while(true){
            System.out.println("\n-------- Thêm thuê bao ---------");
            System.out.println("1: Thêm thuê bao trọn gói.");
            System.out.println("2: Thêm thuê bao theo dung lượng.");
            System.out.println("3: Trở về");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon = 0;
            
            try{
                chon = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                chon = 0;
            }
            
            switch(chon){
                case 1:
                    System.out.println("\n- Nhập thông tin cho thuê bao trọn gói:");
                    ThueBao newTB1 = new ThueBaoTronGoi();
                    newTB1.nhap();
                    
                    DSTB.add(newTB1);
                    
                    System.out.println("=> Thêm mới thuê bao trọn gói thành công!");
                    sc.nextLine();
                    break;
                case 2: 
                    System.out.println("\n- Nhập thông tin cho thuê bao theo dung lượng:");
                    ThueBao newTB2 = new ThueBaoTheoDungLuong();
                    newTB2.nhap();
                    
                    DSTB.add(newTB2);
                    
                    System.out.println("=> Thêm mới thuê bao theo dung lượng thành công!");
                    sc.nextLine();
                    break;
                case 3: return;
                default:
                    System.out.println("=> Lựa chọn của bạn chưa đúng, hãy thử lại!");
                    sc.nextLine();
            }
        }
    }

    private static void inDSTB() {
        while(true){
            System.out.println("\n-------- Xuất danh sách thuê bao ---------");
            System.out.println("1: DS thuê bao trọn gói.");
            System.out.println("2: DS thuê bao theo dung lượng.");
            System.out.println("3: DS toàn bộ thuê bao.");
            System.out.println("4: Trở về");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon = 0;
            
            try{
                chon = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                chon = 0;
            }
            
            switch(chon){
                case 1:
                    System.out.println("\n- DS các thuê bao trọn gói:");
                    xuat(1);
                    
                    sc.nextLine();
                    break;
                case 2: 
                    System.out.println("\n- DS các thuê bao theo dung lượng:");
                    xuat(2);
                    
                    sc.nextLine();
                    break;
                case 3: 
                    System.out.println("\n- DS toàn bộ các thuê bao:");
                    xuat(3);
                    
                    sc.nextLine();
                    break;
                case 4: return;
                default:
                    System.out.println("=> Lựa chọn của bạn chưa đúng, hãy thử lại!");
                    sc.nextLine();
            }
        }
    }

    private static void maxCuoc() {
        double max;
        
    }

    private static void saveData() throws Exception {
        String link = "E:/Data.txt";
        for(ThueBao tb : DSTB)
            db.LuuFile(link, DSTB);
        
        System.out.println("=> Lưu dữ liệu thành công!");
        sc.nextLine();
    }

    private static void readData() throws Exception {
        String link = "E:/Data.txt";
        
        for(int i = 0; i < 5; i++){
            DSTB.add((ThueBao) db.docFile(link));
            
        }
        
        System.out.println("=> Đọc dữ liệu thành công!");
        sc.nextLine();
    }
   
    private static void xuat(int i){
        ThueBao.title();
        int stt = 0;
        if(i == 1){
            for(ThueBao tb : DSTB)
                if(tb instanceof ThueBaoTronGoi)
                    tb.xuat(++stt);
        }
        else if(i == 2){
            for(ThueBao tb : DSTB)
                if(tb instanceof ThueBaoTheoDungLuong)
                    tb.xuat(++stt);
        }     
        else{
            for(ThueBao tb : DSTB)
                tb.xuat(++stt);
        }
    }
    
}
