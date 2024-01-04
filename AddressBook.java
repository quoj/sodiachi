package Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private static final Map<String, Contact> contactMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm sẵn một số liên hệ
        Contact trungDH = new Contact("TrungDH", "0904818238");
        Contact tuanNM = new Contact("TuanNM", "0904949494");

        contactMap.put(trungDH.getName(), trungDH);
        contactMap.put(tuanNM.getName(), tuanNM);

        while (true) {
            hienThiMenu();
            int luaChon = nhapLuaChonNgDung();

            switch (luaChon) {
                case 1:
                    themLienHe();
                    break;
                case 2:
                    timLienHeTheoTen();
                    break;
                case 3:
                    hienThiDanhBa();
                    break;
                case 4:
                    thoatChuongTrinh();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 4.");
            }
        }
    }

    private static void themLienHe() {
        System.out.print("Nhập tên liên hệ: ");
        String ten = scanner.nextLine();

        System.out.print("Nhập số điện thoại liên hệ: ");
        String soDienThoai = scanner.nextLine();

        // Kiểm tra xem số điện thoại chỉ chứa số
        if (!soDienThoai.matches("\\d+")) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập chỉ chứa số.");
            return;
        }

        Contact lienHeMoi = new Contact(ten, soDienThoai);
        contactMap.put(ten, lienHeMoi);

        System.out.println("Đã thêm liên hệ thành công!");
    }

    private static void timLienHeTheoTen() {
        System.out.print("Nhập tên để tìm liên hệ: ");
        String ten = scanner.nextLine();

        Contact lienHe = contactMap.get(ten);
        if (lienHe != null) {
            System.out.println("Số điện thoại cho " + ten + ": " + lienHe.getPhoneNumber());
        } else {
            System.out.println("Không tìm thấy liên hệ.");
        }
    }

    private static void hienThiDanhBa() {
        System.out.println("\nSổ địa chỉ");
        System.out.printf("%-15s %-15s\n", "Tên liên hệ", "Số điện thoại");
        for (Contact lienHe : contactMap.values()) {
            System.out.println(lienHe);
        }
    }

    private static int nhapLuaChonNgDung() {
        System.out.print("Nhập lựa chọn của bạn: ");
        int luaChon;
        try {
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ dấu xuống dòng
        } catch (Exception e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 4.");
            scanner.nextLine(); // Tiêu thụ dấu xuống dòng
            return nhapLuaChonNgDung(); // Gọi đệ quy để lấy lựa chọn hợp lệ
        }
        return luaChon;
    }

    private static void thoatChuongTrinh() {
        System.out.println("Bạn Đã Thoát Sổ Địa Chỉ. Tạm biệt!");
        System.exit(0);
    }

    private static void hienThiMenu() {
        System.out.println("\nMenu Sổ Địa Chỉ:");
        System.out.println("1. Thêm liên hệ mới");
        System.out.println("2. Tìm liên hệ theo tên");
        System.out.println("3. Hiển thị danh bạ");
        System.out.println("4. Thoát");
    }
}