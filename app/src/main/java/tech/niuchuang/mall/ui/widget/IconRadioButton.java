package tech.niuchuang.mall.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import tech.niuchuang.mall.R;
import tech.niuchuang.xzlibrary.utils.Utility;


public class IconRadioButton extends RelativeLayout {
    private CharSequence iconText;
    private Drawable background;
    private int mButtonId;
    private int count;
    private boolean isShowRedpoint = false;
    private RadioButton mRadioButton;

    public IconRadioButton(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public IconRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.IconRadioButton);
        background = attributes.getDrawable(R.styleable.IconRadioButton_iconbBackground);
        iconText = attributes.getString(R.styleable.IconRadioButton_iconText);

        init();
    }

    public IconRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_iconradiobutton_layout, this);
        mRadioButton = (RadioButton) findViewById(R.id.btn_radiobutton);
        if (background != null) {
            mRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,
                    background,
                    null, null);
        }
        if (!TextUtils.isEmpty(iconText)) {
            mRadioButton.setText(iconText);
        }
    }

    public void setCount(int count) {
        this.count = count;
        isShowRedpoint = false;
        setWillNotDraw(false);
        invalidate();
    }

    public void setRedpoint(boolean isShow) {
        isShowRedpoint = isShow;
        count = 0;
        setWillNotDraw(false);
        invalidate();
    }



    /**
     * set check
     *
     * @param checked
     */
    public void setChecked(boolean checked) {
        this.mRadioButton.setChecked(checked);
    }

    /**
     * @param background
     */
    public void setButtonBackground(Drawable background) {
        this.background = background;
        if (this.background != null) {
            mRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,
                    background,
                    null, null);
        }
    }

    public void setIconText(CharSequence text) {
        this.iconText = text;
        if (!TextUtils.isEmpty(iconText)) {
            mRadioButton.setText(iconText);
        }
    }

    /**
     * @param id
     */
    public void setButtonId(int id) {
        mRadioButton.setId(id);
    }

    /**
     * @param listener
     */
    public void setButtonOnClickListener(OnClickListener listener) {
        if (listener == null)
            return;
        mRadioButton.setOnClickListener(listener);
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void draw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.draw(canvas);
        if (count > 0) {

            if (mRadioButton != null) {
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                // paint.setStrokeJoin(Paint.Join.ROUND);
                // paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setAntiAlias(true);
                float targetX = 0;
                float targetY = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    targetX = mRadioButton.getX() + mRadioButton.getWidth() / 2
                            + Utility.dip2px(getContext(), 18);
                    targetY = mRadioButton.getY()
                            + Utility.dip2px(getContext(), 20) / 2;
                } else {
                    targetX = mRadioButton.getLeft() + mRadioButton.getWidth()
                            / 2 + Utility.dip2px(getContext(), 18);
                    targetY = mRadioButton.getBottom()
                            + Utility.dip2px(getContext(), 20) / 2;
                }
                // canvas.translate(targetX, targetY);
                int radius = Utility.dip2px(getContext(), 7);

                if (count > 9) {
                    RectF rect = new RectF((int) (targetX - 1.5 * radius),
                            (int) (targetY - radius),
                            (int) (targetX + 1.5 * radius),
                            (int) (targetY + radius));
                    canvas.drawRoundRect(rect, radius, radius, paint);
                } else {
                    canvas.drawCircle(targetX, targetY, radius, paint);
                }
                canvas.save();
                Paint textpaint = new Paint();
                textpaint.setColor(Color.WHITE);
                textpaint.setTextSize(Utility.dip2px(getContext(), 12));
                textpaint.setAntiAlias(true);
                // canvas.drawText(String.valueOf(count),
                // targetX - Utility.dip2px(getContext(), 16) / 4, targetY
                // + Utility.dip2px(getContext(), 16) / 4,
                // textpaint);
                String text = String.valueOf(count);
                if (count > 99)
                    text = "99+";
                textpaint.setTextAlign(Align.CENTER);

                // FontMetrics fontMetrics = textpaint.getFontMetrics();
                canvas.drawText(
                        text,
                        targetX,
                        targetY
                                - (textpaint.getFontMetrics().top + textpaint
                                .getFontMetrics().bottom) / 2,
                        textpaint);
            }

        }
        if (isShowRedpoint) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setAntiAlias(true);
            float targetX = 0;
            float targetY = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                targetX = mRadioButton.getX() + mRadioButton.getWidth() / 2
                        + Utility.dip2px(getContext(), 10);
                targetY = mRadioButton.getY() + Utility.dip2px(getContext(), 8);
            } else {
                targetX = mRadioButton.getLeft() + mRadioButton.getWidth() / 2
                        + Utility.dip2px(getContext(), 10);
                targetY = mRadioButton.getBottom()
                        + Utility.dip2px(getContext(), 8);
            }
            // canvas.translate(targetX, targetY);
            canvas.drawCircle(targetX, targetY,
                    Utility.dip2px(getContext(), 8) / 2, paint);
        }

    }

}
