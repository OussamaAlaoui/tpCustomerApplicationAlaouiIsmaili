/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.alaouiismaili.tpcustomerapplication.managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ma.alaouiismaili.tpcustomerapplication.entities.Customer;
import ma.alaouiismaili.tpcustomerapplication.entities.DiscountCode;
import ma.alaouiismaili.tpcustomerapplication.session.CustomerManager;
import ma.alaouiismaili.tpcustomerapplication.session.DiscountCodeManager;

/**
 *
 * @author Osama
 */
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable{
     private int idCustomer;
  private Customer customer;

  @EJB
  private CustomerManager customerManager;
  private DiscountCodeManager discountCodeManager;

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (celui dans l'attribut customer de
   * cette classe), qu'on appelle une propriété (property)
   */
    public Customer getDetails() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer.
    customer = customerManager.update(customer);
    return "CustomerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.getCustomer(idCustomer);
  }
    /**
   * Retourne la liste de tous les DiscountCode.
     * @return 
   */
  public List<DiscountCode> getDiscountCodes() {
     System.out.println(discountCodeManager.getAllDiscountCodes());
    return discountCodeManager.getAllDiscountCodes();
  }

  
}
