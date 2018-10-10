package com.book.simplegameenginev1;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

// essa classe contem a base para os jogos
public class SGAcivity extends Activity {

    public static final String TAG = "SimpleGameEngine";
    private SGPreferences mPreferences; // " banco de dados "
    protected SGInputPublisher mInputPublisher = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arquivo de preferencias
        mPreferences = new SGPreferences(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onDestroy() { super.onDestroy(); }

    public void enableKeepScreenOn(){//MANTER A TELA ACESSA

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    //métodos para orientação da tela: paisagem o retrato------------------
    //talvez não seja utilizado ,pois, isso ira reiniciar o ciclo de atividade do aplicativo
    public enum SGOrientation{
        LANDSCAPE,PORTRAIT
    }
    public void setOrientation(SGOrientation orientation){

        switch(orientation){

            case LANDSCAPE:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;

            case PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }
    //---------------------------------------------------------------

    //modo tela cheia
    public void enableFullScreen(){

        Window window = getWindow(); //pegar o this.janela ou activity atual

        //deixar em tela cheia
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //remover o titulo do aplicativo
        window.requestFeature(Window.FEATURE_NO_TITLE);
        //remover barra  de navegação comparando a versão da SDK
        if(Build.VERSION.SDK_INT>=19){

            window.getDecorView().setSystemUiVisibility
                    (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            //esconde completamente a barra de navegação
        }

    }
    //---------------------------------------------------------------- entrada de usuário


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(mInputPublisher != null){
            return mInputPublisher.onTouchEvent(event);
        }else{
            return false;
        }
    }

    public void setInputPublisher(SGInputPublisher inputPublisher){
        mInputPublisher = inputPublisher;
    }
    public SGInputPublisher getInputPubliser(){return mInputPublisher;}
}
