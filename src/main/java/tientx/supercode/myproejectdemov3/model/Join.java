/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientx.supercode.myproejectdemov3.model;

import java.io.Serializable;

/**
 *
 * @author zOzDarKzOz
 */
public class Join implements Serializable {

    private String idJoin;
    private SetsOfCommunities socJoin;

    public void setIdJoin(String idJoin) {
        this.idJoin = idJoin;
    }

    public void setSocJoin(SetsOfCommunities socJoin) {
        this.socJoin = socJoin;
    }

    public String getIdJoin() {
        return idJoin;
    }

    public SetsOfCommunities getSocJoin() {
        return socJoin;
    }

    public Join(String idJoin, SetsOfCommunities socJoin) {
        this.idJoin = idJoin;
        this.socJoin = socJoin;
    }

    public Join() {
    }
}
