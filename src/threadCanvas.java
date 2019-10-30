import java.awt.Graphics;

public class threadCanvas extends Thread {
	private CanvasJogo canvas;
	private boolean running = true; 
        private Cobra a;
	
	public threadCanvas(CanvasJogo canvas) {
		this.canvas = canvas;
                this.a = a;
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canvas.paint(canvas.getGraphics());
		}
	}
}
