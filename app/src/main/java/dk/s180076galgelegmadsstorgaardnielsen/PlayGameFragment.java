package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlayGameFragment extends Fragment {
    ImageView progressImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play_game, container, false);
        progressImage = root.findViewById(R.id.imageView);
        progressImage.setImageResource(R.drawable.forkert0);


        return root;
    }
}