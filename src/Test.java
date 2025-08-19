public class Test {
    public static void main(String[] args) {
        // First test - Capacity and size test
        MyList<Integer> liste = new MyList<>();
        System.out.println("Number of Elements in the Array : " + liste.size());
        System.out.println("Capacity of the Array : " + liste.getCapacity());
        
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Number of Elements in the Array : " + liste.size());
        System.out.println("Capacity of the Array : " + liste.getCapacity());
        
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Number of Elements in the Array : " + liste.size());
        System.out.println("Capacity of the Array : " + liste.getCapacity());
        
        System.out.println("-------------------");
        
        // Second test - get, remove, set operations
        MyList<Integer> liste2 = new MyList<>();
        liste2.add(10);
        liste2.add(20);
        liste2.add(30);
        System.out.println("Value at index 2 : " + liste2.get(2));
        liste2.remove(2);
        liste2.add(40);
        liste2.set(0, 100);
        System.out.println("Value at index 2 : " + liste2.get(2));
        System.out.println(liste2.toString());
        
        System.out.println("-------------------");
        
        // Third test - Additional methods
        MyList<Integer> liste3 = new MyList<>();
        System.out.println("List Status : " + (liste3.isEmpty() ? "Empty" : "Full"));
        
        liste3.add(10);
        liste3.add(20);
        liste3.add(30);
        liste3.add(40);
        liste3.add(20);
        liste3.add(50);
        liste3.add(60);
        liste3.add(70);
        
        System.out.println("List Status : " + (liste3.isEmpty() ? "Empty" : "Full"));
        
        // Returns the first index it finds
        System.out.println("Index : " + liste3.indexOf(20));
        
        // Returns -1 if not found
        System.out.println("Index : " + liste3.indexOf(100));
        
        // Returns the last index it finds
        System.out.println("Index : " + liste3.lastIndexOf(20));
        
        // Returns the list as an Object[] array
        Object[] dizi = liste3.toArray();
        System.out.println("First element of Object array : " + dizi[0]);
        
        // Creates a sublist in List data type
        MyList<Integer> altListem = liste3.subList(0, 3);
        System.out.println(altListem.toString());
        
        // Checks if the value exists in the list
        System.out.println("Value 20 in my list : " + liste3.contains(20));
        System.out.println("Value 120 in my list : " + liste3.contains(120));
        
        // Completely clears the list
        liste3.clear();
        System.out.println(liste3.toString());
    }
}
