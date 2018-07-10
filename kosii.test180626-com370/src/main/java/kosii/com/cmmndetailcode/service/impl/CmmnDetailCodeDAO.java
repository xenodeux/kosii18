package kosii.com.cmmndetailcode.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository("CmmnDetailCodeDAO")
public class CmmnDetailCodeDAO extends EgovComAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<EgovMap> selectCmmnDetailCodeList(ComDefaultCodeVO vo) throws Exception {
		return (List<EgovMap>) list("CmmnDetailCodeDAO.selectCmmnDetailCodeList", vo);
	}

}