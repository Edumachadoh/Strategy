package Armas;

import java.util.Random;

import Personagens.ABSPersonagem;

public class EspadaLonga implements IArma{
     // ATRIBUTOS DUPLICADOS: Estes campos agora precisam ser declarados em TODAS as classes de armas.
    private int danoBase;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    private String efeitoNome = "Sangramento";
    private int efeitoDano = 5;
    private int efeitoDuracao = 3;
    private int efeitoChance = 30; 

    public EspadaLonga() {
        this.danoBase = 15;
        this.custoMana = 0;
        this.requisitoNome = "Força";
        this.requisitoValor = 10;
    }

    @Override
     public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca com a Espada Longa!");
        
        alvo.receberDano(this.danoBase);

        if (new Random().nextInt(100) < this.efeitoChance) {
            System.out.println(">> O ataque causou " + this.efeitoNome + "!");
            alvo.aplicarEfeito(this.efeitoNome, this.efeitoDuracao, this.efeitoDano);
        }
    }
    // public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
    //     System.out.println(atacante.getClass().getSimpleName() + " ataca com a Espada Longa!");
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
