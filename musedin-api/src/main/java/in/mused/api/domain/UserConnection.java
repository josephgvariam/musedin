package in.mused.api.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
@Document(collection = "connections")
@CompoundIndexes({
	@CompoundIndex(name = "connections_rank_idx", def = "{'userId': 1, 'providerId': 1, 'rank': 1}", unique = true),
	@CompoundIndex(name = "connections_primary_idx", def = "{'userId': 1, 'providerId': 1, 'providerUserId': 1}", unique = true)
})
public class UserConnection {

    @NotNull
    private String userId;

    @NotNull
    private String providerId;

    private String providerUserId;

    @Min(1L)
    @Max(9999L)
    private int rank;

    private String displayName;

    private String profileUrl;

    private String imageUrl;

    @NotNull
    private String accessToken;

    private String secret;

    private String refreshToken;

    private Long expireTime;
}
