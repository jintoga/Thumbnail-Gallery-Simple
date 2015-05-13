package com.example.dat.gallerytest;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    Bundle myBackupBundle;
    private ArrayList<ImageItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_main);
        getID();
        setEvent();
    }

    private void getID() {
        gridView = (GridView) findViewById(R.id.gridView);

    }

    private void setEvent() {
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ImageItem item = (ImageItem) adapterView.getItemAtPosition(position);
                showOneItem(item);
            }
        });

    }

    private void showOneItem(ImageItem item) {
        setContentView(R.layout.one_item_layout);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        TextView textViewSolo = (TextView) findViewById(R.id.textViewSolo);
        ImageView imageViewSolo = (ImageView) findViewById(R.id.imgSolo);


        imageViewSolo.setImageResource(item.getImageID());
        textViewSolo.setText(item.getTitle());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreate(myBackupBundle);
            }
        });
    }

    // Prepare some dummy data for gridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1)); // fuck bitmap, lag as fuck
            imageItems.add(new ImageItem(imgs.getResourceId(i, -1), "Image#" + i));
        }
        return imageItems;
    }


}
