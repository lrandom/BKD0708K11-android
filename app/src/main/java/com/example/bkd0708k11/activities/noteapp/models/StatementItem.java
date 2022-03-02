package com.example.bkd0708k11.activities.noteapp.models;

public class StatementItem {
    private Long id;
    private Double amount;// số tiền
    private String date;//
    private int isSpend = 1;//chi =1 , thu =0
    private String purpose;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIsSpend() {
        return isSpend;
    }

    public void setIsSpend(int isSpend) {
        this.isSpend = isSpend;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
