package Efeitos;

import Personagens.ABSPersonagem;

public class BolaFogo implements IEfeito{
    private int duracao = 2; 
    private int danoPorTurno = 10;

    @Override
    public void aplicarEfeitoDeTurno(ABSPersonagem alvo) {
        System.out.println(">> Efeito Queimadura: " + alvo.getClass().getSimpleName() + " sofre " + danoPorTurno + " de dano de fogo!");
        alvo.receberDano(danoPorTurno);
        this.duracao--;
    }

    @Override
    public boolean isFinalizado() {
        return this.duracao <= 0;
    }
}
