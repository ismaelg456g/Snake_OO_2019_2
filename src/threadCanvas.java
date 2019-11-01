import java.awt.Graphics;

public class threadCanvas extends Thread {
	private CanvasJogo canvas;
	private boolean running = true; 
        private Cobra cobrinha;
	
	public threadCanvas(CanvasJogo canvas, Cobra cobrinha) {
		this.canvas = canvas;
                this.cobrinha = cobrinha;
	}
	
	@Override
	public void run() {
            boolean aux=true;
		while(running) {
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
			canvas.paint(canvas.getGraphics());
		}
	}
}
