package day08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Island implements Comparable<Island> {
	private Set<Coordinate3D> parts;
	
	public Set<Coordinate3D> getParts() {
		return parts;
	}
	
	public Island() {
		parts = new HashSet<Coordinate3D>();
	}
	
	public Island(Coordinate3D c) {
		parts = new HashSet<Coordinate3D>();
		parts.add(c);
	}
	
	public Island(Island one, Island other) {
		parts = new HashSet<Coordinate3D>();
		parts.addAll(one.getParts());
		parts.addAll(other.getParts());
	}
	
	public Integer size() {
		return parts.size();
	}
	
	public Boolean contains(Coordinate3D c) {
		return parts.contains(c);
	}

	@Override
	public int compareTo(Island o) {
		// TODO Auto-generated method stub
		return size().compareTo(o.size());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Island)) return false;
		Island other = (Island)obj;
		if (size() != other.size()) return false;
		for (Iterator<Coordinate3D> i = parts.iterator(); i.hasNext();)
			if (!other.getParts().contains(i.next())) return false;
		for (Iterator<Coordinate3D> i = other.getParts().iterator(); i.hasNext();)
			if (!parts.contains(i.next())) return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 31;
		for (Iterator<Coordinate3D> i = parts.iterator(); i.hasNext();)
			hash += i.next().hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		return "Island of size "+ size();
	}
}
