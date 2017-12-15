package samoJ;

import it.unimi.dsi.fastutil.floats.FloatArrayList;
import samoJ.PrimitiveLine.DrawableLine;
import samoJ.PrimitiveLine.Line;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import core.Core;
import core.Global_var;

public class GroupShape extends Shape {
	
	List<Shape> shapes;
	
	public GroupShape(Core core, ObjectMode mode, List<Shape> shapes) {
		super(mode, core);
		this.shapes = shapes;
		for (Shape sh:shapes)
		{
			core.global.theShapes.remove(sh.ID);
		}
	}

		
	
	@Override
	public List<Line> getSnapLines() {
		List<Line> retList = new LinkedList<Line>();
		for (Shape sh:shapes)
		{
			retList.addAll(sh.getSnapLines());
		}
		return Collections.unmodifiableList(retList);
	}
	
	@Override
	public List<SnapCoord> getSnapPoints(SnapType st){
		List<SnapCoord> retList = new LinkedList<SnapCoord>();
		for (Shape sh:shapes)
		{
			retList.addAll(sh.getSnapPoints(st));
		}
		return Collections.unmodifiableList(retList);
	}
	
	@Override
	public FloatArrayList toListFloat()
	{
		FloatArrayList ret = new FloatArrayList();
		for (Shape sh:shapes)
			ret.addAll(sh.toListFloat());
		return ret;
		
	}
	
	public static void main(String[] args) {
	
		
	}
	
}


