package lektion01.s165209;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Private variables used throughout the app

    // Regular buttons
    private Button b01;

    // Menu buttons
    private Button bm01;
    private Button bm02;
    private Button bm03;

    // Text views
    private TextView tv01;

    // Edit Text views
    private EditText et01;

    // Variables
    private int currentPage = 1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find views by id
        b01 = (Button) findViewById(R.id.b01);

        bm01 = (Button) findViewById(R.id.bm01);
        bm02 = (Button) findViewById(R.id.bm02);
        bm03 = (Button) findViewById(R.id.bm03);

        tv01 = (TextView) findViewById(R.id.tv01);

        et01 = (EditText) findViewById(R.id.et01);


        // On click listeners
        b01.setOnClickListener(this);
        bm01.setOnClickListener(this);
        bm02.setOnClickListener(this);
        bm03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Button Menu 1
        if (v == bm01) {
            if (currentPage == 1) {
                return;
            }                               // Check the page the user is in

            if (name != null) {                                             // Check whether or not the user has entered his name before
                tv01.setText("Welcome back " + name);
            } else {
                tv01.setText("Please type your name below..");
            }          // else put it back to standard

            tv01.setVisibility(View.VISIBLE);                               // Put all buttons and texts visible (there's nothing on the other pages yet)
            et01.setVisibility(View.VISIBLE);
            b01.setVisibility(View.VISIBLE);

            currentPage = 1;                                                // Change the users current page
            System.out.println("User has moved to page " + currentPage);
        }
        // Button Menu 2
        else if (v == bm02) {
            if (currentPage == 2) {
                return;
            }

            tv01.setText("You are currently viewing Guidelines");
            et01.setVisibility(View.GONE);
            b01.setVisibility(View.GONE);

            currentPage = 2;
            System.out.println("User has moved to page " + currentPage);
        }
        // Button Menu 3
        else if (v == bm03) {
            if (currentPage == 3) {
                return;
            }

            tv01.setText("You are currently viewing Settings");
            et01.setVisibility(View.GONE);
            b01.setVisibility(View.GONE);

            currentPage = 3;
            System.out.println("User has moved to page " + currentPage);
        }
        // Regular buttons on page 1
       else if (v == b01) {
            name = et01.getText().toString();
            if (name != null) {
                tv01.setText("Hello " + name);
                System.out.println(name + " has logged in.");
            } else {
                tv01.setText("Please type your name below");
                System.out.println("User failed to type a name in the editText field");
            }
        }else {
            System.out.println("Some random button has been pressed down");
        }
    }
}