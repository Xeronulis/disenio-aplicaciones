package utils;

import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ColorsUtils {
	
	
	
	public static final Map<String, Color> COLORS;
		static {
			Map<String, Color> temp  = new HashMap<String, Color>();
			temp.put("itemPressed", new Color(10, 11, 28));
			temp.put("menuLineSlctd",new Color(148, 56, 49));
			temp.put("background", new Color(16, 17, 42));
			temp.put("itemHover", new Color(64, 63, 112));
			temp.put("menuHide", new Color(38, 38, 73));
			temp.put("alpha", new Color(16, 15, 36));
			temp.put("txtbackground", new Color(16, 15, 36));
			temp.put("scrollBarThumb", new Color(80, 76, 156));
			COLORS = Collections.unmodifiableMap(temp);
		}
	
	
}
