package tw.com.chainsea.bruce;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import tw.com.chainsea.bruce.FullScreenActivity;
import tw.com.chainsea.bruce.R;
import tw.com.chainsea.bruce.base.BruceConstant;
import tw.com.chainsea.bruce.util.ImageViewerFragment;


/**
 * ImageViewerActivity
 * Created by 90Chris on 2014/11/18.
 */
public abstract class BrucePicViewerActivity extends FullScreenActivity {
    ImageViewerFragment mFragment = null;

    @Override
    public void init() {
        super.init();
        overridePendingTransition(R.anim.bruce_zoom_enter, R.anim.bruce_fade_out);
    }

    @Override
    public Fragment addFragment() {
        return mFragment;
    }

    @Override
    public void onActivityCreate() {
        super.onActivityCreate();
        ArrayList<String> urlList = getIntent().getStringArrayListExtra(BruceConstant.INTENT_IMAGE_URLS);
        mFragment = ImageViewerFragment.newInstance(urlList, 0);
        mFragment.setListener(loadLibrary());
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.bruce_fade_in, R.anim.bruce_zoom_exit);
    }

    protected abstract ImageViewerFragment.ImageLoadListener loadLibrary();
}
