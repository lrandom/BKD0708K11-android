package com.example.bkd0708k11;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImageAsyncTaskLoader extends AsyncTaskLoader<File> {
    String fileUrl;
    public DownloadImageAsyncTaskLoader(@NonNull Context context, String fileUrl) {
        super(context);
        this.fileUrl = fileUrl;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public File loadInBackground() {
        try {
            URL url = new URL(this.fileUrl);
            URLConnection urlConnection = url.openConnection();
            long totalFileSize = urlConnection.getContentLengthLong();
            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream fos = new FileOutputStream(
                    new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"anh_download_2.jpg")
            );
            int count = 0;
            int readingFileSize = 0;
            byte[] myBytes = new byte[1024 * 4];
            while ((count = inputStream.read(myBytes)) != -1) {
                fos.write(myBytes,0, count);
                readingFileSize += count;
                long percent =  (readingFileSize/totalFileSize)*100;
            }
            return
                    new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"anh_download_2.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
