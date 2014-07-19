package com.noteswithlock;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dhanesh on 7/17/2014.
 */
/* this activity check the username and password.
 *
 */
public class LoginCheck extends Activity {
    TextView User_Text_view,Password_Text_View;
    EditText User_Edit_Text,Password_Edit_Text;
    String Username,Password;
    Button Login_Button;

    public static final String Login = "login";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User_Text_view=(TextView )findViewById(R.id.textView1);
        User_Text_view.setText("USER NAME");

        Password_Text_View=(TextView )findViewById(R.id.textView2);
        Password_Text_View.setText("PASSWORD");

        User_Edit_Text=(EditText )findViewById(R.id.editText1);
        Password_Edit_Text=(EditText )findViewById(R.id.editText2);

        Login_Button=(Button)findViewById(R.id.button1);
        Login_Button.setText("Login");


        SharedPreferences settings = getSharedPreferences(Login, 0);
        Username=settings.getString("username", "");
        Password=settings.getString("password", "");
        User_Edit_Text.setText(Username);
        Password_Edit_Text.setText(Password);
        //et1.setText("");et2.setText("");

        Login_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String uname = User_Edit_Text.getText().toString().trim();
                String pass = Password_Edit_Text.getText().toString().trim();
                if(uname.equals("admin")&& pass.equals("admin"))
                {
                    Intent i=new Intent(getApplicationContext(),OpenNotes.class);startActivity(i);
                    Toast.makeText(getApplicationContext(), "Your are successfully login", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong UserName and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //its stores the username and password into the shared Preference.
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences s = getSharedPreferences(Login, 0);
        SharedPreferences.Editor editor = s.edit();
        editor.putString("username", User_Edit_Text.getText().toString().trim());
        editor.putString("password", Password_Edit_Text.getText().toString().trim());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
