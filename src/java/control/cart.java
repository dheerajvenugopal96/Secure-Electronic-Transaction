/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author acer
 */
public class cart {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the customerid
     */
    public int getCustomerid() {
        return customerid;
    }

    /**
     * @param customerid the customerid to set
     */
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    /**
     * @return the productid
     */
    public int getProductid() {
        return productid;
    }

    /**
     * @param productid the productid to set
     */
    public void setProductid(int productid) {
        this.productid = productid;
    }

    /**
     * @return the merchantid
     */
    public int getMerchantid() {
        return merchantid;
    }

    /**
     * @param merchantid the merchantid to set
     */
    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * @return the imagepath
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * @param imagepath the imagepath to set
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    /**
     * @return the seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(String seller) {
        this.seller = seller;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    private int id;
    private int customerid;
    private int productid;
    private int merchantid;
    private String imagepath;
    private String productName;
    private String seller;
    private String amount;
    private String oi;
    private String pi;
    private String oimd;
    private String pimd;
    private String pomd;
    private String dualsignature;
    private String dsm;
    private String merbankcode;
    private String orderstatus;

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the oi
     */
    public String getOi() {
        return oi;
    }

    /**
     * @param oi the oi to set
     */
    public void setOi(String oi) {
        this.oi = oi;
    }

    /**
     * @return the pi
     */
    public String getPi() {
        return pi;
    }

    /**
     * @param pi the pi to set
     */
    public void setPi(String pi) {
        this.pi = pi;
    }

    /**
     * @return the oimd
     */
    public String getOimd() {
        return oimd;
    }

    /**
     * @param oimd the oimd to set
     */
    public void setOimd(String oimd) {
        this.oimd = oimd;
    }

    /**
     * @return the pimd
     */
    public String getPimd() {
        return pimd;
    }

    /**
     * @param pimd the pimd to set
     */
    public void setPimd(String pimd) {
        this.pimd = pimd;
    }

    /**
     * @return the pomd
     */
    public String getPomd() {
        return pomd;
    }

    /**
     * @param pomd the pomd to set
     */
    public void setPomd(String pomd) {
        this.pomd = pomd;
    }

    /**
     * @return the dualsignature
     */
    public String getDualsignature() {
        return dualsignature;
    }

    /**
     * @param dualsignature the dualsignature to set
     */
    public void setDualsignature(String dualsignature) {
        this.dualsignature = dualsignature;
    }

    /**
     * @return the orderstatus
     */
    public String getOrderstatus() {
        return orderstatus;
    }

    /**
     * @param orderstatus the orderstatus to set
     */
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    /**
     * @return the dsm
     */
    public String getDsm() {
        return dsm;
    }

    /**
     * @param dsm the dsm to set
     */
    public void setDsm(String dsm) {
        this.dsm = dsm;
    }

    /**
     * @return the merbankcode
     */
    public String getMerbankcode() {
        return merbankcode;
    }

    /**
     * @param merbankcode the merbankcode to set
     */
    public void setMerbankcode(String merbankcode) {
        this.merbankcode = merbankcode;
    }
}
