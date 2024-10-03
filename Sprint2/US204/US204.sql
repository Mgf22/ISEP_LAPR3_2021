SELECT (port_ware.name)
FROM CONTAINER, MANIFEST_CONT, MANIFEST_LU, PORT_WARE, LOAD_UNLOAD
WHERE container.id_container = manifest_cont.id_container
AND manifest_cont.id_manifest_lu = manifest_lu.id_manifest_lu
AND manifest_lu.id_port_ware = port_ware.id_port_ware
AND manifest_lu.id_load_unload = load_unload.id_load_unload
AND load_unload.id_load_unload = 2
AND container.id_container = 'POLK3597847'
AND manifest_lu.date_manifest <= CURRENT_DATE

SELECT (ship.ship_name)
FROM CONTAINER, MANIFEST_CONT, MANIFEST_LU, SHIP_CONTAINER, VEHICLE, SHIP, LOAD_UNLOAD
WHERE container.id_container = manifest_cont.id_container
AND manifest_cont.id_manifest_lu = manifest_lu.id_manifest_lu
AND manifest_lu.id_load_unload = load_unload.id_load_unload
AND load_unload.id_load_unload = 1
AND manifest_cont.id_manifest_cont = ship_container.id_manifest_cont
AND ship_container.id_vehicle = vehicle.id_vehicle
AND vehicle.id_vehicle = ship.id_vehicle
AND container.id_container = 'BICJ5697847'