import java.util.ArrayList;

class Syllabus extends UniLens{
	private String course;
	private ArrayList<Integer> quizes = new ArrayList<Integer>();
	private ArrayList<Integer> homeworks = new ArrayList<Integer>();
	private ArrayList<Integer> labs = new ArrayList<Integer>();
	private ArrayList<Integer> assingments = new ArrayList<Integer>();
	private int[] major = new int[2];
	private ArrayList<Integer> majors = new ArrayList<Integer>();
	private int[] fin = new int[2];
	
	private ArrayList<String[]> plan = new ArrayList<String[]>();
	
	
	public Syllabus(String course){
		this.course = course;
	    	
	}
	
	public void addToPlan(String[] a){
		plan.add(a);
	}
	
	public String toString(){
		String data = "";
		String[] a = new String[2];
		for(int i = 0; i < plan.size() ; i++){
			a = plan.get(i);
			data += a[0] + "    " + a[1] + "   |  \n";
		}
		return String.format("%s", data);
	}

}
