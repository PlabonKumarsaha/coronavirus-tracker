package com.pks.coronavirustracker.service;

import com.pks.coronavirustracker.models.LocationStat;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;


import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {


    private String VIRUS_DATA_URL = "raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStat> allStats = new ArrayList<>();
//exceute this method after a service is done calling
    @PostConstruct
    //used to make cronoci expression..like time delay..if you put every sceond then this method
    //will run every second..putting 1 in 3rd position means it will refresh everyday
    @Scheduled(cron =" * * 1 * * *" )
    public void fetchVirusData() throws Exception{

        List<LocationStat> newStats = new ArrayList<>();

        //creating a request for client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        //sending the request
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(httpResponse.body());

    //reading something
        Reader in = new FileReader("path/to/file.csv");
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {

            LocationStat locationStat = new LocationStat();

            locationStat.setState(record.get("Provinces/State"));
            locationStat.setState(record.get("Provinces/State"));
            locationStat.setLatestTotalcases(Integer.parseInt(record.get(record.size() - 1)));

            System.out.println(locationStat);
            newStats.add(locationStat);

        }

        this.allStats = newStats;

    }
}
