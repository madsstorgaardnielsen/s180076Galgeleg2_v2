package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WonGameFragment extends Fragment implements View.OnClickListener {
    ImageView imageView;
    TextView winnerMsg;
    TextView winStats;
    Button goToMenu;
    MainMenuFragment mainMenuFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_won_game, container, false);
        imageView = root.findViewById(R.id.winnerImageView);
        winnerMsg = root.findViewById(R.id.winnerMsgTextView);
        winStats = root.findViewById(R.id.winnerStatTextView);
        goToMenu = root.findViewById(R.id.gotoMainMenu);

        imageView.setImageResource(R.drawable.won);
        winnerMsg.setText("DU VANDT!");
        winStats.setText("ANTAL FORSØG"); //TODO overfør data eller kald hangmanlogic (lav den evt til singleton)

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
}