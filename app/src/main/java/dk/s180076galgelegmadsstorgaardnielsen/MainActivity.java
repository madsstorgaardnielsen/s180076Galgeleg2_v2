package dk.s180076galgelegmadsstorgaardnielsen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;

import dk.s180076galgelegmadsstorgaardnielsen.fragments.MainMenuFragment;

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
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlackBackground));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorBlackBackground));
        }
    }
}