package core;

import com.jogamp.opengl.awt.GLCanvas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modules.base_draw_entities.Interface_base_draw;
import open_dxf_lib.Color_rgb;
import samoJ.Dash_base;
import samoJ.Shape;
import samoJ.SnapType;
import core.GUI.GUI;
import core.GUI.Save_dialog;

public class Global_var {
	// Important elements of GUI
	public static JFrame jframe;
	public static GLCanvas glcanvas;
	public static JLabel info_down;
	public static JLabel info;
	public static JLabel info2;
	public static JTextField cmd;
	public static JDialog about_prog;
	public static JDialog dim_style;
	public static JDialog line_style;
	public static JDialog text_style;
	//public static Save_dialog save_dialog;

	// Program state variables
	/**
	 * True if user is press middle mouse button and drag it
	 */
	public static boolean mouse_plan_motion = false;

	/**
	 * True if program in state of draw new Shape or active function state
	 * (copy, mirror, rotate...)
	 */
	public static boolean draw_new_object = false;

	/**
	 * True if program in select with rectangle state
	 */
	public static boolean select_mode = false;

	// Program global variables
	/**
	 * Coords of mouse when mouse_plan_motion
	 */
	public static float[] mouse = new float[2];

	/**
	 * latest coords of cursor
	 */
	public static float[] cursor_coords = new float[2];

	/**
	 * latest coords of cursor with snap
	 */
	public static float[] cursor_snap_coords = new float[2];

	/**
	 * coords of point 1 for draw objects or make actions with them
	 */
	public static float[] point_1_coords = new float[2];

	/**
	 * Coords of point 2 for draw objects or make actions with them
	 */
	public static float[] point_2_coords = new float[2];

	/**
	 * Point 1 of selective rectangle
	 */
	public static float[] select_rect_1 = new float[2];

	/**
	 * Point 2 of selective rectangle
	 */
	public static float[] select_rect_2 = new float[2];

	/**
	 * Class implements Interface_base_draw for run an action if user clicks
	 * left mouse button and draw_new_object == true
	 */
	public static Interface_base_draw current_function = null;
	
	/**
	 * Class for repeat last user action  
	 */
	public static Interface_base_draw old_function = null;
	
	/**
	 * Shape under cursor for select with mouse left button click
	 */
	public static Shape current_Shape = null;

	/**
	 * General HashMap of Shapes - Lines, Circles, Dimensions... Any new Shape
	 * must be put here. Key Integer is Shape ID All of Shapes will be passed to
	 * OpenGL VBO
	 */
	public static Map<Integer, Shape> theShapes = new HashMap<Integer, Shape>();
	// public static Map<Integer, Shape> theShapes = new HashMap<Integer,
	// Shape>();
	// public static List<Shape> theShapes = new LinkedList<Shape>(); 
	public static Dash_base dashes = new Dash_base();
	/**
	 * Selective rectangle vertices for draw on canvas and select Shapes
	 */
	public static float[] select_rect_vertices = new float[12];

	/**
	 * Array for draw indication current Shape under cursor
	 */
	public static float[] current_Shape_vertices = null;

	/**
	 * For draw snap sign, it depend from snap type
	 */
	public static float[] snap_sign_vertices = null;
	
	public static float[] preview_object_vertices = null;

	// COLORES
	public static Color_rgb select_rect_color = new Color_rgb(1.0f, 1.0f, 1.0f);

	/**
	 * Keys for adjust snaps. 0 - off, 1 - on. Positions: 0 - end_point, 1 -
	 * midpoint, 2 - intersection point, 3 - near_point.
	 */
	// public static int[] snap_keys = new int[]{1, 1, 1, 1};
	public static LinkedList<SnapType> snap_keys = new LinkedList<SnapType>(
			Arrays.asList(SnapType.EndPoint, SnapType.MidPoint,
					SnapType.Intersection, SnapType.NearPoint));

	/**
	 * ID of Shape next for creation. It use as key in theShapes HashMap. After
	 * put Shape to theShapes - ID++
	 */
	public static Integer current_ID = 0;

	public static int N_primLines = 0;
	public static int N_dynamic_lines = 0;
}