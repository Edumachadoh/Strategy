package Personagens;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Armas.AdagaSombria;
import Armas.ArcoElfico;
import Armas.CajadoArcano;
import Armas.EspadaLonga;
import Armas.IArma;
import Armas.MachadoGuerra;

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
        // --- VERIFICAÇÃO 1: Requisito de Atributo ---
        boolean atendeRequisitoAtributo = false;
        String requisitoNome = arma.getRequisitoNome().toLowerCase();
        int requisitoValor = arma.getRequisitoValor();

        switch (requisitoNome) {
            case "força":
                if (this.forca >= requisitoValor) atendeRequisitoAtributo = true;
                break;
            case "destreza":
                if (this.destreza >= requisitoValor) atendeRequisitoAtributo = true;
                break;
            case "inteligencia":
                if (this.inteligencia >= requisitoValor) atendeRequisitoAtributo = true;
                break;
            default:
                atendeRequisitoAtributo = true; // Se não houver requisito, permite
                break;
        }

        if (!atendeRequisitoAtributo) {
            System.out.println(">> FALHA AO EQUIPAR: " + this.getClass().getSimpleName() + " não tem " + requisitoNome + " suficiente para usar " + arma.getClass().getSimpleName() + ".");
            return; // Encerra o método se o atributo for insuficiente
        }

        // --- VERIFICAÇÃO 2: Permissão por Classe (Sua Lógica Switch) ---
        boolean tipoPermitido = false;
        String nomeDaClasse = this.getClass().getSimpleName();

        switch (nomeDaClasse) {
            case "Guerreiro":
                // Guerreiro só pode usar EspadaLonga ou MachadoGuerra
                if (arma instanceof EspadaLonga || arma instanceof MachadoGuerra) {
                    tipoPermitido = true;
                }
                break;
            
            case "Arqueiro":
                // Arqueiro só pode usar ArcoElfico ou AdagaSombria
                if (arma instanceof ArcoElfico || arma instanceof AdagaSombria) {
                    tipoPermitido = true;
                }
                break;
            
            case "Mago":
                // Mago só pode usar CajadoArcano ou AdagaSombria
                if (arma instanceof CajadoArcano || arma instanceof AdagaSombria) {
                    tipoPermitido = true;
                }
                break;

            default:
                // Se a classe não estiver listada, não permite por segurança.
                System.out.println(">> AVISO: Classe de personagem '" + nomeDaClasse + "' não possui regras de equipamento definidas.");
                tipoPermitido = false;
                break;
        }

        if (!tipoPermitido) {
            System.out.println(">> FALHA AO EQUIPAR: " + nomeDaClasse + " não pode usar armas do tipo " + arma.getClass().getSimpleName() + ".");
            return; 
        }

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

    // nao consegui um jeito no qual receberDano não seja public, mas eu acho que o ideal é talvez não ser
    public void receberDano(int dano) {
        int danoFinal = dano;

        if (new Random().nextInt(100) < 20) {
            System.out.println(">> GOLPE CRÍTICO recebido! O dano foi amplificado! <<");

            // --- CORREÇÃO AQUI ---
            // Usamos Math.ceil para arredondar o dano adicional para cima,
            // garantindo que seja no mínimo 1.
            int danoAdicional = (int) Math.ceil(dano * 0.05);

            danoFinal += danoAdicional;
        }

        this.vida -= danoFinal;
        this.desprevenido = false;
        System.out.println(this.getClass().getSimpleName() + " sofreu " + danoFinal + " de dano! Vida restante: " + this.vida);
    }
    public boolean isDesprevenido() {
        return this.desprevenido;
    }


    public int getVida() {
        return this.vida;
    }
    


    
}
