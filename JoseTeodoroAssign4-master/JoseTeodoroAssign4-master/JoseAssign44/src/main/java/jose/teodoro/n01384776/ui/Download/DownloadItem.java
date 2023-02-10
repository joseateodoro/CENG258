package jose.teodoro.n01384776.ui.Download;

//download class
public class DownloadItem {

    private String mDownloadName;
    private int mDownloadImage;

    public DownloadItem(String downloadName, int downloadImage) {
        mDownloadName = downloadName;
        mDownloadImage = downloadImage;
    }

    public String getDownloadItemName() {

        return mDownloadName;
    }

    public int getDownloadImage() {
        return mDownloadImage;
    }
    
}
