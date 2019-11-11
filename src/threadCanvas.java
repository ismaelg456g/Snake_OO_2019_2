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
                int contSleep=0;
		while(!cobrinha.checa_morte()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        if(contSleep==100){
                            if(cobrinha.getDiminuiu()){
                                cobrinha.voltaDiminuiu();
                                canvas.init(canvas.getGraphics());
                            }
                            cobrinha.mover();
                            cobrinha.checaColisao();
                            checaColisao();
                            if(!cobrinha.atravessaParede())
                                paredes.checaColisao(cobrinha);
                            destroiFrutas();
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
                            contSleep=0;
                        }else{
                            contSleep++;
                        }
		}
                canvas.gameOver(canvas.getGraphics());
	}
        
        private void geradorFrutas(){
            if(fruta_a==null && fruta_b == null){
                fruta_a = geraFrutaAleaDeVdd();
                geraPosFruta(fruta_a);
            }else if(fruta_a!=null && fruta_b==null){
                fruta_b = geraFrutaAlea();
                if(fruta_b!=null){
                    geraPosFruta(fruta_b, fruta_a);
                }
            }else if(fruta_a==null && fruta_b!=null){
                    fruta_a = geraFrutaAlea();
                    if(fruta_a!=null){
                        geraPosFruta(fruta_a, fruta_b);
                    }
            }
        }
        
        private void checaColisao(){
            if(cobrinha.getCoordCabeca()[0]<0 || cobrinha.getCoordCabeca()[1]<0 || cobrinha.getCoordCabeca()[0]>=canvas.getCanvasNumberOfLines() || cobrinha.getCoordCabeca()[1]>=canvas.getCanvasNumberOfRows()){
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
        private void destroiFrutas(){
            if(fruta_a!=null){
                fruta_a.decrementaContador();
                if(fruta_a.getContador()==0){
                    fruta_a=null;
                    canvas.init(canvas.getGraphics());
                }
            }
            
            if(fruta_b!=null){
                fruta_b.decrementaContador();
                if(fruta_b.getContador()==0){
                    fruta_b=null;
                    canvas.init(canvas.getGraphics());
                }
            }
        }
        
        public void geraPosFruta(Fruta fruta){
            do{
                fruta.geraPos(canvas.getCanvasNumberOfRows(), canvas.getCanvasNumberOfLines());
            }while(checaFrutaBarreira(fruta) || checaFrutaCobra(fruta));
        }
        public void geraPosFruta(Fruta fruta, Fruta outraFruta){
            do{
                fruta.geraPos(canvas.getCanvasNumberOfRows(), canvas.getCanvasNumberOfLines());
            }while(checaFrutaBarreira(fruta) || checaFrutaCobra(fruta) || checaFrutaFruta(fruta, outraFruta));
        }
        private boolean checaFrutaBarreira(Fruta fruta){
            for(int [] a: paredes.get_coordenadas()){
                if(fruta.get_coordenadas()[0]==a[0] && fruta.get_coordenadas()[1]==a[1])
                    return true;
            }
            return false;
        }
        private boolean checaFrutaFruta(Fruta fruta1, Fruta fruta2){
            if(fruta2==null)
                return false;
            else{
                    if(fruta1.get_coordenadas()[0]==fruta2.get_coordenadas()[0]
                        && fruta1.get_coordenadas()[1]==fruta2.get_coordenadas()[1])
                        return true;
            }
            return false;
        }
        private boolean checaFrutaCobra(Fruta fruta){
            for(int [] a: cobrinha.get_coordenadas()){
                if(fruta.get_coordenadas()[0]==a[0] && fruta.get_coordenadas()[1]==a[1])
                    return true;
            }
            return false;
        }
}
