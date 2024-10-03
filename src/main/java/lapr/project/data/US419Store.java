package lapr.project.data;
/**
 * @author João Rodrigues
 */
public class US419Store {
    /**
     * Method that returns area and volume of a container and its center of mass
     * @param escolha type of container (either 1 TEU or 2 TEU)
     * @return returns the area, volume and center of mass of the container
     */
    public String getContainerInfos(int escolha){
        String ret = "";
        double comp = 0;
        double alt = 0;
        double larg = 0;
        double x = 0;
        double y = 0;
        double z = 0;
        double area;
        double volume;

        if (escolha == 1){
            comp = 5.900;
            alt = 2.393;
            larg = 2.350;
        }
        else{
            comp = 12.036;
            alt = 2.392;
            larg = 2.350;
        }

        x = comp /2 ;
        y = larg /2 ;
        z = alt /2 ;

        area = 2 * (comp * larg) + 2 * (larg * alt) + 2 * (comp * alt);
        volume = comp * alt * larg;

        ret = "Contentor: "+escolha+ "\nÁrea do contentor: "+area+" metros quadrados\nVolume do contentor: "+volume+" metros cúbicos\nCentro de massa: \nX: "+x+"m\nY: "+y+"m\nZ: "+z+"m.";

        return  ret;
    }
}
