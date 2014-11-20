/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.le.bataka.jbw.bundle.contact.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import mn.le.farcek.common.entity.FCoreEntity;

@Entity
@XmlRootElement
public class ContactEntity extends FCoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ContactEntity")
    private Integer id;

    private OfferType offerType;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String lastname;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String firstname;
    private String email;
    @Column(columnDefinition = "NTEXT")
    private String offer;

    @Override
    public Serializable getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public enum OfferType {

        Санал, Гомдол
    }
}
