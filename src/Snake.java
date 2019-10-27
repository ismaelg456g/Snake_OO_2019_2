/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

public class Snake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaInicial telaInicio = new TelaInicial();
        
        telaInicio.main(args);
      Cobra abacate = new Cobra();
      List<int[]> alea = abacate.get_coordenadas();
      
      System.out.println("veja : "+ alea.get(0)[0]+ " " + alea.get(0)[1]);
      abacate.mover('l');
      System.out.println("veja : "+ alea.get(0)[0]+ " " + alea.get(0)[1]);
    }
    
}
