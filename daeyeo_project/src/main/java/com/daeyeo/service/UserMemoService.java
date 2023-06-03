package com.daeyeo.service;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.entity.UserMemo;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userMemoService")
@Transactional
public class UserMemoService {
    @Autowired
    UserRepository userRepository;
    // ==================== 메모 관련 메서드 시작 ====================
    // 유저 엔티티를 통해 유저 메모를 추가하는 메서드
    public void insertUserMemo(String email, String content) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        UserMemo newMemo = new UserMemo(content);
        user.addMemoToUser(newMemo);
        userRepository.save(user);
    }

    // 이메일을 통해 유저 메모 컬렉션을 받아오는 메서드
    // TODO: 값 없을 때 할 일
    public Set<UserMemo> getMemos(String email) {
        return userRepository.findByUserEmail(email).get().getUserMemo();
    }

    // 인덱스로 유저의 메모를 하나 찾는 메서드
    public UserMemo findUserMemo(String email, int memoId) {
        Set<UserMemo> memos = userRepository.findByUserEmail(email).get().getUserMemo();
        return memos.stream().filter(UserMemo -> UserMemo.getMemoId() == memoId).findFirst().get();
    }

    // 유저 이메일을 통해 유저 메모를 수정하는 메서드
    public void updateUserMemo(String email, int memoId, String newContent) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        Set<UserMemo> memos = user.getUserMemo(); // 해당 유저 메모 셋 가져오기
        // TODO: 메모 ID에 해당하는 값이 없을 경우 조건 추가
        // 검색한 memoId와 같은 메모 삭제
        UserMemo oldUserMemo = findUserMemo(email, memoId);
        memos.remove(oldUserMemo);
        // 새로운 메모를 할당
        UserMemo newUserMemo = new UserMemo(memoId, newContent);
        memos.add(newUserMemo);
        user.setUserMemo(memos);
    }

    // 유저 이메일을 통해 유저 메모를 삭제
    public void deleteUserMemo(String email, int memoId) {
        Set<UserMemo> memos = userRepository.findByUserEmail(email).get().getUserMemo();
        UserMemo memo = findUserMemo(email, memoId);
        memos.remove(memo);
    }

    // 유저 이메일을 통해 유저 메모 전부 삭제
    public void deleteAllUserMemos(String email) {
        UserEntity user = userRepository.findByUserEmail(email).get();
        Set<UserMemo> memos = new HashSet<>();
        user.setUserMemo(memos);
    }

    // ==================== 메모 관련 메서드 끝 ====================
}
