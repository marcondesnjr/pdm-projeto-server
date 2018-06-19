/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.server.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Alert;
import io.github.marcondesnjr.pdm.projeto.server.entity.Reward;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public abstract class JSONUtils {

    private static JSONArray item;

    public static List<Reward> getRewards(JSONObject missionReward) {
        List<Reward> rewards = new ArrayList<>();
        missionReward.keys().forEachRemaining(key -> {
            Object item = missionReward.get(key);
            if (key.equals("credits")) {
                Reward rw = new Reward();
                rw.setName("Credits");
                rw.setImgRef("credits.png");
                rw.setQuant(missionReward.getInt(key));
                rewards.add(rw);
            } else if (key.equals("countedItems")) {
                JSONArray jArray = missionReward.getJSONArray(key);
                jArray.forEach(arrayObj -> {
                    JSONObject jsonObject = (JSONObject) arrayObj;
                    Reward rw = getItemName(jsonObject.getString("ItemType"));
                    rw.setQuant(jsonObject.getInt("ItemCount"));
                    rewards.add(rw);
                });
            } else if (key.equals("items")) {
                JSONArray ja = missionReward.getJSONArray(key);
                Iterator<Object> inter = ja.iterator();
                while (inter.hasNext()) {
                    String unq = (String) inter.next();
                    Reward rw = getItemName(unq);
                    rw.setQuant(1);
                    rewards.add(rw);
                }
            }
        });
        return rewards;
    }

    public static String locationConverter(String solnode) {
        try {
            String content = readJSON("data/solNodes.json");

            JSONObject root = new JSONObject(content);
            String location = root.getJSONObject(solnode).getString("value");

            return location;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String factionConverter(String fac) {
        try {
            String content = readJSON("data/factionsData.json");

            JSONObject root = new JSONObject(content);
            String faction = root.getJSONObject(fac).getString("value");

            return faction;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String missionConverter(String mis) {
        try {
            String content = readJSON("data/missionTypes.json");

            JSONObject root = new JSONObject(content);
            String mission = root.getJSONObject(mis).getString("value");

            return mission;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String fissureModifierConverter(String mod) {
        try {
            String content = readJSON("data/fissureModifiers.json");

            JSONObject root = new JSONObject(content);
            String mission = root.getJSONObject(mod).getString("value");

            return mission;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String bossNameConverter(String boss) {
        try {
            String content = readJSON("data/sortieData.json");
            JSONObject root = new JSONObject(content);
            JSONObject bosses = root.getJSONObject("bosses");
            String bossName = bosses.getJSONObject(boss).getString("name");

            return bossName;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String sortieModifierConverter(String mod) {
        try {
            String content = readJSON("data/sortieData.json");

            JSONObject root = new JSONObject(content);
            String modifier = root.getJSONObject("modifierTypes").getString(mod);

            return modifier;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getBossFaction(String boss) {
        try {
            String content = readJSON("data/sortieData.json");
            JSONObject root = new JSONObject(content);
            JSONObject bosses = root.getJSONObject("bosses");
            String bossFaction = bosses.getJSONObject(boss).getString("faction");

            return bossFaction;
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static Reward getItemName(String unq) {
        Reward result = new Reward();
        try {
            if (item == null) {
                String str = readJSON("data/items.json");
                item = new JSONArray(str);
            }
            Iterator<Object> iter = item.iterator();
            while (iter.hasNext()) {
                JSONObject jsonObj = (JSONObject) iter.next();
                if (jsonObj.getString("uniqueName").equals(unq)) {
                    result.setName(jsonObj.getString("name"));
                    result.setImgRef(jsonObj.getString("imageName"));
                    break;
                }
            }

        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result.getName() == null){
            String[] name = unq.split("/");
            result.setName(name[name.length-1]);
            result.setImgRef("default-img.png");
        }
        return result;
    }

    private static String readJSON(String file) throws URISyntaxException, IOException {
        try (InputStream in = JSONUtils.class.getClassLoader().getResourceAsStream(file)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        }
    }

}
