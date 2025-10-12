package Armas;

public class ABSArma {
    protected int danoBase;
    protected String efeitoEspecial;
    protected int custoMana;
    protected String requisitoNome; 
    protected int requisitoValor;   

    public ABSArma(int danoBase, String efeitoEspecial, int custoMana, String requisitoNome, int requisitoValor) {
        this.danoBase = danoBase;
        this.efeitoEspecial = efeitoEspecial;
        this.custoMana = custoMana;
        this.requisitoNome = requisitoNome;
        this.requisitoValor = requisitoValor;
    }
}
