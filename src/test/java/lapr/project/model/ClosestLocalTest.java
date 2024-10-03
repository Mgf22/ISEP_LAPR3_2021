package lapr.project.model;

import lapr.project.controller.ClosestLocalController;
import lapr.project.controller.ReadGraphController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestLocalTest {

    @Test
    void returnClosest() {/*
        ReadGraphController rgc = new ReadGraphController();
        rgc.read(10);
        ClosestLocalController clc = new ClosestLocalController();
        String str = "Europa: \n" +
                "Origin: Pristina (Capital)\n" +
                "        Skopje - Distance: 75 Km\n" +
                "        Tirana - Distance: 205 Km\n" +
                "        Podgorica - Distance: 212 Km\n" +
                "Origin: Vilnius (Capital)\n" +
                "        Minsk - Distance: 262 Km\n" +
                "        Riga - Distance: 265 Km\n" +
                "        Tallinn - Distance: 525 Km\n" +
                "Origin: Horta Port (Port)\n" +
                "        Funchal Port - Distance: 0 Km\n" +
                "        Leixoes Port - Distance: 0 Km\n" +
                "        Setubal Port - Distance: 0 Km\n" +
                "Origin: Valletta (Capital)\n" +
                "        Marsaxlokk Port - Distance: 3185 Km\n" +
                "        Genoa Port - Distance: 3775 Km\n" +
                "        Venice Port - Distance: 3775 Km\n" +
                "Origin: Lisbon (Capital)\n" +
                "        Madrid - Distance: 633 Km\n" +
                "        Paris - Distance: 1787 Km\n" +
                "        Brussels - Distance: 2098 Km\n" +
                "Origin: Minsk (Capital)\n" +
                "        Vilnius - Distance: 262 Km\n" +
                "        Kyiv - Distance: 470 Km\n" +
                "        Riga - Distance: 491 Km\n" +
                "Origin: Dublin (Capital)\n" +
                "        London - Distance: 712 Km\n" +
                "        London Port - Distance: 8196 Km\n" +
                "        Liverpool Port - Distance: 8196 Km\n" +
                "Origin: Tallinn Port (Port)\n" +
                "        Kotka Port - Distance: 48 Km\n" +
                "        Helsinki Port - Distance: 48 Km\n" +
                "        Kaliningrad Port - Distance: 154 Km\n" +
                "Origin: Batumi Port (Port)\n" +
                "        Poti Port - Distance: 0 Km\n" +
                "        Tbilisi - Distance: 300 Km\n" +
                "        Feodosia Port - Distance: 324 Km\n" +
                "Origin: Tallinn (Capital)\n" +
                "        Riga - Distance: 260 Km\n" +
                "        Vilnius - Distance: 525 Km\n" +
                "        Minsk - Distance: 751 Km\n" +
                "Origin: Tbilisi (Capital)\n" +
                "        Yerevan - Distance: 125 Km\n" +
                "        Poti Port - Distance: 300 Km\n" +
                "        Batumi Port - Distance: 300 Km\n" +
                "Origin: Madrid (Capital)\n" +
                "        Lisbon - Distance: 633 Km\n" +
                "        Paris - Distance: 1154 Km\n" +
                "        Brussels - Distance: 1465 Km\n" +
                "Origin: Piran Port (Port)\n" +
                "        Genoa Port - Distance: 60 Km\n" +
                "        Venice Port - Distance: 60 Km\n" +
                "        Split Port - Distance: 106 Km\n" +
                "Origin: Lysekil Port (Port)\n" +
                "        Stockholm Port - Distance: 0 Km\n" +
                "        Aarhus Port - Distance: 174 Km\n" +
                "        Copenhagen Port - Distance: 174 Km\n" +
                "Origin: Valencia Port (Port)\n" +
                "        Valencia Port - Distance: 0 Km\n" +
                "        Monaco Port - Distance: 272 Km\n" +
                "        Genoa Port - Distance: 352 Km\n" +
                "Origin: Bern (Capital)\n" +
                "        Vaduz - Distance: 229 Km\n" +
                "        Paris - Distance: 610 Km\n" +
                "        Rome - Distance: 782 Km\n" +
                "Origin: Podgorica (Capital)\n" +
                "        Tirana - Distance: 132 Km\n" +
                "        Sarajevo - Distance: 178 Km\n" +
                "        Pristina - Distance: 212 Km\n" +
                "Origin: Aarhus Port (Port)\n" +
                "        Copenhagen Port - Distance: 0 Km\n" +
                "        Rostock Port - Distance: 108 Km\n" +
                "        Hamburg Port - Distance: 108 Km\n" +
                "Origin: Stockholm Port (Port)\n" +
                "        Stockholm Port - Distance: 0 Km\n" +
                "        Aarhus Port - Distance: 174 Km\n" +
                "        Copenhagen Port - Distance: 174 Km\n" +
                "Origin: Luxembourg (Capital)\n" +
                "        Brussels - Distance: 240 Km\n" +
                "        Amsterdam - Distance: 420 Km\n" +
                "        Paris - Distance: 428 Km\n" +
                "Origin: Mersin Port (Port)\n" +
                "        Ambarli Port - Distance: 0 Km\n" +
                "        Larnaca Port - Distance: 140 Km\n" +
                "        Varna Port - Distance: 141 Km\n" +
                "Origin: Dublin Port (Port)\n" +
                "        London Port - Distance: 117 Km\n" +
                "        Liverpool Port - Distance: 117 Km\n" +
                "        Brest Port - Distance: 228 Km\n" +
                "Origin: Poti Port (Port)\n" +
                "        Poti Port - Distance: 0 Km\n" +
                "        Tbilisi - Distance: 300 Km\n" +
                "        Feodosia Port - Distance: 324 Km\n" +
                "Origin: Budapest (Capital)\n" +
                "        Bratislava - Distance: 229 Km\n" +
                "        Vienna - Distance: 311 Km\n" +
                "        Belgrade - Distance: 320 Km\n" +
                "Origin: Kaliningrad Port (Port)\n" +
                "        St Petersburg Port - Distance: 0 Km\n" +
                "        Gdansk Port - Distance: 67 Km\n" +
                "        Kotka Port - Distance: 106 Km\n" +
                "Origin: Ljubljana (Capital)\n" +
                "        Zagreb - Distance: 167 Km\n" +
                "        Vienna - Distance: 308 Km\n" +
                "        Bratislava - Distance: 391 Km\n" +
                "Origin: Reykjavik (Capital)\n" +
                "        Grundartangi Port - Distance: 12005 Km\n" +
                "        Bergen Port - Distance: 12892 Km\n" +
                "        Narvik Port - Distance: 12892 Km\n" +
                "Origin: Monaco (Capital)\n" +
                "        Paris - Distance: 801 Km\n" +
                "        Brussels - Distance: 1112 Km\n" +
                "        Luxembourg - Distance: 1229 Km\n" +
                "Origin: Prague (Capital)\n" +
                "        Berlin - Distance: 288 Km\n" +
                "        Vienna - Distance: 292 Km\n" +
                "        Bratislava - Distance: 360 Km\n" +
                "Origin: Narvik Port (Port)\n" +
                "        Narvik Port - Distance: 0 Km\n" +
                "        Lysekil Port - Distance: 330 Km\n" +
                "        Stockholm Port - Distance: 330 Km\n" +
                "Origin: London (Capital)\n" +
                "        Dublin - Distance: 712 Km\n" +
                "        London Port - Distance: 7484 Km\n" +
                "        Liverpool Port - Distance: 7484 Km\n" +
                "Origin: Barcelona Port (Port)\n" +
                "        Valencia Port - Distance: 0 Km\n" +
                "        Monaco Port - Distance: 272 Km\n" +
                "        Genoa Port - Distance: 352 Km\n" +
                "Origin: Setubal Port (Port)\n" +
                "        Funchal Port - Distance: 0 Km\n" +
                "        Leixoes Port - Distance: 0 Km\n" +
                "        Setubal Port - Distance: 0 Km\n" +
                "Origin: Tirana (Capital)\n" +
                "        Podgorica - Distance: 132 Km\n" +
                "        Skopje - Distance: 193 Km\n" +
                "        Pristina - Distance: 205 Km\n" +
                "Origin: Zagreb (Capital)\n" +
                "        Ljubljana - Distance: 167 Km\n" +
                "        Sarajevo - Distance: 338 Km\n" +
                "        Budapest - Distance: 387 Km\n" +
                "Origin: Vlore Port (Port)\n" +
                "        Split Port - Distance: 271 Km\n" +
                "        Rijeka Port - Distance: 271 Km\n" +
                "        Koper Port - Distance: 377 Km\n" +
                "Origin: St Petersburg Port (Port)\n" +
                "        St Petersburg Port - Distance: 0 Km\n" +
                "        Gdansk Port - Distance: 67 Km\n" +
                "        Kotka Port - Distance: 106 Km\n" +
                "Origin: Bergen Port (Port)\n" +
                "        Narvik Port - Distance: 0 Km\n" +
                "        Lysekil Port - Distance: 330 Km\n" +
                "        Stockholm Port - Distance: 330 Km\n" +
                "Origin: Marsaxlokk Port (Port)\n" +
                "        Genoa Port - Distance: 590 Km\n" +
                "        Venice Port - Distance: 590 Km\n" +
                "        Izola Port - Distance: 650 Km\n" +
                "Origin: Venice Port (Port)\n" +
                "        Venice Port - Distance: 0 Km\n" +
                "        Izola Port - Distance: 60 Km\n" +
                "        Koper Port - Distance: 60 Km\n" +
                "Origin: Copenhagen (Capital)\n" +
                "        Berlin - Distance: 353 Km\n" +
                "        Prague - Distance: 641 Km\n" +
                "        Vienna - Distance: 922 Km\n" +
                "Origin: Dunkirk Port (Port)\n" +
                "        Dunkirk Port - Distance: 0 Km\n" +
                "        Antwerp Port - Distance: 76 Km\n" +
                "        Zeebrugge Port - Distance: 76 Km\n" +
                "Origin: Rijeka Port (Port)\n" +
                "        Rijeka Port - Distance: 0 Km\n" +
                "        Izola Port - Distance: 106 Km\n" +
                "        Koper Port - Distance: 106 Km\n" +
                "Origin: Vienna (Capital)\n" +
                "        Bratislava - Distance: 83 Km\n" +
                "        Prague - Distance: 292 Km\n" +
                "        Ljubljana - Distance: 308 Km\n" +
                "Origin: Ambarli Port (Port)\n" +
                "        Ambarli Port - Distance: 0 Km\n" +
                "        Larnaca Port - Distance: 140 Km\n" +
                "        Varna Port - Distance: 141 Km\n" +
                "Origin: Athens (Capital)\n" +
                "        Sofia - Distance: 481 Km\n" +
                "        Skopje - Distance: 485 Km\n" +
                "        Tirana - Distance: 555 Km\n" +
                "Origin: Nicosia (Capital)\n" +
                "        Larnaca Port - Distance: 221 Km\n" +
                "        Mersin Port - Distance: 361 Km\n" +
                "        Ambarli Port - Distance: 361 Km\n" +
                "Origin: Brest Port (Port)\n" +
                "        Dunkirk Port - Distance: 0 Km\n" +
                "        Antwerp Port - Distance: 76 Km\n" +
                "        Zeebrugge Port - Distance: 76 Km\n" +
                "Origin: Helsinki Port (Port)\n" +
                "        Kotka Port - Distance: 0 Km\n" +
                "        Tallinn Port - Distance: 48 Km\n" +
                "        Kaliningrad Port - Distance: 106 Km\n" +
                "Origin: Hamburg Port (Port)\n" +
                "        Hamburg Port - Distance: 0 Km\n" +
                "        Aarhus Port - Distance: 108 Km\n" +
                "        Copenhagen Port - Distance: 108 Km\n" +
                "Origin: Constantza Port (Port)\n" +
                "        Galatz Port - Distance: 0 Km\n" +
                "        Bourgas Port - Distance: 76 Km\n" +
                "        Varna Port - Distance: 76 Km\n" +
                "Origin: Moscow (Capital)\n" +
                "        Kyiv - Distance: 927 Km\n" +
                "        Minsk - Distance: 1128 Km\n" +
                "        Chisinau - Distance: 1306 Km\n" +
                "Origin: Vlone Port (Port)\n" +
                "        Split Port - Distance: 271 Km\n" +
                "        Rijeka Port - Distance: 271 Km\n" +
                "        Koper Port - Distance: 377 Km\n" +
                "Origin: Galatz Port (Port)\n" +
                "        Galatz Port - Distance: 0 Km\n" +
                "        Bourgas Port - Distance: 76 Km\n" +
                "        Varna Port - Distance: 76 Km\n" +
                "Origin: Paris (Capital)\n" +
                "        Brussels - Distance: 311 Km\n" +
                "        Luxembourg - Distance: 428 Km\n" +
                "        Amsterdam - Distance: 491 Km\n" +
                "Origin: Skopje (Capital)\n" +
                "        Pristina - Distance: 75 Km\n" +
                "        Tirana - Distance: 193 Km\n" +
                "        Sofia - Distance: 220 Km\n" +
                "Origin: Izola Port (Port)\n" +
                "        Genoa Port - Distance: 60 Km\n" +
                "        Venice Port - Distance: 60 Km\n" +
                "        Split Port - Distance: 106 Km\n" +
                "Origin: Monaco Port (Port)\n" +
                "        Genoa Port - Distance: 86 Km\n" +
                "        Venice Port - Distance: 86 Km\n" +
                "        Koper Port - Distance: 146 Km\n" +
                "Origin: Amsterdam (Capital)\n" +
                "        Brussels - Distance: 180 Km\n" +
                "        Luxembourg - Distance: 420 Km\n" +
                "        Paris - Distance: 491 Km\n" +
                "Origin: Piraeus Port (Port)\n" +
                "        Aspropyrgos Port - Distance: 0 Km\n" +
                "        Mersin Port - Distance: 337 Km\n" +
                "        Ambarli Port - Distance: 337 Km\n" +
                "Origin: London Port (Port)\n" +
                "        Liverpool Port - Distance: 0 Km\n" +
                "        Brest Port - Distance: 111 Km\n" +
                "        Dunkirk Port - Distance: 111 Km\n" +
                "Origin: Stockholm (Capital)\n" +
                "        Helsinki - Distance: 770 Km\n" +
                "        Oslo - Distance: 814 Km\n" +
                "        Moscow - Distance: 2239 Km\n" +
                "Origin: Helsinki (Capital)\n" +
                "        Stockholm - Distance: 770 Km\n" +
                "        Moscow - Distance: 1469 Km\n" +
                "        Oslo - Distance: 1577 Km\n" +
                "Origin: Vaduz (Capital)\n" +
                "        Bern - Distance: 229 Km\n" +
                "        Vienna - Distance: 770 Km\n" +
                "        Paris - Distance: 839 Km\n" +
                "Origin: Gdansk Port (Port)\n" +
                "        St Petersburg Port - Distance: 67 Km\n" +
                "        Kaliningrad Port - Distance: 67 Km\n" +
                "        Kotka Port - Distance: 173 Km\n" +
                "Origin: Bourgas Port (Port)\n" +
                "        Varna Port - Distance: 0 Km\n" +
                "        Constantza Port - Distance: 76 Km\n" +
                "        Galatz Port - Distance: 76 Km\n" +
                "Origin: Riga (Capital)\n" +
                "        Tallinn - Distance: 260 Km\n" +
                "        Vilnius - Distance: 265 Km\n" +
                "        Minsk - Distance: 491 Km\n" +
                "Origin: Belgrade (Capital)\n" +
                "        Pristina - Distance: 237 Km\n" +
                "        Sarajevo - Distance: 252 Km\n" +
                "        Podgorica - Distance: 285 Km\n" +
                "Origin: Rostock Port (Port)\n" +
                "        Hamburg Port - Distance: 0 Km\n" +
                "        Aarhus Port - Distance: 108 Km\n" +
                "        Copenhagen Port - Distance: 108 Km\n" +
                "Origin: Feodosia Port (Port)\n" +
                "        Galatz Port - Distance: 307 Km\n" +
                "        Constantza Port - Distance: 307 Km\n" +
                "        Poti Port - Distance: 324 Km\n" +
                "Origin: Yerevan (Capital)\n" +
                "        Tbilisi - Distance: 125 Km\n" +
                "        Poti Port - Distance: 425 Km\n" +
                "        Batumi Port - Distance: 425 Km\n" +
                "Origin: Grundartangi Port (Port)\n" +
                "        Bergen Port - Distance: 887 Km\n" +
                "        Narvik Port - Distance: 887 Km\n" +
                "        Stockholm Port - Distance: 1217 Km\n" +
                "Origin: Funchal Port (Port)\n" +
                "        Funchal Port - Distance: 0 Km\n" +
                "        Leixoes Port - Distance: 0 Km\n" +
                "        Setubal Port - Distance: 0 Km\n" +
                "Origin: Bratislava (Capital)\n" +
                "        Vienna - Distance: 83 Km\n" +
                "        Budapest - Distance: 229 Km\n" +
                "        Prague - Distance: 360 Km\n" +
                "Origin: Koper Port (Port)\n" +
                "        Genoa Port - Distance: 60 Km\n" +
                "        Venice Port - Distance: 60 Km\n" +
                "        Split Port - Distance: 106 Km\n" +
                "Origin: Bucharest (Capital)\n" +
                "        Sofia - Distance: 356 Km\n" +
                "        Chisinau - Distance: 396 Km\n" +
                "        Skopje - Distance: 576 Km\n" +
                "Origin: Kotka Port (Port)\n" +
                "        Kotka Port - Distance: 0 Km\n" +
                "        Tallinn Port - Distance: 48 Km\n" +
                "        Kaliningrad Port - Distance: 106 Km\n" +
                "Origin: Brussels (Capital)\n" +
                "        Amsterdam - Distance: 180 Km\n" +
                "        Luxembourg - Distance: 240 Km\n" +
                "        Paris - Distance: 311 Km\n" +
                "Origin: Antwerp Port (Port)\n" +
                "        Zeebrugge Port - Distance: 0 Km\n" +
                "        Vlissingen Port - Distance: 37 Km\n" +
                "        Brest Port - Distance: 76 Km\n" +
                "Origin: Zeebrugge Port (Port)\n" +
                "        Zeebrugge Port - Distance: 0 Km\n" +
                "        Vlissingen Port - Distance: 37 Km\n" +
                "        Brest Port - Distance: 76 Km\n" +
                "Origin: Rome (Capital)\n" +
                "        Ljubljana - Distance: 502 Km\n" +
                "        Zagreb - Distance: 669 Km\n" +
                "        Bern - Distance: 782 Km\n" +
                "Origin: Liverpool Port (Port)\n" +
                "        Liverpool Port - Distance: 0 Km\n" +
                "        Brest Port - Distance: 111 Km\n" +
                "        Dunkirk Port - Distance: 111 Km\n" +
                "Origin: Kyiv (Capital)\n" +
                "        Chisinau - Distance: 379 Km\n" +
                "        Minsk - Distance: 470 Km\n" +
                "        Vilnius - Distance: 732 Km\n" +
                "Origin: Leixoes Port (Port)\n" +
                "        Funchal Port - Distance: 0 Km\n" +
                "        Leixoes Port - Distance: 0 Km\n" +
                "        Setubal Port - Distance: 0 Km\n" +
                "Origin: Sofia (Capital)\n" +
                "        Skopje - Distance: 220 Km\n" +
                "        Pristina - Distance: 295 Km\n" +
                "        Bucharest - Distance: 356 Km\n" +
                "Origin: Aspropyrgos Port (Port)\n" +
                "        Aspropyrgos Port - Distance: 0 Km\n" +
                "        Mersin Port - Distance: 337 Km\n" +
                "        Ambarli Port - Distance: 337 Km\n" +
                "Origin: Vlissingen Port (Port)\n" +
                "        Antwerp Port - Distance: 37 Km\n" +
                "        Zeebrugge Port - Distance: 37 Km\n" +
                "        Brest Port - Distance: 96 Km\n" +
                "Origin: Split Port (Port)\n" +
                "        Rijeka Port - Distance: 0 Km\n" +
                "        Izola Port - Distance: 106 Km\n" +
                "        Koper Port - Distance: 106 Km\n" +
                "Origin: Copenhagen Port (Port)\n" +
                "        Copenhagen Port - Distance: 0 Km\n" +
                "        Rostock Port - Distance: 108 Km\n" +
                "        Hamburg Port - Distance: 108 Km\n" +
                "Origin: Berlin (Capital)\n" +
                "        Prague - Distance: 288 Km\n" +
                "        Copenhagen - Distance: 353 Km\n" +
                "        Vienna - Distance: 569 Km\n" +
                "Origin: Oslo (Capital)\n" +
                "        Stockholm - Distance: 814 Km\n" +
                "        Helsinki - Distance: 1577 Km\n" +
                "        Moscow - Distance: 3014 Km\n" +
                "Origin: Varna Port (Port)\n" +
                "        Varna Port - Distance: 0 Km\n" +
                "        Constantza Port - Distance: 76 Km\n" +
                "        Galatz Port - Distance: 76 Km\n" +
                "Origin: Genoa Port (Port)\n" +
                "        Venice Port - Distance: 0 Km\n" +
                "        Izola Port - Distance: 60 Km\n" +
                "        Koper Port - Distance: 60 Km\n" +
                "Origin: Ankara (Capital)\n" +
                "        Mersin Port - Distance: 648 Km\n" +
                "        Ambarli Port - Distance: 648 Km\n" +
                "        Larnaca Port - Distance: 788 Km\n" +
                "Origin: Chisinau (Capital)\n" +
                "        Kyiv - Distance: 379 Km\n" +
                "        Bucharest - Distance: 396 Km\n" +
                "        Sofia - Distance: 752 Km\n" +
                "Origin: Ponta Delgada Port (Port)\n" +
                "        Funchal Port - Distance: 0 Km\n" +
                "        Leixoes Port - Distance: 0 Km\n" +
                "        Setubal Port - Distance: 0 Km\n" +
                "Origin: Larnaca Port (Port)\n" +
                "        Mersin Port - Distance: 140 Km\n" +
                "        Ambarli Port - Distance: 140 Km\n" +
                "        Nicosia - Distance: 221 Km\n" +
                "Origin: Sarajevo (Capital)\n" +
                "        Podgorica - Distance: 178 Km\n" +
                "        Belgrade - Distance: 252 Km\n" +
                "        Tirana - Distance: 310 Km\n" +
                "Origin: Warsaw (Capital)\n" +
                "        Vilnius - Distance: 540 Km\n" +
                "        Bratislava - Distance: 609 Km\n" +
                "        Vienna - Distance: 692 Km\n" +
                "\n" +
                "America:\n" +
                "Origin: Santos Port (Port)\n" +
                "        Salvador Port - Distance: 0 Km\n" +
                "        Santos Port - Distance: 0 Km\n" +
                "        Montevideo Port - Distance: 332 Km\n" +
                "Origin: Halifax Port (Port)\n" +
                "        Vancouver Port - Distance: 0 Km\n" +
                "        Los Angeles Port - Distance: 600 Km\n" +
                "        New Jersey Port - Distance: 600 Km\n" +
                "Origin: Guayaquil Port (Port)\n" +
                "        Guayaquil Port - Distance: 0 Km\n" +
                "        Buenaventura Port - Distance: 235 Km\n" +
                "        Cartagena Port - Distance: 235 Km\n" +
                "Origin: Lima (Capital)\n" +
                "        Quito - Distance: 321 Km\n" +
                "        Bogota - Distance: 564 Km\n" +
                "        Santiago - Distance: 959 Km\n" +
                "Origin: Paramaribo (Capital)\n" +
                "        Brasilia - Distance: 1688 Km\n" +
                "        Asuncion - Distance: 2943 Km\n" +
                "        Montevideo - Distance: 3273 Km\n" +
                "Origin: Mexico City (Capital)\n" +
                "        Guatemala City - Distance: 958 Km\n" +
                "        San Salvador - Distance: 1104 Km\n" +
                "        Belmopan - Distance: 1152 Km\n" +
                "Origin: Bogota (Capital)\n" +
                "        Quito - Distance: 506 Km\n" +
                "        Lima - Distance: 564 Km\n" +
                "        Panama City - Distance: 615 Km\n" +
                "Origin: San Vicente Port (Port)\n" +
                "        Valparaiso Port - Distance: 0 Km\n" +
                "        Callao Port - Distance: 965 Km\n" +
                "        Matarani Port - Distance: 965 Km\n" +
                "Origin: Matarani Port (Port)\n" +
                "        Matarani Port - Distance: 0 Km\n" +
                "        Esmeraldas Port - Distance: 706 Km\n" +
                "        Guayaquil Port - Distance: 706 Km\n" +
                "Origin: Brasilia (Capital)\n" +
                "        Asuncion - Distance: 1255 Km\n" +
                "        Montevideo - Distance: 1585 Km\n" +
                "        Paramaribo - Distance: 1688 Km\n" +
                "Origin: Los Angeles Port (Port)\n" +
                "        New Jersey Port - Distance: 0 Km\n" +
                "        Halifax Port - Distance: 600 Km\n" +
                "        Vancouver Port - Distance: 600 Km\n" +
                "Origin: Tegucigalpa (Capital)\n" +
                "        Managua - Distance: 108 Km\n" +
                "        San Salvador - Distance: 220 Km\n" +
                "        San Jose - Distance: 349 Km\n" +
                "Origin: Balboa Port (Port)\n" +
                "        Balboa Port - Distance: 0 Km\n" +
                "        Puerto Limon Port - Distance: 192 Km\n" +
                "        Buenaventura Port - Distance: 276 Km\n" +
                "Origin: Montevideo (Capital)\n" +
                "        Buenos Aires - Distance: 278 Km\n" +
                "        Asuncion - Distance: 835 Km\n" +
                "        Brasilia - Distance: 1585 Km\n" +
                "Origin: Esmeraldas Port (Port)\n" +
                "        Guayaquil Port - Distance: 0 Km\n" +
                "        Buenaventura Port - Distance: 235 Km\n" +
                "        Cartagena Port - Distance: 235 Km\n" +
                "Origin: La Paz (Capital)\n" +
                "        Santiago - Distance: 716 Km\n" +
                "        Lima - Distance: 999 Km\n" +
                "        Asuncion - Distance: 1244 Km\n" +
                "Origin: Montevideo Port (Port)\n" +
                "        Bahia Blanca Port - Distance: 129 Km\n" +
                "        Buenos Aires Port - Distance: 129 Km\n" +
                "        Rio Grande Port - Distance: 332 Km\n" +
                "Origin: Quito (Capital)\n" +
                "        Lima - Distance: 321 Km\n" +
                "        Bogota - Distance: 506 Km\n" +
                "        Panama City - Distance: 1121 Km\n" +
                "Origin: Asuncion (Capital)\n" +
                "        Buenos Aires - Distance: 557 Km\n" +
                "        Montevideo - Distance: 835 Km\n" +
                "        La Paz - Distance: 1244 Km\n" +
                "Origin: New Jersey Port (Port)\n" +
                "        New Jersey Port - Distance: 0 Km\n" +
                "        Halifax Port - Distance: 600 Km\n" +
                "        Vancouver Port - Distance: 600 Km\n" +
                "Origin: Managua (Capital)\n" +
                "        Tegucigalpa - Distance: 108 Km\n" +
                "        San Jose - Distance: 241 Km\n" +
                "        San Salvador - Distance: 328 Km\n" +
                "Origin: Guatemala City (Capital)\n" +
                "        San Salvador - Distance: 146 Km\n" +
                "        Tegucigalpa - Distance: 366 Km\n" +
                "        Managua - Distance: 474 Km\n" +
                "Origin: Salvador Port (Port)\n" +
                "        Salvador Port - Distance: 0 Km\n" +
                "        Santos Port - Distance: 0 Km\n" +
                "        Montevideo Port - Distance: 332 Km\n" +
                "Origin: Callao Port (Port)\n" +
                "        Matarani Port - Distance: 0 Km\n" +
                "        Esmeraldas Port - Distance: 706 Km\n" +
                "        Guayaquil Port - Distance: 706 Km\n" +
                "Origin: Puerto Quetzal Port (Port)\n" +
                "        Cutuco Port - Distance: 202 Km\n" +
                "        Veracruz Port - Distance: 854 Km\n" +
                "        Manzanillo Port - Distance: 854 Km\n" +
                "Origin: Cartagena Port (Port)\n" +
                "        Cartagena Port - Distance: 0 Km\n" +
                "        Esmeraldas Port - Distance: 235 Km\n" +
                "        Guayaquil Port - Distance: 235 Km\n" +
                "Origin: Manzanillo Port (Port)\n" +
                "        Veracruz Port - Distance: 0 Km\n" +
                "        Puerto Quetzal Port - Distance: 854 Km\n" +
                "        Cutuco Port - Distance: 1055 Km\n" +
                "Origin: San Jose (Capital)\n" +
                "        Managua - Distance: 241 Km\n" +
                "        Tegucigalpa - Distance: 349 Km\n" +
                "        Panama City - Distance: 506 Km\n" +
                "Origin: Buenos Aires Port (Port)\n" +
                "        Buenos Aires Port - Distance: 0 Km\n" +
                "        Montevideo Port - Distance: 129 Km\n" +
                "        Rio Grande Port - Distance: 429 Km\n" +
                "Origin: Washington (Capital)\n" +
                "        Ottawa - Distance: 226 Km\n" +
                "        Mexico City - Distance: 2422 Km\n" +
                "        Guatemala City - Distance: 3380 Km\n" +
                "Origin: Georgetown (Capital)\n" +
                "        Brasilia - Distance: 1875 Km\n" +
                "        Asuncion - Distance: 3130 Km\n" +
                "        Montevideo - Distance: 3460 Km\n" +
                "Origin: Santiago (Capital)\n" +
                "        La Paz - Distance: 716 Km\n" +
                "        Lima - Distance: 959 Km\n" +
                "        Quito - Distance: 1280 Km\n" +
                "Origin: Cutuco Port (Port)\n" +
                "        Puerto Quetzal Port - Distance: 202 Km\n" +
                "        Cristobal Port - Distance: 741 Km\n" +
                "        Balboa Port - Distance: 741 Km\n" +
                "Origin: Valparaiso Port (Port)\n" +
                "        Valparaiso Port - Distance: 0 Km\n" +
                "        Callao Port - Distance: 965 Km\n" +
                "        Matarani Port - Distance: 965 Km\n" +
                "Origin: Puerto Limon Port (Port)\n" +
                "        Cristobal Port - Distance: 192 Km\n" +
                "        Balboa Port - Distance: 192 Km\n" +
                "        Buenaventura Port - Distance: 452 Km\n" +
                "Origin: Vancouver Port (Port)\n" +
                "        Vancouver Port - Distance: 0 Km\n" +
                "        Los Angeles Port - Distance: 600 Km\n" +
                "        New Jersey Port - Distance: 600 Km\n" +
                "Origin: Veracruz Port (Port)\n" +
                "        Veracruz Port - Distance: 0 Km\n" +
                "        Puerto Quetzal Port - Distance: 854 Km\n" +
                "        Cutuco Port - Distance: 1055 Km\n" +
                "Origin: San Salvador (Capital)\n" +
                "        Guatemala City - Distance: 146 Km\n" +
                "        Tegucigalpa - Distance: 220 Km\n" +
                "        Managua - Distance: 328 Km\n" +
                "Origin: Belmopan (Capital)\n" +
                "        Mexico City - Distance: 1152 Km\n" +
                "        Guatemala City - Distance: 2110 Km\n" +
                "        San Salvador - Distance: 2256 Km\n" +
                "Origin: Ottawa (Capital)\n" +
                "        Washington - Distance: 226 Km\n" +
                "        Mexico City - Distance: 2648 Km\n" +
                "        Guatemala City - Distance: 3606 Km\n" +
                "Origin: Buenaventura Port (Port)\n" +
                "        Cartagena Port - Distance: 0 Km\n" +
                "        Esmeraldas Port - Distance: 235 Km\n" +
                "        Guayaquil Port - Distance: 235 Km\n" +
                "Origin: Cristobal Port (Port)\n" +
                "        Balboa Port - Distance: 0 Km\n" +
                "        Puerto Limon Port - Distance: 192 Km\n" +
                "        Buenaventura Port - Distance: 276 Km\n" +
                "Origin: Buenos Aires (Capital)\n" +
                "        Montevideo - Distance: 278 Km\n" +
                "        Asuncion - Distance: 557 Km\n" +
                "        Santiago - Distance: 1335 Km\n" +
                "Origin: Rio Grande Port (Port)\n" +
                "        Salvador Port - Distance: 0 Km\n" +
                "        Santos Port - Distance: 0 Km\n" +
                "        Montevideo Port - Distance: 332 Km\n" +
                "Origin: Panama City (Capital)\n" +
                "        San Jose - Distance: 506 Km\n" +
                "        Bogota - Distance: 615 Km\n" +
                "        Managua - Distance: 747 Km\n" +
                "Origin: Bahia Blanca Port (Port)\n" +
                "        Buenos Aires Port - Distance: 0 Km\n" +
                "        Montevideo Port - Distance: 129 Km\n" +
                "        Rio Grande Port - Distance: 429 Km\n";

        assertEquals(str, clc.returnClosest(3));*/
    }
}