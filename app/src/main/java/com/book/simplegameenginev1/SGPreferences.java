package com.book.simplegameenginev1;

//essa classe armazena com chaves de par e valor em modo xml na memoria interna do app

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SGPreferences {

    //SharedPreferences é um arquivo de referencias que só permite leitura
    // Para modificar uma sharedpreferences é necessario um sharedpreferences.Editor

private SharedPreferences.Editor  mEditor = null;
private SharedPreferences         mPreferences = null;

public SGPreferences(Activity activity){
                          //mode_private: arquivo só pode er acessado pelo aplicativo
    mPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    mEditor = mPreferences.edit();
}

//key: chave que queremos encontrar, defaultValue: valor caso a chave ñ seja encontrada

public boolean getBoolean(String key, boolean defaultValue){

    try{

        return mPreferences.getBoolean(key, defaultValue);

    }catch(ClassCastException e){
    //Log é para ver os erros no LogCat debug
        Log.d(SGAcivity.TAG,"SGPreferences.getBoolean():Valor possui um tipo Diferente");
        return defaultValue;
    }

}
    public float getFloat(String key, float defaultValue){

        try{

            return mPreferences.getFloat(key, defaultValue);

        }catch(ClassCastException e){
            //Log é para ver os erros no LogCat debug
            Log.d(SGAcivity.TAG,"SGPreferences.getFloat():Valor possui um tipo Diferente");
            return defaultValue;
        }

    }
    public int getInt(String key, int defaultValue){

        try{

            return mPreferences.getInt(key, defaultValue);

        }catch(ClassCastException e){
            //Log é para ver os erros no LogCat debug
            Log.d(SGAcivity.TAG,"SGPreferences.getInt():Valor possui um tipo Diferente");
            return defaultValue;
        }

    }
    public long getLong(String key, long defaultValue){

        try{

            return mPreferences.getLong(key, defaultValue);

        }catch(ClassCastException e){
            //Log é para ver os erros no LogCat debug
            Log.d(SGAcivity.TAG,"SGPreferences.getLong():Valor possui um tipo Diferente");
            return defaultValue;
        }

    }
    public String getString(String key, String defaultValue){

        try{

            return mPreferences.getString(key, defaultValue);

        }catch(ClassCastException e){
            //Log é para ver os erros no LogCat debug
            Log.d(SGAcivity.TAG,"SGPreferences.getString():Valor possui um tipo Diferente");
            return defaultValue;
        }

    }

    //método que inicia o processo de edição
    public SGPreferences begin(){
       mEditor = mPreferences.edit();
       return this;
    }

    // inserção de informações
    public SGPreferences putBoolean(String key,boolean value){
    mEditor.putBoolean(key,value);
    return this;
    }

    public SGPreferences putInt(String key,int value){
        mEditor.putInt(key,value);
        return this;
    }
    public SGPreferences putLong(String key,long value){
        mEditor.putLong(key,value);
        return this;
    }
    public SGPreferences putFloat(String key,float value){
        mEditor.putFloat(key,value);
        return this;
    }
    public SGPreferences putString(String key,boolean value){
        mEditor.putBoolean(key,value);
        return this;
    }

    //remover informação com a chave
    public SGPreferences remove(String key){
    mEditor.remove(key);
    return this;
    }

    //finalizar a edição apos terminar
    public void end(){
    mEditor.commit();
    }
}
