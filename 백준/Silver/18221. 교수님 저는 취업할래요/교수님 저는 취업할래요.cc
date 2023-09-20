#include <stdio.h>

int main() {
    int n, c[1001][1001] = {0}, tX, tY, sX, sY, count = 0;;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &c[i][j]);
            if (c[i][j] == 5) {
                tX = i;
                tY = j;
            } else if (c[i][j] == 2) {
                sX = i;
                sY = j;
            }
        }
    }

    if ((((tX - sX) * (tX - sX)) + ((tY - sY) * (tY - sY))) < 25) {
        printf("0");
        return 0;
    }

    if (tX < sX) {
        for (int i = tX; i <= sX; ++i) {
            if (tY < sY) {
                for (int j = tY; j <= sY; ++j) {
                    if (c[i][j] == 1) {
                        count++;
                    }
                }
            } else {
                for (int j = sY; j <= tY; ++j) {
                    if (c[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
    } else {
        for (int i = sX; i <= tX; ++i) {
            if (tY < sY) {
                for (int j = tY; j <= sY; ++j) {
                    if (c[i][j] == 1) {
                        count++;
                    }
                }
            } else {
                for (int j = sY; j <= tY; ++j) {
                    if (c[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
    }

    if (count >= 3) {
        printf("1");
    } else {
        printf("0");
    }
}