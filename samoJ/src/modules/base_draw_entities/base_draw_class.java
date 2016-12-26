package modules.base_draw_entities;

import core.cad_demo;

/**
 * Base "entity"-class for process of creating any Shape (line, circle, etc.) 
 * or functional actions with them (move, rotate, mirror, etc.).
 * Contain typically methods for create Shapes
 * @author vlad
 *
 */
public class base_draw_class{
	
	//Points for create object
	public int x1;
	public int y1;
	
	public int x2;
	public int y2;
	
	public int x3;//for Dimensions and mirror function
	public int y3;	
	
	/**
	 * Initial method of Shape-creating process or any function. 
	 * 
	 * @param message1 text value for first label (before command line)
	 * @param message2 text value for second label (after command line)
	 * @param next_class next class for next draw action
	 */
	public void init_draw(String message1, String message2, base_draw next_class){
		set_next(message1, message2, next_class);
		cad_demo.draw_new_object = true;

	}
	
	/**
	 * First method Shape-creating process - remember cad_demo.point_1_coords - 
	 * coordinates of point 1
	 * @param message1
	 * @param message2
	 * @param next_class
	 */
	public void draw_1(String message1, String message2, base_draw next_class){
		set_next(message1, message2, next_class);
		cad_demo.point_1_coords = cad_demo.cursor_coords.clone();
	}
	
	/**
	 * Second method - for remember coordinates of point 2
	 * @param message1
	 * @param message2
	 * @param next_class
	 */
	public void draw_2(String message1, String message2, base_draw next_class){
		set_next(message1, message2, next_class);
		
		cad_demo.point_2_coords = cad_demo.cursor_coords.clone();
		
		x1 = (int)cad_demo.point_1_coords[0];
		y1 = (int)cad_demo.point_1_coords[1];
		
		x2 = (int)cad_demo.point_2_coords[0];
		y2 = (int)cad_demo.point_2_coords[1];
		cad_demo.point_1_coords = cad_demo.cursor_coords.clone();
	}
	
	/**
	 * Subsidiary method 
	 * @param message1
	 * @param message2
	 * @param next_class
	 */
	public void set_next(String message1, String message2, base_draw next_class){
		cad_demo.info.setText(message1);
		cad_demo.info2.setText(message2);
		cad_demo.current_function = next_class;
	}
	
}