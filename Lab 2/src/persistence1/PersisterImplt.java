package persistence1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.util.List;

public class PersisterImplt<T> implements Persister<T>, Serializable{

	@Override
	public void saveObjectToFile(File f, Object ob) {
		try {
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(ob);
			objOut.close();
			System.out.println("The objwect was saved!");			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void saveListToFile(File f, List myList) {
		try {
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream listOut = new ObjectOutputStream(fileOut);
			listOut.writeObject(myList);
			listOut.close();
			System.out.println("The objwect was saved!");			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public T readObjectFromFile(File f) {
		try {
			FileInputStream fileIn = new FileInputStream(f);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			T obj = (T) objIn.readObject();
			System.out.println("The objrct was read!");		
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List readListFromFile(File f) {
		try {
			FileInputStream fileIn = new FileInputStream(f);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			List list = (List) objIn.readObject();
			System.out.println("The objrct was read!");		
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
