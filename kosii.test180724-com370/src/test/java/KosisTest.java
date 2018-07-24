import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class KosisTest {

	@Test
	public void test() throws Exception {
		// fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();

		// URI url = new URI();

		String result = restTemplate.getForObject(
				"http://kosis.kr/openapi/statisticsList.do?method=getList&apiKey=ZjZjOTI3MjRjNmU1YzdhZTMwOWRjNjgxN2MzNDgwNmY=&vwCd=MT_ZTITLE&parentListId=A&format=json",
				String.class);
		System.out.println("result = " + result);
		System.out.println("result = " + new String(result.getBytes("iso-8859-1"), "utf-8"));

		String originalStr = "{LIST_NM:'ì¸êµ¬ì´ì¡°ì¬',LIST_ID:'A1',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'êµ­ë´ì¸êµ¬ì´ëíµê³',LIST_ID:'A34',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'êµ­ì ì¸êµ¬ì´ëíµê³',LIST_ID:'A31',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ë³ë¬´íµê³',LIST_ID:'144_14401',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ìëªí',LIST_ID:'A5',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì¸êµ¬ëí¥ì¡°ì¬',LIST_ID:'A2',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì¥ëê°êµ¬ì¶ê³',LIST_ID:'A42',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì¥ëì¸êµ¬ì¶ê³',LIST_ID:'A41',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì£¼ë¯¼ë±ë¡ì¸êµ¬íí©',LIST_ID:'A6',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì§ë°©ìì¹ë¨ì²´ê³µë¬´ìì¸ì¬íµê³',LIST_ID:'110_11027',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì§ë°©ìì¹ë¨ì²´ì¸êµ­ì¸ì£¼ë¯¼íí©',LIST_ID:'110_11025',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì²´ë¥ì¸êµ­ì¸íµê³',LIST_ID:'A8',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ì¶ìêµ­ìíµê³',LIST_ID:'A32',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'ê³µë¬´ìì´ì¡°ì¬',LIST_ID:'P3_110_16301_01',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'},{LIST_NM:'êµ­ê°ê³µë¬´ìì¸ì¬íµê³',LIST_ID:'P3_110_16302_01',VW_NM:'êµ­ë´íµê³ ì£¼ì ë³',VW_CD:'MT_ZTITLE'}"; // 테스트
		String[] charSet = { "utf-8", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949" };

		for (int i = 0; i < charSet.length; i++) {
			for (int j = 0; j < charSet.length; j++) {
				try {
					System.out.println("[" + charSet[i] + "," + charSet[j] + "] = "
							+ new String(originalStr.getBytes(charSet[i]), charSet[j]));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
