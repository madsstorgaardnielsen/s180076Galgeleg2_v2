package dk.s180076galgelegmadsstorgaardnielsen.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.menu.help.HelpFragment;
import dk.s180076galgelegmadsstorgaardnielsen.menu.highscore.HighscoreFragment;
import dk.s180076galgelegmadsstorgaardnielsen.playgame.game.GameActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button playGameButton, highscoreButton, helpButton;
    ImageView imageView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.logo);

        playGameButton = findViewById(R.id.playGameButton);
        highscoreButton = findViewById(R.id.highscoreButton);
        helpButton = findViewById(R.id.helpButton);

        playGameButton.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
    }

    //TODO lav settings knap samt logik til den
    @Override
    public void onClick(View v) {
        if (v == playGameButton) {
            setActivity();
        }
        if (v == highscoreButton) {
            setFragment(v);
        }
        if (v == helpButton) {
            setFragment(v);
        }
    }

    //TODO Fix skift af fragmenter
    public void setFragment(View v) {
        if (v == highscoreButton) {
            fragment = new HighscoreFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        if (v == helpButton) {
            fragment = new HelpFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivityFrameLayout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void setActivity() {
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
}