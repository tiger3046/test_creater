package jp.co.sss.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.sss.training.entity.Category;
import jp.co.sss.training.entity.ItemsWithCategories;

public interface ItemsWithCategoriesRepository extends JpaRepository<ItemsWithCategories, Integer> {
	List<ItemsWithCategories> findByCategory(Category category);
	
	@Query("SELECT i FROM ItemsWithCategories i WHERE i.price >= (SELECT AVG(i2.price) FROM ItemsWithCategories i2)")
	public List<ItemsWithCategories> findByPriceGreaterThanEqualAVGPriceQuery();

}
