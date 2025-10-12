package Armas;

import Personagens.ABSPersonagem;

public class MachadoGuerra implements IArma {

     // ATRIBUTOS DUPLICADOS: Estes campos agora precisam ser declarados em TODAS as classes de armas.
    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public MachadoGuerra() {
        // O construtor inicializa seus próprios atributos. Não há "super()".
        this.danoBase = 18;
        this.efeitoEspecial = "Golpe esmagador - Chance de 25% de atordoar o inimigo (perde 1 turno)";
        this.custoMana = 5;
        this.requisitoNome = "Força";
        this.requisitoValor = 15;
    }

    // Implementação do método da estratégia
    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca " + alvo.getClass().getSimpleName() + " com a Espada Longa!");
        alvo.receberDano(this.getDanoBase());
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

   

