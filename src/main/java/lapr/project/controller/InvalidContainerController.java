package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Mateus Fernandes
 */

public class InvalidContainerController {
    /**
     * Method that gets the instance of the store and returns if a container is invalid or not leased by a client
     * @param id_container Id of a container
     * @param id_client Id of a client
     * @return returns the warning code and the identifier of the container
     */
    public String getInvalidContainer(String id_container, int id_client){
        return App.getInstance().getCompany().getInvalidContainerStore().getInvalidContainer(id_container, id_client);
    }
}