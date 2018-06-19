/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.server.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Alert {
    private String id;
    private int minLevel;
    private int maxLevel;
    private Mission mission;
    private List<Reward> rewards;
    private LocalDateTime validade;

    public Alert() {
    }

    

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    public int getMinLevel() {
        return minLevel;
    }
    
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }
    
    public int getMaxLevel() {
        return maxLevel;
    }
    
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    
    
    
    public List<Reward> getRewards() {
        return rewards;
    }
    
    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
    
    public LocalDateTime getValidade() {
        return validade;
    }
    
    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }
    
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
//</editor-fold>

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + this.minLevel;
        hash = 37 * hash + this.maxLevel;
        hash = 37 * hash + Objects.hashCode(this.mission);
        hash = 37 * hash + Objects.hashCode(this.rewards);
        hash = 37 * hash + Objects.hashCode(this.validade);
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
        final Alert other = (Alert) obj;
        if (this.minLevel != other.minLevel) {
            return false;
        }
        if (this.maxLevel != other.maxLevel) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.mission, other.mission)) {
            return false;
        }
        if (!Objects.equals(this.rewards, other.rewards)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alert{" + "id=" + id + ", minLevel=" + minLevel + ", maxLevel=" + maxLevel + ", mission=" + mission + ", rewards=" + rewards + ", validade=" + validade + '}';
    }
   
}
