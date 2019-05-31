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

    Answer mT1_1 = new Answer(R.string.T1_Ans1);
    Answer mT1_2 = new Answer(R.string.T1_Ans2);
    Answer mT2_1 = new Answer(R.string.T2_Ans1);
    Answer mT2_2 = new Answer(R.string.T2_Ans2);
    Answer mT3_1 = new Answer(R.string.T3_Ans1);
    Answer mT3_2= new Answer(R.string.T3_Ans2);

    //indice corrente da historia
    private Story mStorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerBottom = findViewById(R.id.buttonBottom);
        mAnswerTop = findViewById(R.id.buttonTop);

        //TODO:faça o mapeamento da história

        mT1.setAnswerTop(mT1_1);
        mT1.setAnswerBottom(mT1_2);

        mT2.setAnswerTop(mT2_1);
        mT2.setAnswerBottom(mT2_2);

        mT3.setAnswerTop(mT3_1);
        mT3.setAnswerBottom(mT3_2);

        mT1_1.setChildStory(mT3);
        mT1_2.setChildStory(mT2);

        mT3_1.setChildStory(mT6);
        mT3_2.setChildStory(mT5);

        mT2_1.setChildStory(mT3);
        mT2_2.setChildStory(mT4);

        mT3_1.setChildStory(mT6);
        mT3_2.setChildStory(mT5);

        if(savedInstanceState!=null){
            mStorySelected = (Story)
                    savedInstanceState.getSerializable("StoryKey");
            if (mStorySelected.getAnswerTop() == null){
                mStoryTextView.setText(mStorySelected.getStoryID());
                mAnswerTop.setVisibility(View.GONE);
                mAnswerBottom.setVisibility(View.GONE);
            }
            else {
                mStoryTextView.setText(mStorySelected.getStoryID());
                mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
            }
        }
        else {
            mStorySelected = mT1;
            mStoryTextView.setText(mStorySelected.getStoryID());
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        }
    }
    // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
    // do botão setVisibility(View.GONE):

    public void butT(View v){
        mStorySelected = mStorySelected.getAnswerTop().getChildStory();
        if (mStorySelected.getAnswerTop() == null){
            mAnswerTop.setVisibility(View.GONE);
            mAnswerBottom.setVisibility(View.GONE);
        }
        else {
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        }
        mStoryTextView.setText(mStorySelected.getStoryID());
    }

    public void butB(View v){
        mStorySelected = mStorySelected.getAnswerBottom().getChildStory();
        if (mStorySelected.getAnswerBottom() == null){
            mAnswerTop.setVisibility(View.GONE);
            mAnswerBottom.setVisibility(View.GONE);
        }
        else {
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        }
        mStoryTextView.setText(mStorySelected.getStoryID());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("StoryKey",mStorySelected);
    }
}
