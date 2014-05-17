package in.mused.api.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
public class User {

    @NotNull
    private String username;
    
    @NotNull
    private String displayname;    
    
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Boolean accountExpired;

    @NotNull
    private Boolean accountLocked;

    @NotNull
    private Boolean passwordExpired;

    @NotNull
    private Boolean enabled;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateCreated;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date lastUpdated;
    
    @GeoSpatialIndexed
    private double[] location;
    
    @NotNull
    private Set<String> roles;
    
    @NotNull
    private String type;

}
