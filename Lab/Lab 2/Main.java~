import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int noOfCruises = scan.nextInt();

		Loader[] loaders = {new Loader(1), new Loader(2), new Loader(3), new Loader(4), 
			new Loader(5), new Loader(6), new Loader(7), new Loader(8), new Loader(9)};
		Cruise[] cruises = new Cruise [noOfCruises];
		int[] loadersNeeded = new int [noOfCruises];

		for(int i = 0; i < noOfCruises; i++) {
			String identifier = scan.next();
			if(identifier.charAt(0) == 'S') {
				cruises[i] = new SmallCruise(identifier, scan.nextInt());
				loadersNeeded[i] = 1;
			}else {
				cruises[i] = new BigCruise(identifier, scan.nextInt(), scan.nextInt(), scan.nextInt());
				loadersNeeded[i] = cruises[i].loaders;

			}
		}

		for(int i = 0; i < noOfCruises; i++) {
			int loadersLeft = loadersNeeded[i];

			for(int j = 0; j < 9; j++) {
				if(loaders[j].canServe(cruises[i])) {
					loaders[j] = loaders[j].serve(cruises[i]);
					System.out.println(loaders[j]);
					loadersLeft -= 1;
				}
				if(loadersLeft == 0){
					break;
				}

			}
		}
	}

}
