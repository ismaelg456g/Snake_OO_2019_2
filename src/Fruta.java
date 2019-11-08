import java.util.Random;

public abstract class Fruta {
    private int coordenadas[];
    private Random gerador;
    
    public Fruta(){
        coordenadas = new int[2];
        coordenadas[0]=0;
        coordenadas[1]=0;
        gerador = new Random();
    }
    
    public boolean checaColisao(Cobra cobrinha){
        if(cobrinha.getCoordCabeca()[0] == coordenadas[0]  && cobrinha.getCoordCabeca()[1] == coordenadas[1]){
            colide(cobrinha);
            return true;
        }
        return false;
    }
    
    public abstract void colide(Cobra cobrinha);
    
    public void geraPos(int limX, int limY){
        coordenadas[0] = gerador.nextInt(limY);
        coordenadas[1] = gerador.nextInt(limX);
    }
    
    public int[] get_coordenadas(){
        return coordenadas;
    }
}
