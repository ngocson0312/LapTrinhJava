package ControlCoBan;

public class SinhVien {
    private int ma;
    private String name;

    public SinhVien(int ma, String name) {
        this.ma = ma;
        this.name = name;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }        
}
