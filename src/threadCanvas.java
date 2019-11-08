import java.awt.Graphics;

public class threadCanvas extends Thread {
	private CanvasJogo canvas;
        private Cobra cobrinha;
        Fruta fruta_a;
        Fruta fruta_b;
        private boolean fimDeJogo;
	
	public threadCanvas(CanvasJogo canvas, Cobra cobrinha) {
		this.canvas = canvas;
                this.cobrinha = cobrinha;
                fimDeJogo=false;
	}
	
	@Override
	public void run() {
            boolean aux=true;
		while(!fimDeJogo) {
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
                        checaColisaoParede();
                        geradorFrutas();
                            
                        if(fruta_a!=null){
                            if(fruta_a.checaColisao(cobrinha)){
                                fruta_a=null;
                                canvas.paint(canvas.getGraphics());
                            }else
                                canvas.paint(canvas.getGraphics(),fruta_a);
                        }
                        else
                            canvas.paint(canvas.getGraphics());
		}
                
	}
        
        private void geradorFrutas(){
            if(fruta_a==null && fruta_b == null){
                fruta_a = new FrutaSimples();
                fruta_a.geraPos(25, 25);}
//            }else if(fruta_a!=null && fruta_b==null){
//                fruta
//            }
        }
        
        private void checaColisaoParede(){
            if(cobrinha.getCoordCabeca()[0]<0 || cobrinha.getCoordCabeca()[1]<0 || cobrinha.getCoordCabeca()[0]>=25 || cobrinha.getCoordCabeca()[1]>=25){
                fimDeJogo = true;
            }
        }
}
