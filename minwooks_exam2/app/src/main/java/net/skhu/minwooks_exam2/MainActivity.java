package net.skhu.minwooks_exam2;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Uri mImageCaptureUri;

    Button btnAdd;
    Button btnPlus;
    EditText editText;
    ListView listView;
    ImageView imageView;
    Bitmap selectBitmap;
    DEOpenHelper DB;
    private int PICK_FROM_ALBUM = 1;
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1)
            if(resultCode == RESULT_OK){
            try{
                InputStream in = getContentResolver().openInputStream(data.getData());
                selectBitmap = BitmapFactory.decodeStream(in);
                in.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText_title);
        btnAdd = findViewById(R.id.button_add);
        btnPlus = findViewById(R.id.button_plus);
        listView = findViewById(R.id.listView);
        DB=new DEOpenHelper(this);
        DB.open();



        final ListAdapter adapter = new ListAdapter(this);
        listView.setAdapter(adapter);

        for(int i=0;i<DB.getCount();i++)
        {
            adapter.add(BitmapFactory.decodeResource(getResources(), R.mipmap.profile), DB.findcontent(i));
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, qwe.class);
                intent.putExtra("name", adapter.getItem(position).getName());

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                adapter.getItem(position).getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText.getText().toString();
                if(title.equals("")){
                }
                else{
                    if(selectBitmap==null) {
                        adapter.add(BitmapFactory.decodeResource(getResources(), R.mipmap.profile), title);
                        adapter.notifyDataSetChanged();
                        DB.insert(title);
                    }
                    else{
                        adapter.add(selectBitmap, title);
                        adapter.notifyDataSetChanged();
                        DB.insert(title);
                    }
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_ALBUM);
                /*
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_ALBUM);
                mImageCaptureUri = intent.getData();
                intent.setDataAndType(mImageCaptureUri, "image/*");
                */

                /*
                String url = "tmp_" + String.valueOf(System.currentTimeMillis() + ".jpg");
                mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), uri));
                mImageCaptureUri = intent.getData();

                Uri uri = intent.getData();
                String[] projection = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                int columnIndex = cursor.getColumnIndex(projection[0]);
                String pricturePath = cursor.getString(columnIndex);
                cursor.close();

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select Picture"), PICK_IMAGE_REQUEST);
                */
            }
        });
    }
}
