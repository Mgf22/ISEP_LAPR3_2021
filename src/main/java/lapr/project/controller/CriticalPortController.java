package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.CriticalPort;
import lapr.project.model.PortsGraph;
import lapr.project.model.store.GraphStore;
import java.util.*;

public class CriticalPortController {
    GraphStore a;

    public CriticalPortController(){
        a = App.getInstance().getCompany().getGraphStore();
    }

    public List<Map.Entry<PortsGraph, Integer>> returnCritical (int n){
        CriticalPort b = new CriticalPort();
        Map<PortsGraph, Integer> mapa = b.returnCritical(a.getGraphStore(), n);
        Set<Map.Entry<PortsGraph, Integer>> set = mapa.entrySet();
        List<Map.Entry<PortsGraph, Integer>> list = new ArrayList<Map.Entry<PortsGraph, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<PortsGraph, Integer>>() {
            @Override
            public int compare(Map.Entry<PortsGraph, Integer> o1, Map.Entry<PortsGraph, Integer> o2) {

                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list.subList(0,n);
    }
}
