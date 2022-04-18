package ontap;

import java.io.Serializable;

public class ThueBaoTronGoi extends ThueBao implements Serializable{
    private final double MB = -1;
    private static double CUOC = 350000;
    
    public void xuat(int stt){
        super.xuat(stt);
        System.out.printf("%15.1f %20.1f\n", MB, CUOC);
    }

    public static double getCUOC() {
        return CUOC;
    }
    
    
}
