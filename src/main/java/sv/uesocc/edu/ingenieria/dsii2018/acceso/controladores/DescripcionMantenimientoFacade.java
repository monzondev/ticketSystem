/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.ingenieria.dsii2018.acceso.controladores;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.uesocc.edu.ingenieria.dsii2018.acceso.definiciones.DescripcionMantenimiento;

/**
 *
 * @author katiro
 */
@Stateless
public class DescripcionMantenimientoFacade extends AbstractFacade<DescripcionMantenimiento> implements DescripcionMantenimientoFacadeLocal {

    @PersistenceContext(unitName = "ticketPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescripcionMantenimientoFacade() {
        super(DescripcionMantenimiento.class);
    }

    @Override
    public List<DescripcionMantenimiento> findByCorrelativo(int Correlativo) {
        return null;
    }

}
