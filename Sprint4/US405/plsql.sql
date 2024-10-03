create or replace function OccupancyManifest (d in varchar2, sh in varchar2) return varchar is
res varchar(1000);
contentores int;
manifestos int;
begin
    SELECT COUNT (id_manifest_travel) INTO manifestos FROM manifest_travel, vehicle, ship s
    WHERE manifest_travel.id_vehicle = vehicle.id_vehicle
    AND vehicle.id_vehicle = s.id_vehicle
    AND s.id_mmsi = sh
    AND date_manifest = TO_DATE(d, 'DD/MM/YYYY');

    SELECT COUNT (cm.id_container_manifest) INTO contentores FROM container_manifest cm, ship_container sc, vehicle v, ship s, manifest_load_unload mlu
    WHERE cm.id_container_manifest = sc.id_container_manifest
    AND sc.id_vehicle = v.id_vehicle
    AND v.id_vehicle = s.id_vehicle
    AND s.id_mmsi = sh
    AND cm.id_manifest_lu = mlu.id_manifest_lu
    AND mlu.id_manifest_travel IN (SELECT mt.id_manifest_travel
    FROM manifest_travel mt, vehicle, ship
    WHERE mt.id_vehicle = vehicle.id_vehicle
    AND vehicle.id_vehicle = ship.id_vehicle
    AND mt.date_manifest = TO_DATE(d, 'DD/MM/YYYY'));

    IF (manifestos = 0) THEN
        return 0;
    END IF;
    res:=(contentores / manifestos) * 100;
return res;
end;