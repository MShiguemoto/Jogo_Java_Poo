package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Personagem {
    //Propriedades que serão passadas para a classe pai posteriormente
    private int posicaoX;
    private int posicaoY;
    private int deslocamentoX;
    private int deslocamentoY;
    private static final int DESLOCAMENTO = 3;
    private static final int POSICAO_INICIAL_X = 380;
    private static final int POSICAO_INICIAL_Y = 664;
    //
    private Image actorImage;
    private int larguraImagem;
    private int AlturaImagem;
    //ArrayList<Tiro> bolaList;

    public Personagem (){
        posicaoX = POSICAO_INICIAL_X;
        posicaoY = POSICAO_INICIAL_Y;

        //bolaList = new ArrayList<Tiro>();
    }


    public void mover(KeyEvent keyEv) {
        int codigo = keyEv.getKeyCode();
        //Retirei essas teclas por não fazer sentido no meu contexto
        //Criar as key para "Cheat";
        
        switch(codigo) {
     //       case KeyEvent.VK_UP: 
       //         deslocamentoY -= DESLOCAMENTO;
     //           break;
            
     //       case KeyEvent.VK_DOWN: 
      //          deslocamentoY += DESLOCAMENTO;
        //        break;

            case KeyEvent.VK_LEFT: 
                //if(posicaoX > 0){
                deslocamentoX -= DESLOCAMENTO;
                //}
                break;
            
            case KeyEvent.VK_RIGHT: 
            //if (posicaoX <= 1092)
                deslocamentoX += DESLOCAMENTO;
                break;

            default:    
            break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
        case KeyEvent.VK_UP:
             deslocamentoY = 0;
             break;

        case KeyEvent.VK_DOWN:
            deslocamentoY = 0;
            break;

        case KeyEvent.VK_LEFT:
            deslocamentoX = 0;
            break;

        case KeyEvent.VK_RIGHT:
            deslocamentoX = 0;
            break;

        default:
            break;
    }
}

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\actor2.jpg");
        actorImage = carregando.getImage();
        larguraImagem = actorImage.getWidth(null);
        AlturaImagem = actorImage.getHeight(null);
    }

    public int getPosicaoX(){
        return this.posicaoX;
    } 

    public int getPosicaoY(){
        return this.posicaoY;
    }

    public Image getImage(){
        return this.actorImage;
    } 

    public void Atualizar(){
        posicaoX += deslocamentoX;
        posicaoY += deslocamentoY; 
    };

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getDeslocamentoX() {
        return this.deslocamentoX;
    }

    public void setDeslocamentoX(int deslocamentoX) {
        this.deslocamentoX = deslocamentoX;
    }

    public int getDeslocamentoY() {
        return this.deslocamentoY;
    }

    public void setDeslocamentoY(int deslocamentoY) {
        this.deslocamentoY = deslocamentoY;
    }

    public Image getActorImage() {
        return this.actorImage;
    }

    public void setActorImage(Image actorImage) {
        this.actorImage = actorImage;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.AlturaImagem;
    }

    public void setAlturaImagem(int AlturaImagem) {
        this.AlturaImagem = AlturaImagem;
    }

}
