package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author João Rodrigues
 */
public class ContainersMaterialsController {
    /**
     * Method that gets the instance of the store and returns the thermal resistance of a container
     * @param material1 Inside material used to build the container
     * @param material2 Middle material used to build the container
     * @param material3 Outside material used to build the container
     * @param espessura1 Inside material thickness
     * @param espessura2 Middle material thickness
     * @param espessura3 Outside material thickness
     * @return returns the thermal resistance of a container
     */
    public String getContainerMaterials(int material1, int material2, int material3, double espessura1, double espessura2, double espessura3){
        return App.getInstance().getCompany().getContainerMaterialsStore().getThermalResistance(material1, material2, material3, espessura1, espessura2, espessura3);
    }
}
