import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class anagramize {
    List<String> all = new ArrayList<String>();
    List<String> ana = new ArrayList<String>();
    List<String> txt = new ArrayList<String>();
    List<String> list = new ArrayList<String>();
    List<String> l = new ArrayList<String>();
//    List<String> ana = new ArrayList<String>();
    
	public void anagramize(String inString, String strList) {
		int i = 0;
		int j = 0;
		System.out.println("input string: " + inString);
		txt = parses();
		
		List<String> l = filter(anagramizeRecursive("", inString.toLowerCase()), i,j);
		System.out.println("All anagrams: " + l);
		List<String> group = nonReFilter(strList);
		System.out.println(group);
		
		System.out.println("Anagrams for string list " + strList + " is: " + group);
		System.out.println("Anagrams for " + inString + ": " + l);
	}

	public List<String> filter(List<String> p, int i, int j) {
		
		System.out.println("one " + i);
		System.out.println(txt.size());
		System.out.println("text word " + txt.get(i));
		System.out.println("all size " + p.size());
		System.out.println("get j " + j);
		System.out.println("all get " + p.get(j));
		
		if(i == 0 && j == 0) {
			List<String> l = new ArrayList<String>();
		}

		if(txt.get(i).equals(p.get(j))) {
			ana.add(p.get(j));
            System.out.println(" yes" + ana);
//            System.out.println("hi");
            i++;
            filter(p, i, j);
	    }else if(i >= (txt.size()-1) && j >= (p.size())-1) {
//	    	System.out.println("p");
	    	return ana;
	    }else if(i >= txt.size()-1) {
    		j++;
    		int k = 0;
//    		System.out.println(" s" + i );
    		filter(p, k, j); 
	    } else {
			i++;
//			System.out.println("n" + i);
            filter(p, i, j);
		}  
	    System.out.println("end");
	    System.out.println("i " + i);
	    System.out.println("j " + j);
	    return null;
	}
	
	public List<String> parses(){		
		try {
			FileReader fr = new FileReader("C:\\Users\\hchen63\\Desktop\\twl06.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String buffer = br.readLine();

	        while ((buffer = br.readLine()) != null) {
	            txt.add(buffer);
	            }  	
	        br.close();
	        fr.close();
			}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return txt;
	}
	
	public List<String> nonReFilter(String strList) {
		String[] sList = strList.split(" ");
		int i = 0;
		for(i = 0; i < sList.length; i++) {
			int j = 0;
			list.add(sList[i]);
			System.out.println("Anagram dog list:" + list);
//			if(i == sList.length-1) {
//				i = 0;
//				filter(list,i,j);
		}
		if(i == sList.length) {
			int x = 0;
			int y = 0;
//			System.out.println("hey");
			filter(list,x,y);
		}		
		return list;
	}
	
	public List<String> anagramizeRecursive(String s1, String lowerCase) {
        int i = 0;
 
		if(lowerCase.length() <= 1){
            i++;
            System.out.println(s1+lowerCase);
            all.add(s1+lowerCase);
            System.out.println("Array" + all);
        }else{
            for(int j = 0; j < lowerCase.length(); j++)
            {
                String x = lowerCase.substring(j, j+1);
                String y = lowerCase.substring(0, j);
                String z = lowerCase.substring(j+1);
                String sub1 = s1+x;
                String sub2 = y+z ;
                anagramizeRecursive(sub1, sub2);
            }
        }
		return all;
    }
}
