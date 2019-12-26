package com.example.terserahh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import server.ConfigUrl;

public class MainActivity extends AppCompatActivity {
      private RequestQueue mRequestQueue;
      private TextView txtdata;
      private EditText edtNpm, edtNama, edtProdi, edtPassword;
      private Button btnKirim;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
  //        getSupportActionBar().hide();
//        mRequestQueue = Volley.newRequestQueue(this);
//
//        txtdata = (TextView) findViewById(R.id.txtdata);
//
//        edtNpm = (EditText) findViewById(R.id.edtNpm);
//        edtNama =(EditText) findViewById(R.id.edtNama);
//        edtProdi = (EditText) findViewById(R.id.edtProdi);
//        edtPassword = (EditText) findViewById(R.id.edtPassword);
//
//        btnKirim = (Button) findViewById(R.id.btnKirim);
//
//        btnKirim.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//            String strNpm = edtNpm.getText().toString();
//            String strNama = edtNama.getText().toString();
//            String strProdi = edtProdi.getText().toString();
//            String strPass = edtPassword.getText().toString();
//
//            if(strNpm.isEmpty()){
//              Toast.makeText(getApplicationContext(), "Npm tidak boleh kosong",
//                Toast.LENGTH_LONG).show();
//            } else if(strNama.isEmpty()) {
//              Toast.makeText(getApplicationContext(), "Nama tidak boleh kosong",
//                Toast.LENGTH_LONG).show();
//            } else  if(strProdi.isEmpty()) {
//              Toast.makeText(getApplicationContext(), "Prodi tidak boleh kosong",
//                Toast.LENGTH_LONG).show();
//            } else  if(strPass.isEmpty()) {
//              Toast.makeText(getApplicationContext(), "Password tidak boleh kosong",
//                Toast.LENGTH_LONG).show();
//            } else {
//              inputData(strNpm, strNama, strProdi, strPass);
//
//              Intent a = new Intent(MainActivity.this,MainActivity.class);
//              startActivity(a);
//              finish();
//            }
//            }
//});
//        fetchJsonResponse();
//    }
//
//    private void fetchJsonResponse() {
//        // Pass second argument as "null" for GET requests
//        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, ConfigUrl.getAllMhs, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            String result = response.getString("data");
//                            //Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//                            //Log.v("ini data dari server",result.toString());
//                            JSONArray res = new JSONArray(result);
//                            for ( int i = 0; i < res.length(); i++){
//                                JSONObject jObj = res.getJSONObject(i);
//                                txtdata.append("npm = "+ jObj.getString("npm") + "\n"+
//                                        "nama = " + jObj.getString("nama") + "\n\n");
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.e("Error: ", error.getMessage());
//            }
//        });
//
//        /* Add your Requests to the RequestQueue to execute */
//        mRequestQueue.add(req);
//    }
//    private void inputData(String npm, String nama, String Prodi, String Pass){
//// Post params to be sent to the server
//      HashMap<String, String> params = new HashMap<String, String>();
//      params.put("npm", npm);
//      params.put("nama", nama);
//      params.put("prodi", Prodi);
//      params.put("password", Pass);
//
//      JsonObjectRequest req = new JsonObjectRequest(ConfigUrl.inputDataMhs, new JSONObject(params),
//        new Response.Listener<JSONObject>() {
//          @Override
//          public void onResponse(JSONObject response) {
//            try {
//              VolleyLog.v("Response:%n %s", response.toString(4));
//            } catch (JSONException e) {
//              e.printStackTrace();
//            }
//          }
//        }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//          VolleyLog.e("Error: ", error.getMessage());
//        }
//      });
//
//// add the request object to the queue to be executed
//      //ApplicationController.getInstance().addToRequestQueue(req);
//      mRequestQueue.add(req);
//    }

}

