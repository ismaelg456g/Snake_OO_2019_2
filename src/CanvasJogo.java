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
    public static final int RECT_WIDTH = 50;
    public static final int RECT_HEIGHT = 37;
    public static final int MARGIN = RECT_HEIGHT;

    private int canvasNumberOfRows = 16;
    private int canvasNumberOfLines = 14;
    
    private Cobra cobrinha;
    private Barreira paredes;
    
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
    private ImageIcon iconFrutaSim;
    private ImageIcon iconFrutaBomba;
    private ImageIcon iconFrutaGrande;
    private ImageIcon iconFrutaDiminuta;
    private ImageIcon iconGameOver;
    private ImageIcon iconMorte;
    private ImageIcon icon0;
    private ImageIcon icon1;
    private ImageIcon icon2;
    private ImageIcon icon3;
    private ImageIcon icon4;
    private ImageIcon icon5;
    private ImageIcon icon6;
    private ImageIcon icon7;
    private ImageIcon icon8;
    private ImageIcon icon9;
    private ImageIcon iconParede;
    
    private Image imgTerra;
    private Image imgCabeca;
    private Image imgCabecaB;
    private Image imgCabecaE;
    private Image imgCabecaC;
    private Image imgCorpo;
    private Image imgCalda;
    private Image imgCaldaB;
    private Image imgCaldaE;
    private Image imgCaldaC;
    private Image imgFrutaSim;
    private Image imgFrutaBomba;
    private Image imgFrutaGrande;
    private Image imgFrutaDiminuta;
    private Image imgGameOver;
    private Image imgMorte;
    private Image img0;
    private Image img1;
    private Image img2;
    private Image img3;
    private Image img4;
    private Image img5;
    private Image img6;
    private Image img7;
    private Image img8;
    private Image img9;
    private Image imgParede;
    
   public void paint(Graphics g) {
        desenhaCobra(g);
        desenhaPlacar(g, cobrinha.getPlacar());
    }
   public void paint(Graphics g, Fruta fruta) {
        desenhaCobra(g);
        desenhaFruta(g, fruta);
        desenhaPlacar(g, cobrinha.getPlacar());
    }
   public void paint(Graphics g, Fruta fruta_a, Fruta fruta_b) {
        desenhaCobra(g);
        desenhaFruta(g, fruta_a);
        desenhaFruta(g, fruta_b);
        desenhaPlacar(g, cobrinha.getPlacar());
    }
   
    public void gameOver(Graphics g){
         g.drawImage(imgGameOver, 3*RECT_WIDTH, 5*RECT_HEIGHT+MARGIN, 10*RECT_WIDTH, 3*RECT_HEIGHT, null);
         g.drawImage(imgMorte, cobrinha.get_coordenadas().get(1)[1]*RECT_WIDTH, cobrinha.get_coordenadas().get(1)[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
    }
    
    public void desenhaBarreira(Graphics g){
        for(int[] a: paredes.get_coordenadas()){
            g.drawImage(imgParede, a[1]*RECT_WIDTH, a[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
        }
    }
    
    public void desenhaFruta(Graphics g, Fruta fruta){
        switch(fruta.get_tipo()){
            case 's':
                g.drawImage(imgFrutaSim, fruta.get_coordenadas()[1]*RECT_WIDTH, fruta.get_coordenadas()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                break;
            case 'b':
                g.drawImage(imgFrutaBomba, fruta.get_coordenadas()[1]*RECT_WIDTH, fruta.get_coordenadas()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                break;
            case 'g':
                g.drawImage(imgFrutaGrande, fruta.get_coordenadas()[1]*RECT_WIDTH, fruta.get_coordenadas()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                break;
            case 'd':
                g.drawImage(imgFrutaDiminuta, fruta.get_coordenadas()[1]*RECT_WIDTH, fruta.get_coordenadas()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                break;
        }
    }
   
    public void desenhaCobra(Graphics g){
        int i=0;
        
        i=0;
        for(int[] coord : cobrinha.get_coordenadas()){
            if(i==0)
                switch(cobrinha.get_direcao()){
                    case 'd':
                        g.drawImage(imgCabeca, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'e':
                        g.drawImage(imgCabecaE, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'b':
                        g.drawImage(imgCabecaB, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'c':
                        g.drawImage(imgCabecaC, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                }
            else if(i==cobrinha.get_coordenadas().size()-1){
                switch(cobrinha.get_direcao_calda()){
                    case 'd':
                        g.drawImage(imgCalda, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'e':
                        g.drawImage(imgCaldaE, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'b':
                        g.drawImage(imgCaldaB, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                    case 'c':
                        g.drawImage(imgCaldaC, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                        break;
                }
            }
            else
                g.drawImage(imgCorpo, coord[1]*RECT_WIDTH, coord[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            i++;
        }
        if(cobrinha.get_atras_calda()[0]!=-1 || cobrinha.get_atras_calda()[1]!=-1 ){
            g.drawImage(imgTerra, cobrinha.get_atras_calda()[1]*RECT_WIDTH, cobrinha.get_atras_calda()[0]*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
            
        }
    }
    public CanvasJogo () {
//        setBackground (Color.green);
        setSize(800, 600);
        cobrinha=new Cobra();
         
        initImg();
        
        paredes = new Barreira();
    }
    
    public CanvasJogo (Cobra cobrinha) {
        setBackground (Color.black);
        setSize(800, 600);
        this.cobrinha = cobrinha;         
         
        initImg();
        
        paredes = new Barreira();
    }
    
    public CanvasJogo (Cobra cobrinha, Barreira paredes) {
        setBackground (Color.black);
        setSize(800, 600);
        this.cobrinha = cobrinha;         
        this.paredes = paredes;
         
        initImg();
        
    }
    
    private void initImg(){
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
        iconFrutaSim = new ImageIcon("img/frutaSim.jpg");
        iconFrutaBomba = new ImageIcon("img/frutaBomba.jpg");
        iconFrutaGrande = new ImageIcon("img/frutaGrande.jpg");
        iconFrutaDiminuta = new ImageIcon("img/frutaDiminuta.jpg");
        iconGameOver = new ImageIcon("img/gameover.jpg");
        iconMorte = new ImageIcon("img/morte.jpg");
        icon0 = new ImageIcon("img/0.jpg");
        icon1 = new ImageIcon("img/1.jpg");
        icon2 = new ImageIcon("img/2.jpg");
        icon3 = new ImageIcon("img/3.jpg");
        icon4 = new ImageIcon("img/4.jpg");
        icon5 = new ImageIcon("img/5.jpg");
        icon6 = new ImageIcon("img/6.jpg");
        icon7 = new ImageIcon("img/7.jpg");
        icon8 = new ImageIcon("img/8.jpg");
        icon9 = new ImageIcon("img/9.jpg");
        iconParede = new ImageIcon("img/parede.jpg");
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
        imgFrutaSim = iconFrutaSim.getImage();
        imgFrutaBomba = iconFrutaBomba.getImage();
        imgFrutaGrande = iconFrutaGrande.getImage();
        imgFrutaDiminuta = iconFrutaDiminuta.getImage();
        imgGameOver = iconGameOver.getImage();
        imgMorte = iconMorte.getImage();
        img0 = icon0.getImage();
        img1 = icon1.getImage();
        img2 = icon2.getImage();
        img3 = icon3.getImage();
        img4 = icon4.getImage();
        img5 = icon5.getImage();
        img6 = icon6.getImage();
        img7 = icon7.getImage();
        img8 = icon8.getImage();
        img9 = icon9.getImage();
        imgParede = iconParede.getImage();
    }
    
    public void init(Graphics g){
        for(int i = 0; i < canvasNumberOfRows; i++) {
                for(int j = 0; j < canvasNumberOfLines; j++) {				
                    g.drawImage(imgTerra, i*RECT_WIDTH, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                }
            }
        desenhaBarreira(g);
        desenhaPlacar(g, cobrinha.getPlacar());
    }
    public void desenhaPlacar(Graphics g, int pontos){
        int i=0;
        for(int aux=100000000; aux>=1; aux=aux/10, i++){
            switch(pontos/aux){
                case 0:
                    g.drawImage(img0, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 1:
                    g.drawImage(img1, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 2:
                    g.drawImage(img2, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 3:
                    g.drawImage(img3, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 4:
                    g.drawImage(img4, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 5:
                    g.drawImage(img5, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 6:
                    g.drawImage(img6, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 7:
                    g.drawImage(img7, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 8:
                    g.drawImage(img8, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
                case 9:
                    g.drawImage(img9, (canvasNumberOfRows-9+i)*RECT_WIDTH, 0, RECT_WIDTH, RECT_HEIGHT, null);
                    break;
            }
            pontos = pontos%aux;
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
    public Barreira getParedes(){
        return paredes;
    }
}
