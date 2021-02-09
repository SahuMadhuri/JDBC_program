package in.jdbc.marksheetResourceBundle;

import in.jdbc.marksheet.MarksheetBean;
import in.jdbc.marksheet.MarksheetModel;

public class Testmarksheet {
	public static void main(String[] args) throws Exception {
		
	//add();
	//update();
	//delete();
	select();
	//maritlist();
	//search();
}
public static void add() throws Exception{
	MarksheetBean bean= new MarksheetBean();
	
	bean.setId(11);
	bean.setRoll_No("110");
	bean.setFname("Anisha");
	bean.setLname("Sahu");
	bean.setPhysics(86);
	bean.setChemistry(92);
	bean.setMaths(96);
	MarksheetModel model=new MarksheetModel();
	model.add(bean);
}
public static void update() throws Exception{
	MarksheetBean b=new MarksheetBean();
	b.setId(11);
	b.setFname("Gitanshi");
     MarksheetModel model=new MarksheetModel();
	model.update(b);
}
public static void delete() throws Exception{
	MarksheetBean k=new MarksheetBean();
	k.setId(11);
     MarksheetModel model=new MarksheetModel();
     model.delete(k);
}
public static void select() throws Exception{
	MarksheetBean j=new MarksheetBean();
	//j.setRoll_No("105");
	  MarksheetModel model=new MarksheetModel();
	  model.select(j);
		}
public static void maritlist() throws Exception{
	MarksheetBean j=new MarksheetBean();
	//j.setRoll_No("105");
	  MarksheetModel model=new MarksheetModel();
	  model.maritlist(j);
}
public static void search() throws Exception{
	MarksheetBean j=new MarksheetBean();
	j.setRoll_No("107");
	MarksheetModel model=new MarksheetModel();
	  model.search(j);
}


}
