package br.com.zup.xyinc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POI")
public class PoiEntity {

    @Id
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "X", nullable = false)
    private Long axisX;

    @Column(name = "Y", nullable = false)
    private Long axisY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAxisX() {
        return axisX;
    }

    public void setAxisX(Long axisX) {
        this.axisX = axisX;
    }

    public Long getAxisY() {
        return axisY;
    }

    public void setAxisY(Long axisY) {
        this.axisY = axisY;
    }
}
