package linegraph.y.p.summer.linegraphview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pengyan on 2017/7/27.
 */

public class LineGraphView extends View {

    private int XPoint = 30;//X坐标点
    private int YPoint = 520;//Y坐标点
    private int XScale = 100;//X轴间距
    private int YScale = 90;//Y轴间距
    private int XLength = 660;
    private int YLength = 370;

    public LineGraphView(Context context) {
        super(context);
    }

    public LineGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineGraphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true); //去锯齿
        paint.setColor(Color.parseColor("#38b2ff"));

        //画Y轴
        canvas.drawLine(XPoint, YPoint - YLength, XPoint, YPoint, paint);

        //画X轴
        canvas.drawLine(XPoint, YPoint, XPoint + XLength, YPoint, paint);

        String[] days = new String[6];
        for (int i = 0; i < days.length; i++) {
            days[i] = String.valueOf(25 + i);
        }
        //画折线的笔
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true); //去锯齿
        paint2.setColor(Color.parseColor("#38b2ff"));
        paint2.setAlpha(160);
        //描边的笔
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true); //去锯齿
        paint3.setColor(Color.parseColor("#38b2ff"));
        paint3.setStrokeWidth(4);
        //画远点的笔
        Paint paint4 = new Paint();
        paint4.setStrokeWidth(15);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint4.setColor(Color.parseColor("#38b2ff"));

        //画折线图
        Path path = new Path();
        path.moveTo(XPoint, YPoint);

        for (int i = 0; i < days.length; i++) {
            float pointy = (float) (YPoint - Math.random() * 400);
            path.lineTo(XPoint + (i + 1) * YScale, pointy);
            canvas.drawPoint(XPoint + (i + 1) * YScale, pointy, paint4);
        }
        path.lineTo(XPoint + XLength, YPoint);
        canvas.drawPath(path, paint2);
        canvas.drawPath(path, paint3);

        //画文字
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true); //去锯齿
        paint1.setColor(Color.parseColor("#ffffff"));
        paint1.setTextSize(30);
        for (int i = 0; i < days.length; i++) {
            canvas.drawText(days[i], XPoint + (i + 1) * YScale - 15, YPoint, paint1);//文字
        }
    }
}
