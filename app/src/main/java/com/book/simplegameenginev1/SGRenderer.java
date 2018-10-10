package com.book.simplegameenginev1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

//Renderizador, responsavel por desenha no lugar da classe gameview à partir do cap 9 do livro
public class SGRenderer {

    private Canvas mTempCanvas;
    private Paint mTempPaint = new Paint();
    private RectF mTempDstRect = new RectF();

    public void beginDrawing(Canvas canvas, int backgroundColor){

        mTempCanvas = canvas;
        canvas.drawColor(backgroundColor);
    }

    //desenha retangulos preenchidos
    public void drawRect(Rect source, int color){

    mTempPaint.setColor(color);
    mTempPaint.setStyle(Paint.Style.FILL);
    mTempCanvas.drawRect(source, mTempPaint);
    }
    //desenha retangulos float preenchidos
    public void drawRect(RectF source, int color){

        mTempPaint.setColor(color);
        mTempPaint.setStyle(Paint.Style.FILL);
        mTempCanvas.drawRect(source, mTempPaint);
    }

    // desenha somente as bordas do retangulo
    public void drawOutlineRect(Rect worldSpaceDestination, int color){

        mTempPaint.setColor(color);
        mTempPaint.setStyle(Paint.Style.STROKE); // stroke = borda
        mTempPaint.setStrokeWidth(0);

        mTempDstRect.set(worldSpaceDestination);
        mTempDstRect.right -=1; // compensar um bug em que a direita e baixo ficam maiores
        mTempDstRect.bottom -=1;
        mTempCanvas.drawRect(mTempDstRect, mTempPaint);
    }

    // desenha somente as bordas do retangulo float
    public void drawOutlineRect(RectF worldSpaceDestination, int color){

        mTempPaint.setColor(color);
        mTempPaint.setStyle(Paint.Style.STROKE); // stroke = borda
        mTempPaint.setStrokeWidth(0); // largura da borda = 0 ou seja , igual à 1

        mTempDstRect.set(worldSpaceDestination);
        mTempDstRect.right -=1;
        mTempDstRect.bottom -=1;
        mTempCanvas.drawRect(mTempDstRect, mTempPaint);
    }

    // responsável por desenhar as imagens
    public void drawImage(SGImage image,Rect source, RectF destination){

        if(image != null){
            Bitmap bitmap = image.getBitmap();
            mTempCanvas.drawBitmap(bitmap, source,destination,mTempPaint);
            // source é a área do retangulo a ser desenhado e destination é o local à ser desenhado
        }else{

            drawRect(destination, Color.RED);
        }
    }

    public void endDrawing(){

    }

}
