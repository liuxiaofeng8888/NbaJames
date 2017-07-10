package com.pft.liuxiaofeng.nbajames.bean;

import android.graphics.Color;
import android.graphics.Paint;


/**
 * @author :Little Pidding
 * @since 17-7-7.
 * 把wave的数据封装成一个对象
 */

public class Wave {
    public float x; //圆心x的坐标
    public float y; //圆心y的坐标
    public Paint paint;
    public float width; //线条的宽度
    public int radius; //圆的半径
    public int randomNum; //随机数
    public int [] randomColor ={Color.BLUE,Color.CYAN,
            Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW};

    public Wave(float x,float y) {
        this.x = x;
        this.y = y;
        initData();
    }

    /**
     * 初始化数据,每次点击都要初始化一次
     */
    private void initData(){
        paint = new Paint(); //因为点击一次需要画出不同的圆环
        paint.setAntiAlias(true);
        randomNum = (int) (Math.random()*6);//[0,5]的随机数
        paint.setColor(randomColor[randomNum]);//设置画笔的颜色
        paint.setStyle(Paint.Style.STROKE);//描边
        paint.setStrokeWidth(width);//设置描边宽度
        paint.setAlpha(255);//透明度的设置(0-255),0为完全透明
        radius=0;//初始化
        width=0;
    }
}
