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
public class GenAleatoriosTest {
    
    public GenAleatoriosTest() {
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
     * Test of generarNumero method, of class GenAleatorios.
     */
    @Test
    public void testGenerarNumero() {
        System.out.println("generarNumero");
        
        int limiteRango = 1;
        int expResult = 0;
        int result = GenAleatorios.generarNumero(limiteRango);
        assertEquals(expResult, result);
        
        limiteRango = 11;
        result = GenAleatorios.generarNumero(limiteRango);
        
        if(result < 0 || result > 10)
            fail();
    }

    /**
     * Test of getNumGenerados method, of class GenAleatorios.
     */
    @Test
    public void testGetNumGenerados() {
        System.out.println("getNumGenerados");
        
        GenAleatorios.generarNumero(2);
        
        int result = GenAleatorios.getNumGenerados();
        
        if(result == 1 || result == 3){
            //OK
        }else{
            fail("No se han generado ni 1 ni 3 numeros");
        }
    }

}
