#include <stdio.h>
#include "receive_alert.h"
#include "calculateRequiredEnergy.h"

char receive_alert (int total_energy, container array[]){
    char alert[] = "";
    int count_energy;
    int i;
    int n =sizeof(array)/sizeof(int);
    for (i=0; i<n; i++){
        array[i]= calculateRequiredEnergy();
        count_energy += array[i];
    }
    if (count_energy<total_energy){
        alert = "The energy provided is enough";
    }
    else{
        alert = "The energy provided is not enough for all the containers";
    }
    return alert;
}