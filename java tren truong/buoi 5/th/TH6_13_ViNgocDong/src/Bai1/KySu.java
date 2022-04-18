/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

/**
 *
 * @author VND
 */
public class KySu extends CanBo{
    private String field;

    @Override
    public void input(){
        super.input();
        System.out.print("\t+ Nhap nghanh dao tao: ");
        field = sc.nextLine();
    }
    
    static void title(){
        CanBo.title();
        System.out.printf("%-20s\n",  "Nganh dao tao");
    }
    
    @Override
    public void output(int i){
        super.output(i);
        System.out.printf("%-20s\n", field);
    }
}
