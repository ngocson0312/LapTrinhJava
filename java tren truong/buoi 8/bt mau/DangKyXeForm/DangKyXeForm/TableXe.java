/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DangKyXeForm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HUY HIEN
 */
public class TableXe extends AbstractTableModel{
    
    private String Name[] = {"chu xe","loai xe","dung tich" ,"tri gia","thue phai nop"};
    
    private Class classess[]  = {String.class,String.class,Integer.class,Float.class,Float.class};
    
    ArrayList<Xe> dsXe = new ArrayList<Xe>();

    public TableXe(ArrayList<Xe> xe) {
        dsXe = xe;
    }

    @Override
    public int getRowCount() {
        return dsXe.size();
    }

    @Override
    public int getColumnCount() {
        return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsXe.get(rowIndex).getTenChuXe();
            
            case 1: return dsXe.get(rowIndex).getLoaiXe();
            
            case 2: return dsXe.get(rowIndex).getDTxiLanh();
             
            case 3: return dsXe.get(rowIndex).getTriGia();
            
            case 4: return dsXe.get(rowIndex).getThuephainop();
            
            default : return null;
        }
    }
    
    public Class getColumnClass(int columnIndex){
        return classess[columnIndex];
    }
    
    public String getColumnName(int column){
        return Name[column];
    }
    
}
