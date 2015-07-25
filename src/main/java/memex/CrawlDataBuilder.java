package memex;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrawlDataBuilder {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    private CrawlData data = new CrawlData();

    public CrawlDataBuilder withUrl(String url) {
        data.setUrl(url);
        return this;
    }

    public CrawlDataBuilder withTimestamp(long timestamp) {
        data.setTimestamp(timestamp);
        return this;
    }

    public CrawlDataBuilder withTeam(String team) {
        data.setTeam(team);
        return this;
    }

    public CrawlDataBuilder withCrawler(String crawler) {
        data.setCrawler(crawler);
        return this;
    }

    public CrawlDataBuilder withRawContent(String rawContent) {
        data.setRawContent(rawContent);
        return this;
    }

    public CrawlDataBuilder withContentType(String contentType) {
        data.setContentType(contentType);
        return this;
    }

    public CrawlDataBuilder withCrawlData(Object crawlData) {
        data.setCrawlData(crawlData);
        return this;
    }

    public CrawlDataBuilder withMetadata(Map<String, String> metadata) {
        data.setMetadata(metadata);
        return this;
    }

    public CrawlDataBuilder withContent(String content) {
        data.setContent(content);
        return this;
    }

    public CrawlDataBuilder withObjects(List<Object> objects) {
        data.setObjects(objects);
        return this;
    }

    public CrawlData build() {

        if (data.getUrl() == null) {
            throw new IllegalArgumentException("Field 'url' is mandatory");
        }
        if (data.getRawContent() == null) {
            throw new IllegalArgumentException("Field 'raw_content' is mandatory");
        }
        if (data.getCrawler() == null) {
            throw new IllegalArgumentException("Field 'crawler' is mandatory");
        }
        if (data.getTeam() == null) {
            throw new IllegalArgumentException("Field 'team' is mandatory");
        }
        if (data.getTimestamp() == 0) {
            throw new IllegalArgumentException("Field 'timestamp' is mandatory");
        }

        TikaExtractor extractor = null;
        if (data.getMetadata() == null || data.getContent() == null) {
            extractor = new TikaExtractor(data.getRawContent());
        }
        if (data.getMetadata() == null && extractor != null) {
            data.setMetadata(extractor.getMetadata());
        }
        if (data.getContent() == null && extractor != null) {
            data.setContent(extractor.getPlainText());
        }

        return data;
    }

    public String buildAsJson() throws JsonProcessingException {
        return jsonMapper.writeValueAsString(this.build());
    }

    public static void main(String[] args) {
        CrawlData data = new CrawlData();
        data.setContent("Text extracted sin");
    }

}
