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
package personajes;

import estructura.Cerradura;
import estructura.EstacionPuerta;
import estructura.Galaxia;
import estructura.Midicloriano;
import java.util.ArrayList;
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
public class LightSideTest {
    
    private static LightSide instance;
    
    public LightSideTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        EstacionPuerta puerta = new EstacionPuerta(24);
        
        //Creacion de una galaxia de prueba para probar el personaje
        Galaxia galaxia = Galaxia.obtenerInstancia(24, puerta, 5, 5);
        
        Cerradura cerradura = new Cerradura(4);

        ArrayList<Midicloriano> combinacion = galaxia.generarMidiclorianosCerradura();

        cerradura.setCombinacionInicial(combinacion);
        cerradura.generarCombinacion();
        cerradura.setEstado(false);

        galaxia.getStarsgate().setCerradura(cerradura);

        galaxia.construirGalaxia();
        galaxia.generarLaberinto();
        galaxia.getGrafo().floyd();
        galaxia.getGrafo().warshall();
        
        instance = new LightSide('L', "LisgthSidePrueba", 0,0);
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
     * Test of estacionvisitada method, of class LightSide.
     */
    @Test
    public void testEstacionvisitada() {
        System.out.println("estacionvisitada");
        ArrayList<Integer> solucion = new ArrayList<>();
        //Simulamos una solucion de ruta por ejemplo: 0, 1, 2, 3, 4, 5
        for (int i = 0; i < 6; i++) {
            solucion.add(i);
        }
        
        //Estacion aun no visitada
        int estacionActual = 3;
        int estacionComprobar = 4;
        
        boolean expResult = false;
        boolean result = instance.estacionvisitada(solucion, estacionActual, estacionComprobar);
        assertEquals(expResult, result);
        
        //Estacion ya visitada
        estacionActual = 3;
        estacionComprobar = 2;
        
        expResult = true;
        result = instance.estacionvisitada(solucion, estacionActual, estacionComprobar);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of accionPuerta method, of class LightSide.
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        LightSide instance = null;
        instance.accionPuerta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accionEstacion method, of class LightSide.
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        LightSide instance = null;
        instance.accionEstacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class LightSide.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        
        instance.generarCamino();
        
        System.out.println(instance.rutaToString());
        
        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
        
        assertEquals(instance.rutaToString(), " S S S E S O E E O N N E S N N E S S S E");
    }

    /**
     * Test of getTipo method, of class LightSide.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        
        String expResult = "lightside";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }
    
}
