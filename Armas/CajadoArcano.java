package Armas;

import Personagens.ABSPersonagem;

public class CajadoArcano implements IArma {
     // ATRIBUTOS DUPLICADOS: Estes campos agora precisam ser declarados em TODAS as classes de armas.
    private int danoBase;
    private String efeitoEspecial;
    private int custoMana;
    private String requisitoNome;
    private int requisitoValor;

    public CajadoArcano() {
        // O construtor inicializa seus próprios atributos. Não há "super()".
        this.danoBase = 8;
        this.efeitoEspecial = "Bola de fogo - Causa queimadura (dano de 10 por 2 turnos)";
        this.custoMana = 25;
        this.requisitoNome = "Inteligencia";
        this.requisitoValor = 12;
    }

    // Implementação do método da estratégia
    @Override
    public void usar(ABSPersonagem atacante, ABSPersonagem alvo) {
        System.out.println(atacante.getClass().getSimpleName() + " ataca com o cajado arcano!");
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
