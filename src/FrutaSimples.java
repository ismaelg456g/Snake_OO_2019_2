/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hercules
 */
public class FrutaSimples extends Fruta{
    public FrutaSimples(){
        tipo = 's';
    }
    @Override
    public void colide(Cobra cobrinha){
        cobrinha.aumentaTamanho();
    }
}
