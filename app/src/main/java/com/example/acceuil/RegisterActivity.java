package com.example.acceuil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.progressBar);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();
                if (validateInputs()) {
                    // Effectuez les actions d'inscription ici
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                  /*  progressBar.setVisibility(View.GONE);*/
                                    if (task.isSuccessful()) {


                                        Toast.makeText(RegisterActivity.this, "Account Created",
                                                Toast.LENGTH_SHORT).show();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    register();
                }
            }
        });
    }



    //retour à la page précédente register-->sign in
    public void backc(View view){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }


    // faire l'inscription et aller vers la page sign in pour se connecter
    public void register() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    // Si l'utilisateur a un compte , revient à la page sign in
    public void log() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
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
            return false;
        }

        return true;
    }

    private boolean isValidFullname(String fullname) {
        String fullnameRegex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(fullnameRegex);
        Matcher matcher = pattern.matcher(fullname);
        return matcher.matches();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
