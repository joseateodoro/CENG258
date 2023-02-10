//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776.ui.WebService;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jose.teodoro.n01384776.R;

public class WebServiceFrag extends Fragment {


    private WebServiceViewModel slideshowViewModel;

    //object variables
    Button webButton;
    EditText webeditText;
    TextView webtextView;
    AlertDialog.Builder builder;
    String webData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //root value via inflater
        View root = inflater.inflate(R.layout.fragment_webservice, container,false);

        //declaring objects to class variable
        webButton = root.findViewById(R.id.jose_web_serviceButton);
        webeditText = root.findViewById(R.id.jose_web_editTextFieldZip);
        webtextView = root.findViewById(R.id.jose_web_textViewZip);
        builder = new AlertDialog.Builder(getContext());

        //button listener for zipcode value
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(webeditText.length() == 0) {
                    builder.setTitle(R.string.jose_Warning)
                            .setMessage(R.string.jose_invalidZip)
                            .setCancelable(true)
                            .setNegativeButton(R.string.jose_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();

                    //webtextView.setError(getString("Error"));
                }
                else{

                    getWeatherData(v);
                }

            }
        });
        return root;
    }

    //getting JSON data from openweathermap.org
    public void getWeatherData(View v)
    {
        webData = webeditText.getText().toString();

        String url = "https://home.openweathermap.org/";
        url += "zip="+ webData;
        url += "&appid=a1ebc6825797316872fac8f3c1c82662";
        Log.d("URL",url);
        new readJSONFeedOutput();
    }

    //checking JSON input values
    public String readJSONFeedInput(String address) {
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        };
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream content = new BufferedInputStream(
                    urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return stringBuilder.toString();
    }

    //checking JSON output value
    private class readJSONFeedOutput extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeedInput(urls[0]);
        }
        protected void onPostExecute(String result) {
            try {
                JSONObject weatherJson = new JSONObject(result);
                JSONArray dataArray1= weatherJson.getJSONArray(getString(R.string.jose_Weather));
                String strResults=getString(R.string.jose_weatherGap);
                for (int i = 0; i < dataArray1.length(); i++) {
                    JSONObject jsonObject = dataArray1.getJSONObject(i);
                    strResults +=getString(R.string.jose_IDcolon)+jsonObject.getString(getString(R.string.jose_ID));
                    strResults +=getString(R.string.jose_mainColon)+jsonObject.getString(getString(R.string.jose_Main));
                    strResults +=getString(R.string.jose_Description)+jsonObject.getString(getString(R.string.jose_intDescription));
                }

                JSONObject dataObject= weatherJson.getJSONObject("");
                strResults +=getString(R.string.jose_temperatureGap)+dataObject.getString(getString(R.string.jose_intTemperature));
                strResults +=getString(R.string.jose_humidityGap)+dataObject.getString(getString(R.string.jose_intHumidity));

                webtextView.setText(strResults);

            }
            catch (Exception e) {
                e.printStackTrace();
                builder.setTitle(R.string.jose_Warning)
                        .setMessage(R.string.jose_invalidZip)
                        .setCancelable(true)
                        .setNegativeButton(R.string.jose_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();

                //webtextView.setError(getString(R.string.InvalidDataError));


            }
        }
    }

}