package edu.washington.grassela.lifecounter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    private int[] lifeCounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            lifeCounts = savedInstanceState.getIntArray("counts");
        } else {
            lifeCounts = new int[4];
            for (int i = 0; i < lifeCounts.length; i++) {
                lifeCounts[i] = 20;
            }
        }
        setContentView(R.layout.activity_main);
        initializeDisplay();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putIntArray("counts", lifeCounts);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        lifeCounts = savedInstanceState.getIntArray("counts");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void updateP1(View view) {
        Button button = (Button) findViewById(view.getId());
        int change;
        String buttonText = "" + button.getText();
        System.out.println(buttonText);
        if (buttonText.length() < 2) {
            change = 1;
        } else {
            change =5;
        }
        if (buttonText.charAt(0) == '-') {
             change *= -1;
        }
        lifeCounts[0] += change;
        String newText = updateDisplay(1);
        TextView tv = (TextView) findViewById(R.id.player1);
        tv.setText(newText);
    }

    public void updateP2(View view) {
        Button button = (Button) findViewById(view.getId());
        int change;
        String buttonText = "" + button.getText();
        System.out.println(buttonText);
        if (buttonText.length() < 2) {
            change = 1;
        } else {
            change =5;
        }
        if (buttonText.charAt(0) == '-') {
            change *= -1;
        }
        lifeCounts[1] += change;
        String newText = updateDisplay(2);
        TextView textView = (TextView) findViewById(R.id.player2);
        textView.setText(newText);
    }

    public void updateP3(View view) {
        Button button = (Button) findViewById(view.getId());
        int change;
        String buttonText = "" + button.getText();
        System.out.println(buttonText);
        if (buttonText.length() < 2) {
            change = 1;
        } else {
            change =5;
        }
        if (buttonText.charAt(0) == '-') {
            change *= -1;
        }
        lifeCounts[2] += change;
        String newText = updateDisplay(3);
        TextView textView = (TextView) findViewById(R.id.player3);
        textView.setText(newText);
    }

    public void updateP4(View view) {
        Button button = (Button) findViewById(view.getId());
        int change;
        String buttonText = "" + button.getText();
        System.out.println(buttonText);
        if (buttonText.length() < 2) {
            change = 1;
        } else {
            change =5;
        }
        if (buttonText.charAt(0) == '-') {
            change *= -1;
        }
        lifeCounts[3] += change;
        String newText = updateDisplay(4);
        TextView textView = (TextView) findViewById(R.id.player4);
        textView.setText(newText);
    }

    private String updateDisplay(int player) {
        String display = "Player " + player + "\n " + "Life Count: " + lifeCounts[player -1];
        if (lifeCounts[player - 1] <= 0) {
            TextView label = (TextView) findViewById(R.id.label);
            label.setText("Player " + player + " LOSES!");
            label.setBackgroundColor(Color.GRAY);
        }
        return display;
    }

    private void initializeDisplay() {
        String newText1 = updateDisplay(1);
        TextView textView1 = (TextView) findViewById(R.id.player1);
        textView1.setText(newText1);
        String newText2 = updateDisplay(2);
        TextView textView2 = (TextView) findViewById(R.id.player2);
        textView2.setText(newText2);
        String newText3 = updateDisplay(3);
        TextView textView3 = (TextView) findViewById(R.id.player3);
        textView3.setText(newText3);
        String newText4 = updateDisplay(4);
        TextView textView4 = (TextView) findViewById(R.id.player4);
        textView4.setText(newText4);

    }
}
