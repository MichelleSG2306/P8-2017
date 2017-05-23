package com.example.rasmus.p8_master;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class AddNewCard extends AppCompatActivity {

    private String scannedBarcode;
    int blueOrGreenCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);
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

                    EditText showBarcode = (EditText) findViewById(R.id.barcodeInput);
                    showBarcode.setText(scannedBarcode, TextView.BufferType.EDITABLE);

                }
            }

        } else {

            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void saveCard (View v){
        EditText nameInput = (EditText)findViewById(R.id.nameInput);
        String nameOfCardInput = nameInput.getText().toString();

        EditText barcodeInput = (EditText) findViewById(R.id.barcodeInput);
        String barcode = barcodeInput.getText().toString();

        if(TextUtils.isEmpty(nameOfCardInput) || TextUtils.isEmpty(barcode))
        {

            TextView infoMissing = (TextView) findViewById(R.id.missingBarcodeName);
            infoMissing.setVisibility(View.VISIBLE);

        }

        else {

            blueOrGreenCard = R.drawable.othercardb;

            DBHelper dbHelper = new DBHelper(AddNewCard.this);
            dbHelper.insertCard(nameOfCardInput, blueOrGreenCard, barcode);
            Toast.makeText(AddNewCard.this, "Card added", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}


