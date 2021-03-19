package com.example.codinginflow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {


    private static String URL_REGISTER = "http://192.168.1.126:8000/api/signup";
    private ProgressBar loading;


    EditText etname;
    EditText etemail;
    EditText etaddress;
    EditText etphone;
    EditText etpassword;
    EditText etretype;
    EditText etusername;

    Button btsignup;
    Button btcancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname = (EditText) findViewById(R.id.etname);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etretype = (EditText) findViewById(R.id.etretype);
        etusername = (EditText) findViewById(R.id.etusername);
        loading = findViewById(R.id.loading);

        btsignup = (Button) findViewById(R.id.btsignup);
        btcancel = (Button) findViewById(R.id.btcancel);


        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regist();
            }
        });

        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etname.setText("");
                etaddress.setText("");
                etemail.setText("");
                etphone.setText("");
                etpassword.setText("");
                etretype.setText("");
                etusername.setText("");

            }
        });


    }

    private void regist() {


        loading.setVisibility(View.VISIBLE);
        btsignup.setVisibility(View.GONE);
        final String name = etname.getText().toString();
        final String address = etaddress.getText().toString();
        final String email = etemail.getText().toString();
        final String phone = etphone.getText().toString();
        final String password = etpassword.getText().toString();
        final String retype = etretype.getText().toString();
        final String username = etusername.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");


                            if (success.equals("1")) {
                                Toast.makeText(SignupActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
                                loading.setVisibility(View.GONE);
                                btsignup.setVisibility(View.VISIBLE);

                            } else if (success.equals("0")) {
                                Toast.makeText(SignupActivity.this, "Username Taken!!", Toast.LENGTH_SHORT).show();
                                loading.setVisibility(View.GONE);
                                btsignup.setVisibility(View.VISIBLE);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(SignupActivity.this, "Error!! Exception" + e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btsignup.setVisibility(View.VISIBLE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignupActivity.this, "Unexpected error !!" + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btsignup.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("phone", phone);
                params.put("address", address);
                params.put("username", username);
                params.put("password", password);
                params.put("retype", retype);

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}