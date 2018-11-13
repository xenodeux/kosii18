package jang.com.table.web;

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
public class TableController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

	@Resource(name = "TableDAO")
	private TableDAO tableDAO;

	@RequestMapping("/table/selectTableList.do")
	public String selectList(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("목록");

		vo.setUseAt("Y");// 파라미터는 무조건 Y를 보낸다.

		List<EgovMap> results = tableDAO.selectList(vo);

		model.addAttribute("results", results);

		return "jang/com/table/selectTableList";
	}

	@RequestMapping("/table/insertTableForm.do")
	public String insertForm(TableVO vo, ModelMap model) {
		LOGGER.debug("등록폼");
		LOGGER.debug("Get TableId = " + vo.getTableId());
		LOGGER.debug("Get Multi = " + vo.getMulti());

		if ("update".equals(vo.getMulti())) {
			EgovMap select = tableDAO.select(vo);
			model.addAttribute("select", select);
			model.addAttribute("select2", tableDAO.select(vo));
		} else {

		}
		return "jang/com/table/insertTableForm";
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

	@RequestMapping("/table/updateTable.do")
	public String update(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("수정");
		LOGGER.debug("vo=" + vo);
		// LOGGER.debug("getApplcntNm=" + vo.getApplcntNm());
		System.out.println("vo=" + vo);
		// System.out.println("getApplcntNm=" + vo.getApplcntNm());

		int update = tableDAO.update(vo);

		model.addAttribute("update", update);

		return "jang/com/table/updateTable";
	}

	@RequestMapping("/table/deleteTable.do")
	public String delete(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("삭제");
		LOGGER.debug("vo=" + vo);
		LOGGER.debug("getTableId=" + vo.getTableId());
		System.out.println("vo=" + vo);
		System.out.println("getTableId=" + vo.getTableId());

		int delete = tableDAO.delete(vo);

		model.addAttribute("delete", delete);

		return "jang/com/table/deleteTable";
	}

	@RequestMapping("/table/rollbackTable.do")
	public String rollback(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("복구");
		LOGGER.debug("vo=" + vo);
		LOGGER.debug("getTableId=" + vo.getTableId());
		System.out.println("vo=" + vo);
		System.out.println("getTableId=" + vo.getTableId());

		int rollback = tableDAO.rollback(vo);

		model.addAttribute("rollback", rollback);

		return "jang/com/table/rollbackTable";
	}

	@RequestMapping("/table/delete2Table.do")
	public String delete2(TableVO vo, ModelMap model) throws Exception {
		LOGGER.debug("삭제");
		LOGGER.debug("vo=" + vo);
		LOGGER.debug("getTableId=" + vo.getTableId());
		System.out.println("vo=" + vo);
		System.out.println("getTableId=" + vo.getTableId());

		int delete = tableDAO.delete2(vo);

		model.addAttribute("delete", delete);

		return "jang/com/table/deleteTable";
	}
}
