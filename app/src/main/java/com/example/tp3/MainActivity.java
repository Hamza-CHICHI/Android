package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp3.db.MyDatabase;
import com.example.tp3.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {    static User user = new User();
    static MyDatabase myDatabase;

    private Button connecter;
    private EditText login;
    private  EditText password;
    private TextView create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connecter = findViewById(R.id.se_connecter);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        create_account = findViewById(R.id.create_account);

        connecter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                myClick(v);
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                myClick(v);
            }
        });

    }

    private void myClick(View v){
        user.login	=	login.getText().toString();
        user.pass	=	password.getText().toString();
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "user_bd").allowMainThreadQueries().build();

        if ( !(login.getText().toString()).matches(""))
        {
            List<User> usr = MainActivity.myDatabase.mydao().get_User(login.getText().toString());
            switch (v.getId()) {
                case R.id.create_account:
                    if (usr.size() != 0) {
                        Toast.makeText(getApplicationContext(), "Impossible de créer le compte : login existant", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        MainActivity.myDatabase.mydao().add_User(user);
                        Toast.makeText(getApplicationContext(), "Parfait le compte est créé", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.se_connecter:
                    if (usr.size() != 0) {
                        if (usr.get(0).pass.contentEquals(password.getText().toString()) ) {
                            Intent intent = new Intent(this,MyList.class);
                            this.startActivity(intent);
                            break;
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Compte non existant", Toast.LENGTH_SHORT).show();
                        break;
                    }
            }

        }

    }
}
