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
import estructura.EstacionBase;
import estructura.EstacionPuerta;
import estructura.Galaxia;
import estructura.Midicloriano;
import etc.Camino;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class PersonajeTest {
    
    private static Personaje instance;
    
    public PersonajeTest() {
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
        
        instance = new Jedi('P', "PersonajeJediPrueba", 8, 4);
        
        System.out.println(galaxia.imprimirGalaxia());
    }
    
    @AfterClass
    public static void tearDownClass() {
        int estaciones = Galaxia.obtenerInstancia().getIdEstacionPuerta();
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTurno method, of class Personaje.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        
        int expResult = 4;
        int result = instance.getTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstacionPosicion method, of class Personaje.
     */
    @Test
    public void testGetEstacionPosicion() {
        System.out.println("getEstacionPosicion");
        
        if(instance.getEstacionPosicion().getID() == 12){
            instance.moverA(Galaxia.obtenerInstancia().getEstacion(8));
            Galaxia.obtenerInstancia().getEstacion(12).sacarPersonaje();
        }
        
        int expResult = 8;
        int result = instance.getEstacionPosicion().getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMarcaClase method, of class Personaje.
     */
    @Test
    public void testGetMarcaClase() {
        System.out.println("getMarcaClase");
        
        char expResult = 'P';
        char result = instance.getMarcaClase();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isGanador method, of class Personaje.
     */
    @Test
    public void testIsGanador() {
        System.out.println("isGanador");
        
        boolean expResult = false;
        boolean result = instance.isGanador();
        assertEquals(expResult, result);
        
        testFin();
        
        expResult = true;
        result = instance.isGanador();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getRuta method, of class Personaje.
     */
    @Test
    public void testGetRuta() {
        System.out.println("getRuta");
        
        instance.generarCamino();
        
        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
        
        System.out.println(instance.getRuta().toString());
        
        String expResult = "[O, N, S, O, N, S, E, S, O, S, O, N, N, N, S, S, S, E, S, O, E, E, O, N, N, E, S, N, N, E, S, S, S, E]";
        String result = instance.getRuta().toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_LinkedList() {
        System.out.println("setRuta");
        
        LinkedList<Camino> ruta = new LinkedList<>();
        
        String expected = "[O, N, S, O, N, S, E]";
        
        //Seteamos una ruta de ejemplo: O, N, S, O, N, S, E
        ruta.add(Camino.OESTE);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.SUR);
        ruta.add(Camino.OESTE);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.SUR);
        ruta.add(Camino.ESTE);
        
        instance.setRuta(ruta);
        
        assertEquals(expected, ruta.toString());
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_ArrayList() {
        System.out.println("setRuta");
        
        ArrayList<Integer> camino = new ArrayList<>();
        String expected = " S, S, S, E";
        
        System.out.print("El personaje esta en la estacion: ");
        System.out.println(instance.getEstacionPosicion().getID());
        
        instance.setRuta(camino);
        
        instance.getRuta().toString();
        
        //Seteamos un camino de ejemplo: mover el personaje hasta la posicion de la puerta desde la pos 8
        camino.add(8);
        camino.add(8+5);        //Mueve al sur
        camino.add(8+5+5);      //Mueve al sur
        camino.add(8+5+5+5);    //Mueve al sur
        camino.add(8+5+5+5+1);  //Mueve al este
        
        instance.setRuta(camino);
        
        assertEquals(expected, instance.getRuta().toString());
    }

    /**
     * Test of moverA method, of class Personaje.
     */
    @Test
    public void testMoverA() {
        System.out.println("moverA");
        EstacionBase expected = Galaxia.obtenerInstancia().getEstacion(12);
        
        instance.moverA(expected);
        Galaxia.obtenerInstancia().getEstacion(8).sacarPersonaje();
        
        EstacionBase estacion = instance.getEstacionPosicion();
        
        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());        
        
        assertEquals(expected, estacion);
    }

    /**
     * Test of recogerMidicloriano method, of class Personaje.
     */
    @Test
    public void testRecogerMidicloriano() {
        System.out.println("recogerMidicloriano");
        Midicloriano midicloriano = new Midicloriano(42);
        
        String expected = " 42";
        
        instance.recogerMidicloriano(midicloriano);
        
        String result = instance.midicloriansToString();
        
        assertEquals(expected, result);
        
    }

    /**
     * Test of mover method, of class Personaje.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Personaje instance = null;
        instance.mover();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accion method, of class Personaje.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        Personaje instance = null;
        instance.accion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esImperial method, of class Personaje.
     */
    @Test
    public void testEsImperial() {
        System.out.println("esImperial");
        Personaje instance = null;
        boolean expResult = false;
        boolean result = instance.esImperial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fin method, of class Personaje.
     */
    @Test
    public void testFin() {
        System.out.println("fin");
        
        instance.fin();
    }

    /**
     * Test of accionPuerta method, of class Personaje.
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        Personaje instance = null;
        instance.accionPuerta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accionEstacion method, of class Personaje.
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        Personaje instance = null;
        instance.accionEstacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class Personaje.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        Personaje instance = null;
        instance.generarCamino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Personaje.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Personaje instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Personaje.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Personaje o = null;
        Personaje instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Personaje.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rutaToString method, of class Personaje.
     */
    @Test
    public void testRutaToString() {
        System.out.println("rutaToString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.rutaToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of midicloriansToString method, of class Personaje.
     */
    @Test
    public void testMidicloriansToString() {
        System.out.println("midicloriansToString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.midicloriansToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLogini method, of class Personaje.
     */
    @Test
    public void testToLogini() {
        System.out.println("toLogini");
        Personaje instance = null;
        instance.toLogini();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLog method, of class Personaje.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        Personaje instance = null;
        instance.toLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PersonajeImpl extends Personaje {

        public PersonajeImpl() {
            super(' ', "", 0, 0);
        }

        public void accionPuerta() {
        }

        public void accionEstacion() {
        }

        public void generarCamino() {
        }

        public String getTipo() {
            return "";
        }
    }
    
}
