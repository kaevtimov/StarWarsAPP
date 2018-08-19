package source.kevtimov.starwarsapp.models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomLightsaberView extends View {
    private Paint mPaintLazer;
    private Paint mPaintHandle;
    private Rect mRectangleLazer;
    private Rect mRectangleHandle;


    public CustomLightsaberView(Context context) {
        super(context);
        init(null);
    }

    public CustomLightsaberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomLightsaberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomLightsaberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    public void init(@Nullable AttributeSet set){
        mPaintLazer = new Paint();
        mPaintLazer.setAntiAlias(true);
        mPaintLazer.setColor(Color.GREEN);

        mPaintHandle = new Paint();
        mPaintHandle.setAntiAlias(true);
        mPaintHandle.setColor(Color.GRAY);

        mRectangleLazer = new Rect();
        mRectangleHandle = new Rect();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        mRectangleLazer.top = 285;
        mRectangleLazer.left = 400;
        mRectangleLazer.right = mRectangleLazer.left + 40;
        mRectangleLazer.bottom = mRectangleLazer.top + 525;

        mRectangleHandle.top = mRectangleLazer.bottom;
        mRectangleHandle.left = 400;
        mRectangleHandle.right = mRectangleHandle.left + 40;
        mRectangleHandle.bottom = mRectangleHandle.top + 135;

        canvas.drawRect(mRectangleLazer, mPaintLazer);
        canvas.drawRect(mRectangleHandle, mPaintHandle);
    }

    public void lightsaberON(){
        mPaintLazer.setColor(Color.BLUE);
        postInvalidate();
    }

    public void lightsaberOFF(){
        mPaintLazer.setColor(Color.BLACK);
        postInvalidate();
    }

    public void change(){
        if(mPaintLazer.getColor() == Color.BLUE){
            mPaintLazer.setColor(Color.RED);
        }else if(mPaintLazer.getColor() == Color.RED){
            mPaintLazer.setColor(Color.YELLOW);
        }else if(mPaintLazer.getColor() == Color.YELLOW){
            mPaintLazer.setColor(Color.GREEN);
        }else if(mPaintLazer.getColor() == Color.GREEN){
            mPaintLazer.setColor(Color.BLUE);
        }
        postInvalidate();
    }
}
