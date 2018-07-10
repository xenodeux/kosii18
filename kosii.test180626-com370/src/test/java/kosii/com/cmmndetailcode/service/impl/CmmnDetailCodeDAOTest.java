package kosii.com.cmmndetailcode.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
public class CmmnDetailCodeDAOTest {

	@Resource(name = "CmmnDetailCodeDAO")
	private CmmnDetailCodeDAO cmmnDetailCodeDAO;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void selectCmmnDetailCodeList() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<EgovMap> results = null;

		results = cmmnDetailCodeDAO.selectCmmnDetailCodeList(vo);

		System.out.println("results=" + results);

		for (EgovMap result : results) {
			System.out.println("result=" + result);
			System.out.println("codeId=" + result.get("codeId"));

			@SuppressWarnings("unchecked")
			List<String> keyList = result.keyList();
			System.out.println("keyList=" + keyList);
			for (String key : keyList) {
				System.out.println("key=" + key);
				System.out.println("value=" + result.get(key));
			}

			@SuppressWarnings("unchecked")
			Set<String> keySet = result.keySet();
			System.out.println("keySet=" + keySet);
			for (String key : keySet) {
				System.out.println("key=" + key);
				System.out.println("value=" + result.get(key));
			}
		}
	}

}
