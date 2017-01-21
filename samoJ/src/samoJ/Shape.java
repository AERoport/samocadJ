package samoJ;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import core.Global_var;

/**
 * General class for all shapes
 * 
 * @author E.Askadullin
 * 
 */

public class Shape {
	// Displayed Lines
	LinkedList<PrimitiveLine> PrimLines;
	LinkedList<PrimitiveLine> SnapLines;
	LinkedList<SnapCoord> SnapPoints;
	double factor;
	int[] mask;
	public int ID;

	public Shape() {
		PrimLines = new LinkedList<PrimitiveLine>();
		SnapLines = new LinkedList<PrimitiveLine>();
		SnapPoints = new LinkedList<SnapCoord>();
		Global_var.theShapes.put(Global_var.current_ID, this);
		this.ID = Global_var.current_ID;
		Global_var.current_ID++;
		// System.out.println("The constructor Shape()");
	}

	ArrayList<Double> toList() {
		ArrayList<Double> ret = new ArrayList<Double>();
		for (PrimitiveLine p : PrimLines)
			ret.addAll(p.toList());
		return ret;
	}

	public DoubleArrayList toListDouble() {
		DoubleArrayList ret = new DoubleArrayList();
		for (PrimitiveLine p : PrimLines)
			ret.addAll(p.toListDouble());
		return ret;
	}

	void add(PrimitiveLine theP) {
		PrimLines.add(theP);
	}

	/**
	 * Method for add new snap line for this Shape. Middle point of line will be
	 * calculated automatically and will be add to SnapPoints
	 * 
	 * @param new_snap_line
	 */
	void add_snap_line(PrimitiveLine new_snap_line) {
		SnapLines.add(new_snap_line);
		/*
		 * for (Coord c : new_snap_line.coords) SnapPoints.add(new
		 * SnapCoord(SnapType.EndPoint, c));
		 */
		SnapPoints.add(new_snap_line.getMiddle());
	}

	public List<PrimitiveLine> getSnapLines() {
		return Collections.unmodifiableList(SnapLines);
	}

	public List<SnapCoord> getSnapPoints(SnapType st) {
		List<SnapCoord> ll = new LinkedList<SnapCoord>();
		switch (st) {
		case MidPoint:
			return SnapPoints;

		case EndPoint: {

			for (PrimitiveLine p : SnapLines) {
				for (Coord c : p.coords) {
					ll.add(new SnapCoord(st, c));
				}
			}
			return Collections.unmodifiableList(ll);
		}

		default:
			return ll;

		}

	}

	// EXAMPLE
	public static void main(String[] args) {

		Shape theShape = new Shape();
		theShape.add(new PrimitiveLine(1, 2, 3, 5, 7, 9));
		theShape.add_snap_line(new PrimitiveLine(1, 2, 3, 5, 7, 9));
		System.out.println(theShape.toList());
		System.out.println(theShape.getSnapPoints(SnapType.MidPoint));
		System.out.println(theShape.getSnapPoints(SnapType.EndPoint));

	}
}
