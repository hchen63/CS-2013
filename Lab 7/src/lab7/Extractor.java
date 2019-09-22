package lab7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Extractor {

	static Map<String, Integer> frequencies = new TreeMap<String, Integer>();
	static Map<String, Integer> frequencie = frequencies;
	Set<String> keys;
	List<String> aList;
	
	public Extractor() {	    
		setFreq();	
//		frequencie = sortByValue();
		frequencie = limitTen();
		keys = frequencie.keySet();
		aList = new ArrayList<String>(keys.size());
		setAList();
		System.out.println(frequencie);
		System.out.println(aList);
	}
	
	public Map<String, Integer> limitTen() {
		Map<String, Integer> myNewMap = frequencie.entrySet().stream()
			    .limit(10)
//			    .sorted()
			    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
		
		return myNewMap;
	}
	
	
	public void setAList() {
		for (String x : keys) 
		      aList.add(x); 
	}
	
	public String getWord(int i) {
		return aList.get(i);
	}
	public Map<String, Integer> getFrequencies() {
		return frequencies;
	}
	public static Map<String, Integer> sortByValue() { 

        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(frequencies.entrySet()); 
  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> first,  
                               Map.Entry<String, Integer> second) 
            { 
                return (second.getValue()).compareTo(first.getValue()); 
            } 
        }); 

        Map<String, Integer> test = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            test.put(aa.getKey(), aa.getValue()); 
        } 
        return test; 
    } 
	
	public static void setFreq() {
		PDDocument pd;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pdf name");
		String name = sc.nextLine();
		File input = new File("src\\lab7\\" + name);	

		try {
			
			pd = PDDocument.load(input);
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setEndPage(20);
			String text = stripper.getText(pd);
			File output = new File("src\\lab7\\blank.txt");
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
	        stripper.writeText(pd, wr);	        		
 
	        List<String> list = new ArrayList<String>(Arrays.asList(text.split(" ")));      
	        
	        for(int i = 0; i < list.size(); i++) {
	        	String word = clean(list.get(i));
	        	if (word != "") {
					Integer count = frequencies.get(word);
					if (count == null) {
						count = 1;
					} else {
						count = count + 1;
					}
					frequencies.put(word, count);
				}
	        }
			for (String key : frequencies.keySet()) {
				System.out.println(key + ": " + frequencies.get(key));
			}
			if (pd != null) {
				pd.close();
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

}
