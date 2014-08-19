package com.mindviewinc.chapter11.exercise;

import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class Ex32 extends PetSequence implements Iterable<Pet>{
	public Iterator<Pet> iterator() {			//ʵ��һ������Collection���ⲿ��ʱ��ʹ��Iterator�ͻ��÷ǳ�������
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public Iterable<Pet> reversed() {			//Iterable����Iterator
		return new Iterable<Pet>() {			
			public Iterator<Pet> iterator() {
				return new Iterator<Pet>() {
					int index = pets.length - 1;
					public Pet next() {
						return pets[index--];
					}
					public boolean hasNext() {
						return index >= 0;
					}
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public static void main(String[] args) {
		Ex32 ex = new Ex32();
		for (Pet pet : ex.reversed()) {//����foreach����
			System.out.println(pet);
		}
		for (Pet pet : ex) {
			System.out.println(pet);
		}
	}
}
