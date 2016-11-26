package tw.com.chainsea.bruce.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import tw.com.chainsea.bruce.R;


/**
 * Toast, 魅族和小米有些机型阻止原生Toast功能
 * Created by chris on 22/11/2016.
 */
public class BruceToast {
    private Context mContext;
    private WindowManager wm;
    private int mDuration;
    private View mNextView;
    public static final int LENGTH_SHORT = 1500;
    public static final int LENGTH_LONG = 3000;

    public BruceToast(Context context) {
        mContext = context.getApplicationContext();
    }

    public static BruceToast makeText(Context context, CharSequence text, boolean isSuccess, int duration) {
        BruceToast result = new BruceToast(context);
        View v = LayoutInflater.from(context).inflate(R.layout.bruce_toast, null);
        TextView tv = (TextView) v.findViewById(R.id.bruce_toast_content);
        tv.setText(text);
        Drawable icon;
        if ( isSuccess ) {
            icon = ContextCompat.getDrawable(context, R.drawable.bruce_correct);
        } else {
            icon = ContextCompat.getDrawable(context, R.drawable.bruce_wrong);
        }
        tv.setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
        result.mNextView = v;
        result.mDuration = duration;
        return result;
    }

    public static BruceToast makeText(Context context, int resId, boolean isSuccess, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), isSuccess, duration);
    }

    public void show() {
        if (mNextView != null) {
            wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            WindowManager.LayoutParams params = new WindowManager.LayoutParams();
            params.gravity = Gravity.CENTER;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
            params.format = PixelFormat.TRANSLUCENT;
            params.windowAnimations = R.style.BruceToast;
            //params.y = dip2px(mContext, 64);
            params.type = WindowManager.LayoutParams.TYPE_TOAST;
            wm.addView(mNextView, params);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (mNextView != null) {
                        //每次显示完后，remove调view
                        wm.removeView(mNextView);
                        mNextView = null;
                        wm = null;
                    }
                }
            }, mDuration);
        }
    }

    private static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
