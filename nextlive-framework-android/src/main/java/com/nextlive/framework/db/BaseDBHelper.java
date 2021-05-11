package com.nextlive.framework.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.nextlive.framework.global.BaseApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BaseDBHelper extends SQLiteOpenHelper {

    public BaseDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        if (!checkDBExist(name)) {
            try {
                copyDB(name, version);
            } catch (Exception ex) {}
        }
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {}

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {}
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            onSaveDBBackup(db);
            db.close();
            delete(getDatabaseName());
            copyDB(getDatabaseName(), newVersion);
        } catch (Exception ex) {}
    }

    public void onSaveDBBackup(SQLiteDatabase db) {}

    public void delete(String dbName)
    {
        try {
            new File(String.format("%s", BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath())).delete();
        } catch (Exception ex) {}
        try {
            new File(String.format("%sshm", BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath())).delete();
        } catch (Exception ex) {}
        try {
            new File(String.format("%swal", BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath())).delete();
        } catch (Exception ex) {}
        try {
            new File(String.format("%s-jourmal", BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath())).delete();
        } catch (Exception ex) {}

    }

    public void copyDB(String dbName, int version) throws IOException
    {
        InputStream mInput = BaseApp.getInstance().getAssets().open(String.format("%s_%d", dbName, version));
        String outFileName = BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath();
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[2024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    private boolean checkDBExist(String dbName) {
        boolean result = false;
        try {
            File dbfile = new File(BaseApp.getInstance().getDatabasePath(dbName).getAbsolutePath());
            result = dbfile.exists();
        } catch(Exception e) {

        }
        return result;
    }
}
