package Armas;

import Personagens.ABSPersonagem;

public class AdagaSombria implements IArma {

    private int danoBase;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public AdagaSombria() {
        this.danoBase = 10;
        this.custoMana = 10;
        this.requisitoNome = "Destreza";
        this.requisitoValor = 12;
    }

    @Override
     public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " tenta um Ataque Furtivo com a Adaga Sombria!");
        
        int danoFinal = this.danoBase;

        if (alvo.isDesprevenido()) {
            System.out.println(">> O alvo estava desprevenido! O ataque causa dano triplicado!");
            danoFinal *= 3;
        }
        
        alvo.receberDano(danoFinal);
    }
    // public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
    //     System.out.println(atacante.getClass().getSimpleName() + " ataca com a adaga sombria!");
    //     alvo.receberDano(this.danoBase);
    // }

    @Override
    public int getDanoBase() { return this.danoBase; }

    @Override
    public int getCustoMana() { return this.custoMana; }

    @Override
    public String getRequisitoNome() { return this.requisitoNome; }

    @Override
    public int getRequisitoValor() { return this.requisitoValor; }
}
