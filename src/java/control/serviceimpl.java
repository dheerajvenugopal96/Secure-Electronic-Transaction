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
public class serviceimpl implements service {
    
    private dao sd;

    /**
     * @return the sd
     */
    public dao getSd() {
        return sd;
    }

    /**
     * @param sd the sd to set
     */
    public void setSd(dao sd) {
        this.sd = sd;
    }

    @Override
    public void insertcustomer(Customer c) {
        sd.insertcustomer(c);
    }

    @Override
    public Boolean checkusername(String username) {
        return sd.checkusername(username);
    }

    @Override
    public void insertmerchant(Merchant m) {
        sd.insertmerchant(m);
    }

    @Override
    public Boolean checkmerchantusername(String username) {
        return sd.checkmerchantusername(username);
    }

    @Override
    public void insertbank(Bank b) {
        sd.insertbank(b);
    }

    @Override
    public List checkcustomer(String email) {
        return sd.checkcustomer(email);
    }

    @Override
    public List checkmerchant(String email) {
       return sd.checkmerchant(email);
    }

    @Override
    public List checkbank(String email) {
       return sd.checkbank(email);
    }

    @Override
    public void insertproduct(product p) {
        sd.insertproduct(p);
    }

    @Override
    public List getcategory() {
        return sd.getcategory();
    }

    @Override
    public List getall() {
        return sd.getall(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getselected(String selectedcategory) {
        return sd.getselected(selectedcategory); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getproduct(int productid) {
        return sd.getproduct(productid);
    }

    @Override
    public List getMerchantdets(int merchantid) {
       return sd.getMerchantdets(merchantid);
    }

    @Override
    public List getcart(int customerid) {
        return sd.getcart(customerid);
    }

    @Override
    public void insertcart(cart c) {
        sd.insertcart(c);
    }

    @Override
    public long getcartcount(int id) {
        return sd.getcartcount(id);
    }

    @Override
    public String gettotal(int customerid) {
        return sd.gettotal(customerid);
    }

    @Override
    public void removecart(int productid, int customerid) {
        sd.removecart(productid,customerid);
    }

    @Override
    public List getbanks() {
        return sd.getbank();
    }

    @Override
    public void update(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        sd.update(bankcode,cardname,ac,expiry,cvvv,id);
    }

    @Override
    public List verify(String code) {
        return sd.verify(code);
    }

    @Override
    public void changebank(int cid) {
        sd.changebank(cid);
    }

    @Override
    public void cvstats(int cid) {
        sd.cvstats(cid);
    }

    @Override
    public void updatemerchant(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        sd.updatemerchant(bankcode,cardname,ac,expiry,cvvv,id);
    }

    @Override
    public String checkverification(int customerid) {
        return sd.checkverification(customerid);
    }

    @Override
    public List getcard(int cusid) {
        return sd.getcard(cusid);
    }

    @Override
    public void updatepay(int cusid) {
        sd.updatepay(cusid);
    }

    @Override
    public List getordersbyid(int cusid) {
        return sd.getordersbyid(cusid);
    }

    @Override
    public List verifymerchant(String code) {
        return sd.verifymerchant(code);
    }

    @Override
    public void changebankmer(int ciid) {
        sd.changebankmer(ciid);
    }

    @Override
    public List getbankdets(String bankcode) {
        return sd.getbankdets(bankcode);
    }

    @Override
    public List checkcardformer(int id) {
        return sd.checkcardformer(id);
    }

    @Override
    public List issuecertificatemerchant() {
        return sd.issuecertificatemerchant();
    }

    @Override
    public void changeproductmer(int ciid) {
        sd.changeproductmer(ciid);
    }

    @Override
    public void updatecustomer(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        sd.updatecustomer(bankcode,cardname,ac,expiry,cvvv,id);
    }

    @Override
    public List getcustomerbyid(int customerid) {
        return sd.getcustomerbyid(customerid);
    }

    @Override
    public List getpaid(String ifsc) {
        return sd.getpaid(ifsc);
    }

    @Override
    public List getfromcartbyid(int id) {
            
        return sd.getfromcartbyid(id);
    }

    
}
