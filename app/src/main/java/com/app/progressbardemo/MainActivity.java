package com.app.progressbardemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.progressbardemo.utils.CatLoadingView;
import com.app.progressbardemo.utils.HorizontalProgressBarWithNumber;
import com.app.progressbardemo.utils.RoundProgressBarWidthNumber;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private HorizontalProgressBarWithNumber mProgressBar1;
    private HorizontalProgressBarWithNumber mProgressBar2;
    private RoundProgressBarWidthNumber mProgressBar3;
    private RoundProgressBarWidthNumber mProgressBar4;
    private static final int MSG_PROGRESS_UPDATE1 = 0x110;
    private static final int MSG_PROGRESS_UPDATE2 = 0x120;
    private static final int MSG_PROGRESS_UPDATE3 = 0x130;
    private static final int MSG_PROGRESS_UPDATE4 = 0x140;

    CatLoadingView mView;

    private Handler mHandler1 = new Handler() {
        // @Log
        public void handleMessage(android.os.Message msg) {

            int progress1 = mProgressBar1.getProgress();
            mProgressBar1.setProgress(++progress1);
            if (progress1 >= 100) {
                mHandler1.removeMessages(MSG_PROGRESS_UPDATE1);
            }
            mHandler1.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE1, 100);
        }

        ;
    };

    private Handler mHandler2 = new Handler() {
        // @Log
        public void handleMessage(android.os.Message msg) {

            int progress2 = mProgressBar2.getProgress();
            mProgressBar2.setProgress(++progress2);
            if (progress2 >= 100) {
                mHandler2.removeMessages(MSG_PROGRESS_UPDATE2);
            }
            mHandler2.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE2, 100);
        }

        ;
    };

    private Handler mHandler3 = new Handler() {
        // @Log
        public void handleMessage(android.os.Message msg) {

            int progress3 = mProgressBar3.getProgress();
            mProgressBar3.setProgress(++progress3);
            if (progress3 >= 100) {
                mHandler3.removeMessages(MSG_PROGRESS_UPDATE3);
            }
            mHandler3.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE3, 100);
        }

        ;
    };

    private Handler mHandler4 = new Handler() {
        // @Log
        public void handleMessage(android.os.Message msg) {

            int progress4 = mProgressBar4.getProgress();
            mProgressBar4.setProgress(++progress4);
            if (progress4 >= 100) {
                mHandler4.removeMessages(MSG_PROGRESS_UPDATE4);
            }
            mHandler4.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE4, 100);
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(toolbar);

        mView = new CatLoadingView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.show(getSupportFragmentManager(), "");
            }
        });

    }

    public void showDialog() {
        mView.show(getSupportFragmentManager(), "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                mProgressBar1 = (HorizontalProgressBarWithNumber) findViewById(R.id.id_progressbar01);
                mProgressBar1.setProgress(0);
                mHandler1.sendEmptyMessage(MSG_PROGRESS_UPDATE1);
                Toast.makeText(this, getResources().getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                mProgressBar2 = (HorizontalProgressBarWithNumber) findViewById(R.id.id_progressbar02);
                mProgressBar2.setProgress(0);
                mHandler2.sendEmptyMessage(MSG_PROGRESS_UPDATE2);
                Toast.makeText(this, getResources().getString(R.string.action_about), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                mProgressBar3 = (RoundProgressBarWidthNumber) findViewById(R.id.id_progress02);
                mProgressBar3.setProgress(0);
                mHandler3.sendEmptyMessage(MSG_PROGRESS_UPDATE3);
                Toast.makeText(this, getResources().getString(R.string.action_like), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_like:
                mProgressBar4 = (RoundProgressBarWidthNumber) findViewById(R.id.id_progress03);
                mProgressBar4.setProgress(0);
                mHandler4.sendEmptyMessage(MSG_PROGRESS_UPDATE4);
                Toast.makeText(this, getResources().getString(R.string.action_share), Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}