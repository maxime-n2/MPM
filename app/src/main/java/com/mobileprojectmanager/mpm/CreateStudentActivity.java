package com.mobileprojectmanager.mpm;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class CreateStudentActivity extends AppCompatActivity {


    private Button mCreateStudentButton;    // Récupération du bouton pour créer les étudiants
    private EditText mTextFieldStudent;

    public ArrayList<Student> mStudentsList = new ArrayList<Student>();      // Créer un tableau dans lequel on va stocker chaque étudiant
    int mId = 0;  // ID unique


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_activity);   // Afficher le layout

        mCreateStudentButton = findViewById(R.id.buttonAddStudent);    // Initialisation du boutton
        mTextFieldStudent = findViewById(R.id.editTextMultiLineStudent);

        // Listener permettant de savoir quand on clique sur le boutton
        mCreateStudentButton.setOnClickListener(view -> {

            String[] studentListFromInput = convertInputTextStrings();

            for (String mCurrentStudentName : studentListFromInput) {     // For each element from the textfield

                //Log.d("MainActivity", currentStudentName);
                Student newStudent = new Student(mCurrentStudentName, mId);
                mStudentsList.add(newStudent);

                mId ++;
            }

            mStudentsList.forEach((n) -> {
                n.getInfo();
            });

            // Affichage de l'activité ListStudent
            Intent intent = new Intent(this, ListStudentActivity.class);
            this.startActivity(intent);


        });





    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("STUDENT_LIST", mStudentsList);
    }





    @NonNull
    private String[] convertInputTextStrings() {
        String inputStudent = mTextFieldStudent.getText().toString();   // Mettre le contenu du textField dans le string inputStudent
        inputStudent = inputStudent.replaceAll("\n", "|");    // Remplacer tout les retours à la ligne par des caractères de séparation |

        String[] studentList = inputStudent.split("[|]");    // Créer un tableau studentList où chaque élement est un nom
        return studentList;
    }


}



