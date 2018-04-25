package sorting_algorithms;

import java.util.Vector;


public class PatienceSort extends Sort{
	public static void patienceSort(int[] n){
		Vector piles = new Vector(0, 1);
		Vector first = new Vector(0, 1);
		first.add(new Integer(n[0]));
		piles.add(first);
		//sort into piles
		for(int a = 1; a < n.length; a++){
			boolean notFound = true;
			for(int i = 0; i < piles.size() && notFound; i++){
				Vector pile = (Vector)(piles.get(i));
				int top = ((Integer)pile.get(pile.size() - 1)).intValue();
				if(top >= n[a]){
					pile.add(new Integer(n[a]));
					notFound = false;
				}
			}
			if(notFound){

				Vector newPile = new Vector(0, 1);
				newPile.add(new Integer(n[a]));
				piles.add(newPile);
			}
		}
		int c = 0;
		while(c < n.length){
			int small = 0;
			//find minimum value of top cards
			for(int a = 1; a < piles.size(); a++){
				Vector pile1 = (Vector)piles.get(a);
				Vector pile2 = (Vector)piles.get(small);
				int n1 = ((Integer)pile1.get(pile1.size() - 1)).intValue();
				int n2 = ((Integer)pile2.get(pile2.size() - 1)).intValue();
				if(n1 < n2){
					small = a;
				}
			}
			Vector smallPile = (Vector)piles.get(small);
			n[c] = ((Integer)smallPile.get(smallPile.size() - 1)).intValue();
			smallPile.remove(smallPile.size() - 1);
			if(((Vector)piles.get(small)).size() == 0){
				piles.remove(small);
			}
			c++;
		}
	}
}
