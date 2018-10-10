package com.book.simplegameenginev1;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

//fábrica de imagens
public class SGImageFactory {

    protected Context mContext = null;

    public SGImageFactory(Context context){

        mContext = context;
    }
    //metodo para carregar imagens 1 => a pasta de assets
    public SGImage createImage(String filename){

        Bitmap bitmap = null;

        try{

            AssetManager assetManager = mContext.getAssets();
            //inputstream representa qualquer fonte de bytes
            InputStream inputStream = assetManager.open(filename);
            //decodeStream decodifica o formato da imagem, png , jpeg etc...
            bitmap = BitmapFactory.decodeStream(inputStream);
            //fechar o inputStream para economizar recursos
            inputStream.close();

        }catch(IOException e){

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SGImageFactory.createImage(): arquivo");
            stringBuilder.append(filename);
            stringBuilder.append("Não encontrado!");
            Log.d("SimpleGameEngine",stringBuilder.toString());
            return null;
        }

        SGImage image = new SGImage(bitmap);
        return image;
    }

    //método para carregar imagens 2
    public SGImage createImage(int resourceID){

        Bitmap bitmap = null;

        try{
            Resources resources = mContext.getResources();
            InputStream inputStream = resources.openRawResource(resourceID);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();

        }catch(IOException e){ }

        SGImage image = new SGImage(bitmap);


        return image;
    }

    public Context getContext() {
        return mContext;
    }
}
