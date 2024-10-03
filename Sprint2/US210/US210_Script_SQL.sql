SELECT id_mmsi,lat,lon 
FROM ship_dynamic 
WHERE next_Day('21.12.13','Segunda-feira') = date_time AND lat IN (SELECT lat FROM port_ware) AND lon IN (SELECT lon FROM port_ware);

