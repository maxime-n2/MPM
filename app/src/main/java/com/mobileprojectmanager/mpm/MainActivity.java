package com.mobileprojectmanager.mpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private Button mCreateStudentButton;    // Récupération du bouton pour créer les étudiants
    private EditText mTextFieldStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_activity);   // Afficher le layout

        mCreateStudentButton = findViewById(R.id.buttonAddStudent);    // Initialisation du boutton
        mTextFieldStudent = findViewById(R.id.editTextMultiLineStudent);

        // Listener permettant de savoir quand on clique sur le boutton
        mCreateStudentButton.setOnClickListener(view -> {

            String inputStudent = mTextFieldStudent.getText().toString();   // Mettre le contenu du textField dans le string inputStudent
            inputStudent = inputStudent.replaceAll("\n", "|");    // Remplacer tout les retours à la ligne par des caractères de séparation |

            String[] studentList = inputStudent.split("[|]");    // Créer un tableau studentList où chaque élement est un nom

            for (String currentStudent : studentList) {
                Log.d("MainActivity", currentStudent);

            }



        });





    }



}