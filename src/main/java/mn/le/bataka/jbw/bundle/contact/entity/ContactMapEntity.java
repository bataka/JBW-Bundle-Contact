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
public class ContactMapEntity extends FCoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ContactMapEntity")
    private Integer id;

    @Column(unique = true)
    private String mapKey;
    private Integer zoom = 12;
    private Double centerLat = 47.9100139019346;
    private Double centerLong = 106.90006256103516;

    @Override
    public Serializable getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMapKey() {
        return mapKey;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public Double getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(Double centerLat) {
        this.centerLat = centerLat;
    }

    public Double getCenterLong() {
        return centerLong;
    }

    public void setCenterLong(Double centerLong) {
        this.centerLong = centerLong;
    }
}
