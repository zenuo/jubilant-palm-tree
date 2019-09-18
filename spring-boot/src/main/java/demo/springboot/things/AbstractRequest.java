package demo.springboot.things;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractRequest<T extends IResponse> implements IRequest<T>{

    private final Class<T> entity;

    AbstractRequest() {
        Class<?> clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            entity = (Class<T>) pType.getActualTypeArguments()[0];
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Class<T> responseClass() {
        return entity;
    }
}
