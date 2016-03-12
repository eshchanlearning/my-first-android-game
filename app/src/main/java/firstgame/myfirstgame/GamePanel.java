package firstgame.myfirstgame;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.MotionEvent;

/**
 * Created by ericchan on 2016-03-09.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

    private GameThread gameThread;

    public GamePanel(Context context){
        super(context);
        getHolder().addCallback(this);
        gameThread = new GameThread(getHolder(), this);

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){
            try {
                gameThread.setRunning(false);
                gameThread.join();
                retry = false;
            }
            catch(Exception e){

            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    public void update(){

    }
}
