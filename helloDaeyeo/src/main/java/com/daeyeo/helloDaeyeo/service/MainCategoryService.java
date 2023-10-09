package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.entity.MainCategory;
import com.daeyeo.helloDaeyeo.exception.MainAlreadyExistsException;
import com.daeyeo.helloDaeyeo.exception.NotFoundMainCategoryException;
import com.daeyeo.helloDaeyeo.mapper.MainCategoryMapper;
import com.daeyeo.helloDaeyeo.repository.MainCategoryRepository;
import com.daeyeo.helloDaeyeo.utils.StreamUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MainCategoryService {
    private  final MainCategoryRepository mainCategoryRepository;
    private final MainCategoryMapper mapper;

    /***
     * 테스트 완료
     * @param mainId
     */
    public void insertMain(String mainId) {
        if (mainCategoryRepository.findById(mainId).isPresent()) {
            throw new MainAlreadyExistsException("메인카테고리가 이미 존재합니다!");
        } else {
            MainCategory mainCategory = new MainCategory(mainId);
            mainCategoryRepository.save(mainCategory);
        }
    }

    public void updateMain(String findMain, String updateMain) {
        Optional<MainCategory> mainCategory = mainCategoryRepository.findById(findMain);
        if (mainCategory.isPresent()) {
            mainCategory.get().setMcId(updateMain);
            mainCategoryRepository.save(mainCategory.get());
        } else {
            throw new NotFoundMainCategoryException("찾으려고 하는 메인카테고리가 없습니다.");
        }
    }

    /***
     * 메인 카테고리를 삭제하기위해서 연관된 서브 카테고리도 삭제해야한다
     * 서브카테고리를 삭제하고 메인카테고리를 삭제하자
     * @param mainId
     */
    public void deleteMain(String mainId) {

    }

    public List<MainCategoryDto> getAllCategories() {
        return mapper.toDtoList(mainCategoryRepository.findAll());
    }
}
