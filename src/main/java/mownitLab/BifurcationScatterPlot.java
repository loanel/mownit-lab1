package mownitLab;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

public class BifurcationScatterPlot extends JFrame {
    public BifurcationScatterPlot(String title, XYDataset dataset){
        super(title);
        JFreeChart chart = ChartFactory.createScatterPlot("Bifurcation diagram", "r values", "x values", dataset);
        XYPlot plot = (XYPlot)chart.getPlot();

        plot.setBackgroundPaint(new Color(255,228,196));
        plot.setRenderer(new XYDotRenderer());
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
