package P4;

import java.io.Serializable;
import java.util.Iterator;

public class AnimalList implements Iterable<Animal>, Serializable { // implement methods of Iterator
    // check the implementations please
    // First
    // part---------------------------------------------------------------------------------------------------------------

    // AnimalNode Class
    class AnimalNode {
        Animal animal;
        AnimalNode next;

        public AnimalNode(Animal A) {
            animal = A;
        }

    }

    // AnimalIterator Class
    private class AnimalIterator implements Iterator<Animal> {
        private AnimalNode currentAnimal;

        public AnimalIterator() {
            this.currentAnimal = head;
        }

        public boolean hasNext() {
            if (currentAnimal == null) {
                return false;
            } else {
                return true;
            }

        }

        public Animal next() {
            AnimalNode storeOfCurrent = currentAnimal;
            currentAnimal = currentAnimal.next;
            return storeOfCurrent.animal;
        }

    }

    // atributes
    private int size;
    private AnimalNode head;
    private AnimalNode tail;

    // methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(Animal animal) {

        AnimalNode node = new AnimalNode(animal);
        if (this.isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(Animal animal) {
        AnimalNode node = new AnimalNode(animal);
        if (this.isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;

    }

    public void add(int index, Animal animal) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(animal);

        } else if (index == size) {
            addLast(animal);
        } else {
            AnimalNode PreviousAnimalReferencer = new AnimalNode(animal);
            AnimalNode AnimalNodeToBeIntserted = new AnimalNode(animal);
            // head = PreviousAnimalReferencer;
            PreviousAnimalReferencer = head;
            for (int NodeCounter = 0; NodeCounter < index - 1; NodeCounter++) {
                PreviousAnimalReferencer = PreviousAnimalReferencer.next;
            }
            AnimalNodeToBeIntserted.next = PreviousAnimalReferencer.next;
            PreviousAnimalReferencer.next = AnimalNodeToBeIntserted;
        }
        size++;

    }

    public Animal removeFirst() {
        AnimalNode removingThisone = head;
        if (this.isEmpty()) {
            return null;
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
        size--;
        return removingThisone.animal;
    }

    public Animal removeLast() {

        if (this.isEmpty()) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            AnimalNode nodetoRemove = head;
            AnimalNode nodeStore = tail;
            for (int NodeCounter = 0; NodeCounter < size - 2; NodeCounter++) {
                nodetoRemove = nodetoRemove.next;

            }
            tail = nodetoRemove;
            tail.next = null;
            size--;
            return nodeStore.animal;

        }

    }

    public Animal remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (this.isEmpty()) {
            return null;

        } else if (index == 1) {
            return removeFirst();

        } else if (index == size) {
            return removeLast();

        } else {
            AnimalNode previousNode = head;

            for (int NodeCounter = 0; NodeCounter < size - 1; NodeCounter++) {
                previousNode = previousNode.next;

            }
            AnimalNode returnableNode = previousNode.next;
            previousNode.next = previousNode.next.next; // double check please
            size--;
            return returnableNode.animal;
        }
    }

    public Animal getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.animal;
        }

    }

    public Animal getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.animal;
        }
    }

    public Animal get(int index) {
        if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else {
            AnimalNode gettingThisOne = head;
            for (int NodeCounter = 0; NodeCounter < index; NodeCounter++) {
                gettingThisOne = gettingThisOne.next;   
            }
            return gettingThisOne.animal;
        }

    }

    public Animal set(int index, Animal animal) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (animal == null) {
            throw new NullPointerException();
        } else if (size == 0) {
            throw null;
        } else if (index == 0) {
           
        removeFirst();
        addFirst(animal);
        } else if (index == size) {
           removeLast();
           addLast(animal);
        } else {                 //could also do remove (int index) and add(int index,animal)
            AnimalNode a = head;
            AnimalNode b = new AnimalNode(animal);
            for (int NodeCounter = 0; NodeCounter < size - 1; NodeCounter++) {
                a = a.next; // stores value previous to the element i want to replace
            }
            a.next = b; // assigns the previous element with the reference of b
            b.next = a.next.next; // assigns the element that is 2 elements after the previous with the next of b
                                  // which is my new created node

        }
        return null;
    }

    public String toString() {
        AnimalNode current = head; // make sure this works later
        String animalRepresentation = "";
        while (current != null) {
            animalRepresentation += current.animal;
            current = current.next;
        }
        return animalRepresentation;
    }

    public Iterator<Animal> iterator() {
        return new AnimalIterator();
    }

    public AnimalList getHungryAnimals() {
        int count = 0;
        int index = 0;
        AnimalList a = new AnimalList();
        AnimalNode current = head;
        while (current != null) {
            if (current.animal.getEnergy() < 50) {

                a.add(index, current.animal);
                index++;
                count++;
            }
            current = current.next;
        }
        if (count == 0) {
            return null;
        }

        return a;
    }

    public AnimalList getStarvingAnimals() {
        int count = 0;
        int index = 0;
        AnimalList a = new AnimalList();
        AnimalNode current = head;
        while (current != null) {
            if (current.animal.getEnergy() < 17) {

                a.add(index, current.animal);
                index++;
                count++;
            }
            current = current.next;
        }
        if (count == 0) {
            return null;
        }

        return a;
    }

    public AnimalList getAnimalsInBarn() {
        int count = 0;
        int index = 0;
        AnimalList a = new AnimalList();
        AnimalNode current = head;
        while (current != null) {
            if (current.animal.getX() >= 450 && current.animal.getX() <= 550 && current.animal.getY() >= 50
                    && current.animal.getY() <= 150) {

                a.add(index, current.animal);
                index++;
                count++;
            }
            current = current.next;
        }
        if (count == 0) {
            return null;
        }

        return a;
    }

    public double getRequiredFood() {
        AnimalNode current = head;
        double amountOfFood = 0;

        while (current != null) {
            amountOfFood += current.animal.getMealAmount();
            current = current.next;
        }

        return amountOfFood;

    }

//     public AnimalList getByType(Class<Animal> a){
// 		String s=a.getSimpleName();
// 		String cow="Cow";
// 		String llama="Llama";
		
// 		int counter=0;
// 		AnimalList ab=new AnimalList();
// 		if(s.equals(cow) ){
// 			for (Animal b : ){
// 			if (b instanceof Cow){
				
//             ab.add(counter, b);
// 			 counter++;
// 			}
// 		}	
// 		return ab;
// 		}else if(s.equals(llama)){
//             for (Animal c : getAnimals()){
// 			if (c instanceof Llama){
// 				ab.add(counter, c);
// 				 counter++;
// 			}
// 			}
// return ab;
// 		}else{
// 			for (Animal d : getAnimals()){
// 			if (d instanceof Chicken){
// 				ab.add(counter, d);
// 				counter++;
// 			}
// 		}	
// 		return ab;
// 		}
// 	 }


}
