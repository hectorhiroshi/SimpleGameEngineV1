package com.book.simplegameenginev1;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

public class SGView extends View {

    private Point mDimensions = new Point();
    //indica as dimensoes da tela
    private boolean mHasStarted=false;
    // indica que as dimensoes da tela ja foram definidas e o jogo foi iniciado
    private SGImageFactory mImageFactory;
    // imagefactory => fábrica de imagens

    int teste = 1;

    private SGRenderer mRenderer;
    //renderizador
    private SGStepwatch mStepwatch = new SGStepwatch();

    public SGView(Context context) {
        super(context);

        mImageFactory = new SGImageFactory(context);
        mRenderer = new SGRenderer();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        step(canvas,mStepwatch.tick());// chama o step da classe abaixo : GameView
        invalidate();// tecnica para indicar k a tela está suja e onDraw deve ser chamado denovo
                     // util para criar a animação do jogo no capitulo 8

    }

    // o objetivo de step é criar um passo de animação, o elapsed time é para temporização
    public void step(Canvas canvas,float elapsedTimeinSeconds){

    }

    //onSizeChanged é chamado sempre que as dimensoes de visão da atividade mudam
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //w = width e h = height , as dimensoes são gravadas aqui porque pode ser que usando
        // getWidth ou getHeight não retorne o valor correto das dimensoes de visão
        mDimensions.set(w,h);

        if(!mHasStarted){

            setup();


            mHasStarted = true;
        }
    }

    protected void setup(){ // fazer os desenhos,definir as caracteristicas do desenho


    }
    // retorna as dimensoes da visão
    public Point getDimensions(){return mDimensions;}

    public SGImageFactory getImageFactory() { return mImageFactory; }
    public SGRenderer getRenderer(){return mRenderer;}
}
