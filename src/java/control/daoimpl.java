/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author acer
 */
public class daoimpl implements dao {
    
    private HibernateTemplate hb;

    /**
     * @return the hb
     */
    public HibernateTemplate getHb() {
        return hb;
    }

    /**
     * @param hb the hb to set
     */
    public void setHb(HibernateTemplate hb) {
        this.hb = hb;
    }

    @Override
    public void insertcustomer(Customer c) {
        
        hb.save(c);
        
    }

    @Override
    public Boolean checkusername(String username) {
      List li=hb.find("from Customer c where c.username=?",username);
      if(li.isEmpty())
      {
          return false;
      }
      else
      {
          return true;
      }
        
    }

    @Override
    public void insertmerchant(Merchant m) {
        hb.save(m);
    }

    @Override
    public Boolean checkmerchantusername(String username) {
        List li=hb.find("from Merchant m where m.username=?",username);
        if(li.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void insertbank(Bank b) {
        hb.save(b);
    }

    @Override
    public List checkcustomer(String email) {
        List li=hb.find("from Customer c where c.email=?",email);
        return li;
    }

    @Override
    public List checkmerchant(String email) {
        List li=hb.find("from Merchant m where m.email=?",email);
        return li;
    }

    @Override
    public List checkbank(String email) {
        List li=hb.find("from Bank b where b.bemail=?",email);
        return li;
    }

    @Override
    public void insertproduct(product p) {
        hb.save(p);
    }

    @Override
    public List getcategory() {
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="select distinct(category) from product p";
        Query q=ses.createQuery(query);
        List li=q.list();
        return li;
    }

    @Override
    public List getall() {
        List li=hb.find("from product p where p.productverified='verified'");
        return li;
    }

    @Override
    public List getselected(String selectedcategory) {
        List li=hb.find("from product p where p.productverified='verified' and p.category=?",selectedcategory);
        return li;
    }

    @Override
    public List getproduct(int productid) {
        List li=hb.find("from product p where p.id=?",productid);
        return li;
    }

    @Override
    public List getMerchantdets(int merchantid) {
        List li=hb.find("from Merchant m where m.id=?",merchantid);
        return li;
    }

    @Override
    public List getcart(int customerid) {
        List li=hb.find("from cart c where c.orderstatus='na' and c.customerid=?",customerid);
        return li;
    }

    @Override
    public void insertcart(cart c) {
        hb.save(c);
    }

    @Override
    public long getcartcount(int id) {
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="select count(*) from cart c where c.customerid= :a and c.orderstatus='na'";
        Query q=ses.createQuery(query);
        q.setParameter("a", id);
        long count=(long) q.uniqueResult();
        return count;
    }

    @Override
    public String gettotal(int customerid) {
        SessionFactory sf=hb.getSessionFactory();
         Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="select sum(c.amount) from cart c where c.customerid= :a and c.orderstatus='na'";
        Query q=ses.createQuery(query);
        q.setParameter("a", customerid);
        String total=(String) q.uniqueResult();
        return total;
        
    }

    @Override
    public void removecart(int productid, int customerid) {
        
        SessionFactory sf=hb.getSessionFactory();
         Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="delete from cart c where c.productid= :a and c.customerid= :b";
        Query q=ses.createQuery(query);
        q.setParameter("a", productid);
        q.setParameter("b", customerid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public List getbank() {
        List li=hb.find("from Bank b");
        return li;
    }

    @Override
    public void update(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        
        SessionFactory sf=hb.getSessionFactory();
         Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Customer c set c.cbank= :a , c.cardname= :b , c.accountnumber= :c , c.expirydate= :d , c.cvv = :e where c.id= :f";
        Query q=ses.createQuery(query);
        q.setParameter("a", bankcode);
         q.setParameter("b", cardname);
          q.setParameter("c", ac);
           q.setParameter("d", expiry);
            q.setParameter("e", cvvv);
             q.setParameter("f", id);
             q.executeUpdate();
             t.commit();
             ses.close();
    }

    @Override
    public List verify(String code) {
        
        List li=hb.find("from Customer c where c.bankverified='na' and c.accountnumber!='na' and c.cbank=?",code);
        return li;
        
    }

    @Override
    public void changebank(int cid) {
         SessionFactory sf=hb.getSessionFactory();
         Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Customer c set c.bankverified='verified' where c.id= :a";
        Query q=ses.createQuery(query);
        q.setParameter("a", cid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public List getcart() {
        List li=hb.find("from Customer c where c.cvissued='na' and c.bankverified='verified'");
        return li;
    }

    @Override
    public void cvstats(int cid) {
        
         SessionFactory sf=hb.getSessionFactory();
         Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Merchant c set c.cerfissued='verified' where c.id= :a";
        Query q=ses.createQuery(query);
        q.setParameter("a", cid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public void updatemerchant(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        
       SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Merchant m set m.bname= :a , m.cardname= :b , m.accountnumber= :c , m.expirydate= :d , m.cvv = :e where m.id= :f";
        Query q=ses.createQuery(query);
        q.setParameter("a", bankcode);
         q.setParameter("b", cardname);
          q.setParameter("c", ac);
           q.setParameter("d", expiry);
            q.setParameter("e", cvvv);
             q.setParameter("f", id);
             q.executeUpdate();
             t.commit();
             ses.close();
        
    }

    @Override
    public String checkverification(int customerid) {
        
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="select c.bankverified from Customer c where c.id= :a";
        Query q=ses.createQuery(query);
        q.setParameter("a", customerid);
        String a=(String) q.uniqueResult();
        return a; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getcard(int cusid) {
       List li=hb.find("from Customer c where c.id=?",cusid);
       return li;
    }

    @Override
    public void updatepay(int cusid) {
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update cart c set c.orderstatus='paid' where c.customerid= :e";
        Query q=ses.createQuery(query);
        q.setParameter("e", cusid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public List getordersbyid(int cusid) {
        List li=hb.find("from cart c where c.orderstatus='paid' and c.customerid=?",cusid);
        return li;
    }

    @Override
    public List verifymerchant(String code) {
       List li=hb.find("from Merchant m where m.bankverified='na' and m.accountnumber!='na' and m.bname=?",code);
       return li;
    }

    @Override
    public void changebankmer(int ciid) {
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Merchant m set m.bankverified='verified' where m.id= :a";
        Query q=ses.createQuery(query);
        q.setParameter("a", ciid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public List getbankdets(String bankcode) {
       List li=hb.find("from Bank b where b.bcode=?",bankcode);
       return li;
    }

    @Override
    public List checkcardformer(int id) {
        List li=hb.find("from Merchant m where m.bname!='na' and m.id=?",id);
        return li;
    }

    @Override
    public List issuecertificatemerchant() {
       List li=hb.find("from Merchant m where m.cerfissued='na'");
       return li;
    }

    @Override
    public void changeproductmer(int ciid) {
        SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update product p set p.productverified='verified' where p.merchantid= :a";
        Query q=ses.createQuery(query);
        q.setParameter("a", ciid);
        q.executeUpdate();
        t.commit();
        ses.close();
    }

    @Override
    public void updatecustomer(String bankcode, String cardname, String ac, String expiry, String cvvv, int id) {
        
         SessionFactory sf=hb.getSessionFactory();
        Session ses=sf.openSession();
        Transaction t=ses.beginTransaction();
        String query="update Customer m set m.cbank= :a , m.cardname= :b , m.accountnumber= :c , m.expirydate= :d , m.cvv = :e where m.id= :f";
        Query q=ses.createQuery(query);
        q.setParameter("a", bankcode);
         q.setParameter("b", cardname);
          q.setParameter("c", ac);
           q.setParameter("d", expiry);
            q.setParameter("e", cvvv);
             q.setParameter("f", id);
             q.executeUpdate();
             t.commit();
             ses.close();
    }

    @Override
    public List getcustomerbyid(int customerid) {
        
        List li=hb.find("from Customer c where c.id=?",customerid);
        return li;
    }

    @Override
    public List getpaid(String ifsc) {
       List li=hb.find("from cart c where c.merbankcode=?",ifsc);
       return li;
    }

    @Override
    public List getfromcartbyid(int id) {
        
        List li=hb.find("from cart c where c.id=?",id);
        return li;
    }
    
}

