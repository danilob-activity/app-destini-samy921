package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;


    // TODO: Declare as variaveis aqui:

    Story  mT1 = new Story(R.string.T1_Story);
    Story  mT2 = new Story(R.string.T2_Story);
    Story  mT3 = new Story(R.string.T3_Story);
    Story  mT4 = new Story(R.string.T4_End);
    Story  mT5 = new Story(R.string.T5_End);
    Story  mT6 = new Story(R.string.T6_End);

    Answer T1_1 = new Answer(R.string.T1_Ans1);
    Answer T1_2 = new Answer(R.string.T1_Ans2);
    Answer T3 = new Answer(R.string.T2_Ans1);
    Answer T4 = new Answer(R.string.T2_Ans2);
    Answer T5 = new Answer(R.string.T3_Ans1);
    Answer T6 = new Answer(R.string.T3_Ans2);

    //indice corrente da historia
    private Story mStorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Faça o link do layout com a activity
//        mStoryTextView =

        //TODO:faça o mapeamento da história

        mT1.setAnswerBottom(T1_2);
        mT1.setAnswerTop(T1_1);

        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):


    }

}
