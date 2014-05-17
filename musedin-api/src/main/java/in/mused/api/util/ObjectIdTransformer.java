package in.mused.api.util;

import java.lang.reflect.Type;

import org.bson.types.ObjectId;

import flexjson.ObjectBinder;
import flexjson.ObjectFactory;
import flexjson.transformer.AbstractTransformer;
import flexjson.transformer.DateTransformer;


public class ObjectIdTransformer extends AbstractTransformer implements ObjectFactory{

    public void transform(Object object) {
        getContext().writeQuoted(object.toString());
    }

	public Object instantiate(ObjectBinder context, Object value, Type targetType, Class targetClass) {
		return new ObjectId(value.toString());
	}

}
