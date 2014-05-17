package in.mused.api.domain;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Song.class, transactional = false)
public class SongIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
