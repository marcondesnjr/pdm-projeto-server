/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Sortie {

    private String id;
    private LocalDateTime expiry;
    private String boss;
    List<Mission> missions;

    public Sortie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }

    public void addMissions(Mission m) {
        if (this.missions == null) {
            this.missions = new ArrayList<>();
        }
        this.missions.add(m);
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.expiry);
        hash = 23 * hash + Objects.hashCode(this.boss);
        hash = 23 * hash + Objects.hashCode(this.missions);
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
        final Sortie other = (Sortie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.boss, other.boss)) {
            return false;
        }
        if (!Objects.equals(this.expiry, other.expiry)) {
            return false;
        }
        if (!Objects.equals(this.missions, other.missions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sortie{" + "id=" + id + ", expiry=" + expiry + ", boss=" + boss + ", missions=" + missions + '}';
    }

}
