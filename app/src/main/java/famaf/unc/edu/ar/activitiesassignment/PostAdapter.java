package famaf.unc.edu.ar.activitiesassignment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;




public class PostAdapter extends ArrayAdapter<PostModel> {
    private List<PostModel> pListPostModel;


    public PostAdapter(Context context, int resource, List<PostModel> lst) {
        super(context, resource);
        pListPostModel = lst;
    }

    @Override
    public int getCount() {
        return pListPostModel.size();
    }

    @Override
    public PostModel getItem(int position) {
        return pListPostModel.get(position);
    }

    @Override
    public int getPosition(PostModel item) {
        return pListPostModel.indexOf(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater vi =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.model_row, parent, false);
        }

        PostModel m = pListPostModel.get(position);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView subreddit = (TextView) convertView.findViewById(R.id.subreddit);
        TextView comments = (TextView) convertView.findViewById(R.id.cantidad_comentarios);
        TextView date = (TextView) convertView.findViewById(R.id.horas);


        titulo.setText(m.getpTitle());
        subreddit.setText(m.getpSubreddit());
        comments.setText(m.getpComments());
        date.setText(m.getpPostDate());

        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return pListPostModel.isEmpty();
    }
}
