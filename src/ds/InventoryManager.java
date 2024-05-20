package ds;
	import java.time.LocalDateTime;
	import java.util.*;

	public class InventoryManager {

	    private List<Product> productList = new ArrayList<>();
	    private Map<Integer, Product> productMap = new HashMap<>();
	    private PriorityQueue<Product> lowStockProducts = new PriorityQueue<>(Comparator.comparingInt(Product::getQuantity));
	    private int idCounter = 1000;

	    public void createProduct(String name, Double price, String category, Integer quantity, String description, String publish) {
	        int id = idCounter++;
	        Product product = new Product();
	        product.setId(id);
	        product.setName(name);
	        product.setPrice(price);
	        product.setCategory(category);
	        product.setQuantity(quantity);
	        product.setDescription(description);
	        product.setPublish(publish);
	        product.setCreatedAt(LocalDateTime.now());

	        productList.add(product);
	        productMap.put(id, product);
	        if (quantity < 10) {
	            lowStockProducts.add(product);
	        }
	        System.out.println("Product added: " + product);
	    }

	    public List<Product> getAllProducts() {
	        System.out.println("Displaying all products:");
	        for (Product product : productList) {
	            System.out.println(product);
	        }
	        return productList;
	    }

	    public void generateLowStockNotification(int limit) {
	        System.out.println("Low stock notifications:");
	        for (Product product : lowStockProducts) {
	            if (product.getQuantity() < limit) {
	                System.out.println("Low stock notification: " + product.getName() + " (Category: "
	                        + product.getCategory() + ", " + "Stock: " + product.getQuantity() + ")");
	            }
	        }
	    }

	    public void updateStock(int id, int quantity) {
	        Product product = productMap.get(id);
	        if (product != null) {
	            product.setQuantity(product.getQuantity() + quantity);
	            if (product.getQuantity() < 10) {
	                lowStockProducts.add(product);
	            } else {
	                lowStockProducts.remove(product);
	            }
	            System.out.println("Stock updated: " + product);
	        } else {
	            System.out.println("Product with ID " + id + " not found.");
	        }
	    }

	    public void placeOrder(int id, int order) {
	        Product product = productMap.get(id);
	        if (product != null) {
	            if (order > product.getQuantity()) {
	                System.out.println("You cannot make this order as we have low stock for this product.");
	            } else {
	                product.setQuantity(product.getQuantity() - order);
	                if (product.getQuantity() < 10) {
	                    lowStockProducts.add(product);
	                } else {
	                    lowStockProducts.remove(product);
	                }
	                System.out.println("Order placed: " + product);
	            }
	        } else {
	            System.out.println("Product with ID " + id + " not found.");
	        }
	    }

}
