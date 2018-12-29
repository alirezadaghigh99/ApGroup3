package Model.OnMaps;

import Model.Animals.Animal;
import Model.Products.Product;

import java.util.ArrayList;

public class Cell {
   private ArrayList<Animal> cellAnimals = new ArrayList<>();
   private ArrayList<Product> cellProducts = new ArrayList<>();
   private Grass grass = new Grass();
   public ArrayList<Animal> getCellAnimals() {
      return cellAnimals;
   }

   public void addCellAnimals(Animal animal) {
      this.cellAnimals.add(animal);
   }

   public ArrayList<Product> getCellProducts() {
      return cellProducts;
   }

   public void addCellProducts(Product product) {
      this.cellProducts.add(product);
   }

   public Grass getGrass() {
      return grass;
   }

}


