package com.pft.liuxiaofeng.nbajames.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author :Little Pidding
 * @since 17-11-22.
 */

public class MyViewDemo extends View{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public MyViewDemo(Context context) {
        super(context);
    }

    public MyViewDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);//画线模式
        paint.setStrokeWidth(30);
        canvas.drawColor(Color.BLUE);
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
//        canvas.drawRoundRect(200,200,100,100,paint);
//        canvas.drawLine(200,200,100,100,paint);
        canvas.drawPath(path,paint);
    }

}
