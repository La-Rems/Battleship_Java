package battleship.models;

public class Boat {
    protected String name;
	protected int value;
	protected int nbTouch;
	protected int tab[];
	protected int tabTest[];
	protected static int i, j;
	
	
	// Constructeur de l'objet BOAT
	public Boat(String n, int val){
		name = n;
		value = val;
		nbTouch = 0;
		i = 0;
		j = 0;
		tab = new int[val];
		tabTest = new int[val];
	}
	
	// Retourne le nom - type du bateau
	public String getName(){
		return name;
	}
	
	// Retourne la taille du bateau
	public int getValue(){
		return value;
	}
	
	// Ajoute une touche au bateau et test si il est "touché" ou "coulé"
	public boolean addTouch(){
		/*
		 * retourne vrai (true) il est coulé
		 * ou faux (false) si il est simplement touché
		 */
		nbTouch ++;
		if (nbTouch == value) return true;
		else return false;
	}
	
	public void SetPosition(int pos){
		/*
		 * Affect une valeur liée à la postion d'un bouton au bateau par un tableau
		 */
		if(i < value)
		{
			tab[i] = pos;
			i++;
		}
		if(i == value) i = 0;
	}
	
	// Retourne le tableau des differentes positions des cases du bateau
	public int[] getPositions(){
		return tab;
	}
	
	public int testPosition(int pos){
		/*
		 * Test si la position correspond au bateau et si il a deja ete touche au meme endroit
		 * si OUI, retourne True
		 * sinon retourne False
		 */
		for(int j=0; j < value; j++){
			if (pos == tab[j]){
				for(int a = 0; a < value; a++){
					if (pos == tabTest[a]){ 
						j--;
						return 0;
					}
				}
				tabTest[j] = pos;
				j++;
				return 2;
			}
		}
		return 1;
	}
}
