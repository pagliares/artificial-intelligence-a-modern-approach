package aima.test.unit.environment.vacuum;

import aima.core.environment.vacuum.ReflexVacuumAgent;
import aima.core.environment.vacuum.VEPercept;
import aima.core.environment.vacuum.VacuumEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Ciaran O'Reilly
 */
public class ReflexVacuumAgentTest {
    private ReflexVacuumAgent agent;

    @BeforeEach
    public void setUp() {
        agent = new ReflexVacuumAgent();
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
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
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
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
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
        assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

}
