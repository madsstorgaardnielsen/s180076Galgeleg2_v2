package dk.s180076galgelegmadsstorgaardnielsen;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class HighscoreManager extends Activity {
    String secretWord;
    String playerName;
    String guesses;
    SharedPreferences.Editor preferenceEditor;
    SharedPreferences highscore;
    String HIGHSCOREKEY = "highscores";

    public HighscoreManager(String secretWord, String playerName, String guesses) {
        this.secretWord = secretWord;
        this.playerName = playerName;
        this.guesses = guesses;
    }

    public ArrayList<String> getHighscorelist() {
        highscore = getSharedPreferences("highscores", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = highscore.getString("highscores", "");
        ArrayList<String> highscoreList = gson.fromJson(json, ArrayList.class);
        return highscoreList;
    }

    public void saveScore(Context context, HighscoreManager score) {
        highscore = PreferenceManager.getDefaultSharedPreferences(context);
        preferenceEditor = highscore.edit();
        Gson gson = new Gson();
        String json = gson.toJson(score);
        preferenceEditor.putString(HIGHSCOREKEY, json);
        preferenceEditor.apply();
    }
}
