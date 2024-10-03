create FUNCTION US406(a int)
    RETURN varchar
AS
    idTrip          Integer;
dateAux         Manifest_travel.date_manifest%type;
    mmsi            Ship.id_mmsi%type;
    aux             Integer;
    information     varchar(10000);
    placeOrigin     varchar(100);
    placeDest       varchar(100);
    dateOrigin      Manifest_travel.date_manifest%type;
    dateDest        Manifest_travel.date_manifest%type;

cursor cIdTrip is
SELECT DISTINCT mt.id_manifest_travel, mlu.date_manifest FROM Manifest_travel mt, Manifest_load_unload mlu
WHERE mt.id_manifest_travel = mlu.id_manifest_travel AND id_type_manifest = 2
  AND mlu.date_manifest < SYSDATE ORDER BY mlu.date_manifest DESC FETCH FIRST 1 ROWS ONLY;

BEGIN
open cIdTrip;
LOOP
fetch cIdTrip into idTrip, dateAux;
        exit when cIdTrip%notfound;

SELECT mt.date_manifest, s.id_mmsi INTO dateAux, mmsi FROM Manifest_travel mt, Vehicle v, Ship s
WHERE mt.id_vehicle = v.id_vehicle AND s.id_vehicle = v.id_vehicle AND mt.id_manifest_travel = idTrip;

aux := TO_NUMBER(OCCUPANCYMANIFEST(dateAux, mmsi));

        if aux < a then
SELECT DISTINCT date_manifest INTO dateDest FROM Manifest_load_unload
WHERE id_manifest_travel = idTrip ORDER BY date_manifest DESC;

SELECT DISTINCT date_manifest INTO dateOrigin FROM Manifest_load_unload
WHERE id_manifest_travel = idTrip ORDER BY date_manifest ASC;

SELECT name INTO placeDest FROM Manifest_travel mt, Facility
WHERE id_manifest_travel = idTrip AND id_departure = id_facility;
SELECT name INTO placeOrigin FROM Manifest_travel mt, Facility
WHERE id_manifest_travel = idTrip AND id_arrival = id_facility;

information := information || 'Origin: ' || placeOrigin || ', Date: ' || to_char(dateOrigin,'DD/MM/YYYY') || ' -> Destination: ' || placeDest || ', Date: ' || to_char(dateDest,'DD/MM/YYYY') || chr(10);

end if;
END LOOP;
close cIdTrip;
return information;
END;
/

