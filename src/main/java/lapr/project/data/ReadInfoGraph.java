package lapr.project.data;

import lapr.project.model.PairPorts;
import lapr.project.model.PortsGraph;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ReadInfoGraph {
    public ReadInfoGraph(){
        //Empty
    }

    public List<PairPorts> getSeaDist(){
        List<PairPorts> al = new ArrayList<>();

        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT (SELECT name FROM Facility WHERE sd.id_facility1 = id_facility) Port1, " +
                    "(SELECT name FROM Facility f WHERE sd.id_facility2 = id_facility) Port2, " +
                    "(SELECT country FROM Facility f, Country c, City ct WHERE sd.id_facility1 = id_facility AND f.id_country = c.id_country AND ct.id_country = c.id_country) Country1, " +
                    "(SELECT country FROM Facility f, Country c, City ct WHERE sd.id_facility2 = id_facility AND f.id_country = c.id_country AND ct.id_country = c.id_country) Country2, sea_dist " +
                    "FROM Sea_dist sd";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        al.add(new PairPorts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public Map<PortsGraph, ArrayList<PortsGraph>> getCapitalPorts(){
        Map<PortsGraph, ArrayList<PortsGraph>> mapa = new HashMap<>();

        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            ArrayList<PortsGraph> al;
            String sql = "SELECT c.id_country, continent, city, lat, lon, country FROM City ct, Country c, Continent con WHERE ct.id_country = c.id_country AND c.id_continent = con.id_continent AND capital = 'Y'";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        sql = "SELECT name, lon, lat FROM Facility WHERE id_type_facility = 1 AND id_country = " + rs.getString(1);
                        try (PreparedStatement ps1 = con.prepareStatement(sql)) {
                            try (ResultSet rs1 = ps1.executeQuery()) {
                                al = new ArrayList<>();
                                while(rs1.next()){
                                    al.add(new PortsGraph("Port", rs1.getString(1), rs.getString(2), rs.getString(6), rs1.getDouble(2), rs1.getDouble(3)));
                                }
                                mapa.put(new PortsGraph("Capital", rs.getString(3), rs.getString(2), rs.getString(6), rs.getDouble(4), rs.getDouble(5)), al);
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapa;
    }

    public Map<PortsGraph, ArrayList<PortsGraph>> getFrontiers(){
        Map<PortsGraph, ArrayList<PortsGraph>> mapa = new HashMap<>();

        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            ArrayList<PortsGraph> al = new ArrayList<>();
            PortsGraph pg;

            String sql = "SELECT (SELECT city FROM City ct, Country c WHERE ct.capital = 'Y' AND ct.id_country = c.id_country AND f.id_country_1 = c.id_country) city1, " +
                    "(SELECT continent FROM City ct, Country c, Continent con WHERE ct.capital = 'Y' AND ct.id_country = c.id_country AND f.id_country_1 = c.id_country AND c.id_continent = con.id_continent) continent1, " +
                    "(SELECT lat FROM City ct, Country c WHERE ct.capital = 'Y' AND ct.id_country = c.id_country AND f.id_country_1 = c.id_country) lat1, " +
                    "(SELECT lon FROM City ct, Country c WHERE ct.capital = 'Y' AND ct.id_country = c.id_country AND f.id_country_1 = c.id_country) lon1, " +
                    "(SELECT country FROM City ct, Country c WHERE ct.capital = 'Y' AND ct.id_country = c.id_country AND f.id_country_1 = c.id_country) country1, " +
                    "city city2, continent continent2, lat lat2, lon lon2, country country2 " +
                    "FROM Frontier f, City ct, Country c, Continent con " +
                    "WHERE ct.id_country = c.id_country AND f.id_country_2 = c.id_country AND c.id_continent = con.id_continent";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    pg = new PortsGraph("Capital", rs.getString(1), rs.getString(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4));
                    al.add(new PortsGraph("Capital", rs.getString(6), rs.getString(7),rs.getString(10), rs.getDouble(8), rs.getDouble(9)));
                    while(rs.next()){
                        if(!pg.getName().equals(rs.getString(1))){
                            mapa.put(pg, al);
                            al = new ArrayList<>();
                            pg = new PortsGraph("Capital", rs.getString(1), rs.getString(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4));
                            al.add(new PortsGraph("Capital", rs.getString(6), rs.getString(7),rs.getString(10), rs.getDouble(8), rs.getDouble(9)));
                        }else{
                            al.add(new PortsGraph("Capital", rs.getString(6), rs.getString(7),rs.getString(10), rs.getDouble(8), rs.getDouble(9)));
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapa;
    }
}