package com.example.rasmus.p8_master;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class AddNewCard extends AppCompatActivity {

    private String scannedBarcode;
    private int counter = 5;
    public boolean statusGreen = false;
    public boolean statusBlue = false;
    int blueOrGreenCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        final ToggleButton green = (ToggleButton)findViewById(R.id.green);
        final ToggleButton blue = (ToggleButton)findViewById(R.id.blue);
        final boolean notChecked = false;

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                blue.setChecked(notChecked);
                statusGreen = true;
                statusBlue = false;

            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                green.setChecked(notChecked);
                statusBlue = true;
                statusGreen = false;
            }
        });


    }

    public void scanBarcode(View v) {

        Intent intent = new Intent(this, ScanBarcodeActivity.class);
        startActivityForResult(intent, 0);

        this.requestCameraPermission();
    }

    public void requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},0);
            }

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    scannedBarcode = barcode.rawValue;

                    TextView showBarcode = (TextView) findViewById(R.id.showBarcode);
                    showBarcode.setText(scannedBarcode);

                }
            }

        } else {

            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void saveCard (View v){
        EditText nameInput = (EditText)findViewById(R.id.nameInput);
        String nameOfCardInput = nameInput.getText().toString();

        if(statusBlue = true){
            blueOrGreenCard = R.drawable.paint_bankcard;
        }

        if (statusGreen = true) {
            blueOrGreenCard = R.drawable.paint_rejsekort;
        }

        DBHelper dbHelper = new DBHelper(AddNewCard.this);
        dbHelper.insertCard(nameOfCardInput, blueOrGreenCard);

        MainActivity main = new MainActivity();
        main.updateListView();
    }

}
