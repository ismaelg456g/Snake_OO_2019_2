import java.awt.Graphics;
import java.util.Random;

public class threadCanvas extends Thread {
	private CanvasJogo canvas;
        private Cobra cobrinha;
        Fruta fruta_a;
        Fruta fruta_b;
        private Random gerador;
	
	public threadCanvas(CanvasJogo canvas, Cobra cobrinha) {
		this.canvas = canvas;
                this.cobrinha = cobrinha;
                gerador = new Random();
	}
	
	@Override
	public void run() {
            boolean aux=true;
		while(!cobrinha.checa_morte()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        if(aux){
                            aux = false;
                            canvas.init(canvas.getGraphics());
                        }
                        cobrinha.mover();
                        checaColisao();
                        geradorFrutas();
                        if(!cobrinha.checa_morte()){
                            if(fruta_a!=null && fruta_b==null){
                                if(fruta_a.checaColisao(cobrinha)){
                                    fruta_a=null;
                                    canvas.paint(canvas.getGraphics());
                                }else
                                    canvas.paint(canvas.getGraphics(),fruta_a);
                            }else if(fruta_a==null && fruta_b!=null){
                                if(fruta_b.checaColisao(cobrinha)){
                                    fruta_b=null;
                                    canvas.paint(canvas.getGraphics());
                                }else
                                    canvas.paint(canvas.getGraphics(),fruta_b);
                            }else if(fruta_a!=null && fruta_b!=null){
                                if(fruta_b.checaColisao(cobrinha)){
                                    fruta_b=null;
                                    canvas.paint(canvas.getGraphics(), fruta_a);
                                }else if(fruta_a.checaColisao(cobrinha)){
                                    fruta_a=null;
                                    canvas.paint(canvas.getGraphics(), fruta_b);
                                }else
                                    canvas.paint(canvas.getGraphics(),fruta_a, fruta_b);
                            }
                            else
                                canvas.paint(canvas.getGraphics());
                        }else{
                            canvas.gameOver(canvas.getGraphics());
                        }
		}
                
	}
        
        private void geradorFrutas(){
            int aleatorio = gerador.nextInt(100);
            
            if(fruta_a==null && fruta_b == null){
                fruta_a = new FrutaSimples();
                fruta_a.geraPos(25, 25);
            }else if(fruta_a!=null && fruta_b==null){
                switch(aleatorio){
                    case 0:
                        fruta_b = new FrutaSimples();
                        do{
                            fruta_b.geraPos(25, 25);
                        }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                                fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                        break;
                    case 25:
                        fruta_b = new FrutaBomba();
                        do{
                            fruta_b.geraPos(25, 25);
                        }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                                fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                        break;
                    case 50:
                        fruta_b = new FrutaDiminuta();
                        do{
                            fruta_b.geraPos(25, 25);
                        }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                                fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                        break;
                    case 75:
                        fruta_b = new FrutaGrande();
                        do{
                            fruta_b.geraPos(25, 25);
                        }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                                fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                        break;
                }
            }else if(fruta_a==null && fruta_b!=null){
                if(gerador.nextInt(20)==0){
                    fruta_a = new FrutaSimples();
                    do{
                        fruta_a.geraPos(25, 25);
                    }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                            fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                }
            }
        }
        
        private void checaColisao(){
            if(cobrinha.getCoordCabeca()[0]<0 || cobrinha.getCoordCabeca()[1]<0 || cobrinha.getCoordCabeca()[0]>=25 || cobrinha.getCoordCabeca()[1]>=25){
                cobrinha.morre();
            }
        }
}
