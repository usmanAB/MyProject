package com.example.usman.myproject.Service;

import com.example.usman.myproject.model.Client;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by usman on 25/11/2017.
 */

public interface HttpClients {
    @GET("/rest/client")
    List<Client> findAnonymToken();
}
