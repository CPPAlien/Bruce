package tw.com.chainsea.bruce_example;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;


import tw.com.chainsea.bruce.TitlebarActivity;

public class MainActivity extends TitlebarActivity {

    @Override
    public Fragment addFragment() {
        return new MainFragment();
    }

    @Override
    public View rightView() {
        TextView textView = new TextView(this);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        textView.setPadding(10, 0, 40, 0);
        textView.setText("跳");
        return textView;
    }

    @Override
    public void rightAction() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
