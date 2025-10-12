package Armas;

import Personagens.ABSPersonagem;

public interface IArma {
   
    // O método da estratégia
    void usar(ABSPersonagem atacante, ABSPersonagem alvo);

    int getDanoBase();
    String getEfeitoEspecial();
    int getCustoMana();
    String getRequisitoNome();
    int getRequisitoValor();
}
