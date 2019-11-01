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
    private ImageIcon iconCabecaB;
    private ImageIcon iconCabecaE;
    private ImageIcon iconCabecaC;
    private ImageIcon iconCorpo;
    private ImageIcon iconCalda;
    private ImageIcon iconCaldaB;
    private ImageIcon iconCaldaE;
    private ImageIcon iconCaldaC;
    
    private final Image imgTerra;
    private final Image imgCabeca;
    private final Image imgCabecaB;
    private final Image imgCabecaE;
    private final Image imgCabecaC;
    private final Image imgCorpo;
    private final Image imgCalda;
    private final Image imgCaldaB;
    private final Image imgCaldaE;
    private final Image imgCaldaC;
    
   public void paint(Graphics g) {
        int i=0;
        
        i=0;
        for(int[] coord : cobrinha.get_coordenadas()){
            if(i==0)
                switch(cobrinha.get_direcao()){
                    case 'd':
                        g.drawImage(imgCabeca, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'e':
                        g.drawImage(imgCabecaE, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'b':
                        g.drawImage(imgCabecaB, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'c':
                        g.drawImage(imgCabecaC, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                }
            else if(i==cobrinha.get_coordenadas().size()-1){
                switch(cobrinha.get_direcao_calda()){
                    case 'd':
                        g.drawImage(imgCalda, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'e':
                        g.drawImage(imgCaldaE, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'b':
                        g.drawImage(imgCaldaB, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'c':
                        g.drawImage(imgCaldaC, coord[1]*RECT_WIDTH+MARGIN, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                }
            }
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
        iconCabecaB = new ImageIcon("img/cabecaB.jpg");
        iconCabecaE = new ImageIcon("img/cabecaE.jpg");
        iconCabecaC = new ImageIcon("img/cabecaC.jpg");
        iconCorpo = new ImageIcon("img/corpo.jpg");
        iconCalda = new ImageIcon("img/calda.jpg");
        iconCaldaB = new ImageIcon("img/caldaB.jpg");
        iconCaldaE = new ImageIcon("img/caldaE.jpg");
        iconCaldaC = new ImageIcon("img/caldaC.jpg");
        // Prepare an Image object to be used by drawImage()
        imgTerra = icon.getImage();
        imgCabeca = iconCabeca.getImage();
        imgCabecaB = iconCabecaB.getImage();
        imgCabecaE = iconCabecaE.getImage();
        imgCabecaC = iconCabecaC.getImage();
        imgCorpo = iconCorpo.getImage();
        imgCalda = iconCalda.getImage();
        imgCaldaB = iconCaldaB.getImage();
        imgCaldaE = iconCaldaE.getImage();
        imgCaldaC = iconCaldaC.getImage();
        
    }
    
    public CanvasJogo (Cobra cobrinha) {
         setBackground (Color.green);
         setSize(800, 600);
         this.cobrinha = cobrinha;         
         
        // Prepare an ImageIcon
        icon = new ImageIcon("img/terra.jpg");
        iconCabeca = new ImageIcon("img/cabeca.jpg");
        iconCabecaB = new ImageIcon("img/cabecaB.jpg");
        iconCabecaE = new ImageIcon("img/cabecaE.jpg");
        iconCabecaC = new ImageIcon("img/cabecaC.jpg");
        iconCorpo = new ImageIcon("img/corpo.jpg");
        iconCalda = new ImageIcon("img/calda.jpg");
        iconCaldaB = new ImageIcon("img/caldaB.jpg");
        iconCaldaE = new ImageIcon("img/caldaE.jpg");
        iconCaldaC = new ImageIcon("img/caldaC.jpg");
        // Prepare an Image object to be used by drawImage()
        imgTerra = icon.getImage();
        imgCabeca = iconCabeca.getImage();
        imgCabecaB = iconCabecaB.getImage();
        imgCabecaE = iconCabecaE.getImage();
        imgCabecaC = iconCabecaC.getImage();
        imgCorpo = iconCorpo.getImage();
        imgCalda = iconCalda.getImage();
        imgCaldaB = iconCaldaB.getImage();
        imgCaldaE = iconCaldaE.getImage();
        imgCaldaC = iconCaldaC.getImage();	
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
