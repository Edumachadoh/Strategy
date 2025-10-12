package Personagens;

public abstract class ABSPersonagem {
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vida;
    protected int mana;
    protected String habilidadePassivaNome;
    protected String podeUsar;

     public ABSPersonagem(int forca, int destreza, int inteligencia, int vida, int mana, String habilidadePassivaNome, String podeUsar) {
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vida = vida;
        this.mana = mana;
        this.habilidadePassivaNome = habilidadePassivaNome;
        this.podeUsar = podeUsar;
    }
    
}
