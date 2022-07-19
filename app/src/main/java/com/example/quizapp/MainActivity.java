package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.Model.Questions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //creating reference for View XML
    TextView totalQuestionsTextView;
    TextView questionsTextView;
    Button answerA,answerB,answerC,answerD;
    Button submitButton;

    //variable declaration
    int score = 0;
    int totalQuestions = Questions.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = ""; //selected answer initialized as an empty String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencing buttons

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionsTextView = findViewById(R.id.question);
        answerA = findViewById(R.id.answer_A);
        answerB = findViewById(R.id.answer_B);
        answerC = findViewById(R.id.answer_C);
        answerD = findViewById(R.id.answer_D);
        submitButton = findViewById(R.id.submit_button);

        //onClick
        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        //after application will be loaded
        totalQuestionsTextView.setText("Total questions : "+totalQuestions);

        //method for new question
        newQuestion();


    }

    @Override
    //setting onClick for all Buttons
    public void onClick(View view) {

        //set all other Button colors to white when onClick

        answerA.setBackgroundColor(Color.WHITE);
        answerB.setBackgroundColor(Color.WHITE);
        answerC.setBackgroundColor(Color.WHITE);
        answerD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_button){
            //increase question score when going to the next question
            if(selectedAnswer.equals(Questions.answers[currentQuestionIndex])){ // if correct answer, increase score
                score++;
            }

            currentQuestionIndex++; //go to next question
            newQuestion(); //newQuestion method called when changing index of the question to the next one
//            totalQuestions--;


        }else{
            //button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.LTGRAY);
        }
    }

    void newQuestion(){

        if(currentQuestionIndex == totalQuestions){ //finish quiz when all questions are answered
            finishQuiz();
            return;
        }

        questionsTextView.setText(Questions.question[currentQuestionIndex]);
        answerA.setText(Questions.choices[currentQuestionIndex][0]);
        answerB.setText(Questions.choices[currentQuestionIndex][1]);
        answerC.setText(Questions.choices[currentQuestionIndex][2]);
        answerD.setText(Questions.choices[currentQuestionIndex][3]);
    }

    //METHOD when finish the quiz. If successful score > 70% - Pass status will be displayed, else -> Failed message.

    void finishQuiz(){
        String passQuizScore = "";
        if(score> totalQuestions * 0.70){ //passed if more than 70% are correct
            passQuizScore = "Passed";
        }else{
            passQuizScore = "Failed";
        }

        //ALERT MESSAGE TO NOTIFY ABOUT SCORE
        new AlertDialog.Builder(this).setTitle(passQuizScore)
                .setMessage("Your score is " + score + "out of " +totalQuestions)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz()) //lambda for representing func restartQuiz()
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        newQuestion(); // loading quiz from start
    }
}