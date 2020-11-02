package dk.s180076galgelegmadsstorgaardnielsen.playgame.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.menu.highscore.HighscoreModel;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.fragments.LostGameFragment;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.fragments.WonGameFragment;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Subject;

public class GameActivity extends AppCompatActivity implements Observer, View.OnClickListener {
    Fragment fragment;
    ImageView progressImage;
    Button tryGuessButton;
    TextView hiddenWordTextView, usedLettersTextView, numberOfGuessesTextView;
    EditText guessEditText;
    GameController gameController;

    ArrayList<HighscoreModel> highscoreList;
    Subject GameModel;

    int wrongGuesses;
    boolean isWon;
    boolean isLost;
    String guess;
    String correctWord;
    String playerName;

    HighscoreModel hsModel;

    String SHAREDPREFKEY = "highscores";
    String HIGHSCOREKEY = "highscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        highscoreList = new ArrayList<>();
        gameController = new GameController();
        GameModel = gameController.getGameModel();
        GameModel.register(this);

        progressImage = findViewById(R.id.imageView);
        progressImage.setImageResource(R.drawable.forkert0);

        tryGuessButton = findViewById(R.id.tryGuessButton);
        hiddenWordTextView = findViewById(R.id.hiddenWordTextView);
        guessEditText = findViewById(R.id.guessEditText);
        usedLettersTextView = findViewById(R.id.usedLettersTextView);
        numberOfGuessesTextView = findViewById(R.id.numberOfGuessesTextView);

        getName();

        //hiddenWordTextView.setText("Ordet: " + gameController.getHiddenWord());
        numberOfGuessesTextView.setText("0 ud af 7 forkerte gæt brugt.");
        usedLettersTextView.setText("Ingen gæt foretaget endnu.");

        tryGuessButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        guess = guessEditText.getText().toString();
        gameController.setUsedLetters(guess);
        boolean isGuessCorrect = gameController.isGuessCorrect(guess);
        int amountWrongGuess;
        String wordProgress;
        String progressMsg;
        //ArrayList<String> usedLetters = new ArrayList<>();
        if (isGuessCorrect) {
            wordProgress = gameController.getWordProgress();
            hiddenWordTextView.setText(wordProgress);
        } else {
            amountWrongGuess = gameController.getAmountWrongGuesses();
            progressMsg = amountWrongGuess + " ud af 7 forkerte gæt brugt.";
            numberOfGuessesTextView.setText(progressMsg);
            updateImage(amountWrongGuess);
        }

        usedLettersTextView.setText("Du har brugt følgende bogstaver: " + gameController.getUsedLetters().toString());
        guessEditText.setText("");
        isGameOver();
    }

    public void isGameOver() {
        if (gameController.isWon()) {
            saveHighscore();
            fragment = new WonGameFragment(GameModel);
            setFragment(fragment);
        }
        if (gameController.isLost()) {
            fragment = new LostGameFragment(GameModel);
            setFragment(fragment);
        }
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityFrameLayout, fragment)
                .commit();
    }

    public void saveHighscore() {
        loadHighscore();
        hsModel = new HighscoreModel(correctWord, playerName, gameController.getAmountWrongGuesses() + "");
        highscoreList.add(hsModel);
        SharedPreferences sharedPreferences = getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(highscoreList);
        editor.putString(HIGHSCOREKEY, json);
        editor.apply();
    }

    private void loadHighscore() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(HIGHSCOREKEY, null);
        Type type = new TypeToken<ArrayList<HighscoreModel>>() {
        }.getType();
        highscoreList = gson.fromJson(json, type);

        if (highscoreList == null) {
            highscoreList = new ArrayList<>();
        }
    }

    public void getName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Indtast navn");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerName = input.getText().toString();
                gameController.setPlayerName(playerName);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerName = "Not named";
                dialog.cancel();
            }
        });
        builder.show();
    }

    @Override
    public void update(boolean isWon, boolean isLost, String guess, int wrongGuesses, String correctWord, String playerName) {
        this.playerName = playerName;
        this.isWon = isWon;
        this.isLost = isLost;
        this.guess = guess;
        this.wrongGuesses = wrongGuesses;
        this.correctWord = correctWord;
        printUpdate();
    }

    public void printUpdate() {
        System.out.println("\n" +
                "Player name: " + playerName + "\n" +
                "isWon: " + isWon + "\n" +
                "isLost: " + isLost + "\n" +
                "Guess: " + guess + "\n" +
                "Wrong Guesses: " + wrongGuesses + "\n" +
                "Correct Word: " + correctWord);
    }

    public void updateImage(int wrongGuesses) {
        switch (wrongGuesses) {
            case 1:
            case 2:
                progressImage.setImageResource(R.drawable.forkert1);
                break;
            case 3:
                progressImage.setImageResource(R.drawable.forkert2);
                break;
            case 4:
                progressImage.setImageResource(R.drawable.forkert3);
                break;
            case 5:
                progressImage.setImageResource(R.drawable.forkert4);
                break;
            case 6:
                progressImage.setImageResource(R.drawable.forkert5);
                break;
            case 7:
                progressImage.setImageResource(R.drawable.forkert6);
                break;
            default:
                break;
        }
    }

}