public class Missao{
    private int a;
    private int b;
    private int resultado;

    private String operador;

    private boolean soma;
    private boolean subtracao;
    private boolean multiplicacao;
    private boolean divisao;
    private boolean tudo;

    private Random gerador;

    private ArrayList<Alvo> alvos;

public Missao(int tipo) {
    soma = false;
    subtracao = false;
    multiplicacao = false;
    divisao = false;
    tudo = false;

    gerador = new Random();

    alvos = new ArrayList<>();

    alvos.add(new Alvo(20*-5, 20*-5, 20, 20, 0));
    alvos.add(new Alvo(20*-5, 20*-5, 20, 20, 0));
    alvos.add(new Alvo(20*-5, 20*-5, 20, 20, 0));
    alvos.add(new Alvo(20*-5, 20*-5, 20, 20, 0));

    setTipoMissao(tipo);
}

    public void gerarMissao(){

    public String pegarMissao(){
            return a+" "+operador+" "+b+" = ":
        }

        public void desenhar(Graphics g) {
            for (Alvo alvo : alvos){
                alvo.desenhar(g);
            }
        }

        private void gerarLocais() {
            for(int i = alvos.size()-1; i >=0; i--){
                int x = gerador.nextInt(24);
                int y = gerador.nextInt(24);
                alvos.get(i).mover(x*20, y*20);
            }
        }

        private void gerarResultados() {
            for(int i = alvos.size()-1; i >=0; i--){
                int r = gerador.nextInt(100);
                alvos.get(i).setConteudo(r);
            }
        }  

        public boolean verificarResultado(int resultado){
            if(this.resultado == resultado) {
                return true;
            }else {
                return false;
            }
        }
        public void setTipoMissao(int tipo) {
            switch (tipo) {
                case 1: {
                    soma = true;
                    subtracao = false;
                    multiplicacao = false;
                    divisao = false;
                    tudo = false;
                    break;
         } 
            case 2: {
                soma = false;
                subtracao = true;
                multiplicacao = false;
                divisao = false;
                tudo = false;
                break;
        }
            case 3: {
            soma = false;
            subtracao = false;
            multiplicacao = true;
            divisao = false;
            tudo = false;
            break;

         }
             case 4: {
        soma = false;
        subtracao = false;
        multiplicacao = false;
        divisao = true;
        tudo = false;
        break;

        }  case 5: {
            soma = false;
            subtracao = false;
            multiplicacao = false;
            divisao = false;
            tudo = true;
            break;
              }
         }
 }

public  ArrayList><Alvo> getAlvos() {
    return alvos;
}

}

    public void gerarMissao() {
        if(soma){
            a=gerador.nextInt(10);
            b=gerador.nextInt(10);
            operador="+";
            resultado=a+b;
        }if(subtracao){
                a=gerador.nextInt(10);
                b=gerador.nextInt(10);
                operador="-";
                resultado=a-b;
            }if(multiplicacao){
                    a=gerador.nextInt(10);
                    b=gerador.nextInt(10);
                    operador="*";
                    resultado=a*b;
                }  if(divisao){
                    a=gerador.nextInt(10);
                    b=gerador.nextInt(10);
                    operador="/";
                    if (a>b) {
                        if(a==0) {a++;}
                        if(b==0) {b++;}
                        a=a*b;
                        resultado=a/b;
                    }if(a<b){
                        if(a==0) {a++;}
                        if(b==0) {b++;}
                        b=a*b;
                        resultado=b/a;
                    }

        }
   if(tudo) {
       int i= gerador.nextInt(4);
       switch(i) {
         case 1: {
        a=gerador.nextInt(10);
        b=gerador.nextInt(10);
        operador="+";
        resultado=a+b;
        break;
    }
     case 2: {
            a=gerador.nextInt(10);
            b=gerador.nextInt(10);
            operador="-";
            resultado=a-b;
            break;
        }
        case 3: {
                a=gerador.nextInt(10);
                b=gerador.nextInt(10);
                operador="*";
                resultado=a*b;
                break;
            }  
            case 4: {
                a=gerador.nextInt(10);
                b=gerador.nextInt(10);
                operador="/";
                if (a>b) {
                    if(a==0) {a++;}
                    if(b==0) {b++;}
                    a=a*b;
                    resultado=a/b;
                }if(a<b){
                    if(a==0) {a++;}
                    if(b==0) {b++;}
                    b=a*b;
                    resultado=b/a;
                }
                break;

       }
   }
   alvos.get(0).setConteudo(resultado);
   gerarLocais();
   gerarResultados();
   
    }

    public String pegarMissao(){
        return a+" "+operador+" "+b+" = ";
    }
}
}