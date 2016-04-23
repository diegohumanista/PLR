package com.development.plr.plr;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;


public class ActivityLogin extends AppCompatActivity {
    //para JSON

    private static String url = "http://192.168.1.12/plrdal/Default.aspx";
    private static String nodes; //todo make static

    Button btnIngresar;
    TextView txtResult;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        txtResult = (TextView) findViewById(R.id.txtResult);


        HashMap<String, String> hsParametros = new HashMap<>();
        hsParametros.put("usuario", "ameba@gmail.com");
        hsParametros.put("password", "caca");
        hsParametros.put("accion", "login");
        new getResult().execute(hsParametros);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private class getResult extends AsyncTask<HashMap<String, String>, Void, Void> {

        ProgressDialog proDialog;

        @Override
        protected Void doInBackground(HashMap<String, String>... params) {
// Creating service handler class instance
            WebRequest webreq = new WebRequest();
// Making a request to url and getting response

            String jsonStr = webreq.makeWebServiceCall(url, WebRequest.GETRequest, params[0]);

            Log.d("Response: ", "> " + jsonStr);

            result = jsonStr;

            return null;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
// Showing progress loading dialog
            proDialog = new ProgressDialog(ActivityLogin.this);
            proDialog.setMessage("Please wait...");
            proDialog.setCancelable(false);
            proDialog.show();
        }


        protected Void doInBackground(Void... arg0) {
// Creating service handler class instance
            WebRequest webreq = new WebRequest();

// Making a request to url and getting response

            return null;
        }

        @Override
        protected void onPostExecute(Void requestresult) {
            super.onPostExecute(requestresult);
// Dismiss the progress dialog
            if (proDialog.isShowing()) {
                proDialog.dismiss();
            }
            if (result.isEmpty()) {
                txtResult.setText("no response received");
            }else txtResult.setText(result);
        }

    }
}


