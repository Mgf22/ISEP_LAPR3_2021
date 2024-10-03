#include <stdio.h>
#include "read_containers.h"
#include "count_containers.h"
#include "container_verification.h"
#include "check_container_position.h"

int numElem = 999;
int (*mPtr)[10][10];
int posx, posy, posz;
int ptrvec[12] = {1,2,3,0,0,0,4,4,4,9,1,1};

int main(){
    int m[10][10][10];
    int x = 10, y = 10, z = 10;
    printf("US313\n");
    for(int i = 0; i < x ; i++){
        for(int j = 0; j < y ; j++){
            for(int k = 0; k < z ; k++){
                m[i][j][k] = 0;
            }
        }
    }

    int (*mPtr)[y][z] = m;
    readContainers(fopen("containers.csv","r"), mPtr);

    for(int i = 0; i < x ; i++){
        for(int j = 0; j < y ; j++){
            for(int k = 0; k < z ; k++){
                printf("Matrix[%d][%d][%d] = %d\n",i, j, k, mPtr[i][j][k]);
            }
        }
    }


    printf("\nUS314\n");
    long a = count_containers();
    int *ptr = (int *) &a;
    printf("There are %d occupied positions.\n", *ptr);
    printf("There are %d free positions.\n", *(ptr + 1));


    printf("\nUS315\n");
    posx = 1;
    posy = 2;
    posz = 3;
    if(container_verification() == 1){
        printf("The position is occupied.");
    }else{
        printf("The position is not occupied.");
    }


    printf("\nUS316\n");
    printf("There are %d slots occupied in the positions given.", check_container_position());
    
    return 0;
}