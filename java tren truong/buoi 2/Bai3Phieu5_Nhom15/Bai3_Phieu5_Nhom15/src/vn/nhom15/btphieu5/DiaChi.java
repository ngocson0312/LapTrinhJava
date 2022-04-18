package vn.nhom15.btphieu5;

public class DiaChi {
	String Duong, Quan, ThanhPho;
	Long MaVung;

    public String ToString(){
        return "Duong " + this.Duong + ", Quan " + this.Quan + ", ThanhPho " + this.ThanhPho + ", MaVung " + this.MaVung;
    }

    public DiaChi(String Duong, String Quan, String ThanhPho, Long MaVung) {
        this.Duong = Duong;
        this.Quan = Quan;
        this.ThanhPho = ThanhPho;
        this.MaVung = MaVung;
    }

    public DiaChi() {
    }
}
