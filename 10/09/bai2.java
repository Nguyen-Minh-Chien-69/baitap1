import java.util.*;

class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private static double laiSuatNam = 0.05; // 5% mặc định

    // Constructor
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
    }

    // Nạp tiền
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
        }
    }

    // Rút tiền
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
        } else {
            System.out.println("Không đủ số dư để rút!");
        }
    }

    // Tính lãi 1 tháng
    public void tinhLaiThang() {
        double lai = soDu * (laiSuatNam / 12);
        soDu += lai;
    }

    // Hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Số TK: " + soTaiKhoan);
        System.out.println("Chủ TK: " + chuTaiKhoan);
        System.out.println("Số dư: " + soDu);
        System.out.println("--------------------------");
    }

    // Getter để tìm kiếm và sắp xếp
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    // Thay đổi lãi suất
    public static void setLaiSuatNam(double laiSuat) {
        laiSuatNam = laiSuat;
    }

    public static void hienThiLaiSuat() {
        System.out.println("Lãi suất năm hiện tại: " + (laiSuatNam * 100) + "%");
    }
}

public class MainTaiKhoan {
    public static void main(String[] args) {
        ArrayList<TaiKhoan> ds = new ArrayList<>();

        ds.add(new TaiKhoan("1001", "Nguyen Van A", 5000));
        ds.add(new TaiKhoan("1002", "Le Thi B", 8000));
        ds.add(new TaiKhoan("1003", "Tran Van C", 3000));

        TaiKhoan.setLaiSuatNam(0.06);
        TaiKhoan.hienThiLaiSuat();

        ds.get(0).napTien(2000);
        ds.get(1).rutTien(1000);
        ds.get(2).tinhLaiThang()
  
        System.out.println("\nDanh sách tài khoản sau khi giao dịch:");
        for (TaiKhoan tk : ds) {
            tk.hienThiThongTin();
        }

        String soTKCanTim = "1002";
        System.out.println("\nKết quả tìm kiếm số TK " + soTKCanTim + ":");
        for (TaiKhoan tk : ds) {
            if (tk.getSoTaiKhoan().equals(soTKCanTim)) {
                tk.hienThiThongTin();
            }
        }

    
        ds.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));
        System.out.println("\nDanh sách tài khoản sau khi sắp xếp theo số dư giảm dần:");
        for (TaiKhoan tk : ds) {
            tk.hienThiThongTin();
        }
    }
}
