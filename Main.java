import Armas.CajadoArcano;
import Armas.EspadaLonga;
import Armas.IArma;
import Batalha.Batalha;
import Personagens.ABSPersonagem;
import Personagens.Guerreiro;
import Personagens.Mago;

public class Main {
     public static void main(String[] args) {
        System.out.println("Criando personagens...");
        
        // criação do heroi
        ABSPersonagem heroi = new Guerreiro(); 
        
        // criação do inimigo
        ABSPersonagem inimigo = new Mago();

        // criação das armas do heroi e do inimigo
        System.out.println("\nForjando armas...");
        IArma armaDoHeroi = new EspadaLonga();
        IArma armaDoInimigo = new CajadoArcano();


        // equipar as armas do heri oe do inimigo
        heroi.equiparArma(armaDoHeroi);
        inimigo.equiparArma(armaDoInimigo);


        // criar uma batalha via metodo construtor
        Batalha arena = new Batalha(heroi, inimigo);
        arena.iniciarBatalha();
    }
}
