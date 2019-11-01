/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hercules
 */
public class CobraTeste {
    private Cobra cobraTeste = new Cobra();
    private List<int[]> coordenadas;
    
//    public CobraTeste() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//        
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
    @Before
    public void setUp() {
        coordenadas = cobraTeste.get_coordenadas();
    }
//    
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
    @Test
     public void CobraConstTeste() {
         
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(0,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(1,coordenadas.get(1)[1]);
         assertEquals(0,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
     }
     
     @Test
     public void CobraMover() {
         cobraTeste.set_direcao('d');
         cobraTeste.mover();
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(1,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(2,coordenadas.get(1)[1]);
         assertEquals(0,coordenadas.get(0)[0]);
         assertEquals(3,coordenadas.get(0)[1]);
         cobraTeste.set_direcao('b');
         cobraTeste.mover();
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(2,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(3,coordenadas.get(1)[1]);
         assertEquals(1,coordenadas.get(0)[0]);
         assertEquals(3,coordenadas.get(0)[1]);
         cobraTeste.set_direcao('e');
         cobraTeste.mover();
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(3,coordenadas.get(2)[1]);
         assertEquals(1,coordenadas.get(1)[0]);
         assertEquals(3,coordenadas.get(1)[1]);
         assertEquals(1,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
         cobraTeste.set_direcao('c');
         cobraTeste.mover();
         assertEquals(1,coordenadas.get(2)[0]);
         assertEquals(3,coordenadas.get(2)[1]);
         assertEquals(1,coordenadas.get(1)[0]);
         assertEquals(2,coordenadas.get(1)[1]);
         assertEquals(0,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
         cobraTeste.set_direcao('b');
         cobraTeste.mover();
         assertEquals(1,coordenadas.get(2)[0]);
         assertEquals(2,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(2,coordenadas.get(1)[1]);
         assertEquals(-1,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
         
         cobraTeste.set_direcao('a');
         cobraTeste.mover();
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(2,coordenadas.get(2)[1]);
         assertEquals(-1,coordenadas.get(1)[0]);
         assertEquals(2,coordenadas.get(1)[1]);
         assertEquals(-2,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
     }
     
     @Test
     public void aumentaTeste() {
         cobraTeste.aumentaTamanho();
         assertEquals(0,coordenadas.get(3)[0]);
         assertEquals(0,coordenadas.get(3)[1]);
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(0,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(1,coordenadas.get(1)[1]);
         assertEquals(0,coordenadas.get(0)[0]);
         assertEquals(2,coordenadas.get(0)[1]);
         cobraTeste.set_direcao('d');
         cobraTeste.mover();
         assertEquals(0,coordenadas.get(3)[0]);
         assertEquals(0,coordenadas.get(3)[1]);
         assertEquals(0,coordenadas.get(2)[0]);
         assertEquals(1,coordenadas.get(2)[1]);
         assertEquals(0,coordenadas.get(1)[0]);
         assertEquals(2,coordenadas.get(1)[1]);
         assertEquals(0,coordenadas.get(0)[0]);
         assertEquals(3,coordenadas.get(0)[1]);
     }
}