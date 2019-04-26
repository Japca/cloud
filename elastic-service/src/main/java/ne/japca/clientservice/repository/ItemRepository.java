package ne.japca.clientservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import ne.japca.clientservice.model.Item;

/**
 * Created by Jakub krhovják on 4/26/19.
 */
@Repository
public interface ItemRepository extends ElasticsearchRepository<Item, String> {

    List<Item> findByName(String name);
}
