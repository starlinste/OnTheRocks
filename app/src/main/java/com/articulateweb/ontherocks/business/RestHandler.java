package com.articulateweb.ontherocks.business;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.articulateweb.ontherocks.business.Objects.OBJHelpParent;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RestHandler {
    public static String baseurl = "http://ontherocks.articulateweb.net/api.php/records";
    private static final String[] _workingResponse = {""};

    public static OBJHelpParent getHelp() throws IOException {
        /*final OBJHelpParent[] returnableObject = {null};

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(baseurl + "/Help")
                .method("GET", null)
                .build();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Gson gson = new Gson();
                    Response response = client.newCall(request).execute();
                    JSONObject convertedBody = new JSONObject(response.body().string());

                    OBJHelpParent objHelpParent = gson.fromJson(convertedBody.toString(), OBJHelpParent.class);

                    if(objHelpParent.getRecords().size() > 0)
                        returnableObject[0] = objHelpParent;
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        //Can't actually return here yet because we're threading the REST call.
        //Need to implement an "OnThreadClosed" handler to return the value in question.
        return returnableObject[0];
         */

        return null;
    }

    public void GetHelpInfo(Context context, String endPoint) throws JSONException {
        GetJSONResponse(context, endPoint);

        while(_workingResponse[0] == "") { }

        Gson gson = new Gson();
        String response = _workingResponse[0];

        if(response == "ERROR")
            return;

        JSONObject convertedBody = new JSONObject(response);
        OBJHelpParent objHelpParent = gson.fromJson(convertedBody.toString(), OBJHelpParent.class);
    }

    private void GetJSONResponse(Context mainContext, String endpoint){
        RequestQueue queue = Volley.newRequestQueue(mainContext);
        String url = baseurl + "/" + endpoint;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                _workingResponse[0] = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                _workingResponse[0] = "ERROR | " + error.getMessage();
            }
        });

        queue.add(request);
    }

    
}