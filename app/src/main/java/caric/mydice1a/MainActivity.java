package caric.mydice1a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String DIE_1 = "die1";
    public static final String DIE_2 = "die2";
    private TextView die1View;
    private TextView die2View;
    Die die1 = new Die();
    Die die2 = new Die();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        die1View = findViewById(R.id.die1);
        die2View = findViewById(R.id.die2);

        if(savedInstanceState != null){
            die1.setNumber(savedInstanceState.getInt(DIE_1));
            die2.setNumber(savedInstanceState.getInt(DIE_2));
            displayDice();
        }

        Button button = findViewById(R.id.roll_button);

        button.setOnClickListener((view)-> rollDice());

    }

    public void rollDice(){
        die1.roll();
        die2.roll();
        displayDice();
    }

    private void displayDice() {
        die1View.setText(String.format(Locale.CANADA,"%1d",die1.getNumber()));
        die2View.setText(String.format(Locale.CANADA,"%1d",die2.getNumber()));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(DIE_1,die1.getNumber());
        outState.putInt(DIE_2,die2.getNumber());
    }
}
