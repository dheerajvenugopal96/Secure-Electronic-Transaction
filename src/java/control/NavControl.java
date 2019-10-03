/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author acer
 */
@Controller
public class NavControl {
    
    @Autowired service se;
    
    @RequestMapping(value="home.html",method=RequestMethod.GET)
    
    public String gethome(HttpSession ses,ModelMap m)
    {
        if(ses.getAttribute("idd")!=null && ses.getAttribute("actype").equals("customer"))
        {
            int id=(int) ses.getAttribute("idd");
            System.out.println(id);
            long c=se.getcartcount(id);
            m.put("cnt",c);
        }
        else
        {
            
        }
        List li=se.getcategory();
        m.put("list",li);
        return "home";
    }
    
    @RequestMapping(value="registration.html",method=RequestMethod.GET)
    
    public String getRegister()
    {
        return "registration";
    }
    
    @RequestMapping(value="regcus.html")
    
    public String registerCustomer(@RequestParam String username,@RequestParam String name,@RequestParam String email,@RequestParam String address,@RequestParam String state,@RequestParam String phone,@RequestParam String pass) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        Customer c=new Customer();
        c.setUsername(username);
        c.setName(name);
        c.setEmail(email);
        c.setAddress(address);
        c.setState(state);
        c.setPhone(phone);
        c.setPass(pass);
         KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            kpg.initialize(512,random); // You can set a different value here
              
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey prk = kp.getPrivate();
            PublicKey puk = kp.getPublic();
            
            Base64.Encoder enc = Base64.getEncoder();
            
            c.setPrivatekey(enc.encodeToString(prk.getEncoded()));
            c.setPublickey(enc.encodeToString(puk.getEncoded()));
            
            c.setCbank("na");
            c.setCardname("na");
            c.setAccountnumber("na");
            c.setExpirydate("na");
            c.setCvv("na");
            c.setBankverified("na");
        se.insertcustomer(c);
        
        return "home";
    }
    
    @RequestMapping(value="ajaxusername.html")
    @ResponseBody
    public String isusername(@RequestParam String username)
    {
        if(se.checkusername(username))
        {
            return "Username Already Taken";
        }
        else
        {
            return "Username Available";
        }
              
        
    }
    
    @RequestMapping(value="regmer.html")
    public String registerMerchant(@RequestParam String musername,@RequestParam String mname,@RequestParam String memail,@RequestParam String maddress,@RequestParam String mstate,@RequestParam String mphone,@RequestParam String mpassword) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        Merchant m=new Merchant();
        m.setUsername(musername);
        m.setName(mname);
        m.setEmail(memail);
        m.setAddress(maddress);
        m.setState(mstate);
        m.setPhone(mphone);
        m.setPass(mpassword);
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            kpg.initialize(512,random); // You can set a different value here
              
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey prk = kp.getPrivate();
            PublicKey puk = kp.getPublic();
            
            Base64.Encoder enc = Base64.getEncoder();
            
            m.setPrivatekey(enc.encodeToString(prk.getEncoded()));
            m.setPublickey(enc.encodeToString(puk.getEncoded()));
            m.setBname("na");
            m.setCardname("na");
            m.setAccountnumber("na");
            m.setExpirydate("na");
            m.setCvv("na");
            m.setBankverified("na");
            m.setCerfissued("na");
        se.insertmerchant(m);
        return "home";
    }
    
    @RequestMapping(value="majaxusername.html")
    @ResponseBody
    public String ismerchant(@RequestParam String username)
    {
        if(se.checkmerchantusername(username))
        {
            return "Username Already Taken";
        }
        else
        {
            return "Username Available";
        }
        
    }
    
    @RequestMapping(value="regbank.html")
    public String insertbank(@RequestParam String bname,@RequestParam String bemail,@RequestParam String bcode,@RequestParam String branch,@RequestParam String bstate,@RequestParam String bphone,@RequestParam String bpassword) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        Bank b=new Bank();
        b.setBname(bname);
        b.setBemail(bemail);
        b.setBcode(bcode);
        b.setBranch(branch);
        b.setBphone(bphone);
        b.setBstate(bstate);
        b.setBpassword(bpassword);
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            kpg.initialize(512,random); // You can set a different value here
              
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey prk = kp.getPrivate();
            PublicKey puk = kp.getPublic();
            
            Base64.Encoder enc = Base64.getEncoder();
            
            b.setPrivatekey(enc.encodeToString(prk.getEncoded()));
            b.setPublickey(enc.encodeToString(puk.getEncoded()));
            
        se.insertbank(b);
        return "home";
    }
    
    @RequestMapping(value="login.html")
    public String getlogin(@RequestParam String Email,@RequestParam String Password,ModelMap m,HttpSession ses)
    {
        List li=se.checkcustomer(Email);
        List lm=se.checkmerchant(Email);
        List lb=se.checkbank(Email);
        if(Email.equals("admin")&&Password.equals("admin"))
        {
            return "redirect:admin.html";
        }
        
        else if(li.isEmpty()&&lm.isEmpty()&&lb.isEmpty())
        {
            m.put("msg", "no");
            
        }
        else if(!li.isEmpty())
        {
            System.out.println("Enters customer");
            Iterator it=li.iterator();
            while(it.hasNext())
            {
                Customer c=(Customer) it.next();
                String em=c.getEmail();
                String pass=c.getPass();
                if(em.equals(Email)&&pass.equals(Password))
                {
                    ses.setAttribute("idd", c.getId());
                    ses.setAttribute("user", c.getUsername());
                    ses.setAttribute("name", c.getName());
                    ses.setAttribute("actype", "customer");
                    return "redirect:home.html";
                }
                else
                {
                    m.put("msg", "no");
                    
                    
                }
            }
            
        }
        else if(!lm.isEmpty())
        {
            
            Iterator it=lm.iterator();
            while(it.hasNext())
            {
                Merchant me=(Merchant) it.next();
                String em=me.getEmail();
                String pass=me.getPass();
                if(em.equals(Email)&&pass.equals(Password))
                {
                    if((me.getCerfissued().equals("verified")))
                    {
                    ses.setAttribute("idd", me.getId());
                    ses.setAttribute("user", me.getUsername());
                    ses.setAttribute("name", me.getName());
                    ses.setAttribute("actype", "merchant");
                     return "redirect:home.html";
                    }
                    else
                    {
                        m.put("msgmer", "no");
                    }
                   
                }
                else
                {
                    m.put("msg", "no");
                    
                    
                }
            }
            
        }
        else if(!lb.isEmpty())
        {
            
                Iterator it=lb.iterator();
            while(it.hasNext())
            {
                Bank b=(Bank) it.next();
                String em=b.getBemail();
                String pass=b.getBpassword();
                if(em.equals(Email)&&pass.equals(Password))
                {
                    ses.setAttribute("idd", b.getId());
                    ses.setAttribute("user", b.getBcode());
                    ses.setAttribute("name", b.getBname());
                    ses.setAttribute("ifsc", b.getBcode());
                    ses.setAttribute("actype", "bank");
                    return "redirect:home.html";
                }
                else
                {
                    m.put("msg", "no");
                    
                    
                }
            }
            
        }
        
        return "home";
    }
    @RequestMapping(value="logout.html",method=RequestMethod.GET)
    public String getLogout()
            {
                return "logout";
            }
    @RequestMapping(value="customer.html",method=RequestMethod.GET)
    public String getCustomer()
    {
        return "customer";
    }
    @RequestMapping(value="merchant.html",method=RequestMethod.GET)
    public String getMerchant()
    {
        return "merchant";
    }
    @RequestMapping(value="addproduct.html",method=RequestMethod.GET)
    
    public String getAddProduct(HttpSession ses,ModelMap m)
    {
        int id=(int) ses.getAttribute("idd");
        List li=se.checkcardformer(id);
        if(li.isEmpty())
        {
            m.put("msg", "no");
        }
        return "addproduct";
    }
    
    @RequestMapping(value="insertproduct.html")
    
    public String insertProduct(@RequestParam String merid,@RequestParam("file") CommonsMultipartFile file,@RequestParam String cat,@RequestParam String brand,@RequestParam String product,@RequestParam String description,@RequestParam String price,@RequestParam String quantity) throws IOException
    {
        product p=new product();
        p.setMerchantid(Integer.parseInt(merid));
        //String filepath="C:\\Users\\acer\\Documents\\SEP\\products\\";
        String filepath="C:\\Users\\Dheeru\\Desktop\\prgming\\SEP\\products\\";
        String filename=file.getOriginalFilename();
        String path=filepath+filename;
        p.setImagepath(path);
        byte[] bytes=file.getBytes();
        Path pa=Paths.get(path);
        Files.write(pa, bytes);
        p.setCategory(cat);
        p.setBrand(brand);
        p.setProductName(product);
        p.setDescription(description);
        p.setAmount(price);
        p.setQuantity(quantity);
        List li=se.getMerchantdets(Integer.parseInt(merid));
        Iterator it=li.iterator();
        while(it.hasNext())
        {
            Merchant m=(Merchant) it.next();
            if(m.getBankverified().equals("verified"))
        {
            p.setProductverified("verified");
        }
        else
        {
        p.setProductverified("na");
        }
        }
        
        se.insertproduct(p);
        
        
        return "addproduct";
    }
    
    @RequestMapping(value="selected.html")
    public String getselected(@RequestParam String selectedcategory,ModelMap m,HttpSession ses)
    {
        if(ses.getAttribute("idd")!=null)
        {
            int id=(int) ses.getAttribute("idd");
            System.out.println(id);
            long c=se.getcartcount(id);
            m.put("cnt",c);
        }
        List li2=se.getcategory();
        m.put("a", selectedcategory);
        m.put("list",li2);
        
        if(selectedcategory.equals("All Categories"))
        {
            List li=se.getall();
            m.put("selectedlist",li);
        }
        else
        {
            List li=se.getselected(selectedcategory);
            m.put("selectedlist", li);
        }
        return "home";
    }
    
    @RequestMapping(value="viewproduct.html",method=RequestMethod.GET)
    public String viewproduct(@RequestParam int productid,ModelMap m)
    {
        int merchantid=0;
        List li=se.getproduct(productid);
        Iterator it=li.iterator();
        while(it.hasNext())
        {
            product p=(product) it.next();
            merchantid=p.getMerchantid();
            
        }
        List li2=se.getMerchantdets(merchantid);
        m.put("list", li);
        m.put("listmer", li2);
        return "viewproduct";
    }
    
    @RequestMapping(value="gotocart.html",method=RequestMethod.GET)
    
    public String getCart(@RequestParam int customerid,ModelMap m)
    {
        
            long c=se.getcartcount(customerid);
            m.put("cnt",c);
            String sum=se.gettotal(customerid);
            m.put("total",sum);
        
        List li=se.getcart(customerid);
        m.put("list", li);
        String verified=se.checkverification(customerid);
        System.out.println(verified);
        if(verified.equals("na"))
        {
            System.out.println("NOT OK");
            m.put("msg", "na");
        }
        else{
             System.out.println("OK");
        }
        return "gotocart";
    }
    
    @RequestMapping(value="addtocart.html")
    public String addCart(@RequestParam int customerid,@RequestParam int merchantid,@RequestParam int productid,@RequestParam String imagepath,@RequestParam String productname,@RequestParam String sellername,@RequestParam String amount) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        cart c =new cart();
        c.setCustomerid(customerid);
        c.setMerchantid(merchantid);
        c.setProductid(productid);
        c.setImagepath(imagepath);
        c.setProductName(productname);
        c.setSeller(sellername);
        c.setAmount(amount);
        List li=se.getMerchantdets(merchantid);
        Iterator it=li.iterator();
        String merbankcode="";
        String mpublickey="";
        String bpublickey="";
        while(it.hasNext())
        {
            Merchant m=(Merchant) it.next();
            merbankcode=m.getBname();
            mpublickey=m.getPublickey();
        }
        c.setMerbankcode(merbankcode);
        c.setOrderstatus("na");
        String oi=customerid+"_"+productname+"_"+productid;
        c.setOi(oi);
        MessageDigest mDigest=MessageDigest.getInstance("SHA1");
        byte[] result=mDigest.digest(oi.getBytes());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<result.length;i++)
        {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100 , 16 ).substring(1));
        }
        String oimd=sb.toString();
        c.setOimd(sb.toString());
        String accnum="";
        List li2=se.getcustomerbyid(customerid);
        Iterator it2=li2.iterator();
        while(it2.hasNext())
        {
            Customer cd =(Customer) it2.next();
            accnum=cd.getAccountnumber();
            
        }
        String pi=customerid+"_"+accnum+"_"+amount;
        String pimd=calcpimd(pi);
        c.setPi(pi);
        c.setPimd(pimd);
        
        
        List li3=se.getbankdets(merbankcode);
        Iterator it3=li3.iterator();
        while(it3.hasNext())
        {
            Bank b=(Bank) it3.next();
            bpublickey=b.getPublickey();
        }
        
        
        String combine=oimd+pimd;
        String pomd=calcpimd(combine);
        
        c.setPomd(pomd);
        
        String dualsignaturebank=ds(bpublickey,pomd);
        c.setDualsignature(dualsignaturebank);
        
        String dualsignaturemerchant=ds(mpublickey,pomd);
        c.setDsm(dualsignaturemerchant);
        
        se.insertcart(c);
        return "redirect:home.html";
    }
    
    public String calcpimd(String pi) throws NoSuchAlgorithmException
    {
          MessageDigest mDigest=MessageDigest.getInstance("SHA1");
        byte[] result=mDigest.digest(pi.getBytes());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<result.length;i++)
        {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100 , 16 ).substring(1));
        }
        
        String pimd=sb.toString();
        return pimd;
    }
    
    public String ds(String publickey,String pomd) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        KeyFactory kf=KeyFactory.getInstance("RSA");
        
		 X509EncodedKeySpec keySpecPKCS8 = new  X509EncodedKeySpec(Base64.getDecoder().decode(publickey));
        PublicKey key = kf.generatePublic(keySpecPKCS8);
		   
		   Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, key);

	        byte[] encryptedBytes = cipher.doFinal(pomd.getBytes());
	        
	      String dualsignature=new String(Base64.getEncoder().encode(encryptedBytes));
        
        return dualsignature;
    }
    
    @RequestMapping(value="remove.html")
    public RedirectView removecart(@RequestParam int productid,@RequestParam int customerid)
    {
       
       se.removecart(productid,customerid);
       RedirectView rv=new RedirectView();
       rv.setContextRelative(true);
       rv.setUrl("gotocart.html?customerid="+customerid);
       return rv;
    }
    
    @RequestMapping(value="addcard.html",method=RequestMethod.GET)
    public String addcard(ModelMap m)
    {
        List li=se.getbanks();
        m.put("list", li);
        return "addcard";
    }
    
    @RequestMapping(value="savecard.html",method = RequestMethod.POST)
    private String getsavecard(@RequestParam String bankcode,@RequestParam String cardname,@RequestParam String ac,@RequestParam String expiry,@RequestParam String cvvv,HttpSession ses)
    {
        int id=(int) ses.getAttribute("idd");
        se.update(bankcode,cardname,ac,expiry,cvvv,id);
        return "redirect:addcard.html";
    }
    
    @RequestMapping(value="bank.html",method = RequestMethod.GET)
    public String getbank()
    {
        return "bank";
    }
    
    @RequestMapping(value="verify.html",method=RequestMethod.GET)
    public String getverify(HttpSession ses,ModelMap m)
    {
        String code=(String) ses.getAttribute("ifsc");
        
        List li=se.verify(code);
        List li2=se.verifymerchant(code);
        m.put("list2", li2);
        m.put("list",li);
        return "verify";
    }
    
    @RequestMapping(value="bankstatus.html")
    public String getstatus(@RequestParam String cid)
    {
        int ciid=Integer.parseInt(cid);
        se.changebank(ciid);
        return "redirect:verify.html";
    }
    
    @RequestMapping(value="admin.html",method=RequestMethod.GET)
    public String getAdmin(ModelMap m)
    {
       
        return "admin";
    }
    
    @RequestMapping(value="cvstatus.html")
    public String cvstatus(@RequestParam int cid)
    {
        
        se.cvstats(cid);
        return "redirect:issuecertificate.html";
    }
    
    @RequestMapping(value="addmerchantcard.html",method=RequestMethod.GET)
    public String cardmerchant(ModelMap m)
    {
        
         List li=se.getbanks();
         m.put("list", li);
         return "addmerchantcard";
    }
    
    @RequestMapping(value="savecardmer.html")
    public String savemerchantcard(@RequestParam String bankcode,@RequestParam String cardname,@RequestParam String ac,@RequestParam String expiry,@RequestParam String cvvv,HttpSession ses)
    {
        int id=(int) ses.getAttribute("idd");
        se.updatemerchant(bankcode,cardname,ac,expiry,cvvv,id);
        return "redirect:addmerchantcard.html";
    }
    
     @RequestMapping(value="savecardcus.html")
    public String savecustomercard(@RequestParam String bankcode,@RequestParam String cardname,@RequestParam String ac,@RequestParam String expiry,@RequestParam String cvvv,HttpSession ses)
    {
        int id=(int) ses.getAttribute("idd");
        se.updatecustomer(bankcode,cardname,ac,expiry,cvvv,id);
        return "redirect:addmerchantcard.html";
    }
    
    @RequestMapping(value="paymentgateway.html")
    public String paymentgateway()
    {
        return "paymentgateway";
    }
    
    @RequestMapping(value="payment.html",method=RequestMethod.GET)
    public String payment(@RequestParam int cusid,ModelMap m)
    {
        List li=se.getcard(cusid);
        m.put("list", li);
        return "payment";
    }
    
    @RequestMapping(value="po.html",method=RequestMethod.POST)
    public String po(@RequestParam int cusid,@RequestParam String accnumber,@RequestParam String expiry,@RequestParam String cardname) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchElementException, UnsupportedEncodingException
    {
     
        
         se.updatepay(cusid);
        return "redirect:home.html";
    }
    
    @RequestMapping(value="addbank.html",method=RequestMethod.GET)
    public String addbank()
    {
        
        
        return "addbank";
    }
    
    @RequestMapping(value="orders.html",method=RequestMethod.GET)
    public String orders(@RequestParam int cusid,ModelMap m)
    {
        List li=se.getordersbyid(cusid);
        m.put("list", li);
        
        return "orders";
    }
    
      @RequestMapping(value="bankstatusmer.html")
    public String getstatusmer(@RequestParam String cid)
    {
        int ciid=Integer.parseInt(cid);
        se.changebankmer(ciid);
        se.changeproductmer(ciid);
        return "redirect:verify.html";
    }
    
    
    @RequestMapping(value="issuecertificate.html",method=RequestMethod.GET)
    public String issuecertificate(ModelMap m)
    {
        List li=se.issuecertificatemerchant();
        m.put("list", li);
        return "issuecertificate";
    }
    
    @RequestMapping(value="transaction.html",method=RequestMethod.GET)
    public String transaction(HttpSession ses,ModelMap m)
    {
        
        String ifsc=(String) ses.getAttribute("ifsc");
        List li=se.getpaid(ifsc);
        m.put("list", li);
        
        return "transaction";
    }
    
    @RequestMapping(value="payverifymer.html",method=RequestMethod.GET)
    public String payverifymer(HttpSession ses,@RequestParam int id,ModelMap m)
    {
        String bankcode=(String) ses.getAttribute("ifsc");
        List li=se.getfromcartbyid(id);
        m.put("list",li);
        List li2=se.getbankdets(bankcode);
        m.put("list2", li2);
        return "payverifymer";
    }
    
    @RequestMapping(value="dec.html")
    @ResponseBody
    public String decrypt(@RequestParam String dsig,@RequestParam String prk) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        
        KeyFactory kf=KeyFactory.getInstance("RSA");

         PKCS8EncodedKeySpec keySpecPKCS81 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(prk));
	 PrivateKey privKey = kf.generatePrivate(keySpecPKCS81);
	        
	        
	        Cipher cipher2=Cipher.getInstance("RSA");
	        
	        cipher2.init(Cipher.DECRYPT_MODE,privKey);
	           byte[] test=Base64.getDecoder().decode(dsig);
	        byte[] decryptedbytes=cipher2.doFinal(test);
	        
	        String pomd=new String(decryptedbytes);
	        
	        
	        
	        
        
       return pomd;
    }
    
    
    
    
    
    
    
    
}
