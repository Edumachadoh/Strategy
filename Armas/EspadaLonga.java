package Armas;

import Personagens.ABSPersonagem;

public class EspadaLonga implements IArma{
     // ATRIBUTOS DUPLICADOS: Estes campos agora precisam ser declarados em TODAS as classes de armas.
    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public EspadaLonga() {
        // O construtor inicializa seus próprios atributos. Não há "super()".
        this.danoBase = 15;
        this.efeitoEspecial = "Corte Profundo (30% chance de sangramento)";
        this.custoMana = 0;
        this.requisitoNome = "Força";
        this.requisitoValor = 10;
    }

    // Implementação do método da estratégia
    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca com a Espada Longa!");
        alvo.receberDano(this.danoBase);
    }

    // IMPLEMENTAÇÃO DOS GETTERS: Esta lógica também será repetida em todas as classes.
    @Override
    public int getDanoBase() { return this.danoBase; }
    
    @Override
    public String getEfeitoEspecial() { return this.efeitoEspecial; }

    @Override
    public int getCustoMana() { return this.custoMana; }

    @Override
    public String getRequisitoNome() { return this.requisitoNome; }

    @Override
    public int getRequisitoValor() { return this.requisitoValor; }
}
