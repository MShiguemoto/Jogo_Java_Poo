package ifpr.paranavai.jogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Tiro {

    private static final int VELOCIDADE = 5; // 2 => 5

    private int posicaoX;
    private int posicaoY;
    private int deslocamentoX;
    private int deslocamentoY;
    private Image bolaImage;
    private int larguraImagem;
    private int alturaImagem;


    public Tiro(int posicaoEmX, int posicaoEmY) {
    posicaoX = posicaoEmX;
    posicaoY = posicaoEmY;
    }

    public int getPosicaoX() {
        return this.posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return this.posicaoY;
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

    public Image getBolaImage() {
        return this.bolaImage;
    }

    public void setBolaImage(Image bolaImage) {
        this.bolaImage = bolaImage;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\ball.png");
        bolaImage = carregando.getImage();
        larguraImagem = bolaImage.getWidth(null);
        alturaImagem = bolaImage.getHeight(null);
    }

    public void Atualizar(){
        //Fazer o método de colisão com as paredes / teto pra direcionar a bola
        //precisa fazer os efeitos tanto nas paredes laterais quanto a superior
        // lateral = inverte a velocidade em X, continua em Y
        // superior = inverte a posição em Y, continua em X
        this.posicaoX += VELOCIDADE;
        this.posicaoY += VELOCIDADE;
    }


}
