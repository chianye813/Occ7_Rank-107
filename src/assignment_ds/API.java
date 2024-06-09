/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class API {
    private static final String API_KEY = "f7cfab75-6710-4e89-bcc8-f02b965eabce";

    public static void fetchPlayerData(String cursor, String per_page, String search, String first_name, String last_name, String team_ids, String player_ids) {
        // Build the query string
        StringBuilder queryString = new StringBuilder();
        queryString.append("?");
        if (!cursor.isEmpty()) queryString.append("cursor=").append(cursor).append("&");
        if (!per_page.isEmpty()) queryString.append("per_page=").append(per_page).append("&");
        if (!search.isEmpty()) queryString.append("search=").append(search).append("&");
        if (!first_name.isEmpty()) queryString.append("first_name=").append(first_name).append("&");
        if (!last_name.isEmpty()) queryString.append("last_name=").append(last_name).append("&");
        if (!team_ids.isEmpty()) queryString.append("team_ids[]=").append(team_ids).append("&");
        if (!player_ids.isEmpty()) queryString.append("player_ids[]=").append(player_ids).append("&");
        
        // Remove the last "&" if present
        if (queryString.length() > 1 && queryString.charAt(queryString.length() - 1) == '&') {
            queryString.setLength(queryString.length() - 1);
        }

        // Final URL with query parameters
        String finalURL = "https://api.balldontlie.io/v1/players" + queryString.toString();
        
        // Create a new SwingWorker to perform the API call in the background
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                URL url = new URL(finalURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", API_KEY);

                // Get response code
                int responseCode = connection.getResponseCode();
                switch (responseCode) {
                    case HttpURLConnection.HTTP_OK:
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
  
                        JSONArray players = new JSONObject(response.toString()).getJSONArray("data");

                        String[] columnNames = {"ID", "First Name", "Last Name", "Position", "Team"};

                        // Create data array
                        Object[][] data = new Object[players.length()][5];
                        for (int i = 0; i < players.length(); i++) {
                            JSONObject player = players.getJSONObject(i);
                            data[i][0] = player.getInt("id");
                            data[i][1] = player.getString("first_name");
                            data[i][2] = player.getString("last_name");
                            data[i][3] = player.getString("position");
                            data[i][4] = player.getJSONObject("team").getString("full_name");
                        }

                        JTable table = new JTable(data, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);
                        table.setFillsViewportHeight(true);

                        JOptionPane.showMessageDialog(null, scrollPane, "Players Information", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_UNAUTHORIZED:
                        JOptionPane.showMessageDialog(null, "Unauthorized - You either need an API key or your account tier does not have access to the endpoint.", "Error 401", JOptionPane.ERROR_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_BAD_REQUEST:
                        JOptionPane.showMessageDialog(null, "Bad Request -- The request is invalid. The request parameters are probably incorrect.", "Error 400", JOptionPane.ERROR_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_NOT_FOUND:
                        JOptionPane.showMessageDialog(null, "Not Found -- The specified resource could not be found.", "Error 404", JOptionPane.ERROR_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_NOT_ACCEPTABLE:
                        JOptionPane.showMessageDialog(null, "Not Acceptable -- You requested a format that isn't JSON.", "Error 406", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 429:
                        JOptionPane.showMessageDialog(null, "Too Many Requests -- You're rate limited.", "Error 429", JOptionPane.ERROR_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_INTERNAL_ERROR:
                        JOptionPane.showMessageDialog(null, "Internal Server Error -- We had a problem with our server. Try again later.", "Error 500", JOptionPane.ERROR_MESSAGE);
                        break;
                    case HttpURLConnection.HTTP_UNAVAILABLE:
                        JOptionPane.showMessageDialog(null, "Service Unavailable -- We're temporarily offline for maintenance. Please try again later.", "Error 503", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unexpected error: " + responseCode, "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                return null;
            }
        }.execute();
    }
}
