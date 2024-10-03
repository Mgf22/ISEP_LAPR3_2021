package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.ShipDynamic;
import lapr.project.model.ShipStatic;
import lapr.project.model.store.ShipStore;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Mateus Fernandes
 */

public class ReadShipController {
    /**
     * Constructor of the method
     */
    public ReadShipController(){
        //empty
    }
    /**
     * Method that reads the ports
     *
     * @param caminho Path to file with ships
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean read(String caminho) {
        ShipDynamic dynamic;
        ShipStatic sta;
        Path pathToFile = Paths.get(caminho);
        String line;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ShipStore a = App.getInstance().getCompany().getShipStore();
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                atributes = line.split(",");
                dynamic = new ShipDynamic(formatter.parse(atributes[1]),Float.parseFloat(atributes[2]),Float.parseFloat(atributes[3]),Float.parseFloat(atributes[4]),Float.parseFloat(atributes[5]),Integer.parseInt(atributes[6]),atributes[15]);
                sta = new ShipStatic(Integer.parseInt(atributes[0]),atributes[7],atributes[8],atributes[9],Integer.parseInt(atributes[10]),Integer.parseInt(atributes[10]),Integer.parseInt(atributes[12]),Float.parseFloat(atributes[13]),atributes[14]);
                a.insert(sta,dynamic);
                line = br.readLine();
            }
        }catch (IOException | ParseException ioe){
            return false;
        }
        return true;
    }
}