package com.example.teamprojeect.service;

import com.example.teamprojeect.domain.dao.show.ShowDAO;
import com.example.teamprojeect.domain.dao.show.ShowFileDAO;
import com.example.teamprojeect.domain.dao.show.ShowReplyDAO;
import com.example.teamprojeect.domain.vo.list.ListDTO;
import com.example.teamprojeect.domain.vo.paging.Criteria;
import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.domain.vo.show.ShowReplyVO;
import com.example.teamprojeect.domain.vo.show.ShowVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowDAO showDAO;
    private final ShowFileDAO showFileDAO;
    private final ShowFileVO showFileVO;
    private final ShowReplyDAO showReplyDAO;

    @Transactional(rollbackFor = Exception.class)
    public void register(ShowVO showVO) {
        showDAO.register(showVO);
        showFileVO.setShowNumber(showVO.getShowNumber());
        showFileDAO.register(showFileVO);
    }

    public boolean modify(ShowVO showVO) {
        return showDAO.modify(showVO);
    }

    public boolean remove(Long showNumber) {
        return showDAO.remove(showNumber);
    }

    public List<ShowVO> getList(Criteria criteria, ListDTO listDTO) {
        return showDAO.getList(criteria, listDTO);
    }

    public List<ShowVO> getListIng(Criteria criteria, ListDTO listDTO) {
        return  showDAO.getListIng(criteria, listDTO);
    }

    public int getTotal(ListDTO listDTO) {
        return showDAO.getTotal(listDTO);
    }

    public int getTotalIng(ListDTO listDTO) {
        return showDAO.getTotalIng(listDTO);
    }

    public ShowVO read(Long showNumber) {
        return showDAO.read(showNumber);
    }


    public void registerReply(ShowReplyVO showReplyVO) {
        showReplyDAO.register(showReplyVO);
    }

    public boolean modifyReply(ShowReplyVO showReplyVO) {
        return showReplyDAO.modify(showReplyVO);
    }

    public boolean removeReply(Long replyNumber) {
        return showReplyDAO.remove(replyNumber);
    }

    public int getTotalReply(Long showNumber) {
        return showReplyDAO.getTotal(showNumber);
    }

    public List<ShowReplyVO> getListReply(Criteria criteria, Long showNumber) {
        return  showReplyDAO.getList(criteria, showNumber);
    }
}
