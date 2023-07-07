package ifpr.paranavai.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements KeyListener, ActionListener{
    private Image background;
    private Personagem personagem;
    private static final int DELAY = 5;
    private Timer timer;
    private ArrayList<Tiro> ball = new ArrayList<Tiro>();

    public Fase() {
        setFocusable(true);            // + define o foco inicial do jogo
        setDoubleBuffered(true);       // + Otimização computacional
        addKeyListener(this);          // + Definindo que a própria classe irá controlar os eventos do teclado
        timer = new Timer(DELAY, this);    // + Criação do objeto Timer
        timer.start();                 // + Iniciando o nosso jogo

        ImageIcon carregando = new ImageIcon("recursos\\background.jpeg");
        background = carregando.getImage();

        personagem = new Personagem();
        personagem.carregar();
        atirar();
        //ball = new Tiro(personagem.getPosicaoX(), personagem.getPosicaoY());
    }

    
    public void paint (Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(background,0,0,null);
        graficos.drawImage(personagem.getImage(),personagem.getPosicaoX(),personagem.getPosicaoY(),this);   //graficos.drawImage(personagem.getImage(),personagem.getPosicaoX(), personagem.dispose()); Livro - Pg 7 (Criando nosso Personagem)  
        graficos.dispose();
        
    }

    public void atirar() {
    int encimaDoActor = personagem.getPosicaoX() + (personagem.getLarguraImagem() / 2);  //this.posicaoX + this.larguraImagem;
    int meioDoActor =   personagem.getPosicaoY() + personagem.getAlturaImagem();      // this.posicaoEmY + (this.alturaImagem / 2);
    Tiro Bola = new Tiro(encimaDoActor, meioDoActor);
    ball.add(Bola);
    }

        
    // public ArrayList<Tiro> getBolaList() {
    //     return this.ball;
    // }

    // public void setBolaList(ArrayList<Tiro> bolaList) {
    //     this.ball = bolaList;
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.Atualizar();
        repaint();        
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
        personagem.mover(e);
        actionPerformed(null);      // Livro - Pg 9 (Movimentando o Personagem 2) - está faltando chamar a actionPerformed  
    }


    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
        actionPerformed(null);      // Livro - Pg 9 (Movimentando o Personagem 2) - está faltando chamar a actionPerformed
    } 

    private void Ballefect(KeyEvent e){
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_SPACE:
                atirar();
            break;

            default:
            break;
        }

    }

}
