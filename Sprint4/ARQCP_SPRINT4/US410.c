#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "US409.h"
#include "US410S.h"

int numContainers;

int findContainer(container* array, int x, int y, int z){
	for (int i = 0; i < numContainers; i++){
		if (array[i].x == x && array[i].y == y && array[i].z == z){
			return i;
		}
	}
	return 0;
}

double calculateRequiredEnergy(container* array, int x, int y, int z){
	int c = findContainer(array, x, y, z);
	if (validaRefrigeracao(array, x, y, z, numContainers) == 1){
		double p = (25/array[c].thermalResistance) * 9000;
		return p;
	}
	return 0;
}