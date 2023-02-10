//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class TeodoroActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //textinputlayout variables
    private TextInputLayout textInputName;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputAddress;
    private TextInputLayout textInputPostal;
    private TextInputLayout textInputCredit;
    private TextInputLayout textInputExpiry;
    private TextInputLayout textInputCVV;

    Button nextActivityButton; //next activity button

    String textInputOutput; //variable to take string input

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teodoro2);

        //declaration of input values put into the textinputlayout boxes
        textInputName = findViewById(R.id.name);
        textInputEmail = findViewById(R.id.email);
        textInputAddress = findViewById(R.id.address);
        textInputPostal = findViewById(R.id.postal);
        textInputCredit = findViewById(R.id.credit);
        textInputExpiry = findViewById(R.id.expiry);
        textInputCVV = findViewById(R.id.cvv);

        //spinner setup for provinces
        //used word array in activity_teodoro2.xml to store provinces and territories
        Spinner spinner = findViewById(R.id.spinnerProvince);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //seeing input of the user for the spinner widget

        nextActivityButton = findViewById(R.id.nextButton); //declaration of the nextButton

        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(TeodoroActivity2.this, TeodoroActivity3.class);
                textInputOutput = nextActivityButton.getText().toString();

                startActivity(nextIntent);
                finish();
            }
        });
    }

    //boolean methods for checking their individual properties
    private boolean validateName() {

        String inputName = textInputName.getEditText().getText().toString().trim();

        if (inputName.isEmpty()) {
            textInputName.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputName.length() < 3) {
            textInputName.setError(getString(R.string.invalidName));
            return false;
        }
        else    {
            textInputName.setError(null);
            return true;
        }

    }

    private boolean validateEmail() {

        String inputEmail = textInputEmail.getEditText().getText().toString().trim();

        if (inputEmail.isEmpty()) {
            textInputEmail.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputEmail != "@") {
            textInputEmail.setError(getString(R.string.invalidEmail));
            return false;
        }
        else    {
            textInputEmail.setError(null);
            return true;
        }

    }

    private boolean validateAddress() {

        String inputAddress = textInputAddress.getEditText().getText().toString().trim();

        if (inputAddress.isEmpty()) {
            textInputAddress.setError(getString(R.string.emptyField));
            return false;
        }
        else    {
            textInputAddress.setError(null);
            return true;
        }

    }

    private boolean validatePostal() {

        String inputPostal = textInputPostal.getEditText().getText().toString().trim();

        if (inputPostal.isEmpty())  {
            textInputPostal.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputPostal.length() > 6)   {
            textInputPostal.setError(getString(R.string.invalidPostal));
            return false;
        }
        else if(inputPostal.length() < 6)   {
            textInputPostal.setError(getString(R.string.invalidPostal));
            return false;
        }
        else    {
            textInputEmail.setError(null);
            return true;
        }

    }

    private boolean validateCredit() { //add number case if there is a numerical input

        String inputCredit = textInputCredit.getEditText().getText().toString().trim();

        if (inputCredit.isEmpty()) {
            textInputCredit.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputCredit.length() < 16) {
            textInputCredit.setError(getString(R.string.invalidCredit));
            return false;
        }
        else if(inputCredit.length() > 16) {
            textInputCredit.setError(getString(R.string.invalidCredit));
            return false;
        }
        else    {
            textInputEmail.setError(null);
            return true;
        }

    }

    private boolean validateExpiry() { //add number case if there is a numerical input

        String inputExpiry = textInputExpiry.getEditText().getText().toString().trim();

        if (inputExpiry.isEmpty()) {
            textInputCredit.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputExpiry.length() < 4) {
            textInputCredit.setError(getString(R.string.invalidExpiry));
            return false;
        }
        else if(inputExpiry.length() > 4) {
            textInputCredit.setError(getString(R.string.invalidExpiry));
            return false;
        }
        else    {
            textInputEmail.setError(null);
            return true;
        }

    }

    private boolean validateCVV() { //add number case if there is a numerical input

        String inputCVV = textInputCVV.getEditText().getText().toString().trim();

        if (inputCVV.isEmpty()) {
            textInputCredit.setError(getString(R.string.emptyField));
            return false;
        }
        else if(inputCVV.length() < 3) {
            textInputCredit.setError(getString(R.string.invalidCVV));
            return false;
        }
        else if(inputCVV.length() > 3) {
            textInputCredit.setError(getString(R.string.invalidCVV));
            return false;
        }
        else    {
            textInputEmail.setError(null);
            return true;
        }

    }

    //to confirm if all of the fields were filled or selected
    public void confirmInput(View v)    {
        if  (!validateName() | !validateEmail() | !validateAddress() | !validatePostal() | !validateCredit() | !validateExpiry() |!validateCVV()) {
            return;
        }

    }

    //checking if the spinner has province chosen
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 0)   {
            nextActivityButton.setEnabled(false);
        }
        else    {
            nextActivityButton.setEnabled(true);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
