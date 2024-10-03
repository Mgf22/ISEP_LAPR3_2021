#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "US409.h"

//este método recebe como parametro o apontador do array dinâmico de containers e o ficheiro com a informação desses containers
container* fill_vec(container* vec, FILE * file){
	if(file){
		container* tmp;
		container value;
		char con[1024];
		char *str;
		char flag = 0;
    	int pos = 0, id, x, y, z;
		double thermalResistance;
		char refrigerated;

		while (fgets(con, 1024, file)) {
			if (flag == 0){
                flag = 1;
                continue;
            }
			str = strtok(con, ",");
		
			id = strtol(str, NULL, 10);
			str = strtok(NULL, ",");

			x = strtol(str, NULL, 10);
			str = strtok(NULL, ",");

			y = strtol(str, NULL, 10);
			str = strtok(NULL, ",");

			z = strtol(str, NULL, 10);
			str = strtok(NULL, ",");

			thermalResistance = strtod(str,NULL);
			str = strtok(NULL, ",");

			refrigerated = strtol(str, NULL, 10);

			value.id = id;
			value.x = x;
			value.y = y;
			value.z = z;
			value.thermalResistance = thermalResistance;
			value.refrigerated = refrigerated;

			//Resize no vetor
			if(pos >= 20){
				tmp = (container *) realloc(vec, (pos+1) * sizeof(container));
				if(tmp == NULL){
					printf ("Unable to resize array!\n");
					break;
				}
				vec = tmp;
			}

			//colocar o container na sua posição correta
			vec[pos] = value;
			pos++;
		}

    	fclose(file);
		numContainers = pos;
		return vec;
	}
	return NULL;
}