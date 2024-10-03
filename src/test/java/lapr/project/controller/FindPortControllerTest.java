package lapr.project.controller;

import lapr.project.model.App;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class FindPortControllerTest {
    @Test
    void getPorts() {
        ReadShipController rc = new ReadShipController();
        String caminho = "src/main/java/lapr/project/csv/sships.csv";
        rc.read(caminho);
        caminho = "src/main/java/lapr/project/csv/bships.csv";
        rc.read(caminho);

        ReadPortController rpc = new ReadPortController();
        caminho = "src/main/java/lapr/project/csv/sports.csv";
        rpc.readPort(caminho);
        caminho = "src/main/java/lapr/project/csv/bports.csv";
        rpc.readPort(caminho);

        FindPortController a = new FindPortController();
        try{
            String str = "Date: 31/12/2020 17:10, Port: IdPort = 28313, Name = Cartagena, Latitude = 10.41666667, Longitude = -75.53333333, Continent = America, Country = Colombia";
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date data = formatter.parse("31/12/2020 17:10");
            assertEquals(str, a.getPorts("C4SQ2", data));
            str = "Ship does not exist";
            assertEquals(str, a.getPorts("", data));
        }catch(Exception e){
        }
        App.getInstance().getCompany().resetStores();
    }
}