/*
 * 
 * 
 */
package io.github.marcondesnjr.pdm.projeto.server.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Invasion;
import io.github.marcondesnjr.pdm.projeto.server.entity.Mission;
import java.util.ArrayList;
import java.util.List;;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class JSONInvasion {

    public static JSONArray getInvasionsJSON(JSONObject root) {
        return root.getJSONArray("Invasions");
    }

    public static List<Invasion> getInvasions(JSONObject root) {
        List<Invasion> listInvasions = new ArrayList<>();
        JSONArray info = getInvasionsJSON(root);

        info.forEach(obj -> {
            Invasion inv = new Invasion();
            JSONObject jInvasion = (JSONObject) obj;
            Mission mission = new Mission();
            
            inv.setId(jInvasion.getJSONObject("_id").getString("$oid"));
            
            String solNode = jInvasion.getString("Node");
            mission.setLocation(JSONUtils.locationConverter(solNode));
            
            String faction = jInvasion.getString("Faction");
            mission.setFaction(JSONUtils.factionConverter(faction));
            
            inv.setMission(mission);
            
            inv.setObjetivo(jInvasion.getInt("Goal"));
            inv.setTotal(jInvasion.getInt("Count"));
            try {
                JSONObject attackerReward = jInvasion.getJSONObject("AttackerReward");
                inv.setAttackRewards(JSONUtils.getRewards(attackerReward));
            } catch (JSONException ex) {
                inv.setAttackRewards(new ArrayList<>());
            }
            try {
                JSONObject deffenderReward = jInvasion.getJSONObject("DefenderReward");
                inv.setAttackRewards(JSONUtils.getRewards(deffenderReward));
            } catch (JSONException ex) {
                inv.setDefenceRewards(new ArrayList<>());
            }
            listInvasions.add(inv);

        });

        return listInvasions;
    }

}
