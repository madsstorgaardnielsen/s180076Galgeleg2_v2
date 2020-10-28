package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LostGameFragment extends Fragment implements View.OnClickListener {
    ImageView imageView;
    TextView loserMsg;
    TextView loserStats;
    Button goToMenu;
    MainMenuFragment mainMenuFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lost_game, container, false);
        String correctWord = "NOT IMPL";

        imageView = root.findViewById(R.id.loserImageView);
        loserMsg = root.findViewById(R.id.loserMsgTextView);
        loserStats = root.findViewById(R.id.loserStatTextView);
        goToMenu = root.findViewById(R.id.gotoMainMenu);

        imageView.setImageResource(R.drawable.lost);
        loserMsg.setText("DU TABTE!");
        loserStats.setText("Ordet var: " + correctWord); //TODO overfør data eller kald hangmanlogic (lav den evt til singleton)

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