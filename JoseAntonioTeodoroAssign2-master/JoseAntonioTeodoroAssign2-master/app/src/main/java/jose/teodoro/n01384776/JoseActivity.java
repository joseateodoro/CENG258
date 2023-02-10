//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class JoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jose);
    }

    //NEED TO DEBUG
    public void nextScreen(View view) {

        switch(view.getId())    {
            case R.id.buttonDominos: //Dominos Selection
                Intent intentDom = new Intent(JoseActivity.this, TeodoroActivity1.class);
                startActivity(intentDom);
                Snackbar snackbardom = Snackbar.make(findViewById(android.R.id.content), R.string.next, Snackbar.LENGTH_LONG); //Snackbar Output
                snackbardom.show();
            case R.id.buttonPizzahut://Pizza Hut Selection
                Intent intentHut = new Intent(JoseActivity.this, TeodoroActivity1.class);
                startActivity(intentHut);
                Snackbar snackbarHut = Snackbar.make(findViewById(android.R.id.content), R.string.next, Snackbar.LENGTH_LONG);
                snackbarHut.show();
            case R.id.buttonPizzaPizza: //Pizza Pizza Selection
                Intent intentPiz = new Intent(JoseActivity.this, TeodoroActivity1.class);
                startActivity(intentPiz);
                Snackbar snackbarPiz = Snackbar.make(findViewById(android.R.id.content), R.string.next, Snackbar.LENGTH_LONG);
                snackbarPiz.show();
        }

    }
}