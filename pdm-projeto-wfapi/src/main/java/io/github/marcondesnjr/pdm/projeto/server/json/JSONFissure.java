/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Fissure;
import io.github.marcondesnjr.pdm.projeto.server.entity.Invasion;
import io.github.marcondesnjr.pdm.projeto.server.entity.Mission;
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
public class JSONFissure {
    public static JSONArray getFissuresJSON(JSONObject root) {
        return root.getJSONArray("ActiveMissions");
    }
    
    public static List<Fissure> getFissures(JSONObject root) {
        List<Fissure> listFissures = new ArrayList<>();
        JSONArray info = getFissuresJSON(root);
        
        
        info.forEach(obj -> {
            JSONObject jFissure = (JSONObject) obj;
            Fissure fis = new Fissure();
            Mission mission = new Mission();
            
            fis.setId(jFissure.getJSONObject("_id").getString("$oid"));
            
            Long mili = jFissure.getJSONObject("Expiry").getJSONObject("$date").getLong("$numberLong");
            LocalDateTime exp = Instant.ofEpochMilli(mili).atZone(ZoneId.of("UTC")).toLocalDateTime();
            
            fis.setExpiry(exp);
            
            String solNode = jFissure.getString("Node");
            mission.setLocation(JSONUtils.locationConverter(solNode));
            
            String type = jFissure.getString("MissionType");
            mission.setType(JSONUtils.missionConverter(type));
            
            String mod = jFissure.getString("Modifier");
            mission.setModifier(JSONUtils.fissureModifierConverter(mod));
            
            fis.setMission(mission);           
            listFissures.add(fis);
            
        });
        return listFissures;
    }
}
