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
public class Bank {

    /**
     * @return the bcode
     */
    public String getBcode() {
        return bcode;
    }

    /**
     * @param bcode the bcode to set
     */
    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the bstate
     */
    public String getBstate() {
        return bstate;
    }

    /**
     * @param bstate the bstate to set
     */
    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    /**
     * @return the bphone
     */
    public String getBphone() {
        return bphone;
    }

    /**
     * @param bphone the bphone to set
     */
    public void setBphone(String bphone) {
        this.bphone = bphone;
    }

    /**
     * @return the bpassword
     */
    public String getBpassword() {
        return bpassword;
    }

    /**
     * @param bpassword the bpassword to set
     */
    public void setBpassword(String bpassword) {
        this.bpassword = bpassword;
    }
    
    private int id;
    private String bname;
    private String bemail;
    private String bcode;
    private String branch;
    private String bstate;
    private String bphone;
    private String bpassword;
    private String publickey;
    private String privatekey;

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
     * @return the bname
     */
    public String getBname() {
        return bname;
    }

    /**
     * @param bname the bname to set
     */
    public void setBname(String bname) {
        this.bname = bname;
    }

    /**
     * @return the bemail
     */
    public String getBemail() {
        return bemail;
    }

    /**
     * @param bemail the bemail to set
     */
    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    /**
     * @return the publickey
     */
    public String getPublickey() {
        return publickey;
    }

    /**
     * @param publickey the publickey to set
     */
    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    /**
     * @return the privatekey
     */
    public String getPrivatekey() {
        return privatekey;
    }

    /**
     * @param privatekey the privatekey to set
     */
    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }
    
}
