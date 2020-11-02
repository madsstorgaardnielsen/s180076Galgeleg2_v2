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

public class WonGameFragment extends Fragment implements View.OnClickListener, Observer {
    ImageView imageView;
    TextView winnerMsg;
    TextView winStats;
    Button goToMenu;
    int wrongGuesses;
    String playerName;


    public WonGameFragment(Subject GameModel) {
        GameModel.register(this);
    }

    public WonGameFragment( ) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_won_game, container, false);

        playerName = GameModel.getInstance().getPlayerName();
        wrongGuesses = GameModel.getInstance().getAmountWrongGuess();

        imageView = root.findViewById(R.id.winnerImageView);
        winnerMsg = root.findViewById(R.id.winnerMsgTextView);
        winStats = root.findViewById(R.id.winnerStatTextView);
        goToMenu = root.findViewById(R.id.gotoMainMenu);

        imageView.setImageResource(R.drawable.won);

        winnerMsg.setText("DU VANDT "+playerName+"!");
        winStats.setText("ANTAL FORSØG: " + wrongGuesses);

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
        this.playerName = playerName;
        this.wrongGuesses = wrongGuesses;
    }
}