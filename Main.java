import Armas.CajadoArcano;
import Armas.EspadaLonga;
import Armas.IArma;
import Batalha.Batalha;
import Personagens.ABSPersonagem;
import Personagens.Guerreiro;
import Personagens.Mago;

public class Main {
     public static void main(String[] args) {
        // 1. Crie os personagens (usando a classe abstrata para declarar as variáveis)
        System.out.println("Criando personagens...");
        
        // A variável 'heroi' pode guardar um Guerreiro, Arqueiro, Mago ou qualquer
        // outra classe que herde de ABSPersonagem.
        ABSPersonagem heroi = new Guerreiro(); 
        
        // A variável 'inimigo' também é flexível.
        ABSPersonagem inimigo = new Mago();

        // Para testar uma batalha diferente, a mudança é mínima:
        // ABSPersonagem heroi = new Arqueiro();
        // ABSPersonagem inimigo = new Guerreiro();


        // 2. Crie as armas (usando a interface para declarar as variáveis)
        System.out.println("\nForjando armas...");
        IArma armaDoHeroi = new EspadaLonga();
        IArma armaDoInimigo = new CajadoArcano();


        // 3. Equipe os personagens
        // Os métodos são chamados a partir das variáveis de tipo abstrato,
        // mas a execução acontece nos objetos concretos (Guerreiro e Mago).
        heroi.equiparArma(armaDoHeroi);
        inimigo.equiparArma(armaDoInimigo);


        // 4. Crie e inicie a batalha
        // O construtor de Batalha espera dois ABSPersonagem, então 'heroi' e 'inimigo' são perfeitos.
        Batalha arena = new Batalha(heroi, inimigo);
        arena.iniciarBatalha();
    }
}
