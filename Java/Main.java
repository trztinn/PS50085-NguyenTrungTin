import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n+-----------------------------------+");
            System.out.println("|             MENU CHON             |");
            System.out.println("+-----------------------------------+");
            System.out.println("| 1. Giai phuong trinh bac nhat     |");
            System.out.println("| 2. Giai phuong trinh bac hai      |");
            System.out.println("| 3. Tinh tien dien                 |");
            System.out.println("| 4. Ket thuc                       |");
            System.out.println("+-----------------------------------+");
            System.out.print("Nhap so (1-4): ");

            int chon = sc.nextInt();

            switch (chon) {
                case 1: {
                    System.out.println("\n--- GIAI PHUONG TRINH BAC NHAT ---");
                    System.out.print("Nhap a: ");
                    int a = sc.nextInt();
                    System.out.print("Nhap b: ");
                    int b = sc.nextInt();

                    if (a == 0 && b == 0) {
                        System.out.println("Phuong trinh vo so nghiem.");
                    } else if (a == 0) {
                        System.out.println("Phuong trinh vo nghiem.");
                    } else {
                        double x = (double) -b / a;
                        System.out.println("Nghiem x = " + x);
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n--- GIAI PHUONG TRINH BAC HAI ---");
                    System.out.print("Nhap a: ");
                    int a = sc.nextInt();
                    System.out.print("Nhap b: ");
                    int b = sc.nextInt();
                    System.out.print("Nhap c: ");
                    int c = sc.nextInt();

                    System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");

                    if (a == 0) {
                        if (b == 0) {
                            if (c == 0) {
                                System.out.println("Phuong trinh vo so nghiem!");
                            } else {
                                System.out.println("Phuong trinh vo nghiem!");
                            }
                        } else {
                            double x = (double) -c / b;
                            System.out.println("Phuong trinh co 1 nghiem: x = " + x);
                        }
                    } else {
                        double delta = (double) b * b - 4 * a * c;

                        if (delta < 0) {
                            System.out.println("Phuong trinh vo nghiem!");
                        } else if (delta == 0) {
                            double x = (double) -b / (2 * a);
                            System.out.println("Phuong trinh co nghiem kep: x = " + x);
                        } else {
                            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                            System.out.println("Phuong trinh co 2 nghiem phan biet:");
                            System.out.println("x1 = " + x1);
                            System.out.println("x2 = " + x2);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n--- TINH TIEN DIEN ---");
                    System.out.print("Nhap so kWh dien su dung: ");
                    int kwh = sc.nextInt();

                    if (kwh < 0) {
                        System.out.println("So kWh khong hop le!");
                    } else {
                        double tienDien;
                        // Gia dinh: Duoi hoac bang 50 kWh tinh gia 1000/kWh, tren 50 kWh tinh gia 1200/kWh cho phan vuot
                        if (kwh <= 50) {
                            tienDien = kwh * 1000;
                        } else {
                            tienDien = 50 * 1000 + (kwh - 50) * 1200;
                        }
                        System.out.println("Tong tien dien phai tro: " + tienDien + " VNĐ");
                    }
                    break;
                }
                case 4:
                    System.out.println("Tam biet!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        }
    }
}