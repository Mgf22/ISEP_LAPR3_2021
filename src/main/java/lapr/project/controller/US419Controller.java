package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author João Rodrigues
 */
public class US419Controller {
    /**
     * Method that gets the and returns the area, volume and center of mass of a container
     * @param escolha (either 1 or 2), type of container
     * @return  returns the area, volume and center of mass of a container
     */
    public String getContainersInfo(int escolha) {
        return App.getInstance().getCompany().getUS419store().getContainerInfos(escolha);
    }
}
