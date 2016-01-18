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

import java.io.IOException;
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
public class ReaderTest {
    
    private static Reader instance;
    
    public ReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        instance = new Reader("./pruebaReader.txt");
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
     * Test of getDatosGalaxia method, of class Reader.
     */
    @Test
    public void testGetDatosGalaxia() {
        System.out.println("getDatosGalaxia");
        
        String[] expResult = {"GALAXIA","6","8","47","3"};
        String[] result = instance.getDatosGalaxia();
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getJedis method, of class Reader.
     */
    @Test
    public void testGetJedis() {
        System.out.println("getJedis");
        
        String[][] expResult = {{"JEDI","Finn","F","2"}};
        String[][] result = instance.getJedis();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getContrabandistas method, of class Reader.
     */
    @Test
    public void testGetContrabandistas() {
        System.out.println("getContrabandistas");
        
        String[][] expResult = {{"CONTRABANDISTA","BB-8","B","1"}};
        String[][] result = instance.getContrabandistas();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of getReales method, of class Reader.
     */
    @Test
    public void testGetReales() {
        System.out.println("getReales");
        
        String[][] expResult = {{"FAMILIAREAL","Rey","R","1"}};
        String[][] result = instance.getReales();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getImperiales method, of class Reader.
     */
    @Test
    public void testGetImperiales() {
        System.out.println("getImperiales");
        
        String[][] expResult = {{"IMPERIAL","Kylo","K","1"}};
        String[][] result = instance.getImperiales();
        assertArrayEquals(expResult, result);
    }
    
}
