package Armas;

import java.util.Random;

import Personagens.ABSPersonagem;

public class MachadoGuerra implements IArma {

    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    private String efeitoNome = "Atordoado";
    private int efeitoDuracao = 1; 
    private int efeitoChance = 25;

    public MachadoGuerra() {
        this.danoBase = 18;
        this.efeitoEspecial = "Golpe esmagador - Chance de 25% de atordoar o inimigo (perde 1 turno)";
        this.custoMana = 5;
        this.requisitoNome = "Força";
        this.requisitoValor = 15;
    }

    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " desfere um Golpe Esmagador com o Machado de Guerra!");
        
        alvo.receberDano(this.danoBase);
        
        if (new Random().nextInt(100) < this.efeitoChance) {
            System.out.println(">> O golpe foi tão forte que atordoou " + alvo.getClass().getSimpleName() + "!");
            alvo.aplicarEfeito(this.efeitoNome, this.efeitoDuracao, 0);
        }
    }
    // public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
    //     System.out.println(atacante.getClass().getSimpleName() + " ataca " + alvo.getClass().getSimpleName() + " com a Espada Longa!");
    //     alvo.receberDano(this.getDanoBase());
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

   

