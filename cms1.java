package morpion;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;


public class cms1 {

public static char[] creerLigne (int nbCase) {
	char [] tab =new char[nbCase] ; 
	return tab ;
}
	
public static char lireValeurCaseLigne(char [] Laligne , int indexCase)	{	
			return Laligne[indexCase];
}

public static void affecterValeurCaseLigne (char [] Laligne, int indexCase, char valeurCase)
{
	if (Laligne[indexCase] == ' ')
	{
		if (valeurCase == 'X' || valeurCase == 'O')
		{
			Laligne[indexCase] = valeurCase;
		}	
	}
}
//question 6 facultatif
public static char [] indicesCaseVideLigne(char [] Laligne)
{
	for (int i = 0; i < Laligne.length; i++)
	{
		System.out.print(Laligne[i] + " ");
	}
	return Laligne;
}

public static char lireValeurCaseGrille(char [] [] grille, int indexLigne, int indexColonne)
{
	return grille[indexLigne][indexColonne];
}

public static void affecterValeurCaseGrille(char [] [] grille, int indexLigne, int indexColonne, char valeurCase)
{
	affecterValeurCaseLigne(grille[indexLigne], indexColonne, valeurCase);
	//grille[indexLigne][indexColonne] = valeurCase;
	//en appelant la fonction affecterValeurCaseLigne nous n'avons pas besoin de refaire de if
}

//question 9 facultatif
public static int[][][] coordoneesCasesVides (char [][] grille)
{
	int [][][] tab = new int [grille.length][][];
	for (int i = 0; i < tab.length; i++)
	{
		tab [i] = new int [grille[i].length][2];
		for (int j = 0; j < grille[i].length; j++)
		{
			if (grille[i][j] == ' ')
			{
				tab[i][j][0] = i; //ligne
				tab[i][j][1] = j; //colonne
			}
		}
	}
	return tab;
}

public static void afficherLigne (char[] LaLigne)
{
	for (int i = 0; i < LaLigne.length; i++)
	{
		System.out.print(lireValeurCaseLigne(LaLigne, i) + " | ");
	}
}

public static void afficherGrille (char[][] grille)
{
	for (int i = 0; i < grille.length; i++)
	{
		for (int j = 0; j < grille[i].length; j++)
		{
			System.out.print(lireValeurCaseGrille(grille, i, j) + " | ");
		}
		System.out.println();
		System.out.println();
	}
}

public static int [] saisieCoordonees()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Saisissez les coordonnees de la ligne");
	int indexLigne = sc.nextInt();
	System.out.println("Saisissez les coordonnees de la colonne");
	int indexColonne = sc.nextInt();
	int tab [] = {indexLigne, indexColonne};
	return tab;
}

public static int [] demandeCase (char [][] grille)
{
	int [] tab = saisieCoordonees();
	if (grille[tab[0]][tab[1]] == ' ')
	{
	}
	else 
	{
		System.out.println("La case n'est pas vide");
		int [] tabe = saisieCoordonees();
		if (grille[tabe[0]][tabe[1]] == ' ')
		{
			tab[0] = tabe[0];
			tab[1] = tabe[1];
		}
		else
		{
			System.out.println("La case n'est pas vide POV CON ca fait 2 fois");
			int [] tab3 = saisieCoordonees();
			if (grille[tab3[0]][tab3[1]] == ' ')
			{
				tab[0] = tab3[0];
				tab[1] = tab3[1];
			}
		}
	}
	return tab;
}

public static int entierAleatoire(int a, int b){
	//Retourne un entier aléatoire entre a (inclus) et b (inclus)
	return ThreadLocalRandom.current().nextInt(a, b + 1);	
}

public static boolean gagne(char [][] grille)
{
	if ( ((grille[0][0]=='X')&&(grille[0][1]=='X')&&(grille[0][2]=='X'))
           	||((grille[1][0]=='X')&&(grille[1][1]=='X')&&(grille[1][2]=='X'))
			||((grille[2][0]=='X')&&(grille[2][1]=='X')&&(grille[2][2]=='X'))	
			||((grille[0][0]=='X')&&(grille[1][0]=='X')&&(grille[2][0]=='X'))
			||((grille[0][1]=='X')&&(grille[1][1]=='X')&&(grille[2][1]=='X'))
			||((grille[0][2]=='X')&&(grille[1][2]=='X')&&(grille[2][2]=='X'))
			||((grille[0][0]=='X')&&(grille[1][1]=='X')&&(grille[2][2]=='X'))
			||((grille[0][2]=='X')&&(grille[1][1]=='X')&&(grille[2][0]=='X'))		
			)
	{
		return true;
	}
	else if (((grille[0][0]=='O')&&(grille[0][1]=='O')&&(grille[0][2]=='O'))
           	||((grille[1][0]=='O')&&(grille[1][1]=='O')&&(grille[1][2]=='O'))
			||((grille[2][0]=='O')&&(grille[2][1]=='O')&&(grille[2][2]=='O'))	
			||((grille[0][0]=='O')&&(grille[1][0]=='O')&&(grille[2][0]=='O'))
			||((grille[0][1]=='O')&&(grille[1][1]=='O')&&(grille[2][1]=='O'))
			||((grille[0][2]=='O')&&(grille[1][2]=='O')&&(grille[2][2]=='O'))
			||((grille[0][0]=='O')&&(grille[1][1]=='O')&&(grille[2][2]=='O'))
			||((grille[0][2]=='O')&&(grille[1][1]=='O')&&(grille[2][0]=='O')))
	{
		return true;
	}
	else 
	{
		return false;
	}
}
			
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int nombreDeCoupMax = 9;
	int nombreDeCoup = 0;
	int nombreDeCoupJoueur1 = 0;
	int nombreDeCoupJoeur2 = 0;
	char joueur1 = 'X';
	char joueur2 = 'O';
	//choisie aleatoirement le joueur qui commence
	int r = entierAleatoire(1,2);
	if (r == 1)
	{
		System.out.println("Le joueur 1 commence, il joue avec X ");
		System.out.println();
	}
	else
		{
		System.out.println("Le joueur 2 commence, il joue avec O ");
		System.out.println();
		}

	//creation d'une grille vide
			char [][] grille = new char [3][3];
			for (int i = 0; i < grille.length; i++)
			{
				for (int j = 0; j < grille[i].length; j++)
				{
					grille [i][j] = ' ';
				}
			}
			//boucle qui fait tourner le jeu jusqu a la victoire ou egalite
			do 
			{
				if (nombreDeCoup % 2 == 0)
				{
					if (r == 1)
					{
						System.out.println("Au tour du joueur 1 de jouer");
						System.out.println();
						int tab [] = demandeCase(grille);
						affecterValeurCaseGrille(grille, tab[0], tab[1], joueur1);
						afficherGrille(grille);
						nombreDeCoupJoueur1++;
					}
					else
					{
						System.out.println("Au tour du joueur 2 de jouer ");
						System.out.println();
						int tab [] = demandeCase(grille);
						affecterValeurCaseGrille(grille, tab[0], tab[1], joueur2);
						afficherGrille(grille);
						nombreDeCoupJoeur2++;
					}
				}
				else // nombreDeCoup % 2 != 0 
				{
					if (r == 1)
					{
						System.out.println("Au tour du joueur 2 de jouer ");
						System.out.println();
						int tab [] = demandeCase(grille);
						affecterValeurCaseGrille(grille, tab[0], tab[1], joueur2);
						afficherGrille(grille);
						nombreDeCoupJoeur2++;
					
					}
					else
					{
						System.out.println("Au tour du joueur 1 de jouer");
						System.out.println();
						int tab [] = demandeCase(grille);
						affecterValeurCaseGrille(grille, tab[0], tab[1], joueur1);
						afficherGrille(grille);
						nombreDeCoupJoueur1++;
					}
				}
				nombreDeCoup++;
			}
			while (nombreDeCoup < nombreDeCoupMax && !gagne(grille));
	
		if (gagne(grille))
		{
			if (nombreDeCoupJoeur2 < nombreDeCoupJoueur1)
			{
				System.out.println("La partie est gagne par Joeur 1");
			}
			else
			{
				System.out.println("La partie est gagne par Joueur 2");
			}	
		}
		else 
		{
			System.out.println("La partie est termine personne n'a gagne");
		}
	sc.close();
	}
}
