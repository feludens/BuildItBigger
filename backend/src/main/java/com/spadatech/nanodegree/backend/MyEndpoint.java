/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.spadatech.nanodegree.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.spadatech.nanodegree.jokes.JokeProvider;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.nanodegree.spadatech.com",
    ownerName = "backend.nanodegree.spadatech.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public MyBean getJoke(){
        JokeProvider provider = new JokeProvider();
        MyBean joke = new MyBean();
        joke.setData(provider.getJoke());

        return joke;
    }

}
