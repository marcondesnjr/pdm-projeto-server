/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Invasion {

    private String id;
    private Mission mission;
    private int total;
    private int objetivo;
    private List<Reward> attackRewards;
    private List<Reward> defenceRewards;

    public Invasion() {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public List<Reward> getAttackRewards() {
        return attackRewards;
    }

    public void setAttackRewards(List<Reward> attackRewards) {
        this.attackRewards = attackRewards;
    }

    public List<Reward> getDefenceRewards() {
        return defenceRewards;
    }

    public void setDefenceRewards(List<Reward> defenceRewards) {
        this.defenceRewards = defenceRewards;
    }
//</editor-fold>

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.mission);
        hash = 41 * hash + this.total;
        hash = 41 * hash + this.objetivo;
        hash = 41 * hash + Objects.hashCode(this.attackRewards);
        hash = 41 * hash + Objects.hashCode(this.defenceRewards);
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
        final Invasion other = (Invasion) obj;
        if (this.total != other.total) {
            return false;
        }
        if (this.objetivo != other.objetivo) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.mission, other.mission)) {
            return false;
        }
        if (!Objects.equals(this.attackRewards, other.attackRewards)) {
            return false;
        }
        if (!Objects.equals(this.defenceRewards, other.defenceRewards)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Invasion{" + "id=" + id + ", mission=" + mission + ", total=" + total + ", objetivo=" + objetivo + ", attackRewards=" + attackRewards + ", defenceRewards=" + defenceRewards + '}';
    }

}
