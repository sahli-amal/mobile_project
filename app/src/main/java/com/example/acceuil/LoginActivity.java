package com.example.acceuil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private Button loginButton;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Récupérez les références des champs de saisie et du bouton
        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);


        // Ajoutez un écouteur de clic sur le bouton "se connecter"
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();
                if (validateInputs()) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        Toast.makeText(LoginActivity.this, "Login Successfull",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }
            }


        });
    }

    private boolean validateInputs() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Vérifier si l'adresse e-mail est valide
        if (!isValidEmail(email)) {
            emailEditText.setError("Veuillez saisir une adresse e-mail valide");
            return false;
        }

        // Vérifier si le mot de passe est saisi
        if (password.isEmpty()) {
            passwordEditText.setError("Veuillez saisir un mot de passe");
            passwordEditText.onVisibilityAggregated(false);
            return false;
        } else {
            passwordEditText.onVisibilityAggregated(true);
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        // Utiliser une expression régulière pour vérifier la validité de l'adresse e-mail
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}


