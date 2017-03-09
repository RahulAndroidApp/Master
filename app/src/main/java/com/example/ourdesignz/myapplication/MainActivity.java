package com.example.ourdesignz.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBrowserHist();


    }


    public void getBrowserHist() {
        String[] proj = new String[] { Browser.BookmarkColumns.TITLE, Browser.BookmarkColumns.URL };
        String sel = Browser.BookmarkColumns.BOOKMARK + " = 0"; // 0 = history, 1 = bookmark
        Cursor mCur = getContentResolver().query(Browser.BOOKMARKS_URI, proj, sel, null, null);
        Log.e("mCur","mCur"+mCur.getCount());
        mCur.moveToFirst();
        @SuppressWarnings("unused")
        String title = "";
        @SuppressWarnings("unused")
        String url = "";
        if (mCur.moveToFirst() && mCur.getCount() > 0) {
            boolean cont = true;
            while (mCur.isAfterLast() == false && cont) {
                title = mCur.getString(mCur.getColumnIndex(Browser.BookmarkColumns.TITLE));
                url = mCur.getString(mCur.getColumnIndex(Browser.BookmarkColumns.URL));
                // Do something with title and url
                mCur.moveToNext();
            }
        }
    }


}
