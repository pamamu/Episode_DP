/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernandogonzalez
 */
public class StationTest {
    
    public StationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class Station.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Station instance = new Station(24);
        int expResult = 24;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class Station.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int iD = 0;
        Station instance = null;
        instance.setID(iD);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haveGate method, of class Station.
     */
    @Test
    public void testHaveGate() {
        System.out.println("haveGate");
        Station instance = null;
        boolean expResult = false;
        boolean result = instance.haveGate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Station.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Station instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Station.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Station instance = new Station(1);
        String expResult = "Station";
        String result = instance.getType();
        
        assertEquals(expResult, result);
    }
    
}
