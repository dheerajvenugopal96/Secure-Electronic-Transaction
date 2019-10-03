/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;

/**
 *
 * @author acer
 */
public interface dao {
    
    public void insertcustomer(Customer c);
    public Boolean checkusername(String username);
    public void insertmerchant(Merchant m);
    public Boolean checkmerchantusername(String username);
    public void insertbank(Bank b);
     public List checkcustomer(String email);
    public List checkmerchant(String email);
    public List checkbank(String email);
    public void insertproduct(product p);
    public List getcategory();

    public List getall();

    public List getselected(String selectedcategory);

    public List getproduct(int productid);

    public List getMerchantdets(int merchantid);

    public List getcart(int customerid);

    public void insertcart(cart c);

    public long getcartcount(int id);

    public String gettotal(int customerid);

    public void removecart(int productid, int customerid);

    public List getbank();

    public void update(String bankcode, String cardname, String ac, String expiry, String cvvv, int id);

    public List verify(String code);

    public void changebank(int cid);

    public List getcart();

    public void cvstats(int cid);

    public void updatemerchant(String bankcode, String cardname, String ac, String expiry, String cvvv, int id);

    public String checkverification(int customerid);

    public List getcard(int cusid);

    public void updatepay(int cusid);

    public List getordersbyid(int cusid);

    public List verifymerchant(String code);

    public void changebankmer(int ciid);

    public List getbankdets(String bankcode);

    public List checkcardformer(int id);

    public List issuecertificatemerchant();

    public void changeproductmer(int ciid);

    public void updatecustomer(String bankcode, String cardname, String ac, String expiry, String cvvv, int id);

    public List getcustomerbyid(int customerid);

    public List getpaid(String ifsc);

    public List getfromcartbyid(int id);
    
}
