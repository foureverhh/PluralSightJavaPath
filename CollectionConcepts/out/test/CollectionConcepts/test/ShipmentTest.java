

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Shipment Tester. 
* 
* @author <Authors name> 
* @since <pre>07/06/2019</pre> 
* @version 1.0 
*/ 
public class ShipmentTest extends TestCase {

    private Shipment shipment = new Shipment();

@Test
public ShipmentTest(String name) { 
super(name);

} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: add(Product product) 
* 
*/ 
public void testAdd() throws Exception { 
//TODO: Test goes here...
  shipment.add(door);
  shipment.add(window);
  assertThat(shipment, contains(door,window));
} 

/** 
* 
* Method: replace(Product product) 
* 
*/ 
public void testReplace() throws Exception { 
//TODO: Test goes here...
    shipment.add(door);
    shipment.add(window);

    shipment.replace(door,floorPanel);
    assertThat(shipment, contains(floorPanel, window));
} 

/** 
* 
* Method: prepare() 
* 
*/ 
public void testPrepare() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: iterator() 
* 
*/ 
public void testIterator() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: forEach(Consumer<? super Product> action) 
* 
*/ 
public void testForEach() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: spliterator() 
* 
*/ 
public void testSpliterator() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getHeavyVanProducts() 
* 
*/ 
public void testGetHeavyVanProducts() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getLightVanProducts() 
* 
*/ 
public void testGetLightVanProducts() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(ShipmentTest.class); 
} 
} 
