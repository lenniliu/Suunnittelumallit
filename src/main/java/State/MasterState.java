package State;

public class MasterState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You are a Master! There's nothing more to train.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are a Master! There's nothing more to meditate.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are a Master! There's nothing more to fight.");
    }
}

