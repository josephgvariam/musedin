package in.mused.api.domain;

import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
public class Activity {

    @NotNull
    private String msg;

    @NotNull
    private String code;

    @NotNull
    private String tstamp;
}
