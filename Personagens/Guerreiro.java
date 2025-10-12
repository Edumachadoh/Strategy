package Personagens;

import Armas.IArma;

public class Guerreiro extends ABSPersonagem{
    //private IArma armaEquipada;

    public Guerreiro() {
        // Delega a inicialização dos atributos comuns para a classe pai.
        super(15, 8, 5, 120, 50, "Pele Dura (Reduz dano recebido em 20%)", "Espadas, Machados");
        
    }
}
