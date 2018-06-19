/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Mission;
import io.github.marcondesnjr.pdm.projeto.server.entity.Sortie;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class JSONSortie {
    
    public static JSONArray getSortiesJSON(JSONObject root) {
        return root.getJSONArray("Sorties");
    }
    
    public static List<Sortie> getSortie(JSONObject root) {
        JSONArray sortieJson = getSortiesJSON(root);
        List<Sortie> listSorties = new ArrayList<>();
        
        sortieJson.forEach(obj -> {
            JSONObject jSortie = (JSONObject) obj;
            Sortie st = new Sortie();
            
            st.setId(jSortie.getJSONObject("_id").getString("$oid"));
            
            Long mili = jSortie.getJSONObject("Expiry").getJSONObject("$date").getLong("$numberLong");
            LocalDateTime exp = Instant.ofEpochMilli(mili).atZone(ZoneId.systemDefault()).toLocalDateTime();
            st.setExpiry(exp);
            
            String boss = jSortie.getString("Boss");
            st.setBoss(JSONUtils.bossNameConverter(boss));
            
            JSONArray variants = jSortie.getJSONArray("Variants");
            variants.forEach(var -> {
                JSONObject jMission = (JSONObject) var;
                Mission mission = new Mission();
                
                String solNode = jMission.getString("node");
                mission.setLocation(JSONUtils.locationConverter(solNode));
                
                String missionType = jMission.getString("missionType");
                mission.setType(JSONUtils.missionConverter(missionType));
                
                mission.setFaction(JSONUtils.getBossFaction(boss));
                
                String modifier = jMission.getString("modifierType");
                mission.setModifier(JSONUtils.sortieModifierConverter(modifier));
                
                st.addMissions(mission);
            });
            
            listSorties.add(st);
        
        });
                
        return listSorties;
    }
    
}
