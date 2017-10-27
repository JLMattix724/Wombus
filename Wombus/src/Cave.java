


import java.io.*;
import java.util.*;
public class Cave
{
	File gameFile = new File("Layout");
	private CaveLayout[] caves;
	private CaveLayout currentcave;
	private boolean alive = false;

	public void readCave() throws FileNotFoundException
	{
		Scanner input = new Scanner(gameFile);
		int numberofcaves = input.nextInt();
		this.caves = new CaveLayout[numberofcaves];
		for(int i = 1; i <= numberofcaves; i++)
		{
			int cavenumber = input.nextInt();
			int adjacent1 = input.nextInt();
			int adjacent2 = input.nextInt();
			int adjacent3 = input.nextInt();
			this.caves[numberofcaves] = new CaveLayout(cavenumber, adjacent1, adjacent2, adjacent3);
			input.close();
		}	
			this.alive = true;
			this.currentcave =this.caves[0];
			this.currentcave.BeenVisited();
	}

	public void getFile() throws FileNotFoundException
	{
		Scanner s = new Scanner(gameFile);
		while(s.hasNext())
		{
			String result = s.nextLine();
			System.out.println(result);
		}
		s.close();
	}
	public String playerMove(int rooms)
	{
		this.currentcave = this.caves[this.currentcave.getAdjacentnum(rooms)];
		this.currentcave.BeenVisited();
		return "OK";
	}
	public String shootArrow()
	{
		this.adjacentcave = CaveNumber;
	}
	public String currentLocation()
	{
		String message = "You are now in" + this.currentcave.getCaveNumber();
		for(int i = 0; i < 3; i++)
		{
			CaveLayout adjacentcave = this.caves[this.currentcave.getAdjacentnum(1)];
			if((boolean) adjacentcave.BeenVisited())
			{
				message += "/n (" + i + ") " + adjacentcave.getCaveNumber();
			}
		}
		return message;
	}
	
	public boolean stillAlive()
	{
		return this.alive;
	}
	
	public boolean hasWumpus()
	{
		return true;
	}
}
