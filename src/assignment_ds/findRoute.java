/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author TEOH YU XUAN
 */
import java.util.ArrayList;
import java.util.List;
//Depth-first search
public class findRoute {
    private Graph<String, Integer> graph;
    private List<String> bestRoute;
    private int best = Integer.MAX_VALUE;

    public findRoute(Graph<String, Integer> graph) {
        this.graph = graph;
    }

    public void findShortestRoute(String startCity) {
        ArrayList<String> route = new ArrayList<>();
        route.add(startCity);
        visitCity(route, 0, startCity);
    }

    private void visitCity(List<String> route, int current, String currentCity) {
        if (route.size() == graph.getSize()) {
            // Check if this route is better than the previously found route
            if (current < best) {
                best = current;
                bestRoute = new ArrayList<>(route);
            }
            return;
        }

        for (String neighbor : graph.getNeighbours(currentCity)) {
            if (!route.contains(neighbor)) {
                route.add(neighbor);
                visitCity(route, current + graph.getEdgeWeight(currentCity, neighbor), neighbor);
                route.remove(route.size() - 1); // backtrack
            }
        }
    }

    public List<String> getBestRoute() {
        return bestRoute;
    }

    public int getBestCost() {
        return best;
    }
}
