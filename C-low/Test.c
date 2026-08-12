#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <windows.h>

void thapPhanSangThapLucPhan() {
    int n;
    char hex[50];
    int count = 0;

    printf("Nhap n: ");
    scanf("%d", &n);

    // Trường hợp đặc biệt n = 0
    if (n == 0) {
        printf("Thap luc phan (Hex): 0\n");
        return;
    }

    int N = n;

    while (N > 0) {
        int du = N % 16; // 1. Chia lấy dư cho 16

        // 2. Chuyển số dư thành ký tự tương ứng
        if (du < 10) {
            hex[count] = du + '0';         // Dư 0..9 -> '0'..'9'
        } else {
            hex[count] = (du - 10) + 'A';  // Dư 10..15 -> 'A'..'F'
        }

        count++;
        N = N / 16; // Chia lấy nguyên cho 16
    }

    // In kết quả đảo ngược
    printf("Thap luc phan (Hex): ");
    for (int i = count - 1; i >= 0; i--) {
        printf("%c", hex[i]);
    }

    printf("\n");
}
int main(){
    thapPhanSangThapLucPhan();
    
    return 0;
}

    


