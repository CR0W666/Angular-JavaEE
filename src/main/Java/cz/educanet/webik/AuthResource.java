package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthResource {

    @Inject
    private AuthManager authManager;

    @GET
    public Response getLoggedUser() {

        if(authManager.userState())
            return  Response.ok(authManager.getLoggedUser()).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();


    }

    @POST
    public Response login(User user) {
        authManager.login(user);

        if (authManager.userState())
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }



}