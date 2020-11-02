package dk.s180076galgelegmadsstorgaardnielsen.menu.settings;

public class SettingController {
    private SettingsModel settingsModel;
    private String difficultyLevel;

    public SettingController() {
        settingsModel = new SettingsModel();
    }

    public void setDifficultyLevel(String difficultyLevel) {
        settingsModel.setDifficultyLevel(difficultyLevel);
    }

    public String getDifficultyLevel() {
        return settingsModel.getDifficultyLevel();
    }
}
