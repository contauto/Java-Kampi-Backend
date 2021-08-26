package controleng.northwind.business.abstracts;

import controleng.northwind.core.utilities.results.DataResult;
import controleng.northwind.core.utilities.results.Result;
import controleng.northwind.entities.concretes.Product;
import controleng.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> findById(int id);
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
