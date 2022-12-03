package com.example.demo2.repository;

import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.GroupUser;
import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupUserRepository extends JpaRepository<GroupUser,Integer> {
    boolean existsByGroupsAndUser(Groups groups, User user);
    boolean existsByStateUserAndUser(String string, User user);
    Optional<List<GroupUser>> findAllByUser(User user);
    Optional<List<GroupUser>> findAllByGroups(Groups groups);
    Optional<GroupUser> findByGroupsAndUser(Groups groups,User user);


    //Optional<GroupUser> save(GroupUser groupUser);

}
