/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

public class Cobra {
    private List<int[]> coordenadas;
    
    public Cobra(){
        int[] calda = new int[2];
        calda[0]=0;
        calda[1]=0;
        int[] corpo = new int[2];
        corpo[0]=0;
        corpo[1]=1;
        int[] cabeca = new int[2];
        cabeca[0]=0;
        cabeca[1]=2;
        coordenadas = new ArrayList<int[]>();
        coordenadas.add(0, cabeca);
        coordenadas.add(1, corpo);
        coordenadas.add(2, calda);
    }
    
    public List<int[]> get_coordenadas(){
        return coordenadas;
    }
    public void mover(char direcao){
        int[] aux = new int[2];
        int i;
        
        if(direcao == 'd'){ //direita
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
        }else if(direcao == 'e'){ //esquerda
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
        }else if(direcao == 'b'){ //baixo
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
        }else if(direcao == 'c'){ //cima
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
        }else{
            System.err.println("Erro ao mover personagem...");
        }
    }
    
}
