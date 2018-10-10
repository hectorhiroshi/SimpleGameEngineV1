package com.book.simplegameenginev1;

import android.graphics.Point;

public class SGWorld {

    private Point mDimensions;

    public SGWorld(Point worldDimensions){

        mDimensions = new Point(worldDimensions);
    }

    public void step(float ElapsedTimeInSeconds){}
    public void setup(){}
    public Point getmDimensions() { return mDimensions; }


}
