import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControleTelaJogo implements KeyListener, ActionListener, Runnable {
    private TelaJogo tela;

    private boolean cima;
    private boolean baixo;
    private boolean esquerda;
    private boolean direita;

    private volatile boolean pausado;

    private Thread loop;

    public ControleTelaJogo(TelaJogo tela) {
        this.tela = tela;

        cima = false;
        baixo = false;
        esquerda = false;
        direita = true;
        pausado = true;
        loop = new Thread(this);
        atualizarMissao();

        this.tela.getStatusPanel().getVoltar().addActionListener(this);

    }
    public void iniciar() {
        pausado = false;
        tela.getGamePanel().getTimer().start();
        loop.start();
    }

    public void stop() {
        pausado = true;
        tela.getGamePanel().getTimer().stop();
    }

    private void atualizar() {
        if (cima) {
            tela.getGamePanel().getCobrinha().atualizar(Cobrinha.CIMA);
        } else if (baixo) {
            tela.getGamePanel().getCobrinha().atualizar(Cobrinha.BAIXO);
        } else if (esquerda) {
            tela.getGamePanel().getCobrinha().atualizar(Cobrinha.ESQUERDA);
        } else if (direita) {
            tela.getGamePanel().getCobrinha().atualizar(Cobrinha.DIREITA);
        }

public void atualizarMissao() {
    tela.getGamePanel().getMissao().gerarMissao;
    tela.getStatusPanel().getMissao().setText(tela.getGamePanel().getMissao().pegarMissao() );
}


    }
    private void voltarMenu() {
        stop();
        ControleTelaMenu.mostraTelaMenu();
        this.tela.setVisible(false);
        this.tela.dispose();
    }

    private boolean colidiu(Elemento a, Elemento b){
        if ((a.getX()==b.getX())&&(a.getY()==b.getY()))
             return true;
        else
             return false;
    }

   private void verificarColisao() {
       for(Alvo alvo:tela.getGamePanel().getMissao().getAlvos()) {
       if(colidiu(tela.getGamePanel().getCobrinha().getCobrinha().get(0), Alvo)){
           if(getGamePanel().getMissao().verificarResultado(alvo.getConteudo())) {

           }
       }
        
    }


    // pressiona tecla
    @Override

    public void run() {
        while (!pausado) {
            try {
                Thread.sleep(1000 / 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atualizar();
            verificarColisao();
        }
    }

   


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && !baixo) {
            cima = true;
            esquerda = false;
            direita = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && !cima) {
            baixo = true;
            esquerda = false;
            direita = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && !direita) {
            baixo = false;
            esquerda = true;
            cima = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && !esquerda) {
            baixo = false;
            cima = false;
            direita = true;
        }
    }

    // solta a tecla
    @Override
    public void keyReleased(KeyEvent e) {

    }

    // quando esta digitando
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        voltarMenu();
    }
}
