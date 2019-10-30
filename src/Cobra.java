/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

public class Cobra {
    private List<int[]> coordenadas;
    
    public Cobra(){
        coordenadas = new ArrayList<int[]>();
        coordenadas.add(0, new int[2]);
        coordenadas.get(0)[0]=0;
        coordenadas.get(0)[1]=2;
        coordenadas.add(1, new int[2]);
        coordenadas.get(1)[0]=0;
        coordenadas.get(1)[1]=1;
        coordenadas.add(2, new int[2]);
        coordenadas.get(2)[0]=0;
        coordenadas.get(2)[1]=0;
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
            if(coordenadas.get(2)[0]==coordenadas.get(0)[0] && coordenadas.get(2)[1]==coordenadas.get(0)[1]+1)
                coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
            else
                coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
        }else if(direcao == 'e'){ //esquerda
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            if(coordenadas.get(2)[0]==coordenadas.get(0)[0] && coordenadas.get(2)[1]==coordenadas.get(0)[1]-1)
                coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
            else
                coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
        }else if(direcao == 'b'){ //baixo
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            if(coordenadas.get(2)[0]==coordenadas.get(0)[0]+1 && coordenadas.get(2)[1]==coordenadas.get(0)[1])
                coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
            else
                coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
        }else if(direcao == 'c'){ //cima
            for(i=coordenadas.size()-1; i>=1; i--){
                coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
            }
            if(coordenadas.get(2)[0]==coordenadas.get(0)[0]-1 && coordenadas.get(2)[1]==coordenadas.get(0)[1]-1)
                coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
            else
                coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
        }else{
            System.err.println("Erro ao mover personagem...");
        }
    }
    
    public void aumentaTamanho(){
        coordenadas.add(new int[2]);
        coordenadas.get(coordenadas.size()-1)[0] = coordenadas.get(coordenadas.size()-2)[0];
        coordenadas.get(coordenadas.size()-1)[1] = coordenadas.get(coordenadas.size()-2)[1];
        
    }
    
}
