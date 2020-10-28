package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HighscoreFragment extends Fragment {

    //TODO en form for måde at måle spillerene på, eventuelt på tid og antal gæt for et bestemt ord.
    //TODO brug ListView eller RecyclerView
    //TODO gem denne data lokalt på telefonen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_highscore, container, false);



        return root;
    }
}