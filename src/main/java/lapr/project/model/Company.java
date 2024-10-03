package lapr.project.model;

import lapr.project.controller.US419Controller;
import lapr.project.data.*;
import lapr.project.model.store.GraphStore;
import lapr.project.model.store.PortStore;
import lapr.project.model.store.ShipStore;
/**
 * @author Jorge Lima
 */
public class Company {
    private ShipStore ss;
    private PortStore ps;
    private ContainersStore cs;
    private OccupancyRateStore ors;
    private AvailableShipStore ass;
    private LoadedContainers lc;
    private OccupancyRateTimeStore orts;
    private FindContainerStore fcs;
    private ManifestTransportStore mts;
    private GraphStore gs;
    private OccupancyWarehouseStore ow;
    private InsertFrontierStore ifs;
    private InsertCountryStore ics;
    private InsertSeaDistStore isds;
    private InsertFacilityStore ifas;
    private InsertCityStore icis;
    private InvalidContainerStore icos;
    private AuditTrailsStore ats;
    private US310 US310;
    private RouteContainerStore rcs;
    private ContainerMaterialsStore cms;
    private US405 US405;
    private US419Store US419store;
    private CenterOfMassStore coms;
    private CalculateEnergyStore ces;
    private US413Store us413Store;
    private IdleShipsStore iss;
    private US407 us407;
    private US406 us406;

    /**
     * Constructor method
     */
    public Company(){
        ss = new ShipStore();
        ps = new PortStore();
        cs = new ContainersStore();
        ors = new OccupancyRateStore();
        ass = new AvailableShipStore();
        lc = new LoadedContainers();
        orts = new OccupancyRateTimeStore();
        fcs = new FindContainerStore();
        mts = new ManifestTransportStore();
        ow = new OccupancyWarehouseStore();
        gs = new GraphStore();
        ifs = new InsertFrontierStore();
        ics = new InsertCountryStore();
        isds = new InsertSeaDistStore();
        ifas = new InsertFacilityStore();
        icis = new InsertCityStore();
        icos = new InvalidContainerStore();
        ats = new AuditTrailsStore();
        US310 = new US310();
        cms = new ContainerMaterialsStore();
        rcs = new RouteContainerStore();
        US405 = new US405();
        US419store = new US419Store();
        coms = new CenterOfMassStore();
        ces = new CalculateEnergyStore();
        us413Store = new US413Store();
        iss = new IdleShipsStore();
        us407 = new US407();
        us406 = new US406();
    }
    /**
     * Method to get the ship store
     *
     * @return returns the ship store
     */
    public ShipStore getShipStore(){
        return ss;
    }
    /**
     * Method to get the port store
     *
     * @return returns the port store
     */
    public PortStore getPortStore(){ return ps; }
    /**
     * Method to get the container store
     *
     * @return returns the container store
     */
    public ContainersStore getContainersStore(){ return cs; }
    /**
     * Method to get the occupancy rate store
     *
     * @return returns the occupancy rate store
     */
    public OccupancyRateStore getOccupancyRateStore(){return ors;}
    /**
     * Method to get the available ship store
     *
     * @return returns the available ship store
     */
    public AvailableShipStore getAvailableShipStore(){return ass;}
    /**
     * Method to get the loaded containers store
     *
     * @return returns the loaded containers store
     */
    public LoadedContainers getLoadedContainers(){return lc;}
    /**
     * Method to get the occupancy rate time store
     *
     * @return returns the occupancy rate time store
     */
    public OccupancyRateTimeStore getOccupancyRateTimeStore(){return orts;}
    /**
     * Method to get the container store
     *
     * @return returns the container store
     */
    public FindContainerStore getContainer(){return fcs;}
    /**
     * Method to get the manifest transport store
     *
     * @return returns the manifest transport store
     */
    public ManifestTransportStore getManifestTransport(){return mts;}
    /**
     * Method to get the occupancy warehouse store
     *
     * @return returns the occupancy warehouse store
     */
    public OccupancyWarehouseStore getOccupancyWarehouseStore(){return ow;}
    /**
     * Method to get the graph store
     *
     * @return returns the graph store
     */
    public GraphStore getGraphStore(){return gs;}
    /**
     * Method to get the insert frontier store
     *
     * @return returns the insert frontier store
     */
    public InsertFrontierStore getInsertFrontierStore(){return ifs;}
    /**
     * Method to get the insert country store
     *
     * @return returns the insert country store
     */
    public InsertCountryStore getInsertCountryStore(){return ics;}
    /**
     * Method to get the insert sea distance store
     *
     * @return returns the insert sea distance store
     */
    public InsertSeaDistStore getInsertSeaDistStore(){return isds;}
    /**
     * Method to get the insert facility store
     *
     * @return returns the insert facility store
     */
    public InsertFacilityStore getInsertFacilityStore(){return ifas;}
    /**
     * Method to get the insert city store
     *
     * @return returns the insert city store
     */
    public InsertCityStore getInsertCityStore(){return icis;}
    /**
     * Method to return if a container is valid or not leased by a client
     *
     * @return returns the code of the warning and the identifier of the container
     */
    public InvalidContainerStore getInvalidContainerStore(){return icos;}
    /**
     * Method that returns the audit trails of a container
     *
     * @return returns the operations made on a container
     */
    public AuditTrailsStore getAuditTrailsStore(){return ats;}
    /**
     * Method that returns US310 store
     *
     * @return returns US310 store
     */
    public US310 getUS310(){return US310;}
   // public ShipOccupationStore getShipOccupationStore(){return sos;}
    /**
     * Method that returns container materials store and returns the thermal resistance of the container
     *
     * @return returns the thermal resistance of the container
     */
    public ContainerMaterialsStore getContainerMaterialsStore(){return cms;}
    /**
     * Method to return the route of a container
     *
     * @return returns the route of a container or a warning
     */
    public RouteContainerStore getRouteContainerStore(){return rcs;}
    /**
     * Method that returns the occupancy rate per cargo manifest of a given ship on a given date
     *
     * @return returns the occupancy rate per cargo manifest of a given ship on a given date
     */
    public US405 getUS405(){return US405;}
    /**
     * Method that returns area, volume and center of mass of a container
     *
     * @return returns area, volume and center of mass of a container
     */
    public US419Store getUS419store(){return US419store;}
    /**
     * Method that returns center of mass store and returns the center of mass of the ship
     *
     * @return returns the center of mass
     */
    public CenterOfMassStore getCenterOfMassStore(){return coms;}
    /**
     * Method that returns calculate energy store and returns the energu necessary to supply for a container
     *
     * @return returns the energy necessary for a container
     */
    public CalculateEnergyStore getEnergy(){return ces;}
    /**
     * Method that returns calculate the total energy needed to feed a set of containers
     *
     * @return returns the energy necessary for a set of containers
     */
    public US413Store getTotalEnergy(){return us413Store;}
    /**
     * Method that returns the days a ship has been idle
     *
     * @return returns the days a ship has been idle
     */
    public IdleShipsStore getIdleShipStore(){return iss;}
    /**
     * Method that returns us407 store
     *
     * @return returns us407 store
     */
    public US407 getUs407(){return us407;}
    /**
     * Method that returns us406 store
     *
     * @return returns us406 store
     */
    public US406 getUs406(){return us406;}
    /**
     * Method to reset stores
     */
    public void resetStores(){
        ss = new ShipStore();
        ps = new PortStore();
    }
}
