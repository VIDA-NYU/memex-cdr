# Crawl Data Repository (CDR) Implementation

## Introduction

This is a implementation for the Memex CDR schema.
This implementation provides:
- A class for representation of the CDR schema
- Default metadata and content extractions using Apache Tika
- A builder class for CDR objects with validation
- JSON serialization of objects

## Use cases

- Use in production for generation and serialization of objects
- Extraction of default metadata and textual content
- Validation of objects generated by third part implementations

## API usage

### Creating a CDR document

```java
CDRDocumentBuilder builder = new CDRDocumentBuilder();

builder.withUrl("http://www.darpa.mil/program/memex")
       .withRawContent("<html><head><title>Sample title</title></head><body>Original text</body></html>")
       .withContentType("text/html")
       .withCrawler("memex-crawler")
       .withTeam("DARPA")
       .withTimestamp(new Date().getTime());

// A object to acccess CDR document fields
CDRDocument doc = builder.build();

// A object already serialized in JSON format       
String json = builder.buildAsJson();
```

The output variable `json` will contain a JSON representation for valid CDR object, including metadata and textual content extracted.

Sample output in JSON format:

```json
{
  "url": "http://www.darpa.mil/program/memex",
  "timestamp": 1457053240762,
  "team": "DARPA",
  "crawler": "memex-crawler",
  "raw_content": "<html><head><title>Sample title</title></head><body>Original text</body></html>",
  "content_type": "text/html",
  "crawl_data": null,
  "extracted_metadata": {
    "X-Parsed-By": "org.apache.tika.parser.DefaultParser",
    "dc:title": "Sample title",
    "Content-Encoding": "ISO-8859-1",
    "title": "Sample title",
    "Content-Type": "text/html; charset=ISO-8859-1"
  },
  "extracted_text": "Original text"
}
```
