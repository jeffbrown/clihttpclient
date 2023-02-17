package clihttpclient;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "clihttpclient", description = "...",
        mixinStandardHelpOptions = true)
public class ClihttpclientCommand implements Runnable {

    @Option(names = {"-s", "--search"}, description = "Search Term")
    String searchTerm;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(ClihttpclientCommand.class, args);
    }

    @Inject
    ItunesClient itunesClient;
    public void run() {
        SearchResult results = itunesClient.search(searchTerm, 10);
        results.getResults().stream().forEach(System.out::println);
    }
}
