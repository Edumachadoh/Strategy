package Batalha;

import java.util.Scanner;

import Personagens.ABSPersonagem;

public class Batalha {
    private ABSPersonagem personagem1;
    private ABSPersonagem personagem2;
    private int turno;

    /**
     * Construtor que define os dois combatentes.
     */
    public Batalha(ABSPersonagem p1, ABSPersonagem p2) {
        this.personagem1 = p1;
        this.personagem2 = p2;
        this.turno = 1;
    }

    /**
     * Inicia e gerencia o loop de combate até que um personagem seja derrotado.
     */
    public void iniciarBatalha() {
        System.out.println("\n====== A BATALHA COMEÇOU! ======");
        System.out.println(personagem1.getClass().getSimpleName() + " VS " + personagem2.getClass().getSimpleName());

        Scanner scanner = new Scanner(System.in);

        // O loop continua enquanto ambos estiverem vivos.
        while (personagem1.getVida() > 0 && personagem2.getVida() > 0) {
            System.out.println("\n========= Turno " + this.turno + " =========");
            
            ABSPersonagem atacante;
            ABSPersonagem defensor;

            // Decide quem ataca com base se o turno é par ou ímpar.
            if (turno % 2 != 0) {
                atacante = personagem1;
                defensor = personagem2;
            } else {
                atacante = personagem2;
                defensor = personagem1;
            }

            System.out.println("É a vez de " + atacante.getClass().getSimpleName() + " atacar!");
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine(); // Pausa o programa até o usuário teclar Enter.

            // A Batalha delega a ação para o personagem atacante.
            atacante.atacar(defensor);

            this.turno++;
        }
        
        scanner.close();
        declararVencedor();
    }

    /**
     * Anuncia o vencedor ao final do combate.
     */
    private void declararVencedor() {
        System.out.println("\n====== A BATALHA TERMINOU! ======");
        if (personagem1.getVida() <= 0) {
            System.out.println(personagem2.getClass().getSimpleName() + " é o vencedor!");
        } else {
            System.out.println(personagem1.getClass().getSimpleName() + " é o vencedor!");
        }
    }
}