package jang.com.table2.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import jang.com.table.service.TableVO;
import jang.com.table.service.impl.TableDAO;

@Controller
public class Table2Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(Table2Controller.class);

	@Resource(name = "TableDAO")
	private TableDAO tableDAO;

	@RequestMapping("/table/selectTableList.do")
	public String selectList(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("목록");

		List<EgovMap> results = tableDAO.selectList(vo);

		model.addAttribute("results", results);

		return "jang/com/table/selectTableList";
	}

	// @RequestMapping("/table2/selectTable2List.do")

	// public String selectList(TableVO vo, ModelMap model) throws Exception {
	// LOGGER.debug("목록");
	//
	// List<EgovMap> results = tableDAO.selectList(vo);
	//
	// model.addAttribute("results", results);
	//
	// return "jang/com/table2/selectTable2List";
	// }

	@RequestMapping("/table/insertTableForm.do")
	public String insertForm(ModelMap model) {
		LOGGER.debug("등록폼");
		return "jang/com/table/insertTableForm";
	}

	@RequestMapping("/table2/insertTable2Form.do")
	public String insertForm(ModelMap model) {
		LOGGER.debug("등록폼");
		return "jang/com/table2/insertTable2Form";
	}

	@RequestMapping("/table/insertTable.do")
	public String insert(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("등록");
		LOGGER.debug("vo=" + vo);
		// LOGGER.debug("getApplcntNm=" + vo.getApplcntNm());
		System.out.println("vo=" + vo);
		// System.out.println("getApplcntNm=" + vo.getApplcntNm());

		tableDAO.insert(vo);

		return "jang/com/table/insertTable";
	}

	@RequestMapping("/table2/insertTable2.do")
	public String insert(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("등록");
		LOGGER.debug("vo=" + vo);
		// LOGGER.debug("getApplcntNm=" + vo.getApplcntNm());
		System.out.println("vo=" + vo);
		// System.out.println("getApplcntNm=" + vo.getApplcntNm());

		tableDAO.insert(vo);

		return "jang/com/table2/insertTable2";
	}

}
