/*
 * The MIT License
 *
 * Copyright 2016 Fernando Gonzalez < fernandogv.inf@gmail.com >.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package etc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class CaminoTest {
    
    public CaminoTest() {
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
     * Test of getAncho method, of class Camino.
     */
    @Test
    public void testGetAncho() {
        System.out.println("getAncho");
        
        Camino instance = Camino.NORTE;
        int expResult = 0;
        int result = instance.getAncho();
        assertEquals(expResult, result);
        
        instance = Camino.SUR;
        result = instance.getAncho();
        assertEquals(expResult, result);
        
        instance = Camino.OESTE;
        expResult = -1;
        result = instance.getAncho();
        assertEquals(expResult, result);
        
        instance = Camino.ESTE;
        expResult = 1;
        result = instance.getAncho();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlto method, of class Camino.
     */
    @Test
    public void testGetAlto() {
        System.out.println("getAlto");
        
        Camino instance = Camino.NORTE;
        int expResult = -1;
        int result = instance.getAlto();
        assertEquals(expResult, result);
        
        instance = Camino.SUR;
        expResult = 1;
        result = instance.getAlto();
        assertEquals(expResult, result);
        
        
        instance = Camino.OESTE;
        expResult = 0;
        result = instance.getAlto();
        assertEquals(expResult, result);
        
        instance = Camino.ESTE;
        result = instance.getAlto();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Camino.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Camino instance = Camino.NORTE;
        String expResult = "N";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
        instance = Camino.SUR;
        expResult = "S";
        result = instance.toString();
        assertEquals(expResult, result);
        
        instance = Camino.OESTE;
        expResult = "O";
        result = instance.toString();
        assertEquals(expResult, result);
        
        instance = Camino.ESTE;
        expResult = "E";
        result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
