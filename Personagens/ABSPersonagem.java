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
        if (this.armaEquipada == null) {
            System.out.println(this.getClass().getSimpleName() + " está desarmado e não pode atacar!");
            return;
        }

        // Pega o custo de mana da arma equipada
        int custoMana = this.armaEquipada.getCustoMana();

        // Verifica se o personagem tem mana suficiente
        if (this.mana >= custoMana) {
            // Se tiver, gasta a mana
            this.gastarMana(custoMana);
            
            System.out.println("------------------------------------");
            System.out.println(this.getClass().getSimpleName() + " gastou " + custoMana + " de mana. (Mana restante: " + this.mana + ")");
            
            // E então executa o ataque
            this.armaEquipada.usar(this, alvo);
        } else {
            // Se não tiver, o ataque falha
            System.out.println("------------------------------------");
            System.out.println("Mana insuficiente para atacar com " + this.armaEquipada.getClass().getSimpleName() + "! O ataque falhou.");
        }
    }

    private void gastarMana(int custo) {
        this.mana -= custo;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.println(this.getClass().getSimpleName() + " sofreu " + dano + " de dano! Vida restante: " + this.vida);
    }


    public int getVida() {
        return this.vida;
    }
    


    
}
