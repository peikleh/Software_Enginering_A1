package esof322.a3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoor{
	private Room r0;
	
	private Room r2;
	private Player p1;
	private Player p2;
	private Door d1;
	private Key k1;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//create three rooms, two players
		r0 = new Room();
		
		r2 = new Room();
		p1 =new Player();
		p2 = new Player();
		
		//create room connectin with door
		
		//create room connection with key required
		k1 = new Key();
		d1 = new Door(r0, r2, k1);
		r0.setSide(5, d1);
		r2.setSide(4, d1);
		//set p1 and p2 location to r0
		p1.setLoc(r0);
		p2.setLoc(r0);
		r0.addItem(k1);
		//give p2 a key to test
		p2.pickUp(k1);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		
		
		
	}

	@Test
	public void testEnter() {
		//test player trying to enter room without key
		p1.go(5);
		assertTrue("Should be in room 0", p1.getLoc().equals(r0));
		assertFalse("Should be in room 0", p1.getLoc().equals(r2));
		
		//test player entering room with key
		p2.go(5);
		assertTrue("Should be in room 2", p2.getLoc().equals(r2));
		assertFalse("Should be in room 2", p2.getLoc().equals(r0));
		
		//test player going back through door with key
		p2.go(4);
		assertTrue("Should be in room 0", p1.getLoc().equals(r0));
		assertFalse("Should be in room 0", p1.getLoc().equals(r2));
		
		
	}

}

