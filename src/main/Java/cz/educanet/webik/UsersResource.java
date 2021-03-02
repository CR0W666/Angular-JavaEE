package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager userManager;
    //@Inject
    //private LoggedManager loggedManager;


    @GET
    public Response getAllUserNames() {
        return Response.ok(userManager.getAllUserNames()).build();
    }

    @GET
    @Path("{id}")
    public Response getUserName(@PathParam("id") int id) {
        return  Response.ok(userManager.getUserName(id)).build();
    }

    @POST
    public Response createUser(User user){
        if(!userManager.createUser(user))
            return Response.status(400).build();

        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if(userManager.removeUserName(id)){
            return Response.ok("User deleted").build(); 
        } else { 
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
