package Personagens;

public class Mago extends ABSPersonagem{
     //private IArma armaEquipada;

     public Mago() {
        // Delega a inicialização dos atributos comuns para a classe pai.
        super(5, 7, 18, 70, 150, "Regeneração de Mana (+10 mana por turno)", "Cajados, Adagas");

    }
}
