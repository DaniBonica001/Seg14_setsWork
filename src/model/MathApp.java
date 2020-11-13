package model;
import java.util.*;
public class MathApp{
	//Atributes
	private int amount;
	//Relations
	private ArrayList <IntegerSet> sets;
	//Methods
	public MathApp(){
		amount=0;
		sets = new ArrayList<IntegerSet>();
	}

	public IntegerSet findSet(String name){
		IntegerSet find=null;
		boolean exit=false;
		for (int i=0;i<sets.size() && !exit;i++){
			if (sets.get(i).getName().equalsIgnoreCase(name)){
				find= sets.get(i);
				exit=true;
			}
		}
	return find;
	}

	public int findSetPosition(String name){
		int numberIndex =-1;
		boolean exit=false;
		for (int i=0;i<sets.size() && !exit;i++){
			if (sets.get(i).getName().equalsIgnoreCase(name)){
				numberIndex=i;
				exit=true;
			}
		}
	return numberIndex;
	}

	public void addSet(String name){
		IntegerSet findSet= findSet(name);
		String message="";
		if (findSet==null){
			sets.add(new IntegerSet(name));
			amount+=1;
			message="Se ha creado el conjunto";
		}else{
			message="Error.Ese conjunto ya existe";
		}
	}

	public void removeSet(String name){
		int findSet= findSetPosition(name);
		String message="";
		if (findSet==-1){
			message="Error.No se encontro el conjunto";			
		}else{
			sets.remove(findSet);
			amount-=1;
			message="Se ha eliminado el conjunto";
		}
	}

	public void addElementToSet(String name,int element){
		IntegerSet findSet= findSet(name);
		String message="";
		if (findSet==null){
			message="Error. No se encontro el conjunto";
		}else{
			findSet.addElement(element);
			message="Se añadira el elemento";
		}
	}


	public void removeElementFromSet(String name,int element){
		IntegerSet findSet= findSet(name);
		String message="";
		if (findSet==null){
			message="Error. No se encontro el conjunto";
		}else{
			findSet.removeElement(element);
			message="Se eliminara el elemento";
		}
	}

	public void union(String name1,String name2,String newName){
		IntegerSet findSet1= findSet(name1);
		IntegerSet findSet2= findSet(name2);
		IntegerSet findSet3= findSet(newName);
		

		if (findSet1!=null && findSet2!=null && findSet3==null){
			
			findSet3=findSet1.union(findSet2,newName);
			sets.add(findSet3);
			amount++;
		}
	}

	public void difference(String name1,String name2,String newName){
		IntegerSet findSet1= findSet(name1);
		IntegerSet findSet2= findSet(name2);
		IntegerSet findSet3= findSet(newName);
		

		if (findSet1!=null && findSet2!=null && findSet3==null){
			
			findSet3=findSet1.difference(findSet2,newName);
			sets.add(findSet3);
			amount++;
		}
	}

	public void intersection(String name1,String name2,String newName){
		IntegerSet findSet1= findSet(name1);
		IntegerSet findSet2= findSet(name2);
		IntegerSet findSet3= findSet(newName);
		

		if (findSet1!=null && findSet2!=null && findSet3==null){
			
			findSet3=findSet1.intersection(findSet2,newName);
			sets.add(findSet3);
			amount++;
		}
	}

	public void symmetricDifference(String name1,String name2,String newName){
		IntegerSet findSet1= findSet(name1);
		IntegerSet findSet2= findSet(name2);
		IntegerSet findSet3= findSet(newName);
		

		if (findSet1!=null && findSet2!=null && findSet3==null){
			
			findSet3=findSet1.symmetricDifference(findSet2,newName);
			sets.add(findSet3);
			amount++;
		}
	}



	public String showInfoSet(String name){
		IntegerSet findSet= findSet(name);
		String message="";
		boolean exit=false;
		for (int i=0;i<sets.size() && !exit;i++){
			if (sets.get(i).getName().equalsIgnoreCase(name)){
				message+=findSet.showContents();
				exit=true;
			}
		}
	return message;

	}

	public String showInfoSet(){
		String message="Cantidad de conjuntos: "+amount;
		for (int i=0;i<sets.size();i++){
			IntegerSet objIntegerSet=sets.get(i);
			message+=objIntegerSet.showContents();		
			
		}
	return message;

	}




}