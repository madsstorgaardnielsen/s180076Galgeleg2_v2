package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class MainMenuFragment extends Fragment implements View.OnClickListener {
    Button playGameButton, highscoreButton, helpButton;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_menu, container, false);
        imageView = root.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.logo);

        playGameButton = root.findViewById(R.id.playGameButton);
        highscoreButton = root.findViewById(R.id.highscoreButton);
        helpButton = root.findViewById(R.id.helpButton);

        playGameButton.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == playGameButton) {
            setFragment(v);
        }
        if (v == highscoreButton) {
            setFragment(v);
        }
        if (v == helpButton) {
            setFragment(v);
        }
    }

    public void setFragment(View v) {
        Fragment fragment;

        if (v == playGameButton) {
            fragment = new PlayGameFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        if (v == highscoreButton) {
            fragment = new HighscoreFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        if (v == helpButton) {
            fragment = new HelpMenuFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}