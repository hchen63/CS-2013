package lab11;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoadMapTest {

	@Test
	public void testMapCreated() {
		RoadMap r = new RoadMap();
		assertNotNull(r);
	}

	@Test
	public void testSizeEmptyMap() {
		RoadMap r = new RoadMap();
		assertEquals(r.getSize(), 0);
	}

	@Test
	public void testSizeOneCity() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		assertEquals(r.getSize(), 1);
	}

	@Test
	public void testSizeTwoCities() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.getSize(), 2);
	}

	@Test
	public void testNodeNeighborsEmpty() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 0);
	}
	
	@Test
	public void testNodeNeighborsOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 1);
	}

	@Test
	public void testNodeNeighborsFirstCorrectUsingNode() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().get(0).getCityName(), "San Diego");
	}

	@Test
	public void testNodeNeighborsFirstCorrectUsingNames() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNames().get(0), "San Diego");
	}

	@Test
	public void testContains() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("San Diego"));
	}

	@Test
	public void testNodeNeighborsSymmetric() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertTrue(r.findCityNodeByName("San Diego").getNeighborNames().contains("Los Angeles"));
	}
	@Test
	public void testNodeNeighborsNotReflexive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles", "San Diego");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Los Angeles"));
	}

	@Test
	public void testNodeNeighborsNotTransitive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Phoenix"));
	}

	@Test
	public void testNeighborsSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");
		assertEquals(r.findCityNodeByName("San Diego").getNeighborNodes().size(), 1);
	}

	@Test
	public void testMergeSort() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");

		r.getSortedListOfNodes();
		
	}
	
	@Test
	public void testTransversal() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("San Franciso");
		r.addCity("Fresno");
		r.addCity("Sacramento");
		
		r.getBFTraversal("Phoenix");
	}
}

