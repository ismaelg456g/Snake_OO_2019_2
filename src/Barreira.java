import java.io.BufferedReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hercules
 */
public class Barreira{
    private List<int[]> coordenadas;
    
    public Barreira(){
        coordenadas = new ArrayList<int[]>();
        try{
            BufferedReader arq = new BufferedReader(new FileReader("maps/map0"));
            String numero="";
            int aux=0;
            while(numero!=null){
                coordenadas.add(new int[2]);
                numero= arq.readLine();
                if(numero!=null){
                    aux = Integer.parseInt(numero);
                    coordenadas.get(coordenadas.size()-1)[0]=aux;
                    numero= arq.readLine();
                    if(numero!=null){
                        aux = Integer.parseInt(numero);
                        coordenadas.get(coordenadas.size()-1)[1]=aux;
                    }else
                        coordenadas.remove(coordenadas.size()-1);
                }else
                    coordenadas.remove(coordenadas.size()-1);
            }
        }catch(IOException i){
            
        }
        
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
