/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasonline2.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import reservasonline2.Reservas;

/**
 *
 * @author Usuario0307
 */
@Stateless
@Path("reservasonline2.reservas")
public class ReservasFacadeREST extends AbstractFacade<Reservas> {
    @PersistenceContext(unitName = "reservasonlinePU")
    private EntityManager em;

    public ReservasFacadeREST() {
        super(Reservas.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Reservas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{IdReserva}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Reservas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{IdReserva}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{IdReserva}")
    @Produces({"application/xml", "application/json"})
    public Reservas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Reservas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Reservas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
