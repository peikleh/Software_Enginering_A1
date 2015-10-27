package esof322.a3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPlayer {
	private Room r0;
	private Room r1;
	
	private Player p1;
	private Item i1;
	private Item i2;
	private Item i3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r0 = new Room();
		r1 = new Room();
		p1 = new Player();
		
		r0.setSide(5, r1);
		r1.setSide(4, r0);
		i1 = new Item();
		i2 = new Item();
		i3 = new Item();
		r0.addItem(i1);
		r0.addItem(i2);
		r0.addItem(i3);
		
		p1.setLoc(r0);

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Following tests the pickUp method
		//test that player has nothing initially
		assertTrue("Player should have nothing", p1.getMyThings()[0] == null && p1.getMyThings()[1] == null);
		//test that player has item 1
		p1.pickUp(i1);
		assertTrue("Player should have i1", p1.haveItem(i1));
		//test that player has item 1 and 2
		p1.pickUp(i2);
		assertTrue("Player should have i1 and i2", p1.haveItem(i1) && p1.haveItem(i2));
		//test that player still has i1 and i2 but not i3
		p1.pickUp(i3);
		assertTrue("Player should have i1 and i2, not i3", p1.haveItem(i1) && p1.haveItem(i2) && !p1.haveItem(i3));
		
		
		//The following tests test the drop method
		//tests dropping second item
		p1.drop(1);
		assertTrue("p1 has i2 but not i1", p1.haveItem(i1) && !p1.haveItem(i2));
		//tests dropping first item
		p1.drop(0);
		assertTrue("p1 has neither i1 nor i2", p1.handsEmpty());
		
		
		//the following tests test the go method
		assertTrue("p1 should be in r0 initialy", p1.getLoc() == r0);
		//test going into room
		p1.go(5);
		assertTrue("p1 should be in r1", p1.getLoc() == r1);
		//test going back to original room
		p1.go(4);
		assertTrue("p1 should be in r0", p1.getLoc() == r0);
		
		
	}

}
