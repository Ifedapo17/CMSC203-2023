
public class Plot {
	//Data fields
	private int x_coordinate;
	private int y_coordinate;
	private int plot_Depth;
	private int plot_Width;
	
	//Constructors
	public Plot() {
		this.x_coordinate = 0;
		this.y_coordinate = 0;
		this.plot_Depth = 1;
		this.plot_Width = 1;
	}
	
	public Plot(Plot plo1) {
		this.x_coordinate = plo1.x_coordinate;
		this.y_coordinate = plo1.y_coordinate;
		this.plot_Depth = plo1.plot_Depth;
		this.plot_Width = plo1.plot_Width;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.plot_Depth = depth;
		this.plot_Width = width;
	}

	//Methods
	/**
	 * @return the x_coordinate
	 */
	public int getX() {
		return x_coordinate;
	}

	/**
	 * @param x_coordinate the x_coordinate to set
	 */
	public void setX(int x) {
		this.x_coordinate = x;
	}

	/**
	 * @return the y_coordinate
	 */
	public int getY() {
		return y_coordinate;
	}

	/**
	 * @param y_coordinate the y_coordinate to set
	 */
	public void setY_coordinate(int y) {
		this.y_coordinate = y;
	}

	/**
	 * @return the plot_Depth
	 */
	public int getDepth() {
		return plot_Depth;
	}

	/**
	 * @param plot_Depth the plot_Depth to set
	 */
	public void setPlot_Depth(int depth) {
		this.plot_Depth = depth;
	}

	/**
	 * @return the plot_Width
	 */
	public int getWidth() {
		return plot_Width;
	}

	/**
	 * @param plot_Width the plot_Width to set
	 */
	public void setPlot_Width(int width) {
		this.plot_Width = width;
	}
	
	public String toString() {
		String plot_String = "";
		plot_String += "Upper left: (" + x_coordinate + "," + y_coordinate + 
				"); Width: " + plot_Width
				+ " Depth: " + plot_Depth;
		return plot_String;
	}
	
	public boolean overlaps(Plot plo1) {
		int [][] XYZ1 = {{this.x_coordinate, this.y_coordinate + this.plot_Depth},
				{this.x_coordinate, this.y_coordinate},
				{this.x_coordinate + this.plot_Width, this.y_coordinate},
				{this.x_coordinate + this.plot_Width, this.y_coordinate + this.plot_Depth}};
		
		int [][] XYZ1_plo1 = {{plo1.x_coordinate, plo1.y_coordinate + plo1.plot_Depth},
				{plo1.x_coordinate, plo1.y_coordinate},
				{plo1.x_coordinate + plo1.plot_Width, plo1.y_coordinate},
				{plo1.x_coordinate + plo1.plot_Width, plo1.y_coordinate + plo1.plot_Depth}};
		
		if ((XYZ1_plo1[0][0] < XYZ1[0][0]) && (XYZ1_plo1[3][0] <= XYZ1[0][0])) {
			return false;
		}
		
		if ((XYZ1_plo1[3][0] > XYZ1[3][0]) && (XYZ1_plo1[0][0] >= XYZ1[3][0])) {
			return false;
		}
		
		if ((XYZ1_plo1[0][1] > XYZ1[0][1]) && (XYZ1_plo1[1][1] >= XYZ1[0][1])) {
			return false;
		}
		
		if ((XYZ1_plo1[1][1] < XYZ1[1][1]) && (XYZ1_plo1[0][1] <= XYZ1[1][1])) {
			return false;
		}
		return true;

	}
	
	public boolean encompasses(Plot plo1) {
		int [][] XYZ1 = {{this.x_coordinate, this.y_coordinate + this.plot_Depth},
				{this.x_coordinate, this.y_coordinate},
				{this.x_coordinate + this.plot_Width, this.y_coordinate},
				{this.x_coordinate + this.plot_Width, this.y_coordinate + this.plot_Depth}};
		
		int [][] XYZ1_plo1 = {{plo1.x_coordinate, plo1.y_coordinate + plo1.plot_Depth},
				{plo1.x_coordinate, plo1.y_coordinate},
				{plo1.x_coordinate + plo1.plot_Width, plo1.y_coordinate},
				{plo1.x_coordinate + plo1.plot_Width, plo1.y_coordinate + plo1.plot_Depth}};
		
		if ((XYZ1_plo1[0][0] >= XYZ1[0][0]) && (XYZ1_plo1[2][0] <= XYZ1[2][0])){
			if((XYZ1_plo1[1][1] >= XYZ1[1][1]) && XYZ1_plo1[3][1] <= XYZ1[3][1]){
				return true;
			}
		}
		return false;
	}
}
