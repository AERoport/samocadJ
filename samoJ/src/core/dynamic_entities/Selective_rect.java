package core.dynamic_entities;

import open_dxf_lib.Color_rgb;

public class Selective_rect {
	public  float[] select_rect_1;
	public  float[] select_rect_2;
	/**
	 * Selective rectangle vertices for draw on canvas and select Shapes
	 */
	public  float[] select_rect_vertices;
	
	public float x1;
	public float y1;
	public float x2;
	public float y2;
	
	public Color_rgb color_1 = new Color_rgb(255, 0, 0);
	public Color_rgb color_2 = new Color_rgb(0, 0, 255);
	
	public Color_rgb select_rect_color;
		
	public void init(float[] point_1, float[] point_2) {
		select_rect_1 = point_1.clone();
		select_rect_2 = point_2.clone();
		calc_rect();
	}
	
	public void new_data(float[] point_2) {
		select_rect_2 = point_2.clone();
		calc_rect();
	}
	
	private void calc_rect() {
		x1 = select_rect_1[0];
		y1 = select_rect_1[1];
		x2 = select_rect_2[0];
		y2 = select_rect_2[1];
		select_rect_vertices = new float[]{
				x1, y1, 0,
				x2, y1, 0, 
				x1, y2, 0,
				x2, y2, 0,
				x2, y1, 0,
				x2, y2, 0,
				x1, y1, 0,
				x1, y2, 0};
		if (x1 > x2){
			select_rect_color = color_1;
		}
		else
		{
			select_rect_color = color_2;
		}		
	}

	public void clear() {
		select_rect_vertices = null;
	}

}
