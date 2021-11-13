/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ma.alaouiismaili.tpcustomerapplication.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.alaouiismaili.tpcustomerapplication.entities.Customer;

/**
 *
 * @author Osama
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
private EntityManager em;

public void persist(Object customer) {
  em.persist(customer);
}
    public List<Customer> getAllCustomers(){
        Query query= em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    public Customer update (Customer customer)
    {
        
        return em.merge(customer);
    }
}
