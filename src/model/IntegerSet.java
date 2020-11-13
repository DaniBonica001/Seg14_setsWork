package model;
import java.util.*;
public class IntegerSet{
	//Atributes
	private String name;
	private int cardinality;
	private ArrayList <Integer> elements;

	//Methods
	public IntegerSet(String name){
		this.name=name;
		cardinality=0;
		elements= new ArrayList <Integer>();
	}

	//Setters annd getters
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setCardinality(int cardinality){
		this.cardinality=cardinality;
	}
	public int getCardinality(){
		return cardinality;
	}

	public void setElements(ArrayList<Integer> elements){
		this.elements=elements;
	}
	public ArrayList<Integer> getElements(){
		return elements;
	}


	public void addElement(int element){
		elements.add(element);
		cardinality+=1;
	}

	public void removeElement(int element){
		boolean exit=false;
		for (int i=0;i<elements.size() && !exit;i++){
			if (elements.get(i)==element){
				elements.remove(i);
				cardinality-=1;
				exit=true;
			}
		}
	}


	public IntegerSet union(IntegerSet set,String newName){
		IntegerSet newSet= new IntegerSet(newName);	
		int cardinalityUnion= 0;	
		ArrayList <Integer> elementsSecondSet= new ArrayList <Integer>();
		elementsSecondSet=set.getElements();
		

		for (int i=0;i<elements.size();i++){
			newSet.addElement(elements.get(i));	
			cardinalityUnion++;
		}

		for (int j=0;j<elementsSecondSet.size();j++){
			newSet.addElement(elementsSecondSet.get(j));
			cardinalityUnion++;										
		}

		for (int a=0;a<elements.size();a++){
			for (int b=0;b<elementsSecondSet.size();b++){
				if (elements.get(a)==elementsSecondSet.get(b)){
					newSet.getElements().remove(newSet.getElements().lastIndexOf(elements.get(a)));					
					cardinalityUnion--;
				}
			}
		}

		newSet.setCardinality(cardinalityUnion);

	return newSet;
	}

	public IntegerSet difference(IntegerSet set,String newName){
		IntegerSet newSet= new IntegerSet(newName);		
		int cardinalityUnion= 0;
		ArrayList <Integer> elementsSecondSet= new ArrayList <Integer>();
		elementsSecondSet=set.getElements();
		

		for (int i=0;i<elements.size();i++){
			newSet.addElement(elements.get(i));	
			cardinalityUnion++;		
		}

		for (int a=0;a<elements.size();a++){
			for (int b=0;b<elementsSecondSet.size();b++){
				if (elements.get(a)==elementsSecondSet.get(b)){
					newSet.getElements().remove(newSet.getElements().lastIndexOf(elements.get(a)));	
					cardinalityUnion--;				
				}
			}
		}

		newSet.setCardinality(cardinalityUnion);

	return newSet;
	}

	public IntegerSet intersection(IntegerSet set,String newName){
		IntegerSet newSet= new IntegerSet(newName);	
		int cardinalityUnion= 0;	
		ArrayList <Integer> elementsSecondSet= new ArrayList <Integer>();
		elementsSecondSet=set.getElements();

		ArrayList <Integer> sameElements= new ArrayList <Integer>();
		

		for (int i=0;i<elements.size();i++){
			newSet.addElement(elements.get(i));						
		}

		for (int j=0;j<elementsSecondSet.size();j++){
			newSet.addElement(elementsSecondSet.get(j));										
		}

		for (int a=0;a<elements.size();a++){
			for (int b=0;b<elementsSecondSet.size();b++){
				if (elements.get(a)==elementsSecondSet.get(b)){
					sameElements.add(elements.get(a));
					cardinalityUnion++;						
				}
			}
		}
		newSet.setCardinality(cardinalityUnion);
		newSet.setElements(sameElements);
		

	return newSet;
	}

	public IntegerSet symmetricDifference(IntegerSet set,String newName){
		IntegerSet newSet= new IntegerSet(newName);	
		int cardinalityUnion= 0;	
		ArrayList <Integer> elementsSecondSet= new ArrayList <Integer>();
		elementsSecondSet=set.getElements();
		

		for (int i=0;i<elements.size();i++){
			newSet.addElement(elements.get(i));	
			cardinalityUnion++;
		}

		for (int j=0;j<elementsSecondSet.size();j++){
			newSet.addElement(elementsSecondSet.get(j));
			cardinalityUnion++;										
		}

		for (int a=0;a<elements.size();a++){
			for (int b=0;b<elementsSecondSet.size();b++){
				if (elements.get(a)==elementsSecondSet.get(b)){
					newSet.getElements().remove(elements.get(a));
					cardinalityUnion--;				
					newSet.getElements().remove(elementsSecondSet.get(b));				
					cardinalityUnion--;
				}
			}
		}

		newSet.setCardinality(cardinalityUnion);

	return newSet;
	}

	public String showContents(){
		String numbers="{";
		for (int i=0;i<elements.size();i++){
			numbers+=elements.get(i)+",";
		}
		String message="\n*********************"+
						"\n**Nombre: "+name+
						"\n**Cardinalidad: "+cardinality+
						"\n**Elementos: "+ numbers+"}"+
						"\n********************";
	return message;
	}

}