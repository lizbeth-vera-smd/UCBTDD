package edu.ucb.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TresEnRayaTest {

    private TresEnRaya tresEnRaya;
    @Rule
    public ExpectedException expecetion = ExpectedException.none();

    @Before
    public void before(){
        tresEnRaya = new TresEnRaya();
    }

    @Test
    public void cuandoFueraXLanzarException() throws Exception {

        expecetion.expect(Exception.class);
        tresEnRaya.jugar(0,2);
    }

    @Test
    public void cuandoFueraYLanzarException() throws Exception {

        expecetion.expect(Exception.class);
        tresEnRaya.jugar(2,5);
    }

    @Test
    public void cuandoCasillaOcupadaLanzarExcepcion() throws Exception {

        tresEnRaya.jugar(2,1);
        expecetion.expect(Exception.class);
        tresEnRaya.jugar(2,1);

    }

    @Test
    public void siPrimerTurnoEntoncesJuegaX(){

        assertEquals('X',tresEnRaya.siguienteTurno());
    }

    @Test
    public void  siPrimerTurnoXSiguienteCero() throws Exception{
        tresEnRaya.jugar(2,1); //X
        assertEquals('+',tresEnRaya.siguienteTurno());

        tresEnRaya.jugar(2,2); //0
        assertEquals('X',tresEnRaya.siguienteTurno());

    }

    @Test
    public void cuandoJuegaNoHayGanador() throws Exception{
        String resultado = tresEnRaya.jugar(2,1); //X
        assertEquals("No hay ganador",resultado);
    }

    @Test
    public void siLlenaUnEjeVerticalEntoncesGana() throws Exception{
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(2,2);
        String resultado = tresEnRaya.jugar(3,1);
        assertEquals("Xes el ganador",resultado);
    }

    @Test
    public void siLlenaUnEjeHorizontalEntoncesGana() throws Exception{
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(3,1);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(2,2);
        String resultado = tresEnRaya.jugar(1,3);
        assertEquals("+es el ganador",resultado);
    }

}
