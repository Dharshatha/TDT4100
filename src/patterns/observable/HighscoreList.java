package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList{
	private List<Integer> HighscoreList = new ArrayList<>();
	private List<HighscoreListListener> Lyttere = new ArrayList<HighscoreListListener>();
	private int maxint; 
	
	public HighscoreList(int max_elementer) {
		this.maxint = max_elementer;
	}
	
	public Integer size() {
		return this.HighscoreList.size();
	}
	
	
	public int getElement(int tall) {
		return this.HighscoreList.get(tall);
	}
	
	public void addResult(Integer result) {
		int pos = 0;
		while (pos < size() && result >= this.HighscoreList.get(pos)) {
			pos++;
		}
		addElement(pos, result);
	}
	
	public void addElement(int pos, int element) {
		if (pos < this.maxint) {
			while (size() >= this.maxint) {
				this.HighscoreList.remove((size() - 1));
			}
			this.HighscoreList.add(pos, element);
			this.alertLyttere(pos);
		}
	}


	
	public void addHighscoreListListener(HighscoreListListener Lytter) {
		if(!this.Lyttere.contains(Lytter)) {
			this.Lyttere.add(Lytter);
		}
		else {
			throw new IllegalArgumentException("Du kan ikke legge til en lytter som allerede eksisterer");
		}
		
	}
	public void removeHighscoreListListener(HighscoreListListener Lytter) {
		if(this.Lyttere.contains(Lytter)) {
			this.Lyttere.remove(Lytter);
		}
		else {
			throw new IllegalArgumentException("Du kan ikke fjerne en lytter som ikke eksisterer");
		}
	}
	
	public void alertLyttere(int index){
		for(HighscoreListListener lytter: this.Lyttere) {
			lytter.listChanged(this, index);
		}
	}


	
	

}
