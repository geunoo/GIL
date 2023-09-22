#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    int kda[3], i = 0;
    char n[10];
    scanf("%s", &n);
    char* s = strtok(n, "/");
    while (s != NULL) {
        kda[i] = atoi(s);
        s = strtok(NULL, "/");
        i++;
    }

    if (kda[0] + kda[2] < kda[1] || kda[1] == 0) {
        printf("hasu");
    } else {
        printf("gosu");
    }
}
