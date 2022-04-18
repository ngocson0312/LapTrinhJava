/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class CongNhan extends CanBo{
    private String rank;

    @Override
    public void input(){
        super.input();
        System.out.print("\t+ Nhap cap bac: ");
        rank = sc.nextLine();
    }
    
    static void title(){
        CanBo.title();
        System.out.printf("%-10s\n",  "Cap bac");
    }
    
    @Override
    public void output(int i){
        super.output(i);
        System.out.printf("%-10s\n", rank);
    }

}
