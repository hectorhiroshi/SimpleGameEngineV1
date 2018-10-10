package com.book.simplegameenginev1;

import android.view.MotionEvent;

public interface SGInputSubscriber {

    public void onDown(MotionEvent evento);
    public void onScroll
            (MotionEvent downEvent,MotionEvent moveEvent,float distanceX,float distanceY);

    public void onUp(MotionEvent evento);


}
