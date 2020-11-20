package de.cwansart.meecrowave.application;

import de.cwansart.meecrowave.domain.HelloRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("hello")
@ApplicationScoped
public class HelloResource {

    @Inject
    private HelloRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getHello() {
        return this.repository.getNames();
    }
}
