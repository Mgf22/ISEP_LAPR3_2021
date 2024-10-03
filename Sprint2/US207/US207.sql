SELECT COUNT(id_container)
FROM MANIFEST_CONT
WHERE id_container IN (
SELECT (id_container)
FROM MANIFEST_LU, MANIFEST_TRAVEL, LOAD_UNLOAD, MANIFEST_CONT, SHIP_CONTAINER, VEHICLE, WORKER_VEHICLE
WHERE manifest_lu.id_load_unload = load_unload.id_load_unload
AND manifest_cont.id_manifest_lu = manifest_lu.id_manifest_lu
AND manifest_lu.id_manifest_travel = manifest_travel.id_manifest_travel
AND load_unload.id_load_unload = 1
AND manifest_cont.id_manifest_cont = ship_container.id_manifest_cont
AND ship_container.id_vehicle = vehicle.id_vehicle
AND vehicle.id_vehicle = worker_vehicle.id_vehicle
AND worker_vehicle.id_worker = 7
AND date_manifest_tr <= TO_DATE('2021-12-31','YYYY-MM-DD') AND date_manifest_tr >= TO_DATE('2021-01-01','YYYY-MM-DD'))

SELECT COUNT (id_manifest_travel)
FROM manifest_travel, vehicle, worker_vehicle
WHERE (date_manifest_tr >= TO_DATE('2021-01-01','YYYY-MM-DD') and date_manifest_tr <= TO_DATE('2021-12-31','YYYY-MM-DD'))
AND manifest_travel.id_vehicle = vehicle.id_vehicle
AND vehicle.id_vehicle = worker_vehicle.id_vehicle
AND worker_vehicle.id_worker = 7
