package ar.edu.unc.famaf.redditreader;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import famaf.unc.edu.ar.redditreader.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsActivityFragment extends Fragment {

    public NewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        List<PostModel> lst = Backend.getInstance().getTopPosts();
        ListView lv = (ListView) rootView.findViewById(R.id.postLV);

        PostAdapter adapter = new PostAdapter(getContext(), R.layout.model_row, lst);
        lv.setAdapter(adapter);

        return rootView;
    }
}