package fr.talabard.instalike.model;

/**
 * Created by jerem on 31/03/2017.
 */
public class TestResponse {

    public final String body;
    public final int status;

    public TestResponse(int status, String body) {
        this.status = status;
        this.body = body;
    }
}
