import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Searcher
{
    IndexSearcher indexSearcher;
    QueryParser queryParser;
    Query query;
    public Searcher(String indexDirectoryPath) throws IOException {
        Directory indexDirectory = FSDirectory.open(new File(indexDirectoryPath));
        indexSearcher = new IndexSearcher();
        queryParser = new QueryParser(LuceneConstants.CONTENTS,new StandardAnalyzer( Version.LUCENE_8_10_1));
    }
    public TopDocs search(String searchQuery) throws IOException, ParseException
    {
        query = queryParser(searchQuery);
        return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
    }
    public Document getDocument(ScoreDoc scoreDoc) throws CorruptIndexException, IOException
    {
        return indexSearcher.doc(scoreDoc.doc);
    }
    public void close() throws IOException
    {
        indexSearcher.close();
    }
}