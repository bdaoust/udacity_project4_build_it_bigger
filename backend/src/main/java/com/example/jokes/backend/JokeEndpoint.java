/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.jokes.backend;

import com.example.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "funnyJokesApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokes.example.com",
                ownerName = "backend.jokes.example.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(
            name = "sayRandomJoke",
            httpMethod = ApiMethod.HttpMethod.GET)
    public JokeBean sayRandomJoke(){
        JokeBean response;
        JokeProvider jokeProvider;


        jokeProvider = new JokeProvider();
        response = new JokeBean();
        response.setData(jokeProvider.getRandomJoke());

        return response;
    }

}
