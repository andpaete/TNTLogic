/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.bean;

import co.edu.ucentral.modelo.Detallesolicitud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author paez
 */
@Stateless
public class DetallesolicitudFacade extends AbstractFacade<Detallesolicitud> {

    @PersistenceContext(unitName = "TntLogicJsFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallesolicitudFacade() {
        super(Detallesolicitud.class);
    }
    
}
