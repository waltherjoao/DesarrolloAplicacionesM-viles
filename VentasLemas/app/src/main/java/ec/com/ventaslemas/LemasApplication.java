package ec.com.ventaslemas;

import android.app.Application;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png
//https://es.acervolima.com/como-utilizar-la-biblioteca-universal-image-loader-en-android/
public class LemasApplication extends Application {

    private Retrofit restAdapter;
    private static LemasApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        restAdapter = retrofitLemas();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisc(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(options)
                .threadPoolSize(4)
                .discCacheSize(10 * 1024 * 1024)
                .build();
        ImageLoader.getInstance().init(config);
    }

    private Retrofit retrofitLemas() {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(getString(R.string.server_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return client;
    }

    public Retrofit getRestAdapter() {
        return restAdapter;
    }

    public static LemasApplication getmInstance() { return mInstance; }
}
