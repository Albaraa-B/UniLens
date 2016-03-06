import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UniLens {
	protected static String settings_path;
	protected static String syll_folder_path;
	protected static String data_folder_path;
	protected static File syll_folder;
	
	
	//Methods
	public static void readSyllabuses(){
		if(new File("Settings.txt").exists()){
			Scanner settings_file_scanner;
			try {
				settings_file_scanner = new Scanner(new FileInputStream("Settings.txt"));
				if(settings_file_scanner.hasNextLine()){
					syll_folder_path = settings_file_scanner.nextLine();
					syll_folder_path = syll_folder_path.substring(syll_folder_path.indexOf(":")+ 1).trim();
					System.out.println(syll_folder_path);
					syll_folder = new File(syll_folder_path);
					settings_file_scanner.close();
				}else{
					File settings = new File("Settings.txt");
					boolean deleted_q = settings.delete();
					JOptionPane.showMessageDialog(null, String.format("The Settings File seems Corrupted, I will Try to delete it!%nThe program will terminate, start again to resetup"));
					if(deleted_q)
						System.exit(1);
					else{
						JOptionPane.showMessageDialog(null, String.format("Sorry, Couldn't delete it myself, please delete the settings file %n%s",settings_path));
						System.exit(1);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				}else{
					setup();
					}
				
		File syll_data = new File("Data");
		if(!syll_data.exists())
			syll_data.mkdir();
		
		
		
		System.out.printf("Is Folder? %b%n",syll_folder.isDirectory());
		File[] syllabuses = new File(syll_folder.getPath()).listFiles();
		System.out.printf("%d Files Detected...%n", syllabuses.length);
		for(File syllabus: syllabuses){
			try {
				Syllabus course = new Syllabus(syllabus.getName());
				Scanner s = new Scanner(new FileInputStream(syllabus.getPath()));
				while(s.hasNextLine()){
					String line = s.nextLine();
					if(line.contains("%")){
						String category = line.substring(0, line.lastIndexOf("%")- 2);
						String value = line.substring(line.lastIndexOf("%")- 2);
						System.out.printf("%s %s%n",category,value);
						String[] cv = {category,value};
						
						course.addToPlan(cv);
					}
				}
				s.close();
				PrintWriter p = new PrintWriter(new FileOutputStream("Data/"+syllabus.getName()));
				p.printf("%s%n", course.toString());
				p.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void setup(){
		JOptionPane.showMessageDialog(null, String.format("Press OK to locate the Folder containing Syllabus Files"), "Setup", JOptionPane.INFORMATION_MESSAGE);
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int check = fc.showDialog(null, "This Folder has it All");
		if(check == JFileChooser.APPROVE_OPTION){
			syll_folder = fc.getSelectedFile();
			syll_folder_path = syll_folder.getPath();
			PrintWriter p;
			try {
				p = new PrintWriter(new FileOutputStream("Settings.txt"));
				p.printf("Path: %s%n",syll_folder_path);
				p.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void fetchData(){
		if(new File("Data").exists()){
			File 
		}
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readSyllabuses();
	}

}
