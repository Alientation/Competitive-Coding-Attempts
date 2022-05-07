import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhatToDo {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int testcase = console.nextInt();
		console.nextLine();
		for (; testcase > 0; testcase--) {
			String firstLine = console.nextLine();
			int C = Integer.parseInt(firstLine.substring(0, firstLine.indexOf(',')));
			int T = Integer.parseInt(firstLine.substring(firstLine.indexOf(',') + 1));
			ArrayList<Entry> list = new ArrayList<>();
			for (int i = 0; i < T; i++) {
				String[] line = console.nextLine().split(",");
				list.add(new Entry(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]),i));
			}
			Collections.sort(list);
			for (int i = 0; i < C; i++) {
				int bestPriority = Integer.MIN_VALUE;
				int bestPlace = Integer.MAX_VALUE;
				int index = -1;
				for (int j = 0; j < list.size(); j++) {
					if (i + 1 < list.get(j).timeConstraint || list.get(j).cyclesToComplete <= 0)
						continue;
					if (list.get(j).priorityLevel >= bestPriority) {
						if (list.get(j).priorityLevel != bestPriority || bestPlace > list.get(j).place) {
							bestPriority = list.get(j).priorityLevel;
							bestPlace = list.get(j).place;
							index = j;
						}
					}
				}
				if (index == -1) {
					System.out.println((i + 1)+",Wait");
					continue;
				}
				list.get(index).cyclesToComplete--;
				System.out.println((i + 1) +"," + list.get(index).name);
				if (list.get(index).cyclesToComplete <= 0)
					list.remove(index);
			}
		}
		console.close();
	}
}

class Entry implements Comparable<Entry> {
	public String name;
	public int priorityLevel, timeConstraint, cyclesToComplete, place;
	public Entry(String name, int prio, int time, int cycle, int place) {
		this.name = name;
		this.priorityLevel = prio;
		this.timeConstraint = time;
		this.cyclesToComplete = cycle;
		this.place = place;
	}
	@Override
	public int compareTo(Entry other) {
		return this.timeConstraint - other.timeConstraint;
	}
	@Override
	public String toString() {
		return name + "," + this.priorityLevel + "," + this.timeConstraint + "," + this.cyclesToComplete;
	}
}
