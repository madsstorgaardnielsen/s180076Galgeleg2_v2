package dk.s180076galgelegmadsstorgaardnielsen.menu.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.R;

public class SettingsFragment extends Fragment implements View.OnClickListener {
    Button easyButton, mediumButton, hardButton;
    SettingController settingController;
    String DIFFICULTY_LEVEL_EASY = "easy";
    String DIFFICULTY_LEVEL_MEDIUM = "medium";
    String DIFFICULTY_LEVEL_HARD = "hard";
    String difficultyLevel = "";
    SettingsModel settings;
    ArrayList<SettingsModel> difficultySettings = new ArrayList<>();

    String SHAREDPREFKEY = "settings";
    String SETTINGSKEY = "settingskey";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        settingController = new SettingController();

        easyButton = root.findViewById(R.id.easyButton);
        mediumButton = root.findViewById(R.id.mediumButton);
        hardButton = root.findViewById(R.id.hardButton);

        easyButton.setOnClickListener(this);
        mediumButton.setOnClickListener(this);
        hardButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == easyButton) {
            difficultyLevel = DIFFICULTY_LEVEL_EASY;
        } else if (v == mediumButton) {
            difficultyLevel = DIFFICULTY_LEVEL_MEDIUM;
        } else if (v == hardButton) {
            difficultyLevel = DIFFICULTY_LEVEL_HARD;
        }
        settingController.setDifficultyLevel(difficultyLevel);
        saveSettings();
    }

    public void saveSettings() {
        settings = new SettingsModel(settingController.getDifficultyLevel());
        difficultySettings.add(settings);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(difficultySettings);
        editor.putString(SETTINGSKEY, json);
        editor.apply();
    }

/*    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(HIGHSCOREKEY, null);
        Type type = new TypeToken<ArrayList<HighscoreModel>>() {
        }.getType();
        highscoreList = gson.fromJson(json, type);

        if (highscoreList == null) {
            highscoreList = new ArrayList<>();
        }
    }*/
}