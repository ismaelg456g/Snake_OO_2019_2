import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hercules
 */
public class Barreira {
    private List<int[]> coordenadas;
    
    public Barreira(){
        coordenadas = new ArrayList<int[]>();
        coordenadas.add(0, new int[2]);
        coordenadas.get(0)[0]=12;
        coordenadas.get(0)[1]=5;
        coordenadas.add(1, new int[2]);
        coordenadas.get(1)[0]=12;
        coordenadas.get(1)[1]=6;
        coordenadas.add(2, new int[2]);
        coordenadas.get(2)[0]=12;
        coordenadas.get(2)[1]=7;
        coordenadas.add(3, new int[2]);
        coordenadas.get(3)[0]=12;
        coordenadas.get(3)[1]=8;
        coordenadas.add(4, new int[2]);
        coordenadas.get(4)[0]=12;
        coordenadas.get(4)[1]=9;
    }
    
    public boolean checaColisao(Cobra cobrinha){
        for(int[] a: coordenadas){
            if(cobrinha.getCoordCabeca()[0] == a[0]  && cobrinha.getCoordCabeca()[1] == a[1]){
                colide(cobrinha);
                return true;
            }
        }
        return false;
    }
    
    public void colide(Cobra cobrinha){
        cobrinha.morre();
    }
    
    public List<int[]> get_coordenadas(){
        return coordenadas;
    }
}
