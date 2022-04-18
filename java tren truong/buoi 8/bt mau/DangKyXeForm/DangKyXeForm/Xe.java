/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DangKyXeForm;

/**
 *
 * @author HUY HIEN
 */
public class Xe {
    String tenChuXe,loaiXe;
    int  DTxiLanh;
    float triGia,thuephainop;
    
    public Xe(String tenChuXe, String loaiXe, int DTxiLanh, float triGia) {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.DTxiLanh = DTxiLanh;
        this.triGia = triGia;
        this.thuephainop = thuexe();
    }

    public Xe() {
    }

    public void setTenChuXe(String tenChuXe) {
        this.tenChuXe = tenChuXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public void setDTxiLanh(int DTxiLanh) {
        this.DTxiLanh = DTxiLanh;
    }

    public void setTriGia(float triGia) {
        this.triGia = triGia;
    }

    public String getTenChuXe() {
        return tenChuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setThuephainop(float thuephainop) {
        this.thuephainop = thuexe();
    }

    public int getDTxiLanh() {
        return DTxiLanh;
    }

    public float getTriGia() {
        return triGia;
    }

    public float getThuephainop() {
        return thuexe();
    }
    
    public float thuexe(){
        
        if(DTxiLanh<100){
            return (float) (triGia*0.01);
        }else if(DTxiLanh<200){
            return (float) (triGia*0.03);
        }else{
            return (float) (triGia*0.05);
        }
      
    }

    
    
    
    
    
}
