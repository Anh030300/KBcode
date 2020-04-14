package main;

public class GASearch {
	public static void main(String[] args) {
		Population p = new Population();
		p.Init();
		for(int i = 0; i < Config.generationNum; i++) {
			p.Evolve();
			p.Selection();
			System.out.println("Vong lap " + i + ": Gia tri indi tot nhat x = "+ p.pop.get(0).value 
					+ "  || f(x) = " + p.pop.get(0).obj);
		}
	}
} 
