#include <stdio.h>
#include "US409.h"
#include "US411.h"

int numContainers;

char receiveAlert(int totalEnergy, container* array){
    int energyQuant, i;

    for (i = 0; i < numContainers; i++){
        double energy = calculateRequiredEnergy(array, array[i].x, array[i].y, array[i].z);
        if(energy > -1){
            energyQuant += energy;
        }
    }

    if (energyQuant < totalEnergy){
        return 1;
    }else{
        return 0;
    }
}