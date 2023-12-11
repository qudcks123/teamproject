
import java.io.*;
import java.util.ArrayList;

public class Info implements Serializable {
	public static void Information(ArrayList<Store> p, String name) {
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream( name +"_Information.txt"));
			writer.writeObject(p);
			
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Store> Information(String name) {
		
		ArrayList<Store> read_data = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + "_Information.txt"));
			read_data = (ArrayList<Store>) ois.readObject();//파일에서 ArrayList읽기
			ois.close();
			
		} catch (EOFException | FileNotFoundException e) {
            // 파일 끝에 도달하여 EOFException이 발생할 때 처리할 내용
			return read_data;
        } 
		catch(IOException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		return read_data;
	}
	
}

