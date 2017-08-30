package com.example.user.maddiscovery;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Upload extends Activity implements View.OnClickListener{
  private static final int RESULT_LOAD_IMAGE =1;


   ImageView imageToUpload;
    Button bUploadUImage,bCreate;
    EditText uploadImageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

    imageToUpload = (ImageView)findViewById( R.id.imageToUpload );
    bUploadUImage = (Button) findViewById(R.id.btnUploadImage);
    uploadImageName = (EditText)findViewById(R.id.etUploadName);
    bCreate =  (Button)findViewById(R.id.btnCreate);

        imageToUpload.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         switch(v.getId()){
             case R.id.imageToUpload:
                 Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                 startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
                  break;

             case R.id.btnUploadImage:


                 break;

         }
    }

    public void btn_create(View view) {
        Intent intent = new Intent(Upload.this,Event_details.class);
        startActivity(intent);
    }
}






