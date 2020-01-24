package edu.ritindia.bmical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText w,h;
    TextView res;
    Button b1;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w = findViewById(R.id.weight);
        h = findViewById(R.id.height);
        res = findViewById(R.id.result);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                if(w.getText().toString().isEmpty() ||  h.getText().toString().isEmpty())
                {
                    res.setText("enter numbers in both fields");
                }
                else{
                    Double w1 = Double.parseDouble(w.getText().toString());
                    Double h1 = Double.parseDouble(h.getText().toString());
                    double bmi = (w1 / (h1 * h1 / 10000));
                    if (bmi < 18.5) {
                        res.setText("Under Weight (" + df2.format(bmi) + ")");
                    } else if (bmi < 24.9) {
                        res.setText("Normal (" + df2.format(bmi) + ")");
                    } else if (bmi < 29.9)
                        res.setText("Over Weight (" + df2.format(bmi) + ")");
                    else
                        res.setText("Obes (" + df2.format(bmi) + ")");

                }

            }
        });
    }
}
