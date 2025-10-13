package Efeitos;

import Personagens.ABSPersonagem;

public class CorteProfundo implements IEfeito{
    private int duracao = 3; 
    private int danoPorTurno = 5;

    @Override
    public void aplicarEfeitoDeTurno(ABSPersonagem alvo) {
        System.out.println(">> Efeito Sangramento: " + alvo.getClass().getSimpleName() + " sofre " + danoPorTurno + " de dano!");
        alvo.receberDano(danoPorTurno); 
        this.duracao--;
    }

    @Override
    public boolean isFinalizado() {
        return this.duracao <= 0;
    }
}
