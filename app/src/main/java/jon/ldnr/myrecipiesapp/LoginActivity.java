package jon.ldnr.myrecipiesapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // Properties
    private EditText username;
    private EditText password;
    private String loginUsername;
    private String loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Fields of login form
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginUsername = getString(R.string.username);
        loginPassword = getString(R.string.password);
    }

    /**
     * Connect to app on submit
     * @param view
     */
    protected void submitLoginForm(View view) {

        if (username.getText().toString().equals(loginUsername) && password.getText().toString().equals(loginPassword)) {

            // close login form
            this.finish();

            // Authorize to add new recipe
            // code...

        } else {

            Toast.makeText(this, "Utilisateur inconnu", Toast.LENGTH_SHORT).show();

        }

    }
}
