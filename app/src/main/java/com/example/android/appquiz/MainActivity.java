package com.example.android.appquiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    RadioGroup radioOne, radioTwo, radioThree, radioFive;
    RadioButton questionOneA, questionOneB, questionOneC, questionOneD, questionTwoA,questionTwoB,questionTwoC,questionTwoD,questionThreeA,questionThreeB,questionThreeC,questionThreeD,questionFiveA,questionFiveB,questionFiveC,questionFiveD;
    CheckBox answerBoolean, answerEditable, answerBolean, answerStringe;
    EditText inputQuestionFour;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioOne = findViewById(R.id.radioOne);
        radioTwo = findViewById(R.id.radioTwo);
        radioThree = findViewById(R.id.radioThree);
        radioFive = findViewById(R.id.radioFive);


        /** Getting the Id of the Users name */
        inputName = findViewById(R.id.inputName);

        /** Getting IDs of the Checkboxes, RadioButtons, and EditTexts in the quiz*/
        questionOneA = findViewById(R.id.questionOneA);
        questionOneB = findViewById(R.id.questionOneB);
        questionOneC = findViewById(R.id.questionOneC);
        questionOneD = findViewById(R.id.questionOneD);
        questionTwoA = findViewById(R.id.questionTwoA);
        questionTwoB = findViewById(R.id.questionTwoB);
        questionTwoC = findViewById(R.id.questionTwoC);
        questionTwoD = findViewById(R.id.questionTwoD);
        questionThreeA = findViewById(R.id.questionThreeA);
        questionThreeB = findViewById(R.id.questionThreeB);
        questionThreeC = findViewById(R.id.questionThreeC);
        questionThreeD = findViewById(R.id.questionThreeD);
        questionFiveA = findViewById(R.id.questionFiveA);
        questionFiveB = findViewById(R.id.questionFiveB);
        questionFiveC = findViewById(R.id.questionFiveC);
        questionFiveD = findViewById(R.id.questionFiveD);


    }

    public void submitButton(View view) {


        String usersName = inputName.getText().toString().trim();

        String questOne, questTwo , questThree, questFour, questFive, questSix;

        /** Calling methods with answers.*/
        questOne = questionOne(view);
        questTwo = questionTwo(view);
        questThree = questionThree(view);
        questFour = questionFour(view);
        questFive = questionFive(view);
        questSix = questionSix(view);


        /** Check of the questions are not null. */

        if (questOne.equals("") || questTwo.equals("")|| questThree.equals("")|| questFour.equals("")|| questFive.equals("")|| questSix.equals(""))
        {

            Toast.makeText(getApplicationContext(), "Answer all the questions!.", Toast.LENGTH_LONG).show();
        }

        else if (usersName.equals("")) {

            Toast.makeText(getApplicationContext(), "Please ensure you enter your name before submitting your answer.", Toast.LENGTH_LONG).show();
        }

        else {

            showConfirmDialog (view, usersName, questOne, questTwo, questThree, questFour, questFive, questSix);
        }

    }



    public void showConfirmDialog(final View view, final String usersName, final String questOne, final String questTwo, final String questThree, final String questFour, final String questFive, final String questSix) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Submit Answers");
        builder.setMessage("Are you satisfied with your answers?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                /** Correct scores*/
                String answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix;

                answerOne = "2009";
                answerTwo = "USA";
                answerThree = "Oracle";
                answerFour = "Ethereum, Ripple, Litecoin, Dash";
                answerFive = "Saposhi";
                answerSix = "Bolean, Stringe";


                /**Score 1 for correct answer else score 0*/
                int score, scoreOne, scoreTwo, scoreThree, scoreFour, scoreFive, scoreSix;

                if (questOne.equals(answerOne)) {
                    scoreOne = 1;
                } else {
                    scoreOne = 0;
                }

                if (questTwo.equals(answerTwo)) {
                    scoreTwo = 1;
                } else {
                    scoreTwo = 0;
                }

                if (questThree.equals(answerThree)) {
                    scoreThree = 1;
                } else {
                    scoreThree = 0;
                }

                if (questFour.equals(answerFour)) {
                    scoreFour = 1;
                } else {
                    scoreFour = 0;
                }

                if (questFive.equals(answerFive)) {
                    scoreFive = 1;
                } else {
                    scoreFive = 0;
                }

                if (questSix.equals(answerSix)) {
                    scoreSix = 1;
                } else {
                    scoreSix = 0;
                }


                /** Get Final Score */

                score = scoreOne + scoreTwo + scoreThree + scoreFour + scoreFive + scoreSix;

                /** Convert score to String*/
                String totalScore = String.valueOf(score).trim();

                /** Display Final Results*/
                Toast.makeText(getApplicationContext(), "Name: " + usersName + "\nScore: " + totalScore + "/6\n\nQ1: " + questOne + "\nQ2: " + questTwo + "\nQ3: " + questThree + "\nQ4: " + questFour + "\nQ5: " + questFive + "\nQ6: " + questSix , Toast.LENGTH_LONG).show();

                /** Pass correct values of question Four to showResultsDialog*/
                showResultsDialog(answerFour);

            }

            private void showResultsDialog(String answerFour) {

            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Retry.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }


    /**Method to get the value of Question One*/
    public String questionOne(View view) {

        String result;
        RadioGroup radioOne = findViewById(R.id.radioOne);
        int selectedId = radioOne.getCheckedRadioButtonId();
        RadioButton radioButtonOne = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = radioButtonOne.getText().toString();
        }

        return result;

    }

    /**Method to get the value of Question Two*/
    public String questionTwo(View view) {

        String result;
        RadioGroup radioTwo = findViewById(R.id.radioTwo);
        int selectedId = radioTwo.getCheckedRadioButtonId();
        RadioButton radioButtonTwo = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = radioButtonTwo.getText().toString();
        }

        return result;

    }


    /**Method to get the value of Question Three*/
    public String questionThree(View view) {

        String result;
        RadioGroup radioThree = findViewById(R.id.radioThree);
        int selectedId = radioThree.getCheckedRadioButtonId();
        RadioButton radioButtonThree = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = radioButtonThree.getText().toString();
        }

        return result;

    }

    // Method to get the value of Question Seven
    public String questionFour(View view) {

        String result;

        TextView inputQuestionFour = findViewById(R.id.inputQuestionFour);

        if (inputQuestionFour.getText().toString().trim().equals("")) {
            result = "";
        } else {
            result = inputQuestionFour.getText().toString().trim();
        }

        return result;
    }


    /**Method to get the value of Question Five*/
    public String questionFive (View view) {

        String result;
        RadioGroup radioFive = findViewById(R.id.radioFive);
        int selectedId = radioFive.getCheckedRadioButtonId();
        RadioButton radioButtonFive = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = radioButtonFive.getText().toString();
        }

        return result;

    }

    /** Method to get the value of Question Six */
    public String questionSix(View view) {

        CheckBox checkBoxThreeA = findViewById(R.id.answerBoolean);
        CheckBox checkBoxThreeB = findViewById(R.id.answerEditable);
        CheckBox checkBoxThreeC = findViewById(R.id.answerBolean);
        CheckBox checkBoxThreeD = findViewById(R.id.answerStringe);

        String A = checkBoxThreeA.getText().toString();
        String B = checkBoxThreeB.getText().toString();
        String C = checkBoxThreeC.getText().toString();
        String D = checkBoxThreeD.getText().toString();


        String result;

        if (checkBoxThreeA.isChecked() && checkBoxThreeB.isChecked() && checkBoxThreeC.isChecked() && checkBoxThreeD.isChecked()) {
            result = A + ", " + B + ", " + C + ", " + D;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeB.isChecked() && checkBoxThreeC.isChecked()) {
            result = A + ", " + B + ", " + C;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeB.isChecked() && checkBoxThreeD.isChecked()) {
            result = A + ", " + B + ", " + D;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeC.isChecked() && checkBoxThreeD.isChecked()) {
            result = A + ", " + C + ", " + D;
        } else if (checkBoxThreeB.isChecked() && checkBoxThreeC.isChecked() && checkBoxThreeD.isChecked()) {
            result = B + ", " + C + ", " + D;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeB.isChecked()) {
            result = A + ", " + B;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeC.isChecked()) {
            result = A + ", " + C;
        } else if (checkBoxThreeA.isChecked() && checkBoxThreeD.isChecked()) {
            result = A + ", " + D;
        } else if (checkBoxThreeB.isChecked() && checkBoxThreeC.isChecked()) {
            result = B + ", " + C;
        } else if (checkBoxThreeB.isChecked() && checkBoxThreeD.isChecked()) {
            result = B + ", " + D;
        } else if (checkBoxThreeC.isChecked() && checkBoxThreeD.isChecked()) {
            result = C + ", " + D;
        } else if (checkBoxThreeA.isChecked()) {
            result = A;
        } else if (checkBoxThreeB.isChecked()) {
            result = B;
        } else if (checkBoxThreeC.isChecked()) {
            result = C;
        } else if (checkBoxThreeD.isChecked()) {
            result = D;
        } else {
            result = "";
        }
        return result;
    }

}
