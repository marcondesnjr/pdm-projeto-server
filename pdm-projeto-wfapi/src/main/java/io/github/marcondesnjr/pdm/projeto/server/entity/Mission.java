/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.entity;

import java.util.Objects;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Mission {
    private String type;
    private String location;
    private String modifier;
    private String faction;

    public Mission() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + Objects.hashCode(this.location);
        hash = 67 * hash + Objects.hashCode(this.modifier);
        hash = 67 * hash + Objects.hashCode(this.faction);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mission other = (Mission) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.modifier, other.modifier)) {
            return false;
        }
        if (!Objects.equals(this.faction, other.faction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mission{" + "type=" + type + ", location=" + location + ", modifier=" + modifier + ", faction=" + faction + '}';
    }

    
    
    
}
