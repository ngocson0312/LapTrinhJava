package ts_pt;
//khai báo lớp

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyPhongThi {
    //khai báo các thuộc tính tổng thể quan trọng
    static String fileName = "d:/thiSinh.txt";
    private static DBEngine db = new DBEngine();
    
    private static ArrayList<PhongThi> DSPT = new ArrayList<PhongThi>();
    
    static Scanner sc = new Scanner(System.in);
    
    // Tự động đánh mã phong thi.
    private static int autoID = 0;
    
    //Xây dựng menu
    static void menu() throws Exception{
        while(true){
            System.out.println("*****QUẢN LÝ PHÒNG THI*****");
            System.out.println("\n================================");
            System.out.println("1. Phòng thi.");
            System.out.println("2. Thí sinh.");
            System.out.println("3. Lưu dữ liệu.");
            System.out.println("4. Đọc dữ liệu từ file có sẵn.");
            System.out.println("5. Thoát.");
            System.out.println("******************");
            System.out.print("*Chọn lựa của bạn?: ");
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1: childMenuOfPt(); break;
                case 2: childMenuOfTs(); break;
                case 3: //luuFile();
                    break;
                case 4: //docFile();
                    break;
                case 5: 
                    System.out.println("\n- Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! Tạm biệt.^^");
                    System.exit(0);
                default:
                    System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                    sc.nextLine();
            }
        }
    }
    
    static void childMenuOfPt() throws Exception{
        while(true){
            
            System.out.println("\n*****PHÒNG THI*****");
            System.out.println("\n================================");
            System.out.println("1. Thêm phòng thi.");
            System.out.println("2. Sửa thông tin phòng thi.");
            System.out.println("3. Xóa phòng thi.");
            System.out.println("4. Xem danh sách phòng thi.");
            System.out.println("5. Trở về.");
            System.out.println("******************");
            System.out.print("*Chọn lựa của bạn?: ");
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1: themPT(); break;
                case 2: suaPT(); break;
                case 3: xoaPT(); break;
                case 4: xemDSPT(); break;
                case 5: return;
                default:
                    System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                    sc.nextLine();
            }
        }
    }
    
    static void childMenuOfTs() throws Exception{
        while(true){
            System.out.println("\n*****THÍ SINH*****");
            System.out.println("\n================================");
            System.out.println("1. Thêm Thí sinh mới");
            System.out.println("2. Hiệu chỉnh thông tin thí sinh");
            System.out.println("3. Xóa thí sinh khỏi phòng thi");
            System.out.println("4. Lấy thông tin Thí sinh khi biết số báo danh.");
            System.out.println("5. Lấy thông tin Thí sinh khi biết số thứ tự.");
            System.out.println("6. In danh sách thí sinh");
            System.out.println("7. Trở về.");
            System.out.println("******************");
            System.out.print("*Chọn lựa của bạn?: ");
            
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1: themTS(); break;
                case 2: suaTTTS(); break;
                case 3: xoaTS(); break;
//                case 4: layTTSBD(); break;
//                case 5: layTTSTT(); break;
                case 6: inDSTS(); break;
                case 7: return;
                default:
                    System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                    sc.nextLine();
            }
        }
    }
    
    
    //thêm thí sinh vào phòng thi
    static void themTS() {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cần thêm sinh viên: ");
        String maPT = sc.nextLine();

        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách!");
            sc.nextLine();
            return;
        }
        
        while(true){
            ThiSinh ts = new ThiSinh();
            ts.nhap();
            if(DSPT.get(index).themThiSinh(ts)){
                System.out.println("\n- Thêm thí sinh vào phòng thi " + maPT + " thành công.");
                sc.nextLine();
            }
            else{
                System.out.println("\n- Thêm thí sinh vào phòng thi " + maPT + " thất bại.");
                sc.nextLine();
            }
            
            int chon = 0;
            
            while(chon != 1 && chon != 2){
                System.out.println("\n- Bạn còn muốn nhập thêm sinh viên vào phòng thi không?");
                System.out.println("1. Nhập tiếp.");
                System.out.println("2. Thoát.");
                System.out.print("*Chọn lựa của bạn?: ");

                chon = Integer.parseInt(sc.nextLine());


                switch(chon){
                    case 1: System.out.println("\n- Mời bạn nhập thông tin thí sinh tiếp theo:"); break;
                    case 2: return;
                    default:
                        System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                }
            }
        }
    }
    //xóa thí sinh khỏi phòng thi.
    static void xoaTS() {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cần xóa sinh viên: ");
        String maPT = sc.nextLine();

        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách!");
            sc.nextLine();
            return;
        }
        
   
        while(true){
            System.out.print("\tNhập số báo danh cần xóa: ");
            String soBD = sc.nextLine();
         
            if(DSPT.get(index).xoaThisinh(soBD)){
                System.out.println("\n- Xóa thí sinh " + soBD + " khỏi phòng thi " + maPT + " thành công.");
                sc.nextLine();
            }
            else{
                System.out.println("\n- Xóa thí sinh " + soBD + " khỏi phòng thi " + maPT + " thất bại.");
                sc.nextLine();
            }
            
            int chon = 0;
            
            while(chon != 1 && chon != 2){
                System.out.println("\n- Bạn còn muốn xóa thêm sinh viên nào nữa khỏi phòng thi này không?");
                System.out.println("1. Xóa tiếp.");
                System.out.println("2. Thoát.");
                System.out.print("*Chọn lựa của bạn?: ");

                chon = Integer.parseInt(sc.nextLine());


                switch(chon){
                    case 1: System.out.println("\n- Mời bạn xóa tiếp!"); break;
                    case 2: return;
                    default:
                        System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                }
            }
        }
    }
    //sửa thông tin thí sinh
    static void suaTTTS() throws Exception {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cần xóa sinh viên: ");
        String maPT = sc.nextLine();

        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách!");
            sc.nextLine();
            return;
        }
        
   
        while(true){
            System.out.print("\tNhập số báo danh cần sửa thông tin: ");
            String soBD = sc.nextLine();
         
            if(DSPT.get(index).suaThongtinTS(soBD)){
                System.out.println("\n- Sửa thông tin thí sinh " + soBD + " trong phòng thi " + maPT + " thành công.");
                sc.nextLine();
            }
            else{
                System.out.println("\n- Sửa thông tin thí sinh " + soBD + " trong phòng thi " + maPT + " thất bại.");
                sc.nextLine();
            }
            
            int chon = 0;
            
            while(chon != 1 && chon != 2){
                System.out.println("\n- Bạn còn muốn sửa thêm sinh viên nào nữa không?");
                System.out.println("1. Còn sửa tiếp.");
                System.out.println("2. Thoát.");
                System.out.print("*Chọn lựa của bạn?: ");

                chon = Integer.parseInt(sc.nextLine());


                switch(chon){
                    case 1: System.out.println("\n- Mời bạn tiếp tục sửa!"); break;
                    case 2: return;
                    default:
                        System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                }
            }
        }
    }
//    //lấy thông tin thí sinh qua chỉ số
//    static void layTTTS_chiso() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhập số thứ tự cần lấy thông tin:");
//        int stt = input.nextInt();
//        ThiSinh ts = phongthi.layThongtinTS(stt);
//        if(ts == null)
//            System.out.println("không có");
//        else
//            System.out.println(ts);
//    }
//    //lấy thông tin thí sinh qua số báo danh
//    static void layTTTS_soBD() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("\tNhập số báo danh cần lấy thông tin:");
//        String soBD = input.nextLine();
//        ThiSinh ts = phongthi.layThongtinTS(soBD);
//        System.out.println("~~~~~~~~~~Kết quả~~~~~~~~~~~~~~");
//        if(ts == null)
//            System.out.println("Không có");
//        else
//            System.out.println(ts);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//    }
    //in danh sách thí sinh
    
    
    static void inDSTS() {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cần xóa sinh viên: ");
        String maPT = sc.nextLine();

        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách!");
            sc.nextLine();
            return;
        }
        
        System.out.println("==========DANH SÁCH THÍ SINH PHÒNG "+ maPT +"=========");
        System.out.println("Số BD \tHọ tên \tĐiểm toán \tĐiểm Lý \tĐiểm Hóa");
        for (int i = 0; i < DSPT.get(index).soThisinh(); i++){
            ThiSinh ts = DSPT.get(index).layThongtinTS(i);
            System.out.println(ts);
        }
        System.out.println("=====================================");
    }
//    //luu phòng thi vào file
//    public static void luuFile(){
//        try {
//            db.LuuFile(fileName, phongthi);
//            System.out.println("Lưu file thành công");
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }
//    }
//    //đọc file lưu trở lại phòng thi
//    public static void docFile(){
//        try {
//            phongthi=(PhongThi) db.docFile(fileName);
//        } catch (Exception ex) {
//            System.out.println("không đọc được file");
//        }
//    }
    
    // Các chức năng của menu chức năng phòng thi
    private static void themPT() throws Exception {
        PhongThi newPT = new PhongThi(autoID);
        
        System.out.print("- Nhập địa chỉ phòng thi: ");
        newPT.setDiachiPT(sc.nextLine());
        System.out.print("- Nhập địa số lượng thí sinh dự thi: ");
        newPT.setLuongTS(Integer.parseInt(sc.nextLine()));
        
        DSPT.add(newPT);
        
        System.out.println("\n- Thêm 1 phòng thi mới thành công!");
        sc.nextLine();
        // tự động tăng id sau khi thêm phòng thi thành công
        autoID++;
    }

    private static void suaPT() throws Exception {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cấn sửa thông tin: ");
        String maPT = sc.nextLine();
        
        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách!");
            sc.nextLine();
            return;
        }
        
        // Thuận tiện việc mở rộng hệ thống sau này
         while(true){
            System.out.println("*****Sửa thông tin phòng thi*****");
            System.out.println("\n================================");
            System.out.println("1. Sửa địa chỉ phòng thi.");
            System.out.println("2. Sửa số lượng thí sinh tham gia thi.");
            System.out.println("3. Trở về.");
            System.out.println("******************");
            System.out.print("*Chọn lựa của bạn?: ");
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1: 
                    System.out.print("- Nhập địa chỉ mới phòng thi: ");
                    DSPT.get(index).setDiachiPT(sc.nextLine());
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();
                    break;
                case 2: 
                    System.out.print("- Nhập số lượng thí sinh mới tham gia thi: ");
                    DSPT.get(index).setLuongTS(Integer.parseInt(sc.nextLine()));
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();  
                    break;
                case 3: return;
                default:
                    System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                    sc.nextLine();
            }
         }
    }

    private static void xoaPT() {
        //Nên tích hợp thêm chức năng xem DS phòng thi tại đây.
        
        System.out.print("- Nhập mã phòng thi cần xóa: ");
        String maPT = sc.nextLine();
        
        int index = existPT(maPT);
        if(index == -1){
            System.out.println("\n- Phòng thi này không tồn tại trong danh sách! Việc xóa kêt thúc.");
            sc.nextLine();
            return;
        }
        
        System.out.println("\n- Xóa 1 phòng thi có mã " + maPT + " thành công!");
        sc.nextLine();
    }

    private static void xemDSPT() {
        int stt = 0;
        PhongThi.titleOfPT();
        for(PhongThi i : DSPT)
            i.in(++stt);
        
        System.out.println("\n- Danh sách toàn bộ các phòng thi!");
        sc.nextLine();
    }
    
    //Kiểm tra tồn tại của phòng thi
    private static int existPT(String maPT){
        for(PhongThi i : DSPT)
            if(i.getMsPT().equals(maPT))
                return DSPT.indexOf(i);
        return -1;
    }
    
    
    // hàm main
    public static void main(String[] args) {
        
        while(true){
            try{
                menu();
            } catch(Exception x){
                System.err.println(x);
                sc.nextLine();
            }
        }
        //==================================
        
        //==================================
    }
}
//end of class 