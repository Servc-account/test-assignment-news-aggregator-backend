# News Aggregator Backend

A minimal Spring Boot application for aggregating news from multiple sources.

## Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included wrapper)

## Quick Start

1. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or if mvnw doesn't work:
   ```bash
   mvn spring-boot:run
   ```

2. **The application will start on port 5000**
   - API: http://localhost:5000/api/news
   - H2 Console: http://localhost:5000/h2-console

## H2 Database Console Access (if needed)

**IMPORTANT**: The Spring Boot application must be running before accessing H2 console!

1. Navigate to: http://localhost:5000/h2-console
2. Use these **exact** connection settings:
   - **Saved Settings**: Generic H2 (Embedded)
   - **Driver Class**: `org.h2.Driver`
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (leave empty)
3. Click "Connect"

## API Endpoints

- `GET /api/news` - Get all news articles
- `POST /api/news` - Create a new news article

## Project Structure

```
src/main/java/com/newsaggregator/
├── NewsAggregatorApplication.java     # Main application class
├── controller/
│   └── NewsController.java           # REST API endpoints
├── entity/
│   └── News.java                     # News entity
├── repository/
│   └── NewsRepository.java          # Data access layer
├── service/
│   ├── NewsService.java             # Business logic interface
│   ├── NewsAggregatorService.java   # Scheduled news aggregation interface
│   └── impl/
│       ├── NewsServiceImpl.java     # Business logic implementation
│       └── NewsAggregatorServiceImpl.java # Scheduled news aggregation implementation
├── dto/
│   └── NewsDto.java                 # Data transfer object
└── config/
    └── WebConfig.java               # CORS configuration
```

## Your Task

Implement news aggregation in `NewsAggregatorServiceImpl.java`:

1. **API Integration**: Implement `fetchNewsFromApi()` method
   - Choose a news API (https://site.financialmodelingprep.com/developer/docs/fmp-articles-api as an option)
   - Fetch news every 2 hours
   - Parse response and save only new articles

2. **Web Scraping**: Implement `fetchNewsFromWebScraper()` method
   - Choose a VC news website to scrape
   - Extract article data (title, description, URL, published date, etc.)
   - Save only new articles

## Tips

- The scheduled job runs every 2 hours using cron expression `@Scheduled(cron = "0 0 */2 * * ?")`
- Implement your own logic to save news articles and prevent duplicates
- Handle errors gracefully and add logging
- Follow the interface/implementation pattern used in the project

## Database

- Uses H2 in-memory database (data resets on restart)
- There is an existing News table schema, but you can modify it if needed.