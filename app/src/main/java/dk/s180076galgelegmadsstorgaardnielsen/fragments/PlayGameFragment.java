package dk.s180076galgelegmadsstorgaardnielsen.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Subject;
import dk.s180076galgelegmadsstorgaardnielsen.logic.HangmanLogic;
import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.logic.HighscoreManager;

public class PlayGameFragment extends Fragment implements View.OnClickListener {
    ImageView progressImage;
    Button tryGuessButton;
    TextView hiddenWordTextView, usedLettersTextView, numberOfGuessesTextView;
    EditText guessEditText;
    HangmanLogic hangmanGame;
    Fragment gameOver;
    int amountWrongGuess;
    String hiddenWord;
    String guess;
    ArrayList<HighscoreManager> highscoreList = new ArrayList<>();
    String SHAREDPREFKEY = "highscores";
    String HIGHSCOREKEY = "highscore";
    HighscoreManager hsManager;
    String playerName;
    //ArrayList<Observer> observers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play_game, container, false);

        //observers = new ArrayList<>();

        progressImage = root.findViewById(R.id.imageView);
        progressImage.setImageResource(R.drawable.forkert0);

        tryGuessButton = root.findViewById(R.id.tryGuessButton);
        hiddenWordTextView = root.findViewById(R.id.hiddenWordTextView);
        guessEditText = root.findViewById(R.id.guessEditText);
        usedLettersTextView = root.findViewById(R.id.usedLettersTextView);
        numberOfGuessesTextView = root.findViewById(R.id.numberOfGuessesTextView);

        getName();

        hangmanGame = HangmanLogic.getInstance();
        hiddenWord = hangmanGame.getWordProgress();
        hiddenWordTextView.setText("Ordet: " + hiddenWord);
        numberOfGuessesTextView.setText("0 ud af 7 forkerte gæt brugt.");
        usedLettersTextView.setText("Ingen gæt foretaget endnu.");

        tryGuessButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        String wrongGuessProgressMsg;

        guess = guessEditText.getText().toString();
        hangmanGame.guessLetter(guess);
        usedLettersTextView.setText("Du har brugt følgende bogstaver: " + hangmanGame.getUsedLetters().toString());

        if (hangmanGame.isCorrectGuess()) {
            hiddenWord = hangmanGame.getWordProgress();
            hiddenWordTextView.setText(hiddenWord);
        } else {
            amountWrongGuess = hangmanGame.getWrongGuesses();
            wrongGuessProgressMsg = amountWrongGuess + " ud af 7 forkerte gæt brugt.";
            numberOfGuessesTextView.setText(wrongGuessProgressMsg);
            updateImage(amountWrongGuess);
        }
        isGameOver();
        guessEditText.setText("");
    }

    public void saveScore() {
        loadData();
        hsManager = new HighscoreManager(hangmanGame.getCorrectWord(), playerName, hangmanGame.getWrongGuesses() + "");
        highscoreList.add(hsManager);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(highscoreList);
        editor.putString(HIGHSCOREKEY, json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(HIGHSCOREKEY, null);
        Type type = new TypeToken<ArrayList<HighscoreManager>>() {
        }.getType();
        highscoreList = gson.fromJson(json, type);

        if (highscoreList == null) {
            highscoreList = new ArrayList<>();
        }
    }

    public void getName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Indtast navn");
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerName = input.getText().toString();
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

    public void isGameOver() {
        if (hangmanGame.isWon()) {
            gameOver = new WonGameFragment();
            saveScore();
            setFragment(gameOver);
        }
        if (hangmanGame.isLost()) {
            gameOver = new LostGameFragment();
            setFragment(gameOver);
        }
    }

    public void setFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityFrameLayout, fragment)
                .commit();
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