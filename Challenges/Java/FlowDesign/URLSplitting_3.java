package grossmann.tim.FlowDesign;

import java.util.HashMap;
import java.util.Map;

public class URLSplitting_3 {

	public static void main(String[] args) {
		String url = args[0];

		Map<String, String> urlMap = splitURL(url);

		printOut(urlMap);

	}

	private static void printOut(Map<String, String> urlMap) {
		System.out.println("Protokoll:" + urlMap.get("Protocol"));
		System.out.println("Domäne:" + urlMap.get("Domain"));
		System.out.println("Pfad:" + urlMap.get("Path"));
	}

	private static Map<String, String> splitURL(String url) {

		Map<String, String> urlMap = new HashMap<>();

		urlMap.put("Protocol", parseProtocol(url));
		urlMap.put("Domain", parseDomain(url));
		urlMap.put("Path", parsePath(url));

		return urlMap;
	}

	private static String parsePath(String url) {

		String[] parts = url.split("//")[1].split("/");
		String path = "";

		for (int i = 1; i < parts.length; i++) {
			path += "/" + parts[i];
		}

		if (!path.equals("")) {
			path += "/";
		}

		return path;
	}

	private static String parseDomain(String url) {
		return url.split("//")[1].split("/")[0];
	}

	private static String parseProtocol(String url) {
		return url.split("://")[0];
	}

}
