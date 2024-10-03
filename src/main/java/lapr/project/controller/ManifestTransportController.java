package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class ManifestTransportController {
    /**
     * Method that get the average of manifest for a captain and the total manifests in a given year
     *
     * @param ano ano dos manifestos
     * @param idCapitao id do Capitão que transportou os manifestos
     * @return returns the average of manifest for a captain and the total manifests in a given year
     */
    public String getManifestTransport(int idCapitao, int ano){
        return App.getInstance().getCompany().getManifestTransport().getManifest(idCapitao, ano);
    }
}
