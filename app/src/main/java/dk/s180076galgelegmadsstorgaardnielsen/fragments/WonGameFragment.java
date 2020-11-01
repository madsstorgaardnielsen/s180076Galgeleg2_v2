package dk.s180076galgelegmadsstorgaardnielsen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Observer;
import dk.s180076galgelegmadsstorgaardnielsen.interfaces.Subject;
import dk.s180076galgelegmadsstorgaardnielsen.LogicDataGrabber;

public class WonGameFragment extends Fragment implements View.OnClickListener, Observer {
    ImageView imageView;
    TextView winnerMsg;
    TextView winStats;
    Button goToMenu;
    MainMenuFragment mainMenuFragment;
    int wrongGuesses;
    String playerName;

    LogicDataGrabber logicDataGrabber;

    public WonGameFragment(Subject LogicDataGrabber) {
        LogicDataGrabber.register(this);
    }

    public WonGameFragment( ) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_won_game, container, false);
        //logicDataGrabber = new LogicDataGrabber();

        imageView = root.findViewById(R.id.winnerImageView);
        winnerMsg = root.findViewById(R.id.winnerMsgTextView);
        winStats = root.findViewById(R.id.winnerStatTextView);
        goToMenu = root.findViewById(R.id.gotoMainMenu);

        imageView.setImageResource(R.drawable.won);

        winnerMsg.setText("DU VANDT "+playerName+"!");
        winStats.setText("ANTAL FORSØG: " + wrongGuesses);

        goToMenu.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        mainMenuFragment = new MainMenuFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityFrameLayout, mainMenuFragment)
                .commit();
    }

    @Override
    public void update(boolean isWon, boolean isLost, String guess, int wrongGuesses, String correctWord, String playerName) {
        this.playerName = playerName;
        this.wrongGuesses = wrongGuesses;
    }
}