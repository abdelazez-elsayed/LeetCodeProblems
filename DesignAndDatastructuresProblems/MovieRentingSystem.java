package solutions.DesignAndDatastructuresProblems;

import java.util.*;
import java.util.stream.Collectors;

public class MovieRentingSystem {
    final int searchLimit = 5;
    final int reportLimit = 5;


    TreeSet<Movie> rented;
    Map<Integer,Integer> prices;
    Map<Integer,TreeSet<Movie>> available;
    public MovieRentingSystem(int n, int[][] entries) {

        rented = new TreeSet<>();
        prices = new HashMap<>();
        available = new HashMap<>();
        for(int[] entry : entries){
            int shop = entry[0];
            int name = entry[1];
            int price = entry[2];

            Movie movie = new Movie(shop,name,price);
            int hash = hash(shop,name);
            prices.put(hash,price);
            available.computeIfAbsent(name,x->new TreeSet<>()).add(movie);

        }
    }

    public List<Integer> search(int name) {
        LinkedList<Integer> res = new LinkedList<>();
        if(!available.containsKey(name))return res;
        for(Movie movie: available.get(name)){
            res.add(movie.shop);
            if(res.size() ==searchLimit)break;
        }
        return res;
    }

    public void rent(int shop, int name) {
        int hash= hash(shop,name);
        int price = prices.get(hash);
        Movie toRent = new Movie(shop,name,price);
        available.get(name).remove(toRent);
        rented.add(toRent);

    }

    public void drop(int shop, int name) {
        int hash = hash(shop,name);
        int price = prices.get(hash);
        Movie toDrop = new Movie(shop,name,price);
        available.get(name).add(toDrop);
        rented.remove(toDrop);
    }

    public List<List<Integer>> report() {

        return rented.stream().limit(reportLimit).map(e -> List.of(e.shop,e.name)).collect(Collectors.toList());
    }
    class Movie implements Comparable<Movie>{
        int shop, name,price;
        Movie(int s,int i,int p){
            shop = s;
            name = i;
            price = p;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Movie movie = (Movie) o;
            return shop == movie.shop &&
                    name == movie.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop,name);
        }

        @Override
        public int compareTo(Movie o) {
            if(o.price != this.price)
                return Integer.compare(this.price, o.price);
            if(o.shop != this.shop)
                return Integer.compare(this.shop,o.shop);
            return Integer.compare(this.name,o.name);
        }
    }
    private int hash(int shop,int name){
        return Objects.hash(shop,name);
    }
}
