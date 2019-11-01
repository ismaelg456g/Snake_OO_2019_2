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
    
    private Cobra cobrinha;
    
    private ImageIcon icon;
    private ImageIcon iconCabeca;
    private ImageIcon iconCorpo;
    private ImageIcon iconCalda;
    
    private final Image imgTerra;
    private final Image imgCabeca;
    private final Image imgCorpo;
    private final Image imgCalda;
    
   public void paint(Graphics g) {
        int i=0;
        
        i=0;
        for(int[] coord : cobrinha.get_coordenadas()){
            if(i==0)
                g.drawImage(imgCabeca, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            else if(i==cobrinha.get_coordenadas().size()-1)
                g.drawImage(imgCalda, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            else
                g.drawImage(imgCorpo, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            i++;
        }
        if(cobrinha.get_atras_calda()[0]!=-1 || cobrinha.get_atras_calda()[1]!=-1 ){
            g.drawImage(imgTerra, cobrinha.get_atras_calda()[1]*RECT_WIDTH+MARGIN, cobrinha.get_atras_calda()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
        }
        
        
    }
    public CanvasJogo () {
         setBackground (Color.green);
         setSize(800, 600);
         cobrinha=new Cobra();
         
        // Prepare an ImageIcon
        icon = new ImageIcon("img/terra.jpg");
        iconCabeca = new ImageIcon("img/cabeca.jpg");
        iconCorpo = new ImageIcon("img/corpo.jpg");
        iconCalda = new ImageIcon("img/calda.jpg");
        // Prepare an Image object to be used by drawImage()
        imgTerra = icon.getImage();
        imgCabeca = iconCabeca.getImage();
        imgCorpo = iconCorpo.getImage();
        imgCalda = iconCalda.getImage();
        
    }
    
    public CanvasJogo (Cobra cobrinha) {
         setBackground (Color.green);
         setSize(800, 600);
         this.cobrinha = cobrinha;         
         
         // Prepare an ImageIcon
        icon = new ImageIcon("img/terra.jpg");
        iconCabeca = new ImageIcon("img/cabeca.jpg");
        iconCorpo = new ImageIcon("img/corpo.jpg");
        iconCalda = new ImageIcon("img/calda.jpg");
        // Prepare an Image object to be used by drawImage()
        imgTerra = icon.getImage();
        imgCabeca = iconCabeca.getImage();
        imgCorpo = iconCorpo.getImage();
        imgCalda = iconCalda.getImage();	
    }
    
    public void init(Graphics g){
        for(int i = 0; i < canvasNumberOfRows; i++) {
                for(int j = 0; j < canvasNumberOfLines; j++) {				
                    g.drawImage(imgTerra, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                }
            }
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
