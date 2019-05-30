package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    Answer T2_1 = new Answer(R.string.T2_Ans1);
    Answer T2_2 = new Answer(R.string.T2_Ans2);
    Answer T3_1 = new Answer(R.string.T3_Ans1);
    Answer T3_2= new Answer(R.string.T3_Ans2);

    //indice corrente da historia
    private Story mStorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Faça o link do layout com a activity
//        mStoryTextView =

        //TODO:faça o mapeamento da história

        mT1.setAnswerTop(T1_1);
        mT1.setAnswerBottom(T1_2);

        T1_1.setChildStory(mT3);
        T1_2.setChildStory(mT2);

        T3_1.setChildStory(mT6);
        T3_2.setChildStory(mT5);

        mT2.setAnswerTop(T2_1);
        mT2.setAnswerTop(T2_2);

        T2_1.setChildStory(mT3);
        T2_2.setChildStory(mT4);

        mT3.setAnswerTop(T3_1);
        mT3.setAnswerBottom(T3_2);

        T3_1.setChildStory(mT6);
        T3_2.setChildStory(mT5);
    }

        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):

        public void butT(View v){
            Log.d();

    }

        public void butB(View v){
            Log.d();

    }

}
