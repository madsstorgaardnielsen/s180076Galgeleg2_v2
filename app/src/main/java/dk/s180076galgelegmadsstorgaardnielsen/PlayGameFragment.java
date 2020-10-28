package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayGameFragment extends Fragment implements View.OnClickListener {
    ImageView progressImage;
    Button tryGuessButton;
    TextView hiddenWordTextView, usedLettersTextView, numberOfGuessesTextView;
    EditText guessEditText;
    HangmanLogic hangmanGame;
    Fragment gameOver;

    String hiddenWord;
    String guess;

    //TODO arbejd videre på game logic
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play_game, container, false);
        progressImage = root.findViewById(R.id.imageView);
        progressImage.setImageResource(R.drawable.forkert0);

        tryGuessButton = root.findViewById(R.id.tryGuessButton);
        hiddenWordTextView = root.findViewById(R.id.hiddenWordTextView);
        guessEditText = root.findViewById(R.id.guessEditText);
        usedLettersTextView = root.findViewById(R.id.usedLettersTextView);
        numberOfGuessesTextView = root.findViewById(R.id.numberOfGuessesTextView);


        hangmanGame = new HangmanLogic();
        hiddenWord = hangmanGame.getWordProgress();
        hiddenWordTextView.setText("Ordet: "+hiddenWord);
        numberOfGuessesTextView.setText("0 ud af 7 forkerte gæt brugt.");
        usedLettersTextView.setText("Ingen gæt foretaget endnu.");

        tryGuessButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int amountWrongGuess = 0;
        String wrongGuessProgresMsg;

        guess = guessEditText.getText().toString();
        hangmanGame.guessLetter(guess);
        usedLettersTextView.setText("Du har brugt følgende bogstaver: "+ hangmanGame.getUsedLetters().toString());

        if (hangmanGame.isCorrectGuess()) {
            hiddenWord = hangmanGame.getWordProgress();
            hiddenWordTextView.setText(hiddenWord);
        } else {
            amountWrongGuess = hangmanGame.getWrongGuesses();
            wrongGuessProgresMsg = amountWrongGuess+" ud af 7 forkerte gæt brugt.";
            numberOfGuessesTextView.setText(wrongGuessProgresMsg);
            updateImage(amountWrongGuess);
        }
        isGameOver();
        guessEditText.setText("");
    }

    public void isGameOver() {
        if (hangmanGame.isWon()) {
            gameOver = new WonGameFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, gameOver)
                    .commit();
        }
        if (hangmanGame.isLost()) {
            gameOver = new LostGameFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, gameOver)
                    .commit();
        }
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