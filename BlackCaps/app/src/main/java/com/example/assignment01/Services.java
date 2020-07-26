package com.example.assignment01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Services extends Service {



    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intend,int flags, int startid){
       super.onStartCommand(intend,flags,startid);
        return START_NOT_STICKY;
}
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
