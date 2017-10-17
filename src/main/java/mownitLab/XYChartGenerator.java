package mownitLab;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;

public class XYChartGenerator extends ApplicationFrame {

    public XYChartGenerator(String chartTitle, XYSeriesCollection gatheredData){
        super(chartTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart("Relative Error for iterative sum",
                "Step of 25000",
                "Error Value",
                gatheredData,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1080, 960));
        XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setShape(new Rectangle(1,1));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }
}
