package com.myfirst;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b = (Button) findViewById(R.id.bt1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView) findViewById(R.id.tv1);
                t.setText("hahaha new2");
                try {
                    MainActivity.this.Post();
                }
        catch(JSONException e ){
            Toast.makeText(getBaseContext(), "On click response exception:( ", Toast.LENGTH_LONG).show();

        }
            }
        });
    }

    public void Post() throws JSONException {
        //JSONObject params = new JSONObject();
  /*2
       Map<String, String> params = new HashMap<String, String>();
        params.put("teamname","hmm");
        params.put("entry1","10932");
        params.put("name1","Himanshu");
        params.put("entry2","10975");
        params.put("name2","panki");
        params.put("entry3","10922");
        params.put("name3", "Ashu");
2*/
        //System.out.println(params.toString());
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        String URL = "http://agni.iitd.ernet.in/cop290/assign0/register/";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest jsObjRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String  response) {
                        System.out.println(response);
                        pDialog.hide();
    //                    try {
                           // String rs = response.getString("RESPONSE_MESSAGE");
                            //int is = response.getInt("RESPONSE_SUCCESS");
                            Toast.makeText(getBaseContext(), "On succesfull response:( " + response, Toast.LENGTH_LONG).show();

  //                      }
                        //catch(StringRequest e ){
                          //  Toast.makeText(getBaseContext(), "On empty response:(", Toast.LENGTH_LONG).show();

//                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String s = error.toString();
                        System.out.println(s);
                        pDialog.hide();
                        Toast.makeText(getBaseContext(), "On error response:( "+ s, Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("teamname","hmm");
                params.put("entry1","10932");
                params.put("name1","Himanshu");
                params.put("entry2","10975");
                params.put("name2","panki");
                params.put("entry3","10922");
                params.put("name3", "Ashu");

//                params.put("name", "Androidhive");
  //              params.put("email", "abc@androidhive.info");
    //            params.put("password", "password123");

                return params;
            }

            @Override
            public RetryPolicy getRetryPolicy() {
                setRetryPolicy(new DefaultRetryPolicy(5000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            return super.getRetryPolicy();
            }
        };
        queue.add(jsObjRequest);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
