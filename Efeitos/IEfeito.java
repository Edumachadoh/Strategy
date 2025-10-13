package Efeitos;

import Personagens.ABSPersonagem;

public interface IEfeito {
    void aplicarEfeitoDeTurno(ABSPersonagem alvo);

    boolean isFinalizado();
}
