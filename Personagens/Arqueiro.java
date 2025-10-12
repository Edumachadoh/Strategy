package Personagens;

import Armas.IArma;

public class Arqueiro extends ABSPersonagem{
     //private IArma armaEquipada;

     public Arqueiro() {
        // Delega a inicialização dos atributos comuns para a classe pai.
        super(8, 15, 7, 90, 80, "Esquiva (25% de chance de evitar um ataque)", "Arcos, Adagas");

    }
}
