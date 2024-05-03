package com.example.acceuil;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {


     TextInputEditText fullnameEditText;
     TextInputEditText descriptionEditText;
     TextInputEditText localisationEditText;
     TextInputEditText emailEditText;
     Spinner servicesSpinner;
     Button returnButton, addButton;

     Uri uri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        // Récupérez les références des champs de saisie et des boutons
        fullnameEditText = findViewById(R.id.fullname);
        descriptionEditText = findViewById(R.id.description);
        localisationEditText = findViewById(R.id.localisation);
        emailEditText = findViewById(R.id.email);
        servicesSpinner = findViewById(R.id.services);
        returnButton = findViewById(R.id.add1);
        addButton = findViewById(R.id.add2);



        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton "Retour" est cliqué, démarrer l'activité MainActivity
                Intent intent = new Intent(FormActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        // Ajoutez un écouteur de clic sur le bouton "Ajouter service"
        addButton.setOnClickListener(v -> {
            if (validateInputs()) {
                ajouterService();
            }
        });
    }
    private void ajouterService() {
        // Récupérer les valeurs saisies par l'utilisateur
        String fullname = fullnameEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String localisation = localisationEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String service = servicesSpinner.getSelectedItem().toString();

        DataClass dataClass = new DataClass(fullname,description,localisation,email,service);

        FirebaseDatabase.getInstance().getReference().child(fullname).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    // on va se rediriger vers l 'activity profil ! n'oublie pas
                    Toast.makeText(FormActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FormActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


    private boolean validateInputs() {
        String fullname = fullnameEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        String localisation = localisationEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        int selectedServiceIndex = servicesSpinner.getSelectedItemPosition();

        // Vérifier si le nom complet ne contient que des chiffres et des espaces
        if (!isValidFullname(fullname)) {
            fullnameEditText.setError("Veuillez saisir un nom complet valide");
            return false;
        }

        // Vérifier si l'adresse e-mail est valide
        if (!isValidEmail(email)) {
            emailEditText.setError("Veuillez saisir une adresse e-mail valide");
            return false;
        }

        // Vérifier si tous les champs sont remplis
        if (fullname.isEmpty() || description.isEmpty() || localisation.isEmpty() || email.isEmpty() || selectedServiceIndex == 0) {
            return false;
        }

        return true;
    }

    private boolean isValidFullname(String fullname) {
        String fullnameRegex = "^[a-zA-Z0-9\\s]+$";
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
