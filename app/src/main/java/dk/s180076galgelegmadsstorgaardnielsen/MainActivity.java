package dk.s180076galgelegmadsstorgaardnielsen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {
    Fragment mainMenuFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMenuFragment = new MainMenuFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivityFrameLayout, mainMenuFragment)
                .commit();

        barEyeCandy();
    }

    private void barEyeCandy() {
        //Get rid of support action bar in top (Telling name of the app)
        getSupportActionBar().hide();

        //Set color of android's own statusbar in top
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlackBackground));
        }

        //Change color of android's own navigation bar, so it matches our navigation bar
        //Only if android version is compatible
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorBlackBackground));
        }
    }
}