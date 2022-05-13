import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class HelloJsoup {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://outerity.com/").get();


		Elements image = doc.getElementsByClass("img");
		Elements pngs = doc.select("img");
		System.out.println(pngs.attr("data-src"));
		
//		for (String Str : pngs.attr("data-src")) {
//			
//		}
		List<String> imgUrl = new ArrayList<String>();
		for (Element element : pngs) {
			if (!element.attr("data-src").equals(""))
				System.out.println(element.attr("data-src"));
			imgUrl.add(element.attr("data-src"));
		}

		
//		Element imageElement = doc.select("img").first();
//
//		String absoluteUrl = imageElement.absUrl("src"); // absolute URL on src
//		System.out.println(absoluteUrl);
//
//		String srcValue = imageElement.attr("src"); // exact content value of the attribute.
//		System.out.println(srcValue);
//		System.out.println("Title : " + title);
		
		InputStream input = new URL("https://fumart.vn/json/").openStream();
		Reader reader = new InputStreamReader(input, "UTF-8");
		Data data = new Gson().fromJson(reader, Data.class);
		System.out.println(data);
		
	}
}