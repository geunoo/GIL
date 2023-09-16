
#include <stdio.h>

int main() {
    int n = 0;
    int count = 0;
    scanf("%d", &n);

    while (n % 5 != 0) {
        n -= 3;
        count++;
    }
    while (n != 0) {
        if (n >= 5) {
            n -= 5;
            count++;
        } else {
            printf("-1");
            return 0;
        }
    }

    printf("%d", count);
    return 0;
}