package lapr.project.data;
/**
 * @author João Rodrigues
 */
public class US413Store {
    /**
     * Method that gets the required energy to feed a set of refrigerated containers
     * @param nr_cont1 number of containers refrigerated at 7ºC
     * @param nr_cont2 number of containers refrigerated at -5ºC
     * @return  returns the needed energy to feed a set of refrigerated containers
     */
    public String getTotalEnergy(int nr_cont1, int nr_cont2){
        String ret = "";
        double energia_7 = 0;
        double energia_5 = 0;
        double contentor_7 = 10.48;
        double contentor_5 = 15.82;

        energia_7 = nr_cont1 * contentor_7;
        energia_5 = nr_cont2 * contentor_5;

        ret = "Para alimentar os contentores refrigerados a 7ºC são necessários: "+energia_7+"W\nPara alimentar os contentores refrigerados a -5ºC são necessários: "+energia_5+"W\nTotal de energia necessária para alimentar os contentores refrigerados: "+(energia_5+energia_7)+"W";
        return ret;
    }

}
