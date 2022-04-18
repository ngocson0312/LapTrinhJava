package de1;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DaGiac implements Serializable{
    protected String maHinh, tenHinh;
    protected ArrayList<Double> dsCanh = new ArrayList<>();

    protected abstract int tinhCV();
    protected abstract int tinhDT();
    protected abstract boolean nhapDL();

    @Override
    public String toString() {
        return maHinh + "\t" + tenHinh + "\t";
    }


    public void setMaHinh(String maHinh) throws Exception {
        if(maHinh.trim().equals(""))
            throw new Exception("Thông tin không được để trống!");
        this.maHinh = maHinh;
    }

    public void setTenHinh(String tenHinh) throws Exception {
        if(maHinh.trim().equals(""))
            throw new Exception("Thông tin không được để trống!");
        this.tenHinh = tenHinh;
    }

    public DaGiac(String maHinh, String tenHinh) {
        this.maHinh = maHinh;
        this.tenHinh = tenHinh;
    }

    public String getMaHinh() {
        return maHinh;
    }

    
}
