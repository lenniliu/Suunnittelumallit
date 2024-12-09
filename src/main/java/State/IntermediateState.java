package State;

public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +15 XP!");
        character.setExperiencePoints(character.getExperiencePoints() + 15);
        if (character.getExperiencePoints() >= 150) {
            System.out.println("Congratulations! You have advanced to Expert Level!");
            character.setLevel(3);
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating... +20 HP!");
        character.setHealthPoints(character.getHealthPoints() + 20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediates cannot fight.");
    }
}

