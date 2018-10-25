package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileTools {
	
	public static void  apendTextToFile(File f,String content){
		
		try {
			
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f,true));
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write(content);
			bw.newLine();	
			bw.flush();
			bw.close();
			osw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		
	}

}
