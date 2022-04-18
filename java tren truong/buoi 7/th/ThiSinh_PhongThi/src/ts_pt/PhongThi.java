package ts_pt;
//Khai báo lớp và thuộc tính

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PhongThi implements Serializable {
    //các thuộc tính của đối tượng phòng thi
    private String msPT;
    private String diachiPT;
    private int luongTS;
    //đối tượng dùng chứa tập các thí sinh
    private ArrayList<ThiSinh> dsTS;
   // đinh nghĩa các phương thức khởi tạo

    public PhongThi(int autoID) {
        this.msPT = "PT" + autoID;
        dsTS = new ArrayList<>();
    }

    public PhongThi() {
    }

    public String getMsPT() {
        return msPT;
    }

    
    
    
    public String getDiachiPT() {
        return diachiPT;
    }

    public void setDiachiPT(String diachiPT) throws Exception {
        if(diachiPT.equals(""))
            throw new Exception("*Error: Địa chỉ không được để trống!");
        this.diachiPT = diachiPT;
    }

    public int getLuongTS() {
        return luongTS;
    }

    public void setLuongTS(int luongTS) throws Exception {
        if(String.valueOf(luongTS).trim().equals(""))
            throw new Exception("*Error: Lượng thí sinh không được để trống!");
        
        if(luongTS < 1)
            throw new Exception("*Error: Lượng thí sinh không được nhỏ hơn 1!");
        
        this.luongTS = luongTS;
    }

    
    
   //get/set danh sách thí sinh
    public ArrayList<ThiSinh> getDsTS() {
        return dsTS;
    }
    public void setDsTS(ArrayList<ThiSinh> dsTS) {
        this.dsTS = dsTS;
    }
    /**
    * Thêm 1 thí sinh vào phòng thi có kiểm tra trùng mã
    * @param ts: thí sinh thêm vào
    * @return true nếu việc thêm thành công
    */
    public boolean themThiSinh(ThiSinh ts) {
    //Nếu thí sinh đã tồn tại thì không cho thêm
        if(dsTS.contains(ts)) return false;
        if(dsTS.size()+1>luongTS)//nếu đã đủ lượng thí sinh
        {
            System.out.println("đã đủ số lượng thí sinh trong phòng.");
            return false;
        }
        else{
            dsTS.add(ts);
            return true;
        }
    }
    /* Xóa 1 thí sinh khỏi phòng thi
    * @param soBD là số báo danh của thí sinh cần xóa
    * @return trả về true nếu xóa thành công
    */
    public boolean xoaThisinh(String soBD) {
        ThiSinh ts=new ThiSinh(soBD);
        if(!dsTS.contains(ts)) return false;
        else{ 
            dsTS.remove(ts);
            return true;
        }
    }
    /**
    * Sửa thông tin thí sinh
    * @param soBD: số DB của thí sinh cần sử thông tin
    * Cho phép người dùng lựa chọn thông tin cần sửa của thí sinh
    * 
    */
    public boolean suaThongtinTS(String soBD) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        ThiSinh ts = layThongtinTS(soBD);
        if(!dsTS.contains(ts)){
            System.out.println("\n- SBD này không tồn tại trong phòng thi này.");
            return false;
        }
        
        while(true){
            System.out.println("*****Sửa thông tin thí sinh*****");
            System.out.println("\n================================");
            System.out.println("1. Sửa họ tên.");
            System.out.println("2. Sửa điểm toán.");
            System.out.println("3. Sửa điểm lý.");
            System.out.println("4. Sửa điểm hóa.");
            System.out.println("4. Trở về.");
            System.out.println("******************");
            System.out.print("*Chọn lựa của bạn?: ");
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1: 
                    System.out.print("- Nhập họ tên mới thí sinh: ");
                    dsTS.get(dsTS.indexOf(ts)).setHoTen(sc.nextLine());
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();
                case 2: 
                    System.out.print("- Nhập điểm toán mới cho thí sinh: ");
                    dsTS.get(dsTS.indexOf(ts)).setDiemToan(Float.parseFloat(sc.nextLine()));
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();   
                case 3: 
                    System.out.print("- Nhập điểm lý mới cho thí sinh: ");
                    dsTS.get(dsTS.indexOf(ts)).setDiemLy(Float.parseFloat(sc.nextLine()));
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();  
                case 4: 
                    System.out.print("- Nhập điểm hóa mới cho thí sinh: ");
                    dsTS.get(dsTS.indexOf(ts)).setDiemHoa(Float.parseFloat(sc.nextLine()));
                    
                    System.out.println("\n- Sửa thông tin thành công!");
                    sc.nextLine();  
                case 5: return true;
                default:
                    System.out.println("\n- Lựa chọn của bạn không đúng. Vui lòng thử lại!");
                    sc.nextLine();
            }
         }
    }
    /**
    * Lấy thông tin của 1 thí sinh khi biết số báo danh
    * @param soBD số báo danh của ts cần lấy thông tin
    * @return null nếu không lấy được
    */
    public ThiSinh layThongtinTS(String soBD) {
        ThiSinh ts=new ThiSinh(soBD);
        if(!dsTS.contains(ts))
            return null;
        ts=dsTS.get(dsTS.indexOf(ts));
            return ts;
    }
    /**
    * Lấy thông tin của 1 thí sinh khi biết
    * số thứ tự của ts đó trong danh sách
    * @param index :số thứ tự của ts
    * @return null nếu không thành công
    */
    public ThiSinh layThongtinTS(int index){
        if(index<0||index>dsTS.size())
            return null;
        return dsTS.get(index);
    }
    /**
    * Lấy số thí sinh thực sự đang có trong phòng thi
    * @return
    * 
    * */
    public int soThisinh() {
        return dsTS.size();
    }
    
    public void in(int stt){
        System.out.printf("%-5d %-15s %-30s %-25d %-30d\n", stt, this.msPT, this.diachiPT, soThisinh(), luongTS);
    }
    static void titleOfPT(){
        System.out.printf("%-5s %-15s %-30s %-25s %-30s\n", "STT", "Mã phòng thi", "Địa chỉ phòng thi", "Lượng thí sinh đang có", "Lượng thí tham gia thi tối đa");
    }
}//end of class phòng thi
