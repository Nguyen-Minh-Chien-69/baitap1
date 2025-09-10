class SinhVien {

    private String maSv;
    private String hoTen;
    private int tuoi;
    private static int soLuong = 0;
    
    public SinhVien() {
     
        soLuong++;
    }


    public void setThongTin(String maSv, String hoTen, int tuoi) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }


    public void hienThiThongTin() {
        System.out.println("Mã SV: " + maSv);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("------------------------");
    }

 
    public static void hienThiSoLuong() {
        System.out.println("Tổng số sinh viên đã tạo: " + soLuong);
    }
}


public class Main {
    public static void main(String[] args) {

        SinhVien sv1 = new SinhVien();
        sv1.setThongTin("SV001", "Nguyen Van A", 20);

        SinhVien sv2 = new SinhVien();
        sv2.setThongTin("SV002", "Tran Thi B", 21);

        sv1.hienThiThongTin();
        sv2.hienThiThongTin();


        SinhVien.hienThiSoLuong();
    }
}
