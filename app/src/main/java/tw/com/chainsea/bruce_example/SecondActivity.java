package tw.com.chainsea.bruce_example;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import tw.com.chainsea.bruce.TitlebarActivity;

public class SecondActivity extends TitlebarActivity {

    @Override
    public Fragment addFragment() {
        enableLoading();
        return null;
    }

    @Override
    public View rightView() {
        TextView textView = new TextView(this);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        textView.setPadding(10, 0, 40, 0);
        textView.setText("停止loading");
        return textView;
    }

    @Override
    public void rightAction() {
        finishLoading(false, "没有数据");
    }
}
