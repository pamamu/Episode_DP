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
public class LoggerTest {
    
    public LoggerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Logger.obtenerInstancia();
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
     * Test of obtenerInstancia method, of class Logger.
     */
    @Test
    public void testObtenerInstancia() {
        System.out.println("obtenerInstancia");
        Logger expResult = Logger.obtenerInstancia();
        Logger result = Logger.obtenerInstancia();
        assertEquals(expResult, result);
    }

    /**
     * Test of init method, of class Logger.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        String ruta = "./files/prueba.log";
        Logger.obtenerInstancia().init(ruta);
    }

    /**
     * Test of escribelog method, of class Logger.
     */
    @Test
    public void testEscribelog() {
        System.out.println("escribelog");
        String mensaje = "Prueba de Log";
        
        Logger.obtenerInstancia().escribelog(mensaje);
    }

    /**
     * Test of escribeLog method, of class Logger.
     */
    @Test
    public void testEscribeLog() {
        System.out.println("escribeLog");
        String mensaje = "Prueba Con mensaje SEVERE (Crítico) ";
        int tipo = 3;
        
        Logger.obtenerInstancia().escribeLog(mensaje, tipo);
    }

    /**
     * Test of close method, of class Logger.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        
        boolean expResult = true;
        boolean result = Logger.obtenerInstancia().close();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBuffer method, of class Logger.
     */
    @Test
    public void testGetBuffer() {
        System.out.println("getBuffer");
        
        String expResult = "";
        String result = Logger.obtenerInstancia().getBuffer();
        assertEquals(expResult, result);
        
    }
    
}
