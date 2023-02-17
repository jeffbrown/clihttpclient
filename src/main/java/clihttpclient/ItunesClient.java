package clihttpclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://itunes.apple.com")
public interface ItunesClient {

    @Get("/search?limit={maxResults}&media=music&entity=album&term={term}")
    SearchResult search(String term, int maxResults);
}