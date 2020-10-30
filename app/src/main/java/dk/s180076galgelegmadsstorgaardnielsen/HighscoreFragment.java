package dk.s180076galgelegmadsstorgaardnielsen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class HighscoreFragment extends Fragment {
    ListView listView;
    ArrayList<String> highscoreList;

    //TODO en form for måde at måle spillerene på, eventuelt på tid og antal gæt for et bestemt ord.
    //TODO brug ListView eller RecyclerView
    //TODO gem denne data lokalt på telefonen

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_highscore, container, false);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            arrayList.add(i+"");
        }

        //highscoreList = highscoreManager.getHighscorelist();

        listView = root.findViewById(R.id.ListView);

        //listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, highscoreList));
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayList));

        return root;
    }
}