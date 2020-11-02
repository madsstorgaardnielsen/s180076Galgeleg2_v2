package dk.s180076galgelegmadsstorgaardnielsen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;


import dk.s180076galgelegmadsstorgaardnielsen.menu.MainMenuActivity;

public class MainActivity extends AppCompatActivity {

    //FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //frameLayout = findViewById(R.id.mainActivityFrameLayout);
        barEyeCandy();

        Intent myIntent = new Intent(this, MainMenuActivity.class);
        startActivity(myIntent);

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