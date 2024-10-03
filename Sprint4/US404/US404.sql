create or replace function IdleDays(ano int,mmsi varchar) return varchar is
res varchar(1000);
cont int;
type date1_array is varray(10000) of date;
type date2_array is varray(10000) of date;
array1 date1_array;
array2 date2_array;
cursor c1 is
select mlu.date_manifest 
from manifest_load_unload mlu, manifest_travel mt, vehicle v, ship s 
where mlu.id_type_manifest = 1 
and extract(year from mlu.date_manifest) = ano 
and mlu.id_manifest_travel = mt.id_manifest_travel 
and mt.id_vehicle = v.id_vehicle 
and v.id_vehicle = s.id_vehicle 
and s.id_mmsi = mmsi;
cursor c2 is
select mlu.date_manifest 
from manifest_load_unload mlu, manifest_travel mt, vehicle v, ship s 
where id_type_manifest = 2 
and extract(year from mlu.date_manifest) = ano 
and mlu.id_manifest_travel = mt.id_manifest_travel 
and mt.id_vehicle = v.id_vehicle 
and v.id_vehicle = s.id_vehicle 
and s.id_mmsi = mmsi;
begin
open c1;
fetch c1 bulk collect into array1;
close c1;
open c2;
fetch c2 bulk collect into array2;
close c2; 
for i in array1.first..array1.last loop
for j in array2.first..array2.last loop
    if i=j then 
    cont:= array1(i) - array2(j);
    cont:= cont + cont;
    end if;
end loop;
end loop;
res := 'Days the ship '|| mmsi ||' has been idle in the year ' || ano ||': ' || cont;
return res;
end;