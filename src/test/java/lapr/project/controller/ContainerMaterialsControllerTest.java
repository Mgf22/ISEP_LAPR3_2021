package lapr.project.controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerMaterialsControllerTest {
    @Test
    void getContainerThermalResistance(){
        ContainersMaterialsController cms = new ContainersMaterialsController();
        assertEquals("A resitência têrmica do contentor é: 1.241315496098105 K/W", cms.getContainerMaterials(1,2,3,0.02,0.05,0.02));
    }
}
