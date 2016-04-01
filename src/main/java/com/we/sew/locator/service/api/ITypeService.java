package com.we.sew.locator.service.api;

import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.service.Mapping;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Path(Mapping.TYPE)
@WebService
public interface ITypeService {
    @Path(Mapping.ALL)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Type> getAll();
}
