package P4;
//The reasoning behind deletling the following is due to the fact that the objects in Animal List i.e Cow,Chicken and Lllama are not Serialisable so it will give

//an error since we have deleted it rather than going to the part of the method in the method that it woudl preform if the file exists it would instead just add
//and therefore avoid that error the file must not exist and get deleted or it would will throw new NotSerializableException();

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//this class is similar to P3 but has more code for testing
public class FarmTest {

	public static void main(String[] args) throws CloneNotSupportedException, IOException {

		Farm myFarm = new Farm("stat.dat");
		myFarm.getAnimals().addFirst(new Cow());
		myFarm.getAnimals().addLast(new Cow());
		myFarm.getAnimals().add(2, new Cow());
		Animal temp = myFarm.getAnimals().removeFirst();
		System.out.println("removed " + temp.getName());
		myFarm.getAnimals().set(0, new Llama());
		// you may want to test other linked list methods here

		for (Animal a : myFarm.getAnimals())
			a.setEnergy(10 + Math.random() * 90);
		System.out.printf("\nAvailable food before feeding: %.2f\n",
				myFarm.getAvailableFood());
		System.out.println("\nInitial list of animals:\n-------------------------");
		myFarm.printAnimals();
		System.out.println("Adding a clone of the second animal\n----------------");
		myFarm.addClone(myFarm.getAnimals().get(1)); // change
		myFarm.printAnimals();
		System.out.println("List of starving animals:\n------------");
		System.out.println(myFarm.getAnimals().getStarvingAnimals());
		System.out.println("List of hungry animals:\n------------");
		System.out.println(myFarm.getAnimals().getHungryAnimals());
		System.out.printf("Amount of food needed to feed all animals: %.2f\n", myFarm.getAnimals().getRequiredFood());
		System.out.println("\nFeeding animals:\n--------------");
		myFarm.feedAnimals();
		System.out.printf("\nAvailable food after feeding: %.2f\n",
				myFarm.getAvailableFood());
		System.out.println("\nFarm summary:\n--------------");
		myFarm.printSummary();

		myFarm.exit("stat.dat");
		Path a = Paths.get("stat.dat");
		Files.delete(a);
	}

}
