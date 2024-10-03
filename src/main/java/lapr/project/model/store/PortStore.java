package lapr.project.model.store;

import lapr.project.model.KdTree;
import lapr.project.model.Ports;

/**
 * @author Mateus Fernandes
 */
public class PortStore {
    private KdTree<Ports> kd;
    /**
     * Constructor method
     */
    public PortStore(){
        kd = new KdTree<>();
    }
    /**
     * Method that returns the KdTree stored in the store
     */
    public KdTree<Ports> getPortStore(){
        return kd;
    }
    /**
     * Method that inserts a port and returns KdTree
     *
     * @param lat Latitude of port
     * @param lon Longitude of port
     * @param port Information about port
     */
    public KdTree<Ports> insert(Ports port,double lat, double lon){
        kd.insert(port,lat,lon);
        return kd;
    }
    /**
     * Method that balances the KdTree
     */
    public KdTree<Ports> balanceTree(){
        kd.balanceTree();
        return kd;
    }
}
