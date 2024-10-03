#ifndef US409_H
#define US409_H

extern int numContainers;

typedef struct {
    int id, x, y, z;
	double thermalResistance;
	char refrigerated;
}container;

container* fill_vec(container* vec, FILE * file);

#endif