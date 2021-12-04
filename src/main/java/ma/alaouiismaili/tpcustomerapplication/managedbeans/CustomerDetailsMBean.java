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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import ma.alaouiismaili.tpcustomerapplication.entities.Customer;
import ma.alaouiismaili.tpcustomerapplication.entities.DiscountCode;
import ma.alaouiismaili.tpcustomerapplication.session.CustomerManager;
import ma.alaouiismaili.tpcustomerapplication.session.DiscountCodeManager;
/**
 *
 * @author Osama
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class CustomerDetailsMBean implements Serializable {
    private int idCustomer;
    private Customer customer;
    
    @EJB
    private CustomerManager customerManager;
    @EJB
    private DiscountCodeManager discountCodeManager;
    /**
     * Creates a new instance of CustomerDetailsBean
     */
    public int getIdCustomer()
    {
        return idCustomer;
    }
    
    public List<DiscountCode> getDiscountCodes() {
        System.out.print("$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4");
        System.out.println(discountCodeManager.getAllDiscountCodes().get(1).getRate());
    return discountCodeManager.getAllDiscountCodes();
  }
    public void setIdCustomer(int idCustomer){
        this.idCustomer = idCustomer;
    }
    public Customer getDetials(){
//          System.out.print("$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4$$$$$$$$$$$$$$4");
//        System.out.println(customer);
        return customer;
        
    }
    public String update(){
        customer =customerManager.update(customer);
        return "CustomerList";
    }
    public void loadCustomer(){
        this.customer= customerManager.getCustomer(idCustomer);
                
    }
           public Converter<DiscountCode> getDiscountCodeConverter() {
    return new Converter<DiscountCode>() {
      /**
       * Convertit une String en DiscountCode.
       *
       * @param value valeur à convertir
       */
      @Override
      public DiscountCode getAsObject(FacesContext context, UIComponent component, String value) {
        return discountCodeManager.findById(value);
      }

      /**
       * Convertit un DiscountCode en String.
       *
       * @param value valeur à convertir
       */
      @Override
      public String getAsString(FacesContext context, UIComponent component, DiscountCode value) {
        return value.getDiscountCode();
      }
    };
  }
    
}
