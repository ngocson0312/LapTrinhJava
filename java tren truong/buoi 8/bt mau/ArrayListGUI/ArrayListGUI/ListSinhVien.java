package ArrayListGUI;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListSinhVien implements Serializable {

    ArrayList<SinhVien> dssv = new ArrayList<>();

    public boolean checkID(String id, int index) {
        int cout = 0;
        for (SinhVien sv : dssv) {
            if (sv.getMaSV().equalsIgnoreCase(id)) {
                cout++;
            }
            if (sv.getMaSV().equalsIgnoreCase(id)) {
                if (dssv.get(index).getMaSV().equalsIgnoreCase(id)) {
                    cout--;
                }
            }
        }
        if (cout >= 1) {
            return false;
        }
        return true;
    }

    public String[] ThongKeSV(String[] listLop) {
        int k0 = 0;
        int k1 = 0;
        int k2 = 0;
        int total = dssv.size();
        String[] sum = {"", "", "", ""};
        for (SinhVien sv : dssv) {
            if (sv.getLop().equalsIgnoreCase(listLop[0])) {
                k0++;
            } else {
            }
            if (sv.getLop().equalsIgnoreCase(listLop[1])) {
                k1++;
            }
            if (sv.getLop().equalsIgnoreCase(listLop[2])) {
                k2++;
            }
        }
        sum[0] = "" + k0;
        sum[1] = "" + k1;
        sum[2] = "" + k2;
        sum[3] = "" + total;
        return sum;
    }

    public boolean ThemSV(SinhVien sv) {
        try {
            if (dssv.contains(sv)) {
                return false;
            } else {
                dssv.add(sv);
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void inDS(DefaultTableModel dtm) {
        try {
            dssv.stream().forEach((sv) -> {
                dtm.addRow(new Object[]{sv.getLop(), sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh(), sv.getDiaChi()});
            });
        } catch (Exception ex) {
            System.out.println("loi" + ex);
        }
    }

    public void inDSTheoLop(DefaultTableModel dtm, String tenLop) {
        try {
            for (SinhVien sv : dssv) {
                if (sv.getLop().equalsIgnoreCase(tenLop)) {
                    dtm.addRow(new Object[]{sv.getLop(), sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh(), sv.getDiaChi()});
                }
                if (tenLop.equalsIgnoreCase("ALL  ")) {
                    dtm.addRow(new Object[]{sv.getLop(), sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh(), sv.getDiaChi()});
                }
            }
        } catch (Exception ex) {
            System.out.println("loi" + ex);
        }
    }

    public void xoaDS(int index) {
        dssv.remove(index);
    }

    public SinhVien sinhVien(int index) {
        return dssv.get(index);
    }
}
