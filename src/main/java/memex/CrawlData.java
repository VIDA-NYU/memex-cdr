package memex;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
{
    'url': <full URL of the web page>,
    'timestamp': <timestamp for data when scraped, in epoch milliseconds>,
    'team': <name of crawling team>,
    'crawler': <name of crawler; each type of crawler should have a distinct name or reference>,
    'raw_content': <full data of raw crawled page; source page that can be reproduced for system purposes (e.g. provenance, law enforce evidence)>,
    'content_type': <mime-type of data in stored in raw_content>,
    'crawl_data': <source page from crawler that extracts full text but not full layout; full-text>,
    'metadata': {
      // The output JSON of Tika parsing metadata for a given document
    },
    ‘content’: {
      // String output of Tika parsing text for a given document if applicable for that mime type
     },
    'objects': [<urls for binary objects in location that is easily accessible, e.g. S3>]
}
*/
public class CrawlData {

    private String url;
    private long timestamp;
    private String team;
    private String crawler;
    private String rawContent;
    private String contentType;
    private Object crawlData;
    private Map<String, String> metadata;
    private String content;
    private List<Object> objects;

    public CrawlData() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCrawler() {
        return crawler;
    }

    public void setCrawler(String crawler) {
        this.crawler = crawler;
    }

    @JsonProperty("raw_content")
    public String getRawContent() {
        return rawContent;
    }

    @JsonProperty("raw_content")
    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    @JsonProperty("content_type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("content_type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("crawl_data")
    public Object getCrawlData() {
        return crawlData;
    }

    @JsonProperty("crawl_data")
    public void setCrawlData(Object crawlData) {
        this.crawlData = crawlData;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
