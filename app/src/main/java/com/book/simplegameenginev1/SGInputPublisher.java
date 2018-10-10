package com.book.simplegameenginev1;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.ArrayList;

// classe para receber e despachar eventos
public class SGInputPublisher implements GestureDetector.OnGestureListener {

    protected GestureDetector mGestureDetector = null;

    protected ArrayList<SGInputSubscriber> mSubscribers = new ArrayList<>();
    // lista de assinantes

    public SGInputPublisher(Context context){
                                              //this é o propria classe
        mGestureDetector = new GestureDetector(context,this);
    }

    public void registerSubscriber(SGInputSubscriber listener){
        mSubscribers.add(listener);
    }

    public boolean unregisterSubscriber(SGInputSubscriber listener){

        return mSubscribers.remove(listener);
    }

    public boolean onTouchEvent(MotionEvent event){

        int action = event.getActionMasked(); //retorn a ação ligada ao evento

        if(action == MotionEvent.ACTION_UP){  // Action_up = usuario tirou o dedo da tela, e action_down = pressionou

            for(int i=0; i < mSubscribers.size(); i ++){
                mSubscribers.get(i).onUp(event);
            }
            return true;
        }
        return mGestureDetector.onTouchEvent(event);
    }
//------------------------------------------------------------------------------------------------


    @Override
    public boolean onDown(MotionEvent event) {

        for(int i=0; i < mSubscribers.size();i++){
            mSubscribers.get(i).onDown(event);
        }
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onScroll
            (MotionEvent downEvent, MotionEvent moveEvent, float distanceX, float distanceY) {

        for(int i=0; i < mSubscribers.size();i++){
            mSubscribers.get(i).onScroll(downEvent,moveEvent,distanceX,distanceY);
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return true;
    }
}
