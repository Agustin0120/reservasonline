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
import reservasonline2.Habitaciones;

/**
 *
 * @author Usuario0307
 */
@Stateless
@Path("reservasonline2.habitaciones")
public class HabitacionesFacadeREST extends AbstractFacade<Habitaciones> {
    @PersistenceContext(unitName = "reservasonlinePU")
    private EntityManager em;

    public HabitacionesFacadeREST() {
        super(Habitaciones.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Habitaciones entity) {
        super.create(entity);
    }

    @PUT
    @Path("{IdHabitacion}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Habitaciones entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{IdHabitacion}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{IdHabitacion}")
    @Produces({"application/xml", "application/json"})
    public Habitaciones find(@PathParam("id") Integer id) {
        return super.find(id);
         
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Habitaciones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Habitaciones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
