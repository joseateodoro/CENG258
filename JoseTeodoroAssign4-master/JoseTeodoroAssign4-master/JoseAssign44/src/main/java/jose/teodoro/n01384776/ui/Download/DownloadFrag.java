//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776.ui.Download;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import jose.teodoro.n01384776.R;

public class DownloadFrag extends Fragment {

    //objects
    private DownloadViewModel downloadViewModel;
    private ArrayList<DownloadItem> mDownloadList;
    private DownloadAdapter mAdapter;

    //variables
    URL ImageUrl = null;
    InputStream is = null;
    Bitmap bmImg = null;
    ImageView imageView= null;
    ProgressDialog p;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        downloadViewModel =
                new ViewModelProvider(this).get(DownloadViewModel.class);
        View root = inflater.inflate(R.layout.fragment_download, container, false);
        final TextView textView = root.findViewById(R.id.jose_download_textView);
        downloadViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //calling initList 
        initList();

        //declaring objects from xml to class
        Spinner spinner = root.findViewById(R.id.jose_download_Spinner);
        Button downloadButton = root.findViewById(R.id.jose_download_Button);
        imageView = root.findViewById(R.id.jose_download_imageView);

        //checking if the image from spinner is selected to download image
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncDo asyncTask = new AsyncDo();
                asyncTask.execute(getString(R.string.jose_PNG));
            }
        });

        //declaring DownloadAdapter class
        mAdapter = new DownloadAdapter(this, mDownloadList);
        spinner.setAdapter(mAdapter);

        //checking spinner values for which spinner column was chosen
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            
            //checking what image was selected
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DownloadItem clickedItem = (DownloadItem) parent.getItemAtPosition(position);
                String clickedItemDownloadItemName = clickedItem.getDownloadItemName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            
        });

        return root;
    }

    //carrying images from drawable folder
    private void initList() {
        mDownloadList = new ArrayList<>();
        mDownloadList.add(new DownloadItem(getString(R.string.jose_Sky), R.drawable.sky));
        mDownloadList.add(new DownloadItem(getString(R.string.jose_Nature), R.drawable.nature));
        mDownloadList.add(new DownloadItem(getString(R.string.jose_Flower), R.drawable.flower));
    }
    
    //syncing download values
    private class AsyncDo extends AsyncTask<String, String, Bitmap> {

        //checking predetermining values before user input
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p=new ProgressDialog(getContext());
            p.setMessage(getString(R.string.jose_loading));
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        //checking map input value
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {

                ImageUrl = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) ImageUrl
                        .openConnection();
                conn.setDoInput(true);
                conn.connect();
                is = conn.getInputStream();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bmImg = BitmapFactory.decodeStream(is, null, options);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return bmImg;
        }

        //checking post determining values
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(imageView!=null) {
                p.hide();
                imageView.setImageBitmap(bitmap);
            }else {
                p.show();
            }
        }
    }

}