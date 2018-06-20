/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.server;

import io.github.marcondesnjr.pdm.projeto.server.entity.Alert;
import io.github.marcondesnjr.pdm.projeto.server.entity.Fissure;
import io.github.marcondesnjr.pdm.projeto.server.entity.Invasion;
import io.github.marcondesnjr.pdm.projeto.server.entity.Sortie;
import io.github.marcondesnjr.pdm.projeto.server.http.OnlineWorldStatus;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONAlert;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONFissure;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONInvasion;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONSortie;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONUtils;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Main {
    public static void main(String[] args) throws Exception{
        OnlineWorldStatus conn = new OnlineWorldStatus();
        JSONObject root = conn.getRootJson();
        
        List<Alert> alerts = JSONAlert.getAlerts(root);
        List<Invasion> invasions = JSONInvasion.getInvasions(root);
        List<Fissure> fissures = JSONFissure.getFissures(root);
        List<Sortie> sorties = JSONSortie.getSortie(root);
        
        alerts.forEach(item -> System.out.println(item));
        System.out.println("");
        invasions.forEach(item -> System.out.println(item));
        System.out.println("");
        fissures.forEach(item -> System.out.println(item));
        System.out.println("");
        sorties.forEach(item -> System.out.println(item));




//        String str= readJSON("data/items.json");
//        JSONArray json = new JSONArray(str);
//        
//        for(int i = 0; i < json.length(); i++){
//            JSONObject obj = (JSONObject) json.get(i);
//            System.out.println(obj.getString("uniqueName"));
//            if(!obj.getString("uniqueName").contains("/Lotus/Types/StoreItems")){
//                json.remove(i);
//            }
//        }
//        json.forEach(obj -> {
//            JSONObject oj = (JSONObject) obj;
//            
//            Set<String> keys =  new HashSet<>(oj.keySet());
//            
//            for (String key : keys) {
//                if(!key.equals("name") &&
//                        !key.equals("uniqueName") &&
//                        !key.equals("imageName")){
//                    oj.remove(key);
//                    System.out.println("removido key: " + key);
//                }
//            }
//            
//        });
//        Files.write(Paths.get("C:", "Games", "test2.json"), json.toString(3).getBytes(), StandardOpenOption.CREATE);
        
        
    }
    
    private static String readJSON(String file) throws URISyntaxException, IOException {
        Path ph = Paths.get(JSONUtils.class.getClassLoader().getResource(file).toURI());
        StringBuilder builder = new StringBuilder();
        Files.readAllLines(ph).stream().forEach(str -> builder.append(str));
        String content = builder.toString();
        return content;
    }
}
