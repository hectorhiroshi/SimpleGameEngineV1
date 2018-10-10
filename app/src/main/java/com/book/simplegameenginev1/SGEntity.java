package com.book.simplegameenginev1;

import android.graphics.Color;
import android.graphics.PointF;

public class SGEntity {

    public enum DebugDrawingStyle{

        FILLED,OUTLINE
        // retangulo preenchido, retangulo não preenchido
    };

    private String mCategory; //define a categoria da entidade
    protected int mDebugColor = Color.RED; // cor que sera usada para ocupada o local da entidade
    private DebugDrawingStyle mDebbugDrawingStyle = DebugDrawingStyle.FILLED; // estilo de desenho do retangulo
    protected PointF mDimensions = new PointF();//largura e altura da entidade
    private int mId; // identificação unica da entidade
    private boolean mIsActive = true;// define se a entidade está ativa
    protected PointF mPosition = new PointF(); // define a posição da entidade em relação a seu canto superior esquerdo
    private SGWorld mWorld; // referencia ao mundo que a entidade pertence


    public SGEntity(SGWorld world, int id, String category, PointF position, PointF dimensions){


        mWorld = world;
        mId = id;
        mCategory = category;
        mPosition.set(position);
        mDimensions.set(dimensions);
    }

    public void move(float offsetX, float offsetY){

        mPosition.x += offsetX;
        mPosition.y += offsetY;
    }
}
