package Personagens;

import Armas.IArma;

public abstract class ABSPersonagem {
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vida;
    protected int mana;
    protected String habilidadePassivaNome;
    protected String podeUsar;

    protected IArma armaEquipada;

    public ABSPersonagem(int forca, int destreza, int inteligencia, int vida, int mana, String habilidadePassivaNome, String podeUsar) {
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vida = vida;
        this.mana = mana;
        this.habilidadePassivaNome = habilidadePassivaNome;
        this.podeUsar = podeUsar;
    }

    public void equiparArma(IArma arma) {
        // TODO: Adicionar lógica para verificar se o personagem cumpre os requisitos da arma
        this.armaEquipada = arma;
        System.out.println(this.getClass().getSimpleName() + " equipou: " + arma.getClass().getSimpleName());
    }

    public void atacar(ABSPersonagem alvo) {
        if (this.armaEquipada != null) {
            System.out.println("------------------------------------");
            // A mágica do Padrão Strategy acontece aqui:
            // O personagem não sabe como a arma funciona, ele apenas a "usa".
            // A arma (a estratégia) é quem contém toda a lógica do ataque.
            this.armaEquipada.usar(this, alvo);
        } else {
            System.out.println(this.getClass().getSimpleName() + " está desarmado e não pode atacar!");
        }
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.println(this.getClass().getSimpleName() + " sofreu " + dano + " de dano! Vida restante: " + this.vida);
    }

    public int getVida() {
        return this.vida;
    }
    


    
}
