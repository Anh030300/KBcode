package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Population {
	public ArrayList<Individual> pop = new ArrayList<Individual>();

	// buoc 1
	public void Init() {
		Random r = new Random();
		for (int i = 0; i < Config.popSize; i++) {
			pop.add(new Individual(r.nextInt((int) Math.pow(2, Config.indiSize))));
		}
	}

	public void Evolve() {
		//System.out.println(pop.size());
		Random r = new Random();
		int numCross = (int) (pop.size() * Config.rCross);
		int numMuta = (int) (pop.size() * Config.rMuta);
		
		

		// cross
		for (int i = 0; i < numCross; i++) {
			Individual cha = pop.get(r.nextInt(pop.size()));
			Individual me = pop.get(r.nextInt(pop.size()));
			while (me == cha)
				me = pop.get(r.nextInt(pop.size()));

			Individual con = new Individual((me.value + cha.value) / 2);
			pop.add(con);
		}

		// muta
		for (int i = 0; i < numMuta; i++) {
			Individual indi = pop.get(r.nextInt(pop.size()));
			int[] temp = indi.binaryVal.clone();
			int index = r.nextInt(temp.length);
			if (temp[index] == 0)
				temp[index] = 1;
			if (temp[index] == 1)
				temp[index] = 0;
			pop.add(new Individual(temp));
		}
		//System.out.println(pop.size());
	}

	public void Selection() {
		pop.sort(new Comparator<Individual>() {
			@Override
			public int compare(Individual ind1, Individual ind2) {
				double diff = ind1.obj - ind2.obj;
				return diff < 0 ? 1 : diff > 0 ? -1 : 0;
			}
		});
		
		while(pop.size()> Config.popSize) {
			pop.remove(pop.size()-1);
		}
	}

}
