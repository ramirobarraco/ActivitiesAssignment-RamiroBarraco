package famaf.unc.edu.ar.activitiesassignment;

import java.util.ArrayList;
import java.util.List;

public class Backend {
    private static Backend ourInstance = new Backend();

    public static Backend getInstance() {
        return ourInstance;
    }

    private List<PostModel> pListPostModel;
    private Backend() {
        pListPostModel = new ArrayList<>();

        PostModel p1 = new PostModel("titulo1","content1","r/subreddit1", "150", "1 hs", "www.goog/algo.jpg");
        pListPostModel.add(p1);

        PostModel p2 = new PostModel("titulo2","content2","r/subreddit2", "25", "2 hs", "www.goog/algo.jpg");
        pListPostModel.add(p2);

        PostModel p3 = new PostModel("titulo3","content3","r/subreddit3", "60", "3 hs", "www.goog/algo.jpg");
        pListPostModel.add(p3);

        PostModel p4 = new PostModel("titulo4","content4","r/subreddit4", "575", "4 hs", "www.goog/algo.jpg");
        pListPostModel.add(p4);

        PostModel p5 = new PostModel("titulo5","content5","r/subreddit5", "85", "5 hs", "www.goog/algo.jpg");
        pListPostModel.add(p5);

        PostModel p6 = new PostModel("titulo6","content6","r/subreddit6", "134", "6 hs", "www.goog/algo.jpg");
        pListPostModel.add(p6);
    }

    public List<PostModel> getTopPosts() {
        return pListPostModel;
    }
}