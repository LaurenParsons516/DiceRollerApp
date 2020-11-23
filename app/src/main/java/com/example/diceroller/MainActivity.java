package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String numClicked = "";
    private Integer diceClicked;
    private TextView rollSum;
    private TextView rollHistory;
    private TextView rollType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rollSum = this.findViewById(R.id.rollSum);
        this.rollHistory = this.findViewById(R.id.rollHistory);
        this.rollType = this.findViewById(R.id.roll);
    }


    public void onNumberClick(View v) {
        int id = v.getId();
        if (id == R.id.button0) {
            this.numClicked += "0";
        } else if (id == R.id.button1) {
            this.numClicked += "1";
        } else if (id == R.id.button2) {
            this.numClicked += "2";
        } else if (id == R.id.button3) {
            this.numClicked += "3";
        } else if (id == R.id.button4) {
            this.numClicked += "4";
        } else if (id == R.id.button5) {
            this.numClicked += "5";
        } else if (id == R.id.button6) {
            this.numClicked += "6";
        } else if (id == R.id.button7) {
            this.numClicked += "7";
        } else if (id == R.id.button8) {
            this.numClicked += "8";
        } else if (id == R.id.button9) {
            this.numClicked += "9";
        }
    }

    public void onDiceClicked(View v) {
        int id = v.getId();
        if (id == R.id.d4) {
            diceClicked = 4;
        } else if (id == R.id.d6) {
            diceClicked = 6;
        } else if (id == R.id.d8) {
            diceClicked = 8;
        } else if (id == R.id.d10) {
            diceClicked = 10;
        } else if (id == R.id.d12) {
            diceClicked = 12;
        } else if (id == R.id.d20) {
            diceClicked = 20;
        }
    }

    public void onRollClicked(View v) {
        for (int i = 0; i < Integer.parseInt(numClicked); i++) {
            Die die = new Die(diceClicked);
            int singleRoll = die.roll();
            this.rollHistory.setText(rollHistory.getText() + " + " + Integer.toString(singleRoll));
            this.rollType.setText(numClicked + "D" + diceClicked);
            this.rollSum.setText(Integer.toString(Integer.parseInt(rollSum.getText().toString()) + singleRoll));
        }
    }

    public void onPercentileClicked(View v) {
        Die percentDie = new Die(100);
        int percentRoll = percentDie.roll();
        this.rollSum.setText(Integer.toString(percentRoll));
    }

    public void onClearClicked(View v) {
        this.rollHistory.setText("");
        this.rollSum.setText("0");
        this.rollType.setText("");
        this.diceClicked = null;
        this.numClicked = "";
    }
}