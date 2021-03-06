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
import javax.persistence.Query;
import sv.uesocc.edu.ingenieria.dsii2018.acceso.definiciones.Directorio;

/**
 *
 * @author katiro
 */
@Stateless
public class DirectorioFacade extends AbstractFacade<Directorio> implements DirectorioFacadeLocal {

    @PersistenceContext(unitName = "ticketPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DirectorioFacade() {
        super(Directorio.class);
    }

    @Override
    public Directorio FindByEmail(String correo, String contrasenia) {
        Directorio Respuesta = null;
        try {
            Query consulta = em.createNamedQuery("Directorio.findByCorreo");
            consulta.setParameter("correo", correo);
            List<Directorio> directorio = consulta.getResultList();
            if (directorio.get(0).getContrasenia().equals(contrasenia)) {
                Respuesta = directorio.get(0);
            }

        } catch (Exception e) {
            throw e;
        } finally {
        }
        return Respuesta;
    }

    @Override
    public List<Directorio> findByTecFree() {
        return null;
    }

    @Override
    public Directorio autenticar(Directorio usuario) {
        Directorio user= null;
        try{
           Query query=em.createNamedQuery("Directorio.autenticarse");
           query.setParameter("usuario", usuario.getUsuario());
           query.setParameter("contrasenia", usuario.getContrasenia());
           
           List<Directorio> lista = query.getResultList();
           if(!lista.isEmpty()){
               user=lista.get(0);
           }
        }catch(Exception ex){
            throw ex;
        }
        return user;
    }
}
