/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.io.File;

import javax.swing.ImageIcon;
/**
 *
 * @author hercules
 */
public class CanvasJogo extends Canvas {
    public static final int RECT_WIDTH = 32;
    public static final int RECT_HEIGHT = 24;
    public static final int MARGIN = 0;

    private int canvasNumberOfRows = 25;
    private int canvasNumberOfLines = 25;
    
   public void paint(Graphics g) {
        // Prepare an ImageIcon
        ImageIcon icon = new ImageIcon("img/terra.jpg");
        ImageIcon iconCabeca = new ImageIcon("img/cabeca.jpg");
        ImageIcon iconCorpo = new ImageIcon("img/corpo.jpg");
        ImageIcon iconCalda = new ImageIcon("img/calda.jpg");
        // Prepare an Image object to be used by drawImage()
        final Image img = icon.getImage();
        final Image imgCabeca = iconCabeca.getImage();
        final Image imgCorpo = iconCorpo.getImage();
        final Image imgCalda = iconCalda.getImage();

        for(int i = 0; i < canvasNumberOfRows; i++) {
            for(int j = 0; j < canvasNumberOfLines; j++) {				
                g.drawImage(img, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            }

        }	
        g.drawImage(imgCalda, MARGIN, MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
        g.drawImage(imgCorpo, RECT_WIDTH+MARGIN, MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
        g.drawImage(imgCabeca, 2*RECT_WIDTH+MARGIN, MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
    }
    public CanvasJogo () {
         setBackground (Color.green);
         setSize(800, 600);
    }

    
    public int getCanvasNumberOfRows() {
            return canvasNumberOfRows;
    }

    public void setCanvasNumberOfRows(int canvasNumberOfRows) {
            this.canvasNumberOfRows = canvasNumberOfRows;
    }

    public int getCanvasNumberOfLines() {
            return canvasNumberOfLines;
    }

    public void setCanvasNumberOfLines(int canvasNumberOfLines) {
            this.canvasNumberOfLines = canvasNumberOfLines;
    }

}
