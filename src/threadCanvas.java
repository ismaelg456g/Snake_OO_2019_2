import java.awt.Graphics;
import java.util.Random;

public class threadCanvas extends Thread {
	private CanvasJogo canvas;
        private Cobra cobrinha;
        private Barreira paredes;
        Fruta fruta_a;
        Fruta fruta_b;
        private Random gerador;
	
	public threadCanvas(CanvasJogo canvas, Cobra cobrinha) {
		this.canvas = canvas;
                this.cobrinha = cobrinha;
                gerador = new Random();
                paredes = new Barreira();
	}
	
	@Override
	public void run() {
		while(!cobrinha.checa_morte()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        if(cobrinha.getDiminuiu()){
                            cobrinha.voltaDiminuiu();
                            canvas.init(canvas.getGraphics());
                        }
                        cobrinha.mover();
                        cobrinha.checaColisao();
                        checaColisao();
                        if(cobrinha.atravessaParede())
                            paredes.checaColisao(cobrinha);
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
                        }
		}
                canvas.gameOver(canvas.getGraphics());
	}
        
        private void geradorFrutas(){
            if(fruta_a==null && fruta_b == null){
                fruta_a = geraFrutaAleaDeVdd();
                fruta_a.geraPos(25, 25);
            }else if(fruta_a!=null && fruta_b==null){
                fruta_b = geraFrutaAlea();
                if(fruta_b!=null){
                    do{
                        fruta_b.geraPos(25, 25);
                    }while(fruta_a.get_coordenadas()[0]==fruta_b.get_coordenadas()[0] &&
                            fruta_a.get_coordenadas()[1]==fruta_b.get_coordenadas()[1]);
                }
            }else if(fruta_a==null && fruta_b!=null){
                    fruta_a = geraFrutaAlea();
                    if(fruta_a!=null){
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
        
        private Fruta geraFrutaAlea(){
            int aleatorio = gerador.nextInt(100);
            Fruta fruta=null;
            switch(aleatorio){
                    case 0:
                        fruta = new FrutaSimples();
                        break;
                    case 25:
                        fruta = new FrutaBomba();
                        break;
                    case 50:
                        fruta = new FrutaDiminuta();
                        break;
                    case 75:
                        fruta = new FrutaGrande();
                        break;
                }
            return fruta;
        }
        private Fruta geraFrutaAleaDeVdd(){
            int aleatorio = gerador.nextInt(4);
            Fruta fruta=null;
            switch(aleatorio){
                    case 0:
                        fruta = new FrutaSimples();
                        break;
                    case 1:
                        fruta = new FrutaBomba();
                        break;
                    case 2:
                        fruta = new FrutaDiminuta();
                        break;
                    case 3:
                        fruta = new FrutaGrande();
                        break;
                }
            return fruta;
        }
}
