/*
 * This example will read a barcode using the ZXing Barcode reader
 * which is available from the Android Play Store.
 */
package com.example.barcodereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class BarcodeReader extends Activity implements OnClickListener {
	
	private Button button;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	Intent intent = new Intent("com.google.zxing.client.android.SCAN");   
        intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast.makeText(this, contents, Toast.LENGTH_LONG).show();
                // Handle successful scan
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Handle cancel
            	Toast.makeText(this, "Scan Error", Toast.LENGTH_LONG).show();
            }
        }
    }
}