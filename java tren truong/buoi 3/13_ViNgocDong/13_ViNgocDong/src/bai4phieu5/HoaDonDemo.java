package bai4phieu5;

/**
 *
 * @author VND
 */
public class HoaDonDemo {
    static HoaDon x = new HoaDon();
    
    public static void main(String[] args) {
        x.input();
        x.output();
        System.out.println("\n- Danh sach hang sau khi sap xep theo yeu cau: ");
        x.sapxep();
        x.output();
    }
}
