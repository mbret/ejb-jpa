package ejbpersistance.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DaoAbstract<C,I extends Serializable> {

    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<C> getAll() {
        throw new UnsupportedOperationException();
    }

    public C get(I id) {
        throw new UnsupportedOperationException();
    }

    public void save(C object) {
        throw new UnsupportedOperationException();
    }

    public void delete(I id) {
        throw new UnsupportedOperationException();
    }


}
