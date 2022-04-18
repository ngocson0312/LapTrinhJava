package de1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

//Đề 1

public class Demo {
    static public Scanner sc = new Scanner(System.in);
    static LinkedHashSet<HinhVuong> ds = new LinkedHashSet<>();
    static DBEngine db = new DBEngine();
    
    public static void main(String[] args) throws Exception {
        
        //autoCreate();
        menu();
    }
    
    public static void menu() throws Exception{
        while(true){
            System.out.println("\n--------- Demo -----------");
            System.out.println("1. Thêm hình thủ công.");
            System.out.println("2. Tự động tạo 9 hình.");
            System.out.println("3. In danh sách hình.");
            System.out.println("4. Sửa thông tin hình.");
            System.out.println("5. Sắp xếp và in lại danh sách hình theo mã hình.");
            System.out.println("6. Lưu dữ liệu.");
            System.out.println("7. Đọc dữ liệu có sẵn.");
            System.out.println("8. Thoát.");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon = 0;
            
            try{
                chon = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                chon = 0;
            }
            
            switch(chon){
                case 1: addH(); break;
                case 2: autoCreate(); break;
                case 3: xuat(); break;
                case 4: suaH(); break;
                case 5: sapXep(); break;
                case 6: saveData(); break;
                case 7: readData(); break;
                case 8: 
                    System.out.println("=> Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! Bye^^");
                    System.exit(0);
                default:
                    System.out.println("=> Lựa chọn của bạn chưa đúng, hãy thử lại!");
                    sc.nextLine();
            }
        }
    }
        
        
    private static void addH(){
        System.out.println("\n- Nhập thông tin cho hình:");
        HinhVuong newH = new HinhVuong("", "", random());
        if(newH.nhapDL()){
            ds.add(newH);
            System.out.println("=> Thêm mới hình thành công! Độ dài cạnh đã được hệ thống random.");
            sc.nextLine();
        }
    }
    
    
    
    static int random() {
        Random rand = new Random();
        int x = rand.nextInt(100)+20;
        return x;
    }
    
    static void autoCreate(){
        for(int i = 0; i < 9; i++){
            ds.add(new HinhVuong( String.valueOf(i), "Hinh " + i, random()));
        }
    }
    
    static void suaH(){
        System.out.print("- Nhập mã hình bất kỳ: ");
        String maH = sc.nextLine();

        Iterator<HinhVuong> iterator = ds.iterator();
        
        while (iterator.hasNext()) {
            if(iterator.next().getMaHinh().equals(maH)){
                iterator.remove();
                HinhVuong x = new HinhVuong("", "", random());
                x.nhapDL();
                ds.add(x);
                
                return;
            }
        }
        
        
            System.out.print("- Mã hình không tồn tại.");
            sc.nextLine();
        
    }
    
    
 
    
    static void title(){
        System.out.println("Ma Hinh  Ten Hinh  Do dai canh  Chu Vi  Dien Tich");
    }
    
    static void xuat(){
        title();
        Iterator<HinhVuong> iterator = ds.iterator();
        while (iterator.hasNext()) {
            System.out.println((HinhVuong) iterator.next());
        }
    }
    
    static void sapXep(){
          
    }
    
    private static void saveData() throws Exception {
        String link = "db/Data.txt";
        
        db.LuuFile(link, ds);
        System.out.println("=> Lưu dữ liệu thành công!");
    }

    private static void readData() throws Exception {
        String link = "db/Data.txt";
        
        ds = (LinkedHashSet<HinhVuong>) db.docFile(link);
        
        System.out.println("=> Đọc dữ liệu thành công!");
    }
}
