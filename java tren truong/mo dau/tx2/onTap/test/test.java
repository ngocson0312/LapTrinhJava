
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VND
 */
public class test {
    public static void main(String[] args) {
        ArrayList<String> x = new ArrayList<>();
        x.add("b");
        x.add("c");
        x.add("d");
        x.add("a");
        x.add("z");
        x.add("k");
        
        Collections.sort(x, new Comparator<String>() {
            @Override
            public int compare(String o2, String o1) {
                return o1.compareTo(o2);
            }
        });
        
        for(String i : x)
            System.out.println(i);
    }
}
