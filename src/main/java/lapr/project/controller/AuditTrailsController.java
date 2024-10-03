package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author João Rodrigues
 */
public class AuditTrailsController {
    /**
     * Method that gets the instance of the store and returns the operations made on a container
     * @param id_manifest_travel ID of the manifest of a travel
     * @param id_container ID of a container
     * @return returns the operations made on a container
     */
    public String getAuditTrails(int id_manifest_travel, String id_container){
        return App.getInstance().getCompany().getAuditTrailsStore().getAuditTrails(id_manifest_travel,id_container);
    }
}
