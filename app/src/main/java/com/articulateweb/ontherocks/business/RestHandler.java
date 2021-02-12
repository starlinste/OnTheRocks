package com.articulateweb.ontherocks.business;

import com.articulateweb.ontherocks.business.Objects.OBJHelp;
import com.articulateweb.ontherocks.business.Objects.OBJHelpParent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestHandler {
    public static String baseurl = "http://ontherocks.articulateweb.net/api.php/records";

    public static OBJHelpParent getHelp() throws IOException {
        final OBJHelpParent[] returnableObject = {null};

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
    }
}