package famaf.unc.edu.ar.activitiesassignment;


import android.media.Image;

public class PostModel {

    private String pTitle;
    private String pContent;
    private String pSubreddit;
    private String pComments;
    private String pPostDate;

    public PostModel(String pTitle, String pContent, String pSubreddit, String pComments, String pPostDate, String pImage) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pSubreddit = pSubreddit;
        this.pComments = pComments;
        this.pPostDate = pPostDate;
        this.pImage = pImage;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    private String pImage;

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpPostDate() {
        return pPostDate;
    }

    public void setpPostDate(String pPostDate) {
        this.pPostDate = pPostDate;
    }

    public String getpComments() {
        return pComments;
    }

    public void setpComments(String pComments) {
        this.pComments = pComments;
    }

    public String getpSubreddit() {
        return pSubreddit;
    }

    public void setpSubreddit(String pSubreddit) {
        this.pSubreddit = pSubreddit;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }
}