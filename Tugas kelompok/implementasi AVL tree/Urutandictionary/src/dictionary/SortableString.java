/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

public class SortableString implements Sortable {

	private String str;
	public SortableString(String string) {
		str = string;
	}

	@Override
	public int compareTo(Sortable other) {
		/**int result = str.compareTo( other) ;
		if( result == 0 ) return 0;		//print("Equal strings ");
		else if ( comparsionResult > 0 )
		print( string1 + " is greater than " + string2 );
		else 
		print( string1 + " is less than " + string2 );
		
		**/
		
		if(other instanceof SortableString ) {
			SortableString otherString = (SortableString)other;
			return str.toString().compareTo(otherString.toString());
		}
		
		
		throw new RuntimeException("wrong type compare");
	}
	
	
	public String toString(){
		return str;//.toString();
		
	}

}
