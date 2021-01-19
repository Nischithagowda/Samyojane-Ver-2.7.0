package com.bhoomi.Samyojane_Application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Adarsh on 12-Jun-19.
 */

public class PDF_Viewer extends AppCompatActivity {

    Button btnBack;
    String document_Name;
    int document_ID;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    String applicant_name;
    String applicant_Id;
    byte[] bytes;
    String str;
    String mno;
    String filePath = "sdcard/Add_proof.pdf";
    File file;
    InputStream fileInputStream = null;
    OutputStream output = null;
    Uri uri;
    TextView tvDocumentName;


    PDFView pdfView;
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);

        btnBack = findViewById(R.id.btnBack);
        pdfView = findViewById(R.id.pdfView);
        tvDocumentName = findViewById(R.id.tvDocumentName);

        Intent i = getIntent();
        document_ID = Integer.parseInt(i.getStringExtra("document_ID"));
        document_Name = i.getStringExtra("document_Name");

        Log.d("document_ID", ""+document_ID);
        Log.d("document_Name",""+document_Name);
        tvDocumentName.setText(document_Name);

        openHelper = new DataBaseHelperClass_btnDownload_Docs(this);
        database = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from "+DataBaseHelperClass_btnDownload_Docs.TABLE_NAME+" where "+DataBaseHelperClass_btnDownload_Docs.UDT_Document_Id+"="+document_ID, null);
        if(cursor.getCount()>0){
            if (cursor.moveToNext()){
                bytes = cursor.getBlob(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_Docs.UDT_File));
                Log.d("Blob",""+ Arrays.toString(bytes));
            }
        } else {
            cursor.close();
        }
        byte[] pdfAsBytes = Base64.decode(bytes, 0);
        pdfView.fromBytes(pdfAsBytes).load();

        btnBack.setOnClickListener(v -> onBackPressed());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
