/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author TEOH YU XUAN
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ConstructCity extends JPanel {
    private Map<String, Point> cityLocations;
    private Map<String, Map<String, Integer>> edges;
    public Graph<String,Integer> g1=new Graph<>();

    public ConstructCity() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.PINK);
        
        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        topPanel.add(backButton, BorderLayout.WEST);

        JButton routeButton = new JButton("Shortest Route");
        routeButton.setForeground(Color.WHITE);
        routeButton.setBackground(Color.BLUE);
        topPanel.add(routeButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        backButton.addActionListener(e -> goBackAction());
        routeButton.addActionListener(e -> computeRouteAction());

        cityLocations = new HashMap<>();
        edges = new HashMap<>();

        cityLocations.put("San Antonio", new Point(300, 340));
        cityLocations.put("Phoenix", new Point(180, 250));
        cityLocations.put("Oklahoma City", new Point(300, 230));
        cityLocations.put("Houston", new Point(380, 200));
        cityLocations.put("Orlando", new Point(430, 280));
        cityLocations.put("Miami", new Point(480, 330));
        cityLocations.put("Boston", new Point(540, 60));
        cityLocations.put("Los Angeles", new Point(60, 200));
        cityLocations.put("Golden State", new Point(100, 80));
        cityLocations.put("Denver", new Point(300, 100));

        addEdge("San Antonio", "Phoenix", 500);
        addEdge("San Antonio", "Oklahoma City", 678);
        addEdge("San Antonio", "Houston", 983);
        addEdge("San Antonio", "Orlando", 1137);
        addEdge("Phoenix", "Los Angeles", 577);
        addEdge("Oklahoma City", "Los Angeles", 1901);
        addEdge("Oklahoma City", "Golden State", 2214);
        addEdge("Oklahoma City", "Denver", 942);
        addEdge("Oklahoma City", "Houston", 778);
        addEdge("Houston", "Orlando", 458);
        addEdge("Houston", "Boston", 2584);
        addEdge("Orlando", "Miami", 268);
        addEdge("Miami", "Boston", 3045);
        addEdge("Los Angeles", "Golden State", 554);
        addEdge("Golden State", "Denver", 1507);
        addEdge("Denver", "Boston", 2845);
        
        g1.addVertex("San Antonio");
        g1.addVertex("Golden State");
        g1.addVertex("Boston");
        g1.addVertex("Miami");
        g1.addVertex("Los Angeles");
        g1.addVertex("Phoenix");
        g1.addVertex("Orlando");
        g1.addVertex("Denver");
        g1.addVertex("Oklahoma City");
        g1.addVertex("Houston");
        
        g1.addUndirectedEdge("San Antonio", "Phoenix", 500);
        g1.addUndirectedEdge("San Antonio", "Oklahoma City", 678);
        g1.addUndirectedEdge("San Antonio", "Houston", 983);
        g1.addUndirectedEdge("San Antonio", "Orlando", 1137);
        g1.addUndirectedEdge("Phoenix", "Los Angeles", 577);
        g1.addUndirectedEdge("Oklahoma City", "Los Angeles", 1901);
        g1.addUndirectedEdge("Oklahoma City", "Golden State", 2214);
        g1.addUndirectedEdge("Oklahoma City", "Denver", 942);
        g1.addUndirectedEdge("Oklahoma City", "Houston", 778);
        g1.addUndirectedEdge("Houston", "Orlando", 458);
        g1.addUndirectedEdge("Houston", "Boston", 2584);
        g1.addUndirectedEdge("Orlando", "Miami", 268);
        g1.addUndirectedEdge("Miami", "Boston", 3045);
        g1.addUndirectedEdge("Los Angeles", "Golden State", 554);
        g1.addUndirectedEdge("Golden State", "Denver", 1507);
        g1.addUndirectedEdge("Denver", "Boston", 2845);
        g1.printEdges();
        
        setBackground(Color.PINK);
    }
    private void computeRouteAction() {
        shortestRoute route = new shortestRoute();
        route.setLocationRelativeTo(null);
        route.setVisible(true);
    }
    private void goBackAction() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
        new Homepage().setVisible(true);
    }

    private void addEdge(String city1, String city2, int distance) {
        edges.putIfAbsent(city1, new HashMap<>());
        edges.putIfAbsent(city2, new HashMap<>());
        edges.get(city1).put(city2, distance);
        edges.get(city2).put(city1, distance);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw cities
        for (Map.Entry<String, Point> entry : cityLocations.entrySet()) {
            g.fillOval(entry.getValue().x - 5, entry.getValue().y - 5, 10, 10);
            g.drawString(entry.getKey(), entry.getValue().x, entry.getValue().y - 10);
        }

        // Draw edges
        for (Map.Entry<String, Map<String, Integer>> cityEntry : edges.entrySet()) {
            Point p1 = cityLocations.get(cityEntry.getKey());
            for (Map.Entry<String, Integer> edge : cityEntry.getValue().entrySet()) {
                Point p2 = cityLocations.get(edge.getKey());
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                String distanceWithUnit = edge.getValue() + " km"; 
                int textX = (p1.x + p2.x) / 2;
                int textY = (p1.y + p2.y) / 2;
                g.drawString(distanceWithUnit, textX, textY - 5);
            }
        }
    } 
}

