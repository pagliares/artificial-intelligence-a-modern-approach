package aima.test.unit.agent;

import aima.core.agent.api.Rule;
import aima.core.agent.basic.SimpleReflexAgent;
import aima.test.unit.agent.support.TestPercept;
import aima.test.unit.agent.support.TestState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ciaran O'Reilly
 */
public class SimpleReflexAgentTest {

	private SimpleReflexAgent<String, TestPercept, TestState> agent;

	@BeforeEach
	public void setUp() {
		agent = new SimpleReflexAgent<>(Arrays.asList(new Rule<String, TestState>() {
			public Predicate<TestState> condition() {
				return state -> state.dirty;
			}

			public String action() {
				return "Sweep";
			}
		}, new Rule<String, TestState>() {
			public Predicate<TestState> condition() {
				return state -> !state.dirty;
			}

			public String action() {
				return "Drink Tea";
			}
		}), percept -> new TestState(percept.location, percept.floorIsDirty));
	}

	@Test
	public void testSweep() {
		assertEquals("Sweep", agent.perceive(new TestPercept("A", true)));
	}

	@Test
	public void testDrinkTea() {
		assertEquals("Drink Tea", agent.perceive(new TestPercept("A", false)));
	}
}
