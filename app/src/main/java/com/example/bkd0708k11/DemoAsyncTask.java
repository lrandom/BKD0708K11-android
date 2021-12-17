package com.example.bkd0708k11;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DemoAsyncTask extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tvNotify;
    ImageView imgView;
    Button btnStartDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_async_task);
        progressBar = findViewById(R.id.progressBar);
        tvNotify = findViewById(R.id.tvNotify);
        imgView = findViewById(R.id.imageView);
        btnStartDownload = findViewById(R.id.btnStartDownload);
        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
            }
        });
    }

    void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                //đã đuwocj cấp
                //chạy lệnh
                new DownloadImageAsyncTask("https://dbk.vn/uploads/ckfinder/images/tranh-anh/Anh-thien-nhien-1.jpg").execute();
            }else{
                //chưa đc cấp
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2) {
            //đây là hồi đáp cho cái yêu cầu cấp quyền có mã là 2 (yêu cầu cấp quyèn ghi ở đĩa)
            if (grantResults.length>0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //chạy lệnh
                    new DownloadImageAsyncTask("https://dbk.vn/uploads/ckfinder/images/tranh-anh/Anh-thien-nhien-1.jpg").execute();
                }
            }
        }
    }

    public class DownloadImageAsyncTask extends AsyncTask<Void, Long, File> {
        String fileUrl;

        public DownloadImageAsyncTask(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected File doInBackground(Void... voids) {
            try {
                URL url = new URL(this.fileUrl);
                URLConnection urlConnection = url.openConnection();
                long totalFileSize = urlConnection.getContentLengthLong();
                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream fos = new FileOutputStream(
                        new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"anh_download.jpg")
                );
                int count = 0;
                int readingFileSize = 0;
                byte[] myBytes = new byte[1024 * 4];
                while ((count = inputStream.read(myBytes)) != -1) {
                    fos.write(myBytes,0, count);
                    readingFileSize += count;
                    long percent =  (readingFileSize/totalFileSize)*100;
                    publishProgress(percent);
                }
                return
                        new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"anh_download.jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        //CHẠY Ở MAIN THREAD
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvNotify.setText("Bắt đầu tải");
        }

        //CHẠY ƠẢ MAIN THREAD
        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            tvNotify.setText("Đã tải xong");
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            imgView.setImageBitmap(bitmap);

        }

        //CHẠY TRÊN MAIN THREAD
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }
    }
}
