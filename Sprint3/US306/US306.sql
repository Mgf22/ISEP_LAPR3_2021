create or replace function OccupancyWare(n varchar) return varchar is
res varchar(1000);
type number_array is varray(10000) of number;
occupancy_array number_array;
cursor c1 is
select (count(id_container_manifest)/avg(capacity))*100 from facility_container fc, facility f where fc.id_facility = f.id_facility and f.id_type_facility = 2 group by f.id_facility;
begin
open c1;
fetch c1 bulk collect into occupancy_array;
close c1;
for indx in occupancy_array.first..occupancy_array.last loop
   res:= res ||chr(10) || ' Occupancy of Warehouse: ' || occupancy_array(indx);
   end loop;
return res;
end;

create or replace function CountContainer(n varchar) return varchar is
res varchar(1000);
type number_array is varray(10000) of number;
count_array number_array;
cursor c1 is
select count(c.id_container_manifest) 
from container_manifest c, facility_container fc, facility f, manifest_load_unload mlu
where f.id_facility = fc.id_facility 
and fc.id_container_manifest = c.id_container_manifest 
and c.id_manifest_lu = mlu.id_manifest_lu 
and mlu.id_type_manifest = 1 
and mlu.date_manifest <= sysdate + 30
group by f.id_facility;
begin
open c1;
fetch c1 bulk collect into count_array;
close c1;
for indx in count_array.first..count_array.last loop
    res:= res ||chr(10) || ' Number of containers leaving the warehouse in the next 30 days: ' || count_array(indx);
   end loop;
return res;
end;

