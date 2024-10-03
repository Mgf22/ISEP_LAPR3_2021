package lapr.project.model;

import java.util.Map;

public class US414_US415 {
    public double getEnergy7C(int nContainers, Map<Double, Double> sections){
        double area = getArea(2.393, 5.9, 2.350);
        double rTotal = 0.02/(0.13 * area) + 0.05/(0.046 * area) + 0.0015/(39 * area);
        double q;
        double energy = 0.0;

        //q = intervalo de Temperatura / resistencia total
        for(double temperature : sections.keySet()) {
            q = (temperature - 7.0) / rTotal;
            energy += q * sections.get(temperature);
        }

        return Math.round(energy * nContainers * 100.0)/100.0;
    }

    public double getEnergy5C(int nContainers, Map<Double, Double> sections){
        double area = getArea(2.393, 5.9, 2.350);
        double rTotal = 0.02/(0.13 * area) + 0.05/(0.035 * area) + 0.0015/(39 * area);
        double q;
        double energy = 0.0;

        //q = intervalo de Temperatura / resistencia total
        for(double temperature : sections.keySet()) {
            q = (temperature + 5.0) / rTotal;
            energy += q * sections.get(temperature);
        }

        return Math.round(energy * nContainers * 100.0)/100.0;
    }

    public double getEnergyExposedContainers7C(int nSideFacesExposed, int nFrontFacesExposed,int nTopFacesExposed, Map<Double, Double> sections){
        double area = getAreaOfExposedFaces(2.393, 5.9, 2.350, nSideFacesExposed, nFrontFacesExposed, nTopFacesExposed);
        double rTotal = 0.02/(0.13 * area) + 0.05/(0.046 * area) + 0.0015/(39 * area);
        double q;
        double energyForContainers = 0.0;

        //q = intervalo de Temperatura / resistencia total
        for(double temperature : sections.keySet()){
            q = (temperature - 7.0) / rTotal;
            energyForContainers += q * sections.get(temperature);
        }

        return Math.round(energyForContainers * 100.0)/100.0;
    }

    public double getEnergyExposedContainers5C(int nSideFacesExposed, int nFrontFacesExposed, int nTopFacesExposed, Map<Double, Double> sections){
        double area = getAreaOfExposedFaces(2.393, 5.9, 2.350, nSideFacesExposed, nFrontFacesExposed, nTopFacesExposed);
        double rTotal = 0.02/(0.13 * area) + 0.05/(0.035 * area) + 0.0015/(39 * area);
        double q;
        double energyForContainers = 0.0;

        //q = intervalo de Temperatura / resistencia total
        for(double temperature : sections.keySet()){
            q = (temperature + 5.0) / rTotal;
            energyForContainers += q * sections.get(temperature);
        }

        return Math.round(energyForContainers * 100.0)/100.0;
    }

    public int getNumberOfPowerEquipmentNecessary(double time, double energy){
        return (int) Math.round(energy / ((double) 75 * time));
    }

    public double getAreaOfExposedFaces(double alt, double lar, double comp, int nFrontFacesExposed, int nSideFacesExposed, int nTopFacesExposed){
        return (alt * lar) * nFrontFacesExposed + (comp * alt) * nSideFacesExposed + (comp * lar) * nTopFacesExposed;
    }

    public double getArea(double alt, double lar, double comp){
        return (alt * lar) * 2 + (comp * alt) * 2 + (comp * lar) * 2;
    }
}