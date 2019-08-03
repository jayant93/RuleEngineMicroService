package com.onecode.onecodeproject.model;



public class PartnerUser extends OnecodeUser {
    public void setClientId(String clientId) {
        super.setPhonenumber(clientId);
    }
    public void setClientSecret(String clientSecret){
        super.setPassword(clientSecret);
    }
    public String getClientId(){
        return  super.getPhonenumber();
    }
    public String getClientSecret(){
        return super.getPassword();
    }
}
