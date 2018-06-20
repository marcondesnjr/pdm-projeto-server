package io.github.marcondesnjr.pdm.projeto.server.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class OnlineWorldStatus {

    public JSONObject getRootJson() throws IOException {

        URL url = new URL("http://content.warframe.com/dynamic/worldState.php");
        try (InputStream in = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONObject root = new JSONObject(builder.toString());
            return root;
        }
    }
}
