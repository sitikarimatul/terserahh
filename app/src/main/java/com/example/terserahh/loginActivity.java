package com.example.terserahh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import server.ConfigUrl;

public class loginActivity extends AppCompatActivity {
  private Button btnLinkRegister;
  private RequestQueue mRequestQueue;
  private EditText edtNpm, edtPassword;
  private Button btnMasuk;

  private ProgressDialog pDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    getSupportActionBar().hide();
    mRequestQueue = Volley.newRequestQueue(this);

    pDialog = new ProgressDialog(this);
    pDialog.setCancelable(false);


    edtNpm = (EditText) findViewById(R.id.edtNpm) ;
    edtPassword = (EditText) findViewById(R.id.edtPassword) ;


    btnMasuk = (Button) findViewById(R.id.btnMasuk);
    btnLinkRegister = (Button) findViewById(R.id.btnLinkRegister);
    btnLinkRegister.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(loginActivity.this,registrasiActivity.class);
        startActivity(i);
        finish();
      }
    });

      btnMasuk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          String strNpm = edtNpm.getText().toString();
          String strPass = edtPassword.getText().toString();

          if(strNpm.isEmpty()){
            Toast.makeText(getApplicationContext(), "Email tidak boleh kosong",
              Toast.LENGTH_LONG).show();

          } else  if(strPass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Password tidak boleh kosong",
              Toast.LENGTH_LONG).show();
          } else {
            login(strNpm, strPass);
          }
//        Intent i = new Intent(loginactivity.this, MainActivity.class);
//        startActivity(i);
//        finish();
        }
      });
  }
      private void login(String Npm, String Pass) {
        //final String URL = "/volley/resource/12";
        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("npm", Npm);
        params.put("password", Pass);

        pDialog.setMessage("Harap Bersabar ini ujian");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(ConfigUrl.login, new JSONObject(params),
          new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              hideDialog();
              try {
                boolean status = response.getBoolean("error");
                String msg;
                if (status == true) {
                  msg = response.getString("pesan");
                  Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else {
                  msg = response.getString("pesan");
                  Intent a;
                  a = new Intent(loginActivity.this, MainActivity.class);
                  startActivity(a);
                  finish();
                  Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }
                VolleyLog.v("Response:%n %s", response.toString(2));
              } catch (JSONException e) {
                e.printStackTrace();
              }
            }
          }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            hideDialog();
            VolleyLog.e("Error: ", error.getMessage());
          }
        });
// add the request object to the queue to be executed
//ApplicationController.getInstance().addToRequestQueue(req);
        mRequestQueue.add(req);
      }

      private void showDialog() {
        if (!pDialog.isShowing())
          pDialog.show();
      }
      private void hideDialog() {
        if (pDialog.isShowing())
          pDialog.dismiss();
  }
    }
