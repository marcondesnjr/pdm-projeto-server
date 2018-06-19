/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.webapp.json;

import io.github.marcondesnjr.pdm.projeto.server.entity.Alert;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class JSONConverter {
    
    
    public static String convertList(List list){
        JSONArray array = new JSONArray(list);
        return array.toString();
    }
    
}
