package com.example.bkd0708k11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;

public class DemoAsyncTaskLoader extends AppCompatActivity implements LoaderManager.LoaderCallbacks<File> {
    private LoaderManager loaderManager;
    ProgressBar progressBar;
    TextView tvNotify;
    ImageView imgView;
    Button btnStartDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_async_task_loader);
        loaderManager = LoaderManager.getInstance(this);
        Loader<File> loader = loaderManager.initLoader(1, null, this);
        imgView = findViewById(R.id.imageView);
        btnStartDownload = findViewById(R.id.btnStartDownload);
        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.forceLoad();
            }
        });
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int id, @Nullable Bundle args) {
        if (id == 1) {
            return new DownloadImageAsyncTaskLoader(DemoAsyncTaskLoader.this, "https://dbk.vn/uploads/ckfinder/images/tranh-anh/Anh-thien-nhien-3.jpg");
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, File data) {
        if (loader.getId() == 1) {
            //update giao diện
            imgView.setImageBitmap(BitmapFactory.decodeFile(data.getAbsolutePath()));
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
}