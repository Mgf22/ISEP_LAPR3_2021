create or replace function displaywarning(id_cont in varchar2,id_client in number)
return varchar2
is
invalid varchar2(70);
BEGIN
for rec in (SELECT id_container,id_client FROM container_manifest cm) loop 
    if id_cont = rec.id_container and id_client != rec.id_client then
    invalid := '(11 - container is not leased by client) Id_Container: ' || id_cont;
    else 
    invalid := '(10 - invalid container id) Id_Container: ' || id_cont;
    end if;
    end loop;
return invalid;
end;