package dk.s180076galgelegmadsstorgaardnielsen.menu.settings;

public class SettingsModel {
    String difficultyLevel = "easy";

    public SettingsModel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public SettingsModel() {
    }


    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
