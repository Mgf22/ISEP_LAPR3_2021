package lapr.project.data;
/**
 * @author Joao Rodrigues
 */
public class ContainerMaterialsStore {
    /**
     * Method that returns the thermal resistance of a container
     * @param material1 Inside material used to build the container
     * @param material2 Middle material used to build the container
     * @param material3 Outside material used to build the container
     * @param espessura1 Inside material thickness
     * @param espessura2 Middle material thickness
     * @param espessura3 Outside material thickness
     * @return returns the thermal resistance of a container
     */
    public String getThermalResistance(int material1, int material2, int material3, double espessura1, double espessura2, double espessura3){
        double r_termica_mad = 0;
        double r_termica_aco = 0;
        double r_termica_fibra = 0;
        double r_termica_espuma = 0;
        String str = "";
        double r_termica_contentor;

        // material interior
        if(material1 == 1){
            r_termica_mad = espessura1 / 0.13;
        }

        if(material1 == 2) {
            r_termica_fibra = espessura1 / 0.046;
        }

        if(material1 == 3){
            r_termica_aco = espessura1 / 39;
        }

        if(material1 == 4){
            r_termica_espuma = espessura1 /0.035;
        }

        // material da camada do meio
        if(material2 == 1){
            r_termica_mad = espessura2 / 0.13;
        }

        if(material2 == 2) {
            r_termica_fibra = espessura2 / 0.046;
        }

        if(material2 == 3){
            r_termica_aco = espessura2 / 39;
        }

        if(material2 == 4){
            r_termica_espuma = espessura2 /0.035;
        }

        // material da camada exterior
        if(material3 == 1){
            r_termica_mad = espessura3 / 0.13;
        }

        if(material3 == 2) {
            r_termica_fibra = espessura3 / 0.046;
        }

        if(material3 == 3){
            r_termica_aco = espessura3 / 39;
        }

        if(material3 == 4){
            r_termica_espuma = espessura3 /0.035;
        }

        r_termica_contentor = r_termica_aco + r_termica_espuma + r_termica_mad + r_termica_fibra;

        str = ("A resitência têrmica do contentor é: "+r_termica_contentor+ " K/W");

        return str;
    }
}
