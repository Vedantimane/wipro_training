package com.wipro.oops;

public class Shape {

    private String name;
    private String color;
    private int edges;
    private String borderColor;

    public Shape(String name, String color, int edges, String borderColor) {
        this.name = name;
        this.color = color;
        this.edges = edges;
        this.borderColor = borderColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String toString() {
        return "Shape [name=" + name + ", color=" + color +
               ", edges=" + edges + ", borderColor=" + borderColor + "]";
    }

	public Shape() {
		super();
	}
}
