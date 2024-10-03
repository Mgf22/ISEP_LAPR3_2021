#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "US409.h"
#include "US410.h"
#include "US411.h"

int numContainers;

int main(){
    // tamanho da estrutura container
    int sizeContainer = sizeof(container);

	//Instanciar o array e alocar espaço para os containers
    container* array = malloc(sizeContainer * 20);

	//Preencher array com os containers
	array = fill_vec(array, fopen("containers.csv","r"));

    //US409
    for(int i = 0; i < 20; i++) {
	    printf("ID Container: %d, X: %d, Y: %d, Z: %d, Thermal Resistance: %f, Refregeration: %d\n", array[i].id, array[i].x, array[i].y, array[i].z, array[i].thermalResistance, array[i].refrigerated);
	}

    //US410
	int x = 1, y = 1, z = 1;

	double energy = calculateRequiredEnergy(array, x, y, z);
	if (energy != 0){
		printf("The energy required for this container is %f Joules\n", energy);
	} else {
		printf("The container does not exist or it's not refrigerated\n");
	}

	//US411
	double currentEnergy = 2;
	if(receiveAlert(currentEnergy, array) == 1){
		printf("There is enough energy for all the containers.\n");
	} else {
		printf("There is not enough energy for the containers at the moment.\n");
	}

    return 0;
	
}