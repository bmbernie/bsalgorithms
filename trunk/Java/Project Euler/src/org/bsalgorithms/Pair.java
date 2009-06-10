package org.bsalgorithms;

public class Pair<T,U> {
	private T first;
	private U second;
	
	public Pair(T first, U second){
		this.first = first;
		this.second =  second;
	}
	
	public T getFirst(){
		return first;
	}
	
	public U getSecond(){
		return second;
	}
	
	public void setFirst(T first){
		this.first = first;
	}
	
	public void setSecond(U second){
		this.second = second;
	}
	
	public String toString(){
		return "[" + first + ", " + second + "]";
		
	}
}
