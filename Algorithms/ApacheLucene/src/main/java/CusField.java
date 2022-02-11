import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexableFieldType;

public class CusField extends Field {
    protected CusField(String name, IndexableFieldType type) {
        super(name, type);
    }
}
