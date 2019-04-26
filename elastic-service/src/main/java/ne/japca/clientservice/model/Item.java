package ne.japca.clientservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Jakub krhovják on 4/26/19.
 */
@Data
@Accessors(chain = true)
@Document(indexName = "items", type = "data")
public class Item {

    @Id
    private String id;

    private String name;

}
