package dk.s180076galgelegmadsstorgaardnielsen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import dk.s180076galgelegmadsstorgaardnielsen.fragments.MainMenuFragment;
import dk.s180076galgelegmadsstorgaardnielsen.logic.HighscoreManager;

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