package jose.teodoro.n01384776.ui.Download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import jose.teodoro.n01384776.R;

public class DownloadAdapter extends ArrayAdapter <DownloadItem> {

    //super constructor
    public DownloadAdapter(DownloadFrag context, ArrayList<DownloadItem> downloadList) {
        super(context, 0, downloadList);
    }

    //getView method for creation of image spinner
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    //getDropDownView for output of image dropdown spinner
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    //initView to show the images given from drawable fro sky | nature | flower images
    private View initView(int position, View convertView, ViewGroup parent) {

        //checks if the spinner should stay the same with no changes
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_download, parent, false);
        }

        //image view and textview object declaration
        ImageView imageView = convertView.findViewById(R.id.jose_download_imageView);
        TextView textView = convertView.findViewById(R.id.jose_download_textViewSpinner);

        DownloadItem currentItem = getItem(position);

        //checking if spinner has any changes, therefore changing image view of custom spinner
        if (currentItem != null) {
            imageView.setImageResource(currentItem.getDownloadImage());
            textView.setText(currentItem.getDownloadItemName());
        }

        return convertView;
    }


    
}
