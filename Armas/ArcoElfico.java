package Armas;

import Personagens.ABSPersonagem;

public class ArcoElfico implements IArma{
    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public ArcoElfico() {
        this.danoBase = 12;
        this.efeitoEspecial = "Chuva de Flechas - Ataque em área, atinge todos os inimigos";
        this.custoMana = 15;
        this.requisitoNome = "Destreza";
        this.requisitoValor = 8;
    }

    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " dispara uma Chuva de Flechas com o Arco Élfico!");
        
        alvo.receberDano(this.danoBase);

        System.out.println(">> As flechas caem sobre toda a área de combate!");
        
    }
    // public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
    //     System.out.println(atacante.getClass().getSimpleName() + " ataca com o arco elfico!");
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
