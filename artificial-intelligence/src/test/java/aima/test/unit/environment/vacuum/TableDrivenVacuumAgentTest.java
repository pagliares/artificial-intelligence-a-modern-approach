package aima.test.unit.environment.vacuum;

import aima.core.environment.vacuum.TableDrivenVacuumAgent;
import aima.core.environment.vacuum.VEPercept;
import aima.core.environment.vacuum.VacuumEnvironment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Ciaran O'Reilly
 */
public class TableDrivenVacuumAgentTest {
    private TableDrivenVacuumAgent agent;

    @BeforeEach
    public void setUp() {
        agent = new TableDrivenVacuumAgent();
    }

    @Test
    public void testACleanAClean() {
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }


    @Test
    public void testACleanBClean() {
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testACleanBDirty() {
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Dirty))
        );
        assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testADirtyBClean() {
        assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Dirty))
        );
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testADirtyBDirty() {
        assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Dirty))
        );
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Dirty))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }
}
