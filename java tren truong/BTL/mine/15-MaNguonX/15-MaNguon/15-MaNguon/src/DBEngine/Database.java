package DBEngine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author VND
 */

public class Database{
    public void LuuFile(String link, Object obj) throws Exception{
        //Tạo luồng ghi file
        FileOutputStream fs = new FileOutputStream(link);
        //Tạo luồng để serial đối tượng
        ObjectOutputStream os = new ObjectOutputStream(fs);
        //chuyển tải đối tượng tới đích (tập tin)
        os.writeObject(obj);
        //đóng luồng
        fs.close();
        os.close();
    }
    
    public Object docFile(String link) throws Exception{
        Object kq = null;
        //Tạo luồng đọc file đã được serial
        FileInputStream fi = new FileInputStream(link);
        //Tạo luồng để Deserialize đối tượng
        ObjectInputStream ois = new ObjectInputStream(fi);
        //Tiến hành khôi phục đối tượng
        kq = ois.readObject();
        //đóng luồng
        fi.close();
        ois.close();
        return kq;
    }
    
}
