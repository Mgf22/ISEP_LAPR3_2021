package lapr.project.ui;

import lapr.project.controller.*;
import lapr.project.model.US414_US415;
import lapr.project.model.US420;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        final String sep = "\n/-----------------------------------------------------------------------------------------------------/\n";
        String caminho;
        /*
        System.out.println(sep);
        System.out.println("US101");
        ReadShipController a = new ReadShipController();
        caminho = "src/main/java/lapr/project/csv/sships.csv";
        if(a.read(caminho)){
            System.out.println("O ficheiro dos navios pequenos foi lido corretamente.");
        }else{
            System.out.println("O ficheiro dos navios pequenos não foi lido corretamente.");
        }

        caminho = "src/main/java/lapr/project/csv/bships.csv";
        if(a.read(caminho)){
            System.out.println("O ficheiro dos navios grandes foi lido corretamente.");
        }else{
            System.out.println("O ficheiro dos navios grandes não foi lido corretamente.");
        }

        System.out.println(sep);
        System.out.println("US102");
        FindShipController fsc = new FindShipController();
        System.out.println(fsc.getShips("211331640"));
        System.out.println(fsc.getShips("IMO7808152"));
        System.out.println(fsc.getShips("C6ZJ6"));

        System.out.println(sep);
        System.out.println("US107");
        PairShipController psc = new PairShipController();
        System.out.println(psc.filterList());

        System.out.println(sep);
        System.out.println("US201");
        ReadPortController b = new ReadPortController();
        caminho = "src/main/java/lapr/project/csv/sports.csv";
        if(b.readPort(caminho)){
            System.out.println("O ficheiro dos portos pequenos foi lido corretamente.");
        }else{
            System.out.println("O ficheiro dos portos pequenos não foi lido corretamente.");
        }

        caminho = "src/main/java/lapr/project/csv/bports.csv";
        if(b.readPort(caminho)){
            System.out.println("O ficheiro dos portos grandes foi lido corretamente.");
        }else{
            System.out.println("O ficheiro dos portos grandes não foi lido corretamente.");
        }

        System.out.println(sep);
        System.out.println("US202");
        FindPortController fpc = new FindPortController();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
            Date data = formatter.parse("31/12/2020 17:10");
            System.out.println(fpc.getPorts("C4SQ2", data));
        }catch(Exception e){
        }
        System.out.println(sep);

        System.out.println("US204");
        FindContainerController fcs = new FindContainerController();
        System.out.println(fcs.getContainer("POLK3597847"));
        System.out.println(fcs.getContainer("BICJ5697847"));

        System.out.println(sep);

        System.out.println("US205");
        OffloadedContainersController occ = new OffloadedContainersController();
        System.out.println(occ.getListContainers(211331640));

        System.out.println(sep);

        System.out.println("US206");
        LoadedContainersController lcc = new LoadedContainersController();
        System.out.println(lcc.LoadedContainersController(211331640));

        System.out.println(sep);

        System.out.println("US207");
        ManifestTransportController mtc = new ManifestTransportController();
        System.out.println(mtc.getManifestTransport(2, 2021));

        System.out.println(sep);

        System.out.println("US208");
        OccupancyRateController orc = new OccupancyRateController();
        System.out.println(Math.round(orc.getOccupancy(211331640, 2)) + "%");

        System.out.println(sep);

        System.out.println("US209");
        OccupancyRateTimeController ortc = new OccupancyRateTimeController();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy.MM.dd");
            Date data = f.parse("19.12.22");
            System.out.println(Math.round(ortc.getOccupancy(211331640,f.format(data))) + "%");
        } catch (Exception e) {
        }

        System.out.println(sep);

        System.out.println("US210");
        AvailableShipController ass = new AvailableShipController();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy.MM.dd");
            Date data = f.parse("21.12.13");
            System.out.println(ass.getAvailableShip(f.format(data)));
        } catch (Exception e) {
        }

        System.out.println(sep);*/

        {
//            System.out.println("US301");
//            ReadGraphController rgc = new ReadGraphController();
//            if (rgc.read(10)) {
//                System.out.println("Os dados foram lidos corretamente.");
//            } else {
//                System.out.println("Os dados não foram lidos corretamente.");
//            }
//        /*
//        System.}out.println(sep);
//
//        System.out.println("US302");
//        PaintGraphController pgc = new PaintGraphController();
//        if (pgc.paint()) {
//            System.out.println("O grafo foi pintado com sucesso.");
//        } else {
//            System.out.println("O grafo não foi pintado com sucesso.");
//        }
//
//        System.out.println(sep);
//
//        System.out.println("US303");
//        ClosestLocalController clc = new ClosestLocalController();
//        System.out.println(clc.returnClosest(3));
//
//        System.out.println(sep);
//
//        System.out.println("US304");
//        AuditTrailsController ats = new AuditTrailsController();
//        try {
//            System.out.println(ats.getAuditTrails(6, "BIYT9897847"));
//        } catch (Exception e) {
//        }
//
//        System.out.println(sep);
//
//        System.out.println("US305");
//        RouteContainerController rss = new RouteContainerController();
//        try {
//            System.out.println(rss.getRouteContainer(1, "HJIU5670247"));
//            System.out.println(rss.getRouteContainer(10, "POPCJ987847"));
//        } catch (Exception e) {
//        }
//
//        System.out.println(sep);
//
//        System.out.println("US306");
//        OccupancyWarehouseController ocuc = new OccupancyWarehouseController();
//        try {
//            System.out.println(ocuc.getOccupancyWarehouse());
//        } catch (Exception e) {
//        }
//
//        System.out.println(sep);
//
//        //System.out.println("US309");
//        // ShipOccupationController sos = new ShipOccupationController();
//        //try {
//        //   System.out.println(sos.tryAddManifest(17,20351,20301,3,"01/01/2022"));
//        //}catch (Exception e) {
//
//        //}
//        System.out.println(sep);
//
//        System.out.println("US310");
//        Us310Controller us310 = new Us310Controller();
//        System.out.println(us310.getUS310(2020, 1, 9845));
//
//        System.out.println(sep);
//
//        System.out.println("US312");
//        InvalidContainerController icoc = new InvalidContainerController();
//        try {
//            System.out.println(icoc.getInvalidContainer("NHJK3127847", 2));
//            System.out.println(icoc.getInvalidContainer("POPCJ987847", 2));
//        } catch (Exception e) {
//        }
//
//        System.out.println(sep);
//
//        System.out.println("US317 - US320");
//        ContainersMaterialsController cms = new ContainersMaterialsController();
//        System.out.println("Qual é o material que quer utilizar na camada interior?");
//        System.out.println(" 1- Madeira \n 2- Fibra de Vidro \n 3- Aço Corten \n 4- Espuma de poliestereno ");
//        System.out.println("Espessura do material? (Metros)");
//        System.out.println("Qual é o material que quer utilizar na camada do meio?");
//        System.out.println(" 1- Madeira \n 2- Fibra de Vidro \n 3- Aço Corten \n 4- Espuma de poliestereno ");
//        System.out.println("Espessura do material? (Metros)");
//        System.out.println("Qual é o material que quer utilizar na camada exterior?");
//        System.out.println(" 1- Madeira \n 2- Fibra de Vidro \n 3- Aço Corten \n 4- Espuma de poliestereno ");
//        System.out.println("Espessura do material? (Metros)");
//        System.out.println(cms.getContainerMaterials(1, 2, 3, 0.02, 0.05, 0.02));*/
//
//        System.out.println(sep);
//
//        System.out.println("US401");
//        CriticalPortController cpc = new CriticalPortController();
//        System.out.println(cpc.returnCritical(3));
//
//        System.out.println(sep);
//
//        System.out.println("US404");
//        IdleShipsController iss = new IdleShipsController();
//        try {
//            System.out.println(iss.getIdleShip(2022, "366929710"));
//            System.out.println(iss.getIdleShip(2022, "636092932"));
//        } catch (Exception e) {
//        }
//
//        System.out.println(sep);
//
//        System.out.println("US405");
//        Us405Controller us405 = new Us405Controller();
//        System.out.println((us405.getUS405("01/01/2022",255806169)) + "%");
//
//        System.out.println(sep);
//
//        System.out.println("US406");
//        US406Controller us406 = new US406Controller();
//        System.out.println((us406.getUS406(70)));
//
//        System.out.println(sep);
//
//        System.out.println("US407");
//        US407Controller us407 = new US407Controller();
//        System.out.println((us407.getUS407("01/01/2022")));
//
//        System.out.println(sep);
//
//        System.out.println("US412");
//        CalculateEnergyController ces = new CalculateEnergyController();
//        System.out.println("Energy for a container of 7ºC: "+Math.round(ces.getEnergy(0.15,1.09,3.85E-5,20,7,9000))+"J");
//        System.out.println("Energy for a container of -5ºC: "+Math.round(ces.getEnergy(0.15,1.43,3.85E-5,20,-5,9000))+"J");
//
//        System.out.println(sep);
//
//        System.out.println("US413");
//        US413Controller us413 = new US413Controller();
//        System.out.println("Quantos contentores refrigerados a 7ºC?");
//        System.out.println("Quantos contentores a -5ºC? ");
//        System.out.println("A soma dos contentores não pode exceder 24000!");
//        System.out.println(us413.getTotalEnergy(13200, 10000));
//
//        System.out.println(sep);
//
//        System.out.println("US414");
//        US414_US415 us414 = new US414_US415();
//        Map<Double, Double> m = new HashMap<>();
//        m.put(20.1, 1.2);
//        m.put(14.2, 1.5);
//        m.put(-5.1, 2.3);
//        m.put(25.2, 4.9);
//        System.out.println("Necessary energy for 7ºC containers: " + us414.getEnergy7C(10, m) + " Kw");
//        System.out.println("Necessary energy for -5ºC containers: " + us414.getEnergy5C(10, m) + " Kw");
//        System.out.println("Necessary energy for 7ºC exposed containers: " + us414.getEnergyExposedContainers7C(5,3,4,m) + " Kw");
//        System.out.println("Necessary energy for -5ºC exposed containers: " + us414.getEnergyExposedContainers5C( 5,3,4,m) + " Kw");
//
//        System.out.println(sep);
//
//        System.out.println("US415");
//        System.out.println("Number of power equipments necessary: " + us414.getNumberOfPowerEquipmentNecessary(1.5, 300));
//
//        System.out.println(sep);
//
//        System.out.println("US418");
//        CenterOfMassController coms = new CenterOfMassController();
//        System.out.println("Center of mass X: "+Math.round(coms.getCenterOfMass(750,17000,750,15,200,385)));
//        System.out.println("Center of mass Y: "+Math.round(coms.getCenterOfMass(750,17000,750,25,25,25)));
//
//        System.out.println(sep);
//
//        System.out.println("US419");
//        US419Controller us419 = new US419Controller();
//        System.out.println("Qual dos contentores quer saber a informação? (1 - 1 TEU) (2 - 2 TEU)");
//        System.out.println(us419.getContainersInfo(1));
//
//        System.out.println(sep);
//
//        System.out.println("US420");
//        US420 us420 = new US420();
//        int a = us420.calculateTotalMassPlaced(15000);
//        System.out.println("The total mass placed on the vessel is " + a + " Kg.");
//        System.out.println("The ship sinked " + us420.calculateVesselSink(109000000, 400, 50, a) + " Metres.");
//        System.out.println("The pressure exerced on the water was " + us420.pressureExertedInWater(109000000, a) + " P.");
//    }
        }
        System.out.println("Hello");
    }
}