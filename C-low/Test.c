#include <stdio.h>

int main() {
    int n, a[100];

    printf("Nhap so luong phan tu: ");
    scanf("%d", &n);

    // a. Nhap day so nguyen
    for (int i = 0; i < n; i++) {
        printf("Nhap phan tu a[%d]: ", i);
        scanf("%d", &a[i]);
    }

    // b. Kiểm tra phan tu chan thi giam 1
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            a[i] = a[i] - 1;
        }
    }

    // c. Xuat day
    printf("\nDay so sau khi xu ly: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}