#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "read_containers.h"

void readContainers(FILE * containers, int (*mPtr)[10][10]){
    if(containers){
        char buffer[1024], flag = 0;
        char *n;
        int id, x, y, z;

        while (fgets(buffer, 1024, containers)) {
            if (flag == 0){
                flag = 1;
                continue;
            }

            n = strtok(buffer, ",");

            id = strtol(n, NULL, 10);
            n = strtok(NULL, ",");

            x = strtol(n, NULL, 10);
            n = strtok(NULL, ",");

            y = strtol(n, NULL, 10);
            n = strtok(NULL, ",");

            z = strtol(n, NULL, 10);

            mPtr[x][y][z] = id;
        }
    } else {
        printf("The file does not exist.");
    }
    fclose(containers);
}