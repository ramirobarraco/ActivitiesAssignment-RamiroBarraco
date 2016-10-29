package ar.edu.unc.famaf.redditreader;


public class PostModel {

    private String pTitle;
    private String pSubreddit;
    private String pComments;
    private String pPostDate;
    private String pThumbnail;

    public PostModel(String pTitle, String pSubreddit, String pComments, String pPostDate, String pThumbnail) {
        this.pTitle = pTitle;
        this.pSubreddit = pSubreddit;
        this.pComments = pComments;
        this.pPostDate = pPostDate;
        this.pThumbnail = pThumbnail;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
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

    public String getpThumbnail() {
        return pThumbnail;
    }

    public void setmThumbnail(String mThumbnail) {
        this.pThumbnail = mThumbnail;
    }
}