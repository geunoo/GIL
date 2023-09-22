#include <stdio.h>
#include <string.h>

#define _CRT_SECURE_NO_WARNINGS

int main() {
    int i = 0, n, count = 0;
    char s[1001] = {0};

    scanf("%d", &n);

    while (1) {
        sprintf(s, "%d", i);
        if (strstr(s, "666") == NULL) {
            i++;
        } else {
            if (count == n - 1) {
                printf("%d", i);
                break;
            } else {
                count++;
                i++;
                continue;
            }
        }
    }
}