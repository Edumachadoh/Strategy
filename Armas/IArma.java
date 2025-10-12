package Armas;

import Personagens.ABSPersonagem;

public interface IArma {
   
    // O método da estratégia
    void usar(ABSPersonagem atacante, ABSPersonagem alvo);

    // Getters para os atributos que toda arma deve ter
    int getDanoBase();
    String getEfeitoEspecial();
    int getCustoMana();
    String getRequisitoNome();
    int getRequisitoValor();
}
