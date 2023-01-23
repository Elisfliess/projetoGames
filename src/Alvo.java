 Import java.aw.Graphics;

public class Alvo extends Elemento {

    private int conteudo;

    private ImageIcon imagem;

    public Alvo(int x, int y, int largura, int altura)
        super(x, y, largura, altura);
        this.conteudo = conteudo;
        this.imagem = new ImageIcon("res/img/bolinha.png") //coloquei a localização de qual pasta esta a imagem 
    }

    @Override
    public void desenhar (Graphics g) { 

        g.drawImage(imagem.getImage(), getX()-2, getY()-2, getLargura()-2, getAltura()-2,null);
        g.setColor(Color.Black);
        g.drawString(String.valueOf(conteudo), getX(), getY()+14);

    }

    public int getConteudo(){
        return conteudo;
    }

    public void setConteudo(int conteudo){
        this.conteudo = conteudo;
    }
}