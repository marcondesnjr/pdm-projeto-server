/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Fissure {

    private String id;
    private Mission mission;
    private LocalDateTime expiry;

    public Fissure() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }
//</editor-fold>

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.mission);
        hash = 37 * hash + Objects.hashCode(this.expiry);
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
        final Fissure other = (Fissure) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.mission, other.mission)) {
            return false;
        }
        if (!Objects.equals(this.expiry, other.expiry)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fissure{" + "id=" + id + ", mission=" + mission + ", expiry=" + expiry + '}';
    }

}
