package tw.com.chainsea.bruce_example;

import android.graphics.Bitmap;
import android.widget.ImageView;

import cn.hadcn.davinci.DaVinci;
import cn.hadcn.davinci.image.base.ImageEntity;
import tw.com.chainsea.bruce.BrucePicViewerActivity;
import tw.com.chainsea.bruce.util.ImageViewerFragment;

/**
 *
 * Created by chris on 28/11/2016.
 */

public class ExamplePicViewer extends BrucePicViewerActivity implements ImageViewerFragment.ImageLoadListener {

    @Override
    protected ImageViewerFragment.ImageLoadListener loadLibrary() {
        return this;
    }

    @Override
    public void loadImage(String url, ImageView view) {
        DaVinci.with(this).getImageLoader().load(url).into(view);
    }

    @Override
    public Bitmap fetchImage(String url) {
        ImageEntity entity = DaVinci.with(this).getImageLoader().getImage(url);
        return entity.getBitmap();
    }
}
