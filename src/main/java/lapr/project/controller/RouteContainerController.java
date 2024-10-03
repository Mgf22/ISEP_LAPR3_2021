package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Mateus Fernandes
 */

public class RouteContainerController {
    /**
     * Method that gets the instance of the store and returns if a container is invalid or not leased by a client
     * @param id_cont Id of a container
     * @param id_cl Id of a client
     * @return returns the warning code and the identifier of the container
     */
    public String getRouteContainer(int id_cl, String id_cont){
        return App.getInstance().getCompany().getRouteContainerStore().getRouteContainer(id_cl, id_cont);
    }
}