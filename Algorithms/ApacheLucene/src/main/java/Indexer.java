import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableFieldType;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.lucene.util.Version.LATEST;
import static org.apache.lucene.util.Version.LUCENE_8_10_1;

public class Indexer {
    private IndexWriter indexWriter;

    public Indexer(String indexDirectoryPath) throws IOException {
        Directory indexDirectory= FSDirectory.open(Path.of(indexDirectoryPath));

        indexWriter=new IndexWriter(indexDirectory,new IndexWriterConfig());

    }

    public void close() throws IOException {
        indexWriter.close();
    }


    private Document getDocument(File file) throws IOException
    {
        Document document = new Document();
        //index file contents
        Field contentField = new CusField(LuceneConstants.CONTENTS, (IndexableFieldType) new FileReader(file));
        //index file name
        Field fileNameField = new CusField(LuceneConstants.FILE_NAME,  (IndexableFieldType) new FileReader(file));
        //index file path
        Field filePathField = new CusField(LuceneConstants.FILE_NAME,  (IndexableFieldType) new FileReader(file));
        document.add(contentField);
        document.add(fileNameField);
        document.add(filePathField);
        return document;
    }



    private void indexFile(File file) throws IOException
    {
        System.out.println("Indexing "+file.getCanonicalPath());
        Document document = getDocument(file);
        indexWriter.addDocument(document);
    }
    public int createIndex(String dataDirPath, FileFilter filter) throws IOException
    {
        //get all files in the data directory
        File[] files = new File(dataDirPath).listFiles();
        for (File file : files)
        {
            if(!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead() && filter.accept(file) )
            {
                indexFile(file);
            }
        }
        return indexWriter.numRamDocs();
    }
}
