package controleng.northwind.dataAccess.abstracts;

import controleng.northwind.entities.concretes.Product;
import controleng.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    Product findById(int id);
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    List<Product>  getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    @Query("Select new controleng.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
