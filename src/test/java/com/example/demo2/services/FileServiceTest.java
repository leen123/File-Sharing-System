package com.example.demo2.services;

        import com.example.demo2.entity.FileTest;
        import com.example.demo2.entity.GroupsTest;
        import com.example.demo2.model.entity.File;
        import com.example.demo2.model.entity.Groups;
        import com.example.demo2.model.entity.ReportFile;
        import com.example.demo2.model.entity.resours.ConstUrl;
        import com.example.demo2.model.entity.resours.StateFile;
        import com.example.demo2.repository.FileRepository;
        import com.example.demo2.repository.GroupsRepository;
        import com.example.demo2.request.CreateFileRequest;
        import com.example.demo2.request.GetFileRequest;
        import com.example.demo2.request.GetFileSearchRequest;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.BDDMockito;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.context.TestConfiguration;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.context.annotation.Bean;
        import org.springframework.data.jpa.repository.Lock;
        import org.springframework.stereotype.Service;

        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.web.multipart.MultipartFile;

        import javax.persistence.LockModeType;
        import javax.transaction.Transactional;
        import java.io.OutputStream;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.*;
        import static org.mockito.BDDMockito.*;
        import static org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileServiceTest {
    @MockBean
    private FileRepository fileRepository;

    @Autowired
    private UserService userService;

    @MockBean
    private GroupsRepository groupsRepository;
    @Autowired
    private ReportFilerService reportFilerService;

    @Autowired
    private FileService fileService;
    @Test
    public void getFile(){
        int id=1;
        given(fileRepository.findById(id)).willReturn(Optional.ofNullable(FileTest.fileTest1));
        assertThat(fileService.getFile(id)).isEqualTo(FileTest.fileTest1);
    }
    @Test
    public void getFileListTest(){
        GetFileRequest getFileRequest=new GetFileRequest();
        getFileRequest.setGroupId(1);
        getFileRequest.token="1";
        given(groupsRepository.findById(getFileRequest.getGroupId())).willReturn(Optional.ofNullable(GroupsTest.groupsTest1));
         given(fileRepository.findAllByGroups(GroupsTest.groupsTest1)).willReturn(Optional.ofNullable(FileTest.listFileTest));
        assertThat(fileService.getFileList(getFileRequest)).hasSize(3).contains(FileTest.fileTest1,FileTest.fileTest2,FileTest.fileTest3);
    }
    @Test
    public void checkOutFileTest(){
        int userId=1;
        int fileId=1;
        given(fileRepository.findById(1)).willReturn(Optional.ofNullable(FileTest.fileTest1));
        File file =fileService.getFile(fileId);
        file.setState( StateFile.checkOut.name());
        file.setUpdatedAt( new Date(System.currentTimeMillis()));
        this.fileRepository.save(file);
        assertThat(file.getState()).contains( StateFile.checkOut.name());

    }


}
