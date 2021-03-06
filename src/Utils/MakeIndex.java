package Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.gosen.GosenAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import Beans.ItemBean;
import Constants.AppConstants;

public class MakeIndex {

	public void makeIndexFromText(String url, String title, String article)
			throws IOException {
		if (url != null && title != null && article != null && !url.equals("")
				&& !article.equals("") && !title.equals("")&&!title.equals("null")) {
			Directory dir = FSDirectory.open(new File(AppConstants.INDEX_PATH));
			Analyzer analyzer = new GosenAnalyzer(Version.LUCENE_4_9);
			IndexWriterConfig iws = new IndexWriterConfig(Version.LUCENE_4_9,
					analyzer);
			iws.setOpenMode(OpenMode.CREATE_OR_APPEND);
			IndexWriter writer = new IndexWriter(dir, iws);
			Document doc = new Document();
			doc.add(new StoredField("url", url));
			doc.add(new TextField("title", title,Store.YES));
			doc.add(new TextField("article", article, Store.YES));
			writer.addDocument(doc);
			writer.close();
			dir.close();
		}
	}

	/**
	 * 
	 * @param itemList
	 * @param path
	 * @throws IOException
	 */
	public void makeIndexFromBeanList(List<ItemBean> itemList)
			throws IOException {
		// make a new, empty document
		for (ItemBean item : itemList) {
			makeIndexFromText(item.getUrl(), item.getTitle(), item.getArticle());
		}
		Util.l("インデックス作成完了");
	}

}
