package ds;
	import java.time.LocalDateTime;

	public class Product {
	    private int id;
	    private String name;
	    private Double price;
	    private String category;
	    private Integer quantity;
	    private String description;
	    private String publish;
	    private LocalDateTime createdAt;

	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public Double getPrice() {
	        return price;
	    }
	    public void setPrice(Double price) {
	        this.price = price;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public void setCategory(String category) {
	        this.category = category;
	    }
	    public Integer getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    public String getPublish() {
	        return publish;
	    }
	    public void setPublish(String publish) {
	        this.publish = publish;
	    }
	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }
	    @Override
	    public String toString() {
	        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
	                + ", quantity=" + quantity + ", description=" + description + ", publish=" + publish
	                + ", createdAt=" + createdAt + "]";
	    }
	}



