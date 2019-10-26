/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.*;

public class Cobra {
    private List<int[]> coordenadas;
    
    public Cobra(){
        int[] a = new int[2];
        a[0]=0;
        a[1]=0;
        coordenadas = new ArrayList<int[]>();
        coordenadas.add(0, a);
    }
    
    public List<int[]> get_coordenadas(){
        return coordenadas;
    }
    public void mover(char direcao){
        int[] aux = new int[2];
        int i;
        
        if(direcao == 'd'){ //direita
            for(i=1; i<coordenadas.size(); i++){
                coordenadas.set(i, coordenadas.get(i-1));
            }
            coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
        }else if(direcao == 'e'){ //esquerda
            for(i=1; i<coordenadas.size(); i++){
                coordenadas.set(i, coordenadas.get(i-1));
            }
            coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
        }else if(direcao == 'b'){ //baixo
            for(i=1; i<coordenadas.size(); i++){
                coordenadas.set(i, coordenadas.get(i-1));
            }
            coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
        }else if(direcao == 'c'){ //cima
            for(i=1; i<coordenadas.size(); i++){
                coordenadas.set(i, coordenadas.get(i-1));
            }
            coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
        }else{
            System.out.println("erro");
        }
    }
}
