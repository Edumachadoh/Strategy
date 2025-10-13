package Armas;

import Personagens.ABSPersonagem;

public class CajadoArcano implements IArma {
    private int danoBase;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    private String efeitoNome = "Queimadura";
    private int efeitoDano = 10;
    private int efeitoDuracao = 2;
    private int efeitoChance = 100; 

    public CajadoArcano() {
        this.danoBase = 8;
        this.custoMana = 25;
        this.requisitoNome = "Inteligencia";
        this.requisitoValor = 12;
    }

    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca com o Cajado Arcano!");
        
        alvo.receberDano(this.danoBase);
        
        System.out.println(">> O ataque causou " + this.efeitoNome + "!");
        alvo.aplicarEfeito(this.efeitoNome, this.efeitoDuracao, this.efeitoDano);
    } 

    @Override
    public int getDanoBase() { return this.danoBase; }

    @Override
    public int getCustoMana() { return this.custoMana; }

    @Override
    public String getRequisitoNome() { return this.requisitoNome; }

    @Override
    public int getRequisitoValor() { return this.requisitoValor; }
}
