package State;

public class ExpertState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +20 XP!");
        character.setExperiencePoints(character.getExperiencePoints() + 20);
        if (character.getExperiencePoints() >= 300) {
            System.out.println("Congratulations! You have advanced to Master Level!");
            character.setLevel(4);
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating... +25 HP!");
        character.setHealthPoints(character.getHealthPoints() + 25);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting... +30 XP, -15 HP!");
        character.setExperiencePoints(character.getExperiencePoints() + 30);
        character.setHealthPoints(character.getHealthPoints() - 15);
        if (character.getExperiencePoints() >= 300) {
            System.out.println("Congratulations! You have advanced to Master Level!");
            character.setLevel(4);
            character.setState(new MasterState());
        }
    }
}
