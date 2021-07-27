package com.hyan.customerservice.api.response;

public class AssociateResponse {

    private String taxId;

    public AssociateResponse(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

}
