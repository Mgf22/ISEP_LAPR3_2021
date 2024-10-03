create FUNCTION US407(data in varchar2)
    RETURN varchar
AS
    information varchar(10000);
dataAux     Manifest_travel.date_manifest%type;
    name        varchar(100);
    c           varchar(100);
    tipo        varchar(100);
    truck       varchar(100);
    ship        varchar(100);
BEGIN
    dataAux := TO_DATE(data, 'DD/MM/YYYY');
FOR cont IN 1..7
        loop
            dataAux := dataAux + 1;
SELECT COUNT(cm.id_container_manifest) INTO c
FROM Container_manifest cm, Manifest_load_unload mlu, Facility f, Manifest_travel mt, Vehicle v, Truck t
WHERE cm.id_manifest_lu = mlu.id_manifest_lu AND mlu.id_facility = f.id_facility AND mlu.id_manifest_travel = mt.id_manifest_travel
  AND mt.id_vehicle = v.id_vehicle AND t.id_vehicle = v.id_vehicle AND mlu.date_manifest = dataAux AND v.id_type_vehicle = 1;

IF(c > 0) THEN
SELECT f.name, t.truck, tm.type_manifest INTO name, truck, tipo
FROM Container_manifest cm, Manifest_load_unload mlu, Facility f, Manifest_travel mt, Vehicle v, Truck t, Type_manifest tm
WHERE cm.id_manifest_lu = mlu.id_manifest_lu AND mlu.id_facility = f.id_facility AND mlu.id_manifest_travel = mt.id_manifest_travel
  AND mt.id_vehicle = v.id_vehicle AND t.id_vehicle = v.id_vehicle AND mlu.date_manifest = dataAux
  AND mlu.id_type_manifest = tm.id_type_manifest AND v.id_type_vehicle = 1
GROUP BY f.name, t.truck, tm.type_manifest;

information := information || 'Facility: ' || name || ', Truck: ' || truck || ', Containers: ' || c || ', Type Manifest: ' || tipo || ', Date: ' || to_char(dataAux,'DD/MM/YYYY') || chr(10);
end if;

SELECT COUNT(cm.id_container_manifest) INTO c
FROM Container_manifest cm, Manifest_load_unload mlu, Facility f, Manifest_travel mt, Vehicle v, Ship s
WHERE cm.id_manifest_lu = mlu.id_manifest_lu AND mlu.id_facility = f.id_facility AND mlu.id_manifest_travel = mt.id_manifest_travel
  AND mt.id_vehicle = v.id_vehicle AND s.id_vehicle = v.id_vehicle AND mlu.date_manifest = dataAux AND v.id_type_vehicle = 2;

IF(c > 0) THEN
SELECT f.name, s.ship_name, tm.type_manifest INTO name, ship, tipo
FROM Container_manifest cm, Manifest_load_unload mlu, Facility f, Manifest_travel mt, Vehicle v, Ship s, Type_manifest tm
WHERE cm.id_manifest_lu = mlu.id_manifest_lu AND mlu.id_facility = f.id_facility AND mlu.id_manifest_travel = mt.id_manifest_travel
  AND mt.id_vehicle = v.id_vehicle AND s.id_vehicle = v.id_vehicle AND mlu.date_manifest = dataAux
  AND mlu.id_type_manifest = tm.id_type_manifest AND v.id_type_vehicle = 2
GROUP BY f.name, s.ship_name, tm.type_manifest;

information := information || 'Facility: ' || name || ', Ship: ' || Ship || ', Containers: ' || c || ', Type Manifest: ' || tipo || ', Date: ' || to_char(dataAux,'DD/MM/YYYY') || chr(10);
end if;
end loop;
return information;
END;
/

