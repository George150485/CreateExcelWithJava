package model;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class AccessModifier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String modifier;
    private String ppackage;
    private String world;
    private String subclass;
    private String cclass;

    public AccessModifier(String modifier, String ppackage, String world, String subclass, String cclass) {
        this.modifier = modifier;
        this.ppackage = ppackage;
        this.world = world;
        this.subclass = subclass;
        this.cclass = cclass;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getPpackage() {
        return ppackage;
    }

    public void setPpackage(String ppackage) {
        this.ppackage = ppackage;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getCclass() {
        return cclass;
    }

    public void setCclass(String cclass) {
        this.cclass = cclass;
    }

    public Long getId(){return Id;}
}