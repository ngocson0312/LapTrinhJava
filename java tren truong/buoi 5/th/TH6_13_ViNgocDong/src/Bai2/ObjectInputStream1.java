package Bai2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *
 * @author VND
 */


public class ObjectInputStream1 {
    public static void main(String[] args) throws IOException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\Data.txt"));
            // read student
            Student student = (Student) ois.readObject();
            // show student
            System.out.println(student.toString());
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        finally {
            ois.close();
        }
    }
}
