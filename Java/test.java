import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ArrayList<Double> ds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhap so thuc: ");
            // Kiểm tra xem người dùng có nhập đúng số không
            if (!sc.hasNextDouble()) {
                System.out.println("Vui long nhap mot so hople!");
                sc.next(); // Đọc bỏ dữ liệu sai
                continue;
            }
            Double x = sc.nextDouble();
            ds.add(x);

            System.out.print("Tiep tuc nhap? (N de dung): ");
            char N = sc.next().charAt(0);
            
            // Chấp nhận cả 'N' hoa và 'n' thường
            if (N == 'N' || N == 'n') {
                break;
            }
        }

        // Kiểm tra danh sách có phần tử nào không trước khi lấy giá trị
        if (!ds.isEmpty()) {
            double a = ds.get(0);
            System.out.println("Phan tu dau tien: " + a);

            // Tối ưu vòng lặp bằng For-each ngắn gọn hơn
            double sum = 0;
            for (double num : ds) {
                sum += num;
            }

            System.out.println("Tong: " + sum);
            System.out.println("Danh sach cac so: " + ds);
        } else {
            System.out.println("Danh sach rong!");
        }

        sc.close();
    }
}