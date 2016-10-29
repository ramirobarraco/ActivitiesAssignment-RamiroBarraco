package ar.edu.unc.famaf.redditreader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import famaf.unc.edu.ar.redditreader.R;

public class PostAdapter extends ArrayAdapter<PostModel> {

    private List<PostModel> PMList;
    int resourceNo;

    static class ViewHolder {
        TextView title;
        TextView subreddit;
        TextView postDate;
        TextView commentsNumber;
        ImageView thumbnail;
        ProgressBar bar;
    }

    public PostAdapter(Context context, int resource, List<PostModel> list) {
        super(context, resource);
        PMList = list;
        resourceNo = resource;
    }

    @Override
    public int getCount(){
        return PMList.size();
    }

    @Override
    public boolean isEmpty() {
        return PMList.isEmpty();
    }

    @Override
    public PostModel getItem(int position){
        return PMList.get(position);
    }

    @Override
    public int getPosition(PostModel post){
        return PMList.indexOf(post);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resourceNo, parent, false);
        }
        if (convertView.getTag()==null) {
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.titulo);
            holder.commentsNumber = (TextView) convertView.findViewById(R.id.cantidad_comentarios);
            holder.subreddit = (TextView) convertView.findViewById(R.id.subreddit);
            holder.postDate = (TextView) convertView.findViewById(R.id.horas);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            holder.bar = (ProgressBar) convertView.findViewById(R.id.progress);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        PostModel post = PMList.get(position);
        holder.title.setText(post.getpTitle());
        holder.commentsNumber.setText(String.valueOf(post.getpComments()));
        holder.subreddit.setText(post.getpSubreddit());
        holder.postDate.setText(post.getpPostDate());

        new ImageDownloader(){
            @Override
            protected void onPostExecute(Bitmap result) {
                holder.bar.setVisibility(View.GONE);
                if (result != null) {
                    holder.thumbnail.setImageBitmap(result);
                    holder.thumbnail.setVisibility(View.VISIBLE);
                } else {
                    holder.thumbnail.setVisibility(View.GONE);
                }
            }
        }.execute(post.getpThumbnail());

        return convertView;
    }

    class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String ... urlStr) {
            Bitmap bitmap = null;

            try {
                URL url = new URL(urlStr[0]);
                HttpURLConnection connection = null;
                connection = (HttpURLConnection)url.openConnection();
                InputStream stream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(stream, null, null);
            } catch(Exception exception) {
                exception.printStackTrace();
            }

            return bitmap;
        }
    }

}