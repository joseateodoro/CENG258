//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class TeodoroActivity1 extends AppCompatActivity {

    RadioGroup radioGroupType, radioGroupSize; //RadioGroup Variables
    RadioButton radioButtonType, radioButtonSize; //RadioButton Variables
    CheckBox checkBacon, checkHam, checkPepperoni, checkPineapple, checkMushroom; //CheckBox Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teodoro1);

        //Declaration of RadioGroup | CheckBox | RadioButton
        radioGroupType = findViewById(R.id.radioGroupType);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        checkBacon = findViewById(R.id.checkBoxBacon);
        checkHam = findViewById(R.id.checkBoxHam);
        checkPepperoni = findViewById(R.id.checkBoxPepperoni);
        checkPineapple = findViewById(R.id.checkBoxPineapple);
        checkMushroom = findViewById(R.id.checkBoxMushroom);

        //Declaration of The Order Button
        Button btnNextOrder = findViewById(R.id.nextOrder);

        //Reads radio
        btnNextOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)    {

                //checking if radioGroup | Buttons| Toppings are true via boolean
                int radioIdType = radioGroupType.getCheckedRadioButtonId();
                radioButtonType = findViewById(radioIdType);

                int radioIdSize = radioGroupSize.getCheckedRadioButtonId();
                radioButtonSize = findViewById(radioIdSize);

                if(checkBacon.isChecked())  {
                    return;
                }
                if(checkHam.isChecked()) {
                    return;
                }
                if(checkPepperoni.isChecked())  {
                    return;
                }
                if(checkMushroom.isChecked())   {
                    return;
                }
                if(checkPineapple.isChecked())  {
                    return;
                }

            }
        });

    }

     //CHECKING RADIO BUTTON VALUES
    public void checkButton(View view) {

        int radioIdType = radioGroupType.getCheckedRadioButtonId();
        radioButtonType = findViewById(radioIdType);

        int radioIdSize = radioGroupSize.getCheckedRadioButtonId();
        radioButtonSize = findViewById(radioIdSize);


        if (radioGroupType.callOnClick() || radioGroupSize.callOnClick()) {
            Intent intent = new Intent(TeodoroActivity1.this, TeodoroActivity3.class);
            startActivity(intent);
        } else {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.inputNullOrder, Snackbar.LENGTH_LONG);
            snackbar.show();


            Intent intent = new Intent(TeodoroActivity1.this, TeodoroActivity2.class);
            startActivity(intent);
        }


    }

}
