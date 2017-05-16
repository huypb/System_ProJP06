package jsoft.j2se;

import java.util.*;

/**
 * <p>
 * Title: JP project
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author Huy
 * @version 1.0
 */
public class MyArrays {

	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		for (int i = 0; i < n; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}
		return arrInt;
	}

	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}

		return arrInt;
	}

	public static Person[] generatePerson(int n) {
		Person[] list = new Person[n]; // khoi tao kich thuoc cho bo nho

		String[] firstNames = { "Huy", "Nam", "Hoang", "Phuong Anh", "Diep", "Huyen", "Hiep", "Nhung", "Hai", "son",
				"Ngoc", "Minh", "Dat", "Huong" };

		String[] lastNames = { "Phan", "Pham", "Ta", "Nguyen", "Tran", "Ngo", "Micheal", "Torres", "Ronaldo", "Messi",
				"Xavi" };

		int index;
		for (int i = 0; i < n; i++) {
			list[i] = new Person(); // bo nho de luu tru doi tuong
			// lay ngau nhien ten
			index = (int) (Math.random() * firstNames.length);
			list[i].setFristName(firstNames[index]);

			// lay ngau nhien ho
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

			// lay ngau nhien tuoi
			index = (int) (Math.random() * 120);
			list[i].setAge((byte) index);

		}

		return list;
	}

	public static int[] orderArray(int[] arrInt, boolean isASC) {

		int ori = isASC ? 1 : -1;

		int tmp;
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * ori > arrInt[j] * ori) {
					tmp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = tmp;
				}

			}
		}
		int[] temp1 = new int[arrInt.length]; // luu nguyen to
		int[] temp2 = new int[arrInt.length]; // luu k nguyen to
		int t1 = 0, t2 = 0; // 2bien chay theo vi tri

		for (int value : arrInt) {
			if (Examples.checkElement(value)) {
				temp1[t1++] = value;
			} else {
				temp2[t2++] = value;
			}
		}
		// ghep lai
		for (int i = t1; i < temp1.length; i++) {
			temp1[i] = temp2[i - t1];
		}
		return temp1;
	}

	public static Person[] searchPerson(Person[] list, String name) {
		// Ket qua tra ve
		Person[] result = null;

		// Dem so luong ket qua
		int count = 0;
		for (Person p : list) {
			if (p.getFristName().toLowerCase().contains(name.toLowerCase())) {
				count++;
			}
		}

		result = new Person[count];// khoi tao bo nho
		count = 0;// dua count ve b\u0103ng 0

		for (Person p : list) {
			if (p.getFristName().toLowerCase().contains(name.toLowerCase())) {
				result[count++] = p;
			}
		}

		return result;
	}

	// luu ket qua tim kiem bang mang dong
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList searchPerson2(Person[] list, String name) {
		ArrayList result = new ArrayList();
		for (Person p : list) {
			if (p.getFristName().toLowerCase().contains(name.toLowerCase())) {
				result.add(p);
			}
		}

		return result;
	}

	public static void printArray(int[] arrInt) {
		/*
		 * for(int i=0;i<arrInt.length;i++){ System.out.print(arrInt[i]+" ");
		 */
		for (int value : arrInt) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void printArray(int[][] arrInt) {
		for (int[] rows : arrInt) {
			MyArrays.printArray(rows);
		}
	}

	public static void printPerson(Person[] list) {
		for (Person p : list) {
			System.out.println(p);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void printPerson(ArrayList persons) {
		Person p;

		for (int i = 0; i < persons.size(); i++) {
			p = (Person) persons.get(i);
			System.out.println(p);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// Tao mang
		// int[][] arrInt = MyArrays.generateArray(10,15);
		// in
		// MyArrays.printArray(arrInt);
		// int[] order = MyArrays.orderArray(arrInt, true);
		// MyArrays.printArray(order);

		Person[] list = MyArrays.generatePerson(20);
		MyArrays.printPerson(list);

		System.out.println("********************************************");

		// tim kiem
		// Person[] result = MyArrays.searchPerson(list, "huy");
		ArrayList result = MyArrays.searchPerson2(list, "huy");
		MyArrays.printPerson(result);

	}
}
