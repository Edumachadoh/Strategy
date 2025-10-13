package Batalha;

import java.util.Scanner;

import Armas.AdagaSombria;
import Armas.ArcoElfico;
import Armas.CajadoArcano;
import Armas.EspadaLonga;
import Armas.IArma;
import Armas.MachadoGuerra;
import Personagens.ABSPersonagem;

public class Batalha {

    private ABSPersonagem personagem1;
    private ABSPersonagem personagem2;
    private int turno;
    private Scanner scanner;

    public Batalha(ABSPersonagem p1, ABSPersonagem p2) {
        this.personagem1 = p1;
        this.personagem2 = p2;
        this.turno = 1;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarBatalha() {
        System.out.println("\n====== A BATALHA COMEÇOU! ======");
        System.out.println(personagem1.getClass().getSimpleName() + " VS " + personagem2.getClass().getSimpleName());

        while (personagem1.getVida() > 0 && personagem2.getVida() > 0) {
            System.out.println("\n========= Turno " + this.turno + " =========");
            
            ABSPersonagem atacante = (turno % 2 != 0) ? personagem1 : personagem2;
            ABSPersonagem defensor = (turno % 2 != 0) ? personagem2 : personagem1;

            executarTurno(atacante, defensor);

            this.turno++;
        }
        
        declararVencedor();
        scanner.close();
    }

    private void executarTurno(ABSPersonagem atacante, ABSPersonagem defensor) {
        System.out.println("É a vez de " + atacante.getClass().getSimpleName() + "!");
        System.out.println("Escolha sua ação: \n 1 - Atacar \n 2 - Trocar de Arma e Atacar");
        System.out.print("Sua escolha: ");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                atacante.atacar(defensor);
                break;
            case "2":
                boolean trocouComSucesso = menuTrocarArma(atacante);
                
                if (trocouComSucesso) {
                    System.out.println("Após a troca, o personagem ataca!");
                    atacante.atacar(defensor);
                } else {
                    System.out.println("Como a troca de arma falhou, o personagem perdeu o turno.");
                }
                break;
            default:
                System.out.println("Opção inválida! O personagem hesitou e perdeu o turno.");
                break;
        }
    }

    private boolean menuTrocarArma(ABSPersonagem personagem) {
        System.out.println("\n--- Trocar Arma ---");
        System.out.println("Escolha a nova arma para equipar:");
        System.out.println("1 - Machado de Guerra");
        System.out.println("2 - Espada Longa");
        System.out.println("3 - Cajado Arcano");
        System.out.println("4 - Arco Elfico");
        System.out.println("5 - Adaga Sombria");
        System.out.print("Sua escolha: ");
        String escolhaArma = scanner.nextLine();

        IArma novaArma;

        switch (escolhaArma) {
            case "1": novaArma = new MachadoGuerra(); break;
            case "2": novaArma = new EspadaLonga(); break;
            case "3": novaArma = new CajadoArcano(); break;
            case "4": novaArma = new ArcoElfico(); break;
            case "5": novaArma = new AdagaSombria(); break;
            default:
                System.out.println("Opção de arma inválida! A troca falhou.");
                return false; 
        }

        personagem.equiparArma(novaArma);
        return true;
    }

    private void declararVencedor() {
        System.out.println("\n====== A BATALHA TERMINOU! ======");
        if (personagem1.getVida() <= 0) {
            System.out.println(personagem2.getClass().getSimpleName() + " é o vencedor!");
        } else {
            System.out.println(personagem1.getClass().getSimpleName() + " é o vencedor!");
        }
    }
}