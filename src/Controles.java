import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener{
    private Cobra cobrinha;
    
    public Controles(Cobra cobrinha){
        this.cobrinha = cobrinha;
    }
    
    @Override
 
    public void keyPressed(KeyEvent event) {
        switch(event.getKeyCode()){
            case 37:
                cobrinha.set_direcao('e');
                break;
            case 38:
                cobrinha.set_direcao('c');
                break;
            case 39:
                cobrinha.set_direcao('d');
                break;
            case 40:
                cobrinha.set_direcao('b');       
        }
        
    }
 
    @Override

    public void keyReleased(KeyEvent event) {

//        printEventInfo("Key Released", event);

    }

    @Override
    public void keyTyped(KeyEvent event) {

//        printEventInfo("Key Typed", event);

    }
}