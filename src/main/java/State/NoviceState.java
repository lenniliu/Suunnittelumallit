package State;

public class NoviceState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +10 XP!");
        character.setExperiencePoints(character.getExperiencePoints() + 10);
        if (character.getExperiencePoints() >= 50) {
            System.out.println("Congratulations! You have advanced to Intermediate Level!");
            character.setLevel(2);
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novices cannot meditate.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novices cannot fight.");
    }
}
