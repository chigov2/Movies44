package techmarket.uno.movies44;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmailAddress;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);


    }

    public void onClickAlreadyRegistered(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}