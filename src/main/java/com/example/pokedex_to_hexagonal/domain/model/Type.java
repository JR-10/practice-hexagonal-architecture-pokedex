package com.example.pokedex_to_hexagonal.domain.model;

public class Type {

    private Long id;
    private String firstType;
    private String secondtype;

    public Type(Long id, String firstType, String secondtype) {
        this.id = id;
        this.firstType = firstType;
        this.secondtype = secondtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSecondtype() {
        return secondtype;
    }

    public void setSecondtype(String secondtype) {
        this.secondtype = secondtype;
    }
}
