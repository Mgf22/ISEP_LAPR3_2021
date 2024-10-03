package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.Ports;
import lapr.project.model.store.PortStore;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Mateus Fernandes
 */

public class ReadPortController {
    /**
     * Constructor of the method
     */
    public ReadPortController(){
        //Empty
    }
    /**
     * Method that reads the ports
     *
     * @param caminho Path to file with ports
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readPort(String caminho) {
        Path pathToFile = Paths.get(caminho);
        String line;
        Ports port;
        PortStore b = App.getInstance().getCompany().getPortStore();
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                atributes = line.split(",");
                port = new Ports(Integer.parseInt(atributes[2]), atributes[3], Double.parseDouble(atributes[4]), Double.parseDouble(atributes[5]), atributes[0], atributes[1]);
                b.insert(port, Double.parseDouble(atributes[4]), Double.parseDouble(atributes[5]));
                line = br.readLine();
            }
        }catch (IOException ioe){
            return false;
        }
        b.balanceTree();
        return true;
    }
}
