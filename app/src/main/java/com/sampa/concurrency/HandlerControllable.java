package com.sampa.concurrency;

import android.os.Handler;
import android.util.Log;

/**
 * Created by cclamb on 7/18/15.
 */
public final class HandlerControllable implements Controllable {

    private static int DELAY = 500;

    private Handler handler;
    private Worker worker;
    private boolean stop;

    private int count = 0;

    public HandlerControllable() {
        handler = new Handler();
        worker = new Worker();
    }

    @Override
    public void start() {
        handler.postDelayed(worker, DELAY);
    }

    @Override
    public void stop() {
        stop = true;
    }

    public int getCount() {
        return count;
    }

    final class Worker implements Runnable {

        @Override
        public void run() {
            if (!stop) {
                Log.d(Worker.class.toString(), "running: " + count++);
                handler.postDelayed(this, DELAY);
            }
        }
    }
}
