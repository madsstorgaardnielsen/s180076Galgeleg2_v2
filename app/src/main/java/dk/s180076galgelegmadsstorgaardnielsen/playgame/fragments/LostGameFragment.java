package dk.s180076galgelegmadsstorgaardnielsen.playgame.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.menu.MainMenuActivity;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.game.GameModel;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.interfaces.Subject;

public class LostGameFragment extends Fragment implements View.OnClickListener, Observer {
    ImageView imageView;
    TextView loserMsg;
    TextView loserStats;
    Button goToMenu;
    String correctWord;
     int wrongGuesses;
     String playerName;

    public LostGameFragment(Subject GameModel) {
        GameModel.register(this);
    }

    public LostGameFragment( ) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lost_game, container, false);

        playerName = GameModel.getInstance().getPlayerName();
        correctWord = GameModel.getInstance().getCorrectWord();

        imageView = root.findViewById(R.id.loserImageView);
        loserMsg = root.findViewById(R.id.loserMsgTextView);
        loserStats = root.findViewById(R.id.loserStatTextView);
        goToMenu = root.findViewById(R.id.gotoMainMenu);

        imageView.setImageResource(R.drawable.lost);
        loserMsg.setText(playerName+ " DU TABTE!");
        loserStats.setText("Ordet var: " + correctWord);

        GameModel.getInstance().resetVariables();
        goToMenu.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(getActivity(), MainMenuActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void update(boolean isWon, boolean isLost, String guess, int wrongGuesses, String correctWord, String playerName) {
        this.wrongGuesses = wrongGuesses;
        this.correctWord = correctWord;
        this.playerName = playerName;
    }
}