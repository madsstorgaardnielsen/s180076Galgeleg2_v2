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
    TextView hiddenWord;
    EditText guess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play_game, container, false);
        progressImage = root.findViewById(R.id.imageView);
        progressImage.setImageResource(R.drawable.forkert0);

        tryGuessButton = root.findViewById(R.id.tryGuessButton);
        hiddenWord = root.findViewById(R.id.hiddenWordTextView);
        guess = root.findViewById(R.id.guessEditText);

        tryGuessButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {

    }
}