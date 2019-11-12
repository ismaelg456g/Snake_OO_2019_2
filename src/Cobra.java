/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

public class Cobra {
    private List<int[]> coordenadas;
    private int[] atras_calda;
    private char direcao;
    private boolean morri;
    private boolean diminuiu;
    protected int placar;
    
    public Cobra(){
        atras_calda = new int[2];
        atras_calda[0]=-1;
        atras_calda[1]=-1;
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
        direcao = 'd';
        morri = false;
        diminuiu = true;
        placar=0;
    }
    
    public List<int[]> get_coordenadas(){
        return coordenadas;
    }
    public int[] get_atras_calda(){
        return atras_calda;
    }
    
    public void set_direcao(char direcao){
        if(direcao == 'd' || direcao == 'e' || direcao == 'b' || direcao == 'c'){
            this.direcao = direcao;
        }
    }
    
    public char get_direcao(){
        return direcao;
    }
    
    public char get_direcao_calda(){
        if(coordenadas.get(coordenadas.size()-1)[0]<coordenadas.get(coordenadas.size()-2)[0]){
            return 'b';
        }else if(coordenadas.get(coordenadas.size()-1)[0]>coordenadas.get(coordenadas.size()-2)[0]){
            return 'c';
        }else if(coordenadas.get(coordenadas.size()-1)[1]<coordenadas.get(coordenadas.size()-2)[1]){
            return 'd';
        }else if(coordenadas.get(coordenadas.size()-1)[1]>coordenadas.get(coordenadas.size()-2)[1]){
            return 'e';
        }else{
            return direcao;
        }
    }
    
    public void mover(){
        int[] aux = new int[2];
        int i;
        
        switch (direcao) {
            case 'd':
                //direita
                atras_calda[0]=coordenadas.get(coordenadas.size()-1)[0];
                atras_calda[1]=coordenadas.get(coordenadas.size()-1)[1];
                for(i=coordenadas.size()-1; i>=1; i--){
                    coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                    coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
                }   if(coordenadas.get(2)[0]==coordenadas.get(0)[0] && coordenadas.get(2)[1]==coordenadas.get(0)[1]+1)
                    coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
                else
                    coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
                break;
            case 'e':
                //esquerda
                atras_calda[0]=coordenadas.get(coordenadas.size()-1)[0];
                atras_calda[1]=coordenadas.get(coordenadas.size()-1)[1];
                for(i=coordenadas.size()-1; i>=1; i--){
                    coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                    coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
                }   if(coordenadas.get(2)[0]==coordenadas.get(0)[0] && coordenadas.get(2)[1]==coordenadas.get(0)[1]-1)
                    coordenadas.get(0)[1] = coordenadas.get(0)[1]+1;
                else
                    coordenadas.get(0)[1] = coordenadas.get(0)[1]-1;
                break;
            case 'b':
                //baixo
                atras_calda[0]=coordenadas.get(coordenadas.size()-1)[0];
                atras_calda[1]=coordenadas.get(coordenadas.size()-1)[1];
                for(i=coordenadas.size()-1; i>=1; i--){
                    coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                    coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
                }   if(coordenadas.get(2)[0]==coordenadas.get(0)[0]+1 && coordenadas.get(2)[1]==coordenadas.get(0)[1])
                    coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
                else
                    coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
                break;
            case 'c':
                //cima
                atras_calda[0]=coordenadas.get(coordenadas.size()-1)[0];
                atras_calda[1]=coordenadas.get(coordenadas.size()-1)[1];
                for(i=coordenadas.size()-1; i>=1; i--){
                    coordenadas.get(i)[0]=coordenadas.get(i-1)[0];
                    coordenadas.get(i)[1]=coordenadas.get(i-1)[1];
                }   if(coordenadas.get(2)[0]==coordenadas.get(0)[0]-1 && coordenadas.get(2)[1]==coordenadas.get(0)[1])
                    coordenadas.get(0)[0] = coordenadas.get(0)[0]+1;
                else
                    coordenadas.get(0)[0] = coordenadas.get(0)[0]-1;
                break;
            default:
                System.err.println("Erro ao mover personagem...");
                break;
        }
    }
    
    public void aumentaTamanho(){
        coordenadas.add(new int[2]);
        coordenadas.get(coordenadas.size()-1)[0] = coordenadas.get(coordenadas.size()-2)[0];
        coordenadas.get(coordenadas.size()-1)[1] = coordenadas.get(coordenadas.size()-2)[1];
    }
    
    public void diminui(){
        int aux = coordenadas.size();
        for(int i=3; i<aux;i++){
            coordenadas.remove(3);
        }
        diminuiu=true;
    }
    
    public void voltaDiminuiu(){
        diminuiu = false;
    }
    
    public boolean getDiminuiu(){
        return diminuiu;
    }
    
    public int[] getCoordCabeca(){
        return coordenadas.get(0);
    }
    
    public void morre(){
        morri = true;
    }
    
    public boolean checa_morte(){
        return morri;
    }
    
    public boolean checaColisao(){
        boolean aux=true;
        for(int[] a: coordenadas){
            if(aux)
                aux=false;
            else if(getCoordCabeca()[0]==a[0] && getCoordCabeca()[1]==a[1]){
                morre();
                return true;
            }
        }
        return false;
    }
    
    public boolean atravessaParede(){
        return false;
    }
    
    public void incrementaPlacar(){
        placar+=5;
    }
    public int getPlacar(){
        return placar;
    }
}
