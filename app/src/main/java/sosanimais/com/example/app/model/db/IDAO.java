package sosanimais.com.example.app.model.db;
import sosanimais.com.example.app.model.entity.Animal;

import java.util.List;
public interface IDAO <T>{
    
     public boolean save(T entidade);
     public boolean update(T entidade);
     public boolean  delete(T entidade);
     public List<Object> getAll();
     public Animal get(int id);
     public List<T> get(String filtro);

}
