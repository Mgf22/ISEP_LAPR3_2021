package lapr.project.model;

public class US420 {
    public int calculateTotalMassPlaced(int numberContainers){
        return 500 * numberContainers;
    }

    public double calculateVesselSink(double shipEmptyMass, int shipLength, int shipWidth, int massPlaced){
        double density = 1030;
        double totalMass = shipEmptyMass + massPlaced;
        double volume = totalMass/density;

        return Math.round(volume / (shipLength * shipWidth) * 100.0)/100.0;
    }

    public double pressureExertedInWater(double shipEmptyMass, int massPlaced) {
        //gravity acceleration = 9.81
        return Math.round(shipEmptyMass + massPlaced * 9.81 * 100.0)/100.0;
    }
}
