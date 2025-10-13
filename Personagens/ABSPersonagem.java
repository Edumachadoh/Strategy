package Personagens;

import java.util.HashMap;
import java.util.Map;

import Armas.IArma;

public abstract class ABSPersonagem {
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vida;
    protected int mana;
    protected String habilidadePassivaNome;
    protected String podeUsar;

    private Map<String, int[]> efeitosAtivos = new HashMap<>();
    private boolean desprevenido = true;

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
        this.armaEquipada = arma;
        System.out.println(this.getClass().getSimpleName() + " equipou: " + arma.getClass().getSimpleName());
    }

    public void atacar(ABSPersonagem alvo) {
        if (this.armaEquipada == null) {
            System.out.println(this.getClass().getSimpleName() + " está desarmado e não pode atacar!");
            return;
        }

        int custoMana = this.armaEquipada.getCustoMana();

        if (this.mana >= custoMana) {
            this.gastarMana(custoMana);
            
            System.out.println("------------------------------------");
            System.out.println(this.getClass().getSimpleName() + " gastou " + custoMana + " de mana. (Mana restante: " + this.mana + ")");
            
            this.armaEquipada.usar(this, alvo);
        } else {
            System.out.println("------------------------------------");
            System.out.println("Mana insuficiente para atacar com " + this.armaEquipada.getClass().getSimpleName() + "! O ataque falhou.");
        }
    }

    public void aplicarEfeito(String nome, int duracao, int dano) {
    System.out.println(">> " + this.getClass().getSimpleName() + " agora está sofrendo de " + nome + "!");
    this.efeitosAtivos.put(nome, new int[]{duracao, dano});
}

    private void gastarMana(int custo) {
        this.mana -= custo;
    }

    public void receberDano(int dano) {
            this.vida -= dano;
            this.desprevenido = false; 
            System.out.println(this.getClass().getSimpleName() + " sofreu " + dano + " de dano! Vida restante: " + this.vida);
        }

        public boolean isDesprevenido() {
            return this.desprevenido;
        }


    public int getVida() {
        return this.vida;
    }
    


    
}
