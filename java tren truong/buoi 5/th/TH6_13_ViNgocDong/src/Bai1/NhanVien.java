/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class NhanVien extends CanBo{
    private String mission;

    @Override
    public void input(){
        super.input();
        System.out.print("\t+ Nhap cong viec: ");
        mission = sc.nextLine();
    }
    
    static void title(){
        CanBo.title();
        System.out.printf("%-20s\n",  "Cong viec");
    }
    
    @Override
    public void output(int i){
        super.output(i);
        System.out.printf("%-20s\n", mission);
    }
}
