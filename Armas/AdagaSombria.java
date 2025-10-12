package Armas;

import Personagens.ABSPersonagem;

public class AdagaSombria implements IArma {

      // ATRIBUTOS DUPLICADOS: Estes campos agora precisam ser declarados em TODAS as classes de armas.
    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public AdagaSombria() {
        // O construtor inicializa seus próprios atributos. Não há "super()".
        this.danoBase = 10;
        this.efeitoEspecial = "Ataque furtivo - Dano triplo se o inimigo estiver desprevinido";
        this.custoMana = 10;
        this.requisitoNome = "Destreza";
        this.requisitoValor = 12;
    }

    // Implementação do método da estratégia
    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca com a adaga sombria!");
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
