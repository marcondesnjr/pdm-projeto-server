/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.server.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Alert;
import io.github.marcondesnjr.pdm.projeto.server.entity.Mission;
import io.github.marcondesnjr.pdm.projeto.server.entity.Reward;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class JSONAlert {

    public static JSONArray getAlertsJSON(JSONObject root) {
        return root.getJSONArray("Alerts");
    }

    public static List<Alert> getAlerts(JSONObject root) {
        JSONArray alertsJSON = getAlertsJSON(root);
        List<Alert> alerts = new ArrayList<>();
        alertsJSON.forEach(obj -> {
            Alert alert = new Alert();
            Mission mission = new Mission();
            JSONObject alertJson = (JSONObject) obj;
            
            alert.setId(alertJson.getJSONObject("_id").getString("$oid"));
            
            JSONObject missionInfo = alertJson.getJSONObject("MissionInfo");
            
            String solNode = missionInfo.getString("location");
            mission.setLocation(JSONUtils.locationConverter(solNode));
            
            String faction = missionInfo.getString("faction");
            mission.setFaction(JSONUtils.factionConverter(faction));
            
            String missionType = missionInfo.getString("missionType");
            mission.setType(JSONUtils.missionConverter(missionType));
            
            alert.setMission(mission);
            
            alert.setMinLevel(missionInfo.getInt("minEnemyLevel"));
            alert.setMaxLevel(missionInfo.getInt("maxEnemyLevel"));
            
            JSONObject missionReward = missionInfo.getJSONObject("missionReward");
            List<Reward> rewards = JSONUtils.getRewards(missionReward);
            alert.setRewards(rewards);
            Long dateLong = alertJson.getJSONObject("Expiry").getJSONObject("$date")
                    .getLong("$numberLong");
            LocalDateTime date = Instant.ofEpochMilli(dateLong).
                    atZone(ZoneId.of("UTC")).toLocalDateTime();
            alert.setValidade(date);
            
            alerts.add(alert);
        });
        return alerts;
    }

}
