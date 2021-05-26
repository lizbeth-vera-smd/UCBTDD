package edu.ucb.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    @Rule
    public ExpectedException expecetion = ExpectedException.none();

    @Test
    public void enCadenaVaciaRetornarCero() throws Exception {

        //Preparacion de la prueba

        Calculadora c  = new Calculadora();
        //Logica de la prueba
        String resultado = c.suma("");

        //Verificacion o Assert
        assertEquals("0",resultado);
    }

    @Test
    public void para2NumerosComasRetornarSuma() throws Exception{

        Calculadora c  = new Calculadora();

       // String resultado = c.suma("2,3");
        assertEquals("5",c.suma("2,3"));
        assertEquals("500", c.suma("200,300"));
        assertEquals("0", c.suma("0,0"));
        assertEquals("25", c.suma("20,5"));
    }
    @Test
    public void para3NumerosComasRetornarSuma() throws Exception{
        Calculadora c  = new Calculadora();

        // String resultado = c.suma("2,3");
        assertEquals("10",c.suma("2,3,5"));
        assertEquals("22",c.suma("12,8,2"));
        assertEquals("190",c.suma("80,50,60"));
        assertEquals("55",c.suma("2,3,50"));
    }

    @Test
    public void numerosMayores1000sonIgnorados() throws Exception{
        Calculadora c  = new Calculadora();
        assertEquals("5",c.suma("2,3,1001"));

    }

    @Test
    public void numerosNegativosLanzanExcepcion() throws Exception{
        Calculadora c  = new Calculadora();
        expecetion.expect(Exception.class);
        assertEquals("5",c.suma("2,3,-1"));

    }
}
