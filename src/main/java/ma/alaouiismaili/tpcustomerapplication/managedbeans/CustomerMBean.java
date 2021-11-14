/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.alaouiismaili.tpcustomerapplication.managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import ma.alaouiismaili.tpcustomerapplication.entities.Customer;
import ma.alaouiismaili.tpcustomerapplication.session.CustomerManager;

/**
 *
 * @author Osama
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
    private List<Customer> customerList;
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    public List<Customer> getCustomers(){
        if(customerList == null)
        {
            customerList= customerManager.getAllCustomers();
           
        }
        return customerList;
    }
}
